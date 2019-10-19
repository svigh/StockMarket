package stockMarket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StockMarket {
    private ArrayList<Stock> totalStocksArray = new ArrayList<>();
    private ArrayList<Offer> pendingBuyOffersArray = new ArrayList<>();
    private ArrayList<Offer> pendingSellOffersArray = new ArrayList<>();
    private ArrayList<Transaction> transactionHistoryArray = new ArrayList<>();
    private static int ID_sequence = 0; // Not necessary to be static because StockMarket will be singleton but whatever

    public StockMarket(ArrayList<Stock> _totalStocksArray) {
        totalStocksArray = _totalStocksArray;
    }

    // Order the lists based on the name and price of the stock
    private static ArrayList<Offer> orderOffers(ArrayList<Offer> offersArray, String type) {
        // TODO: find a better way to order the arrays instead of returning a ordered array that overwrites the old one
        Comparator<Offer> comparator = Comparator.comparing(offer -> offer.getStock().toString());

        // Determine if ascending or descending order
        // We want buys to be biggest price first and sells lowest price first
        if(type.equals("buy"))
            comparator = comparator.thenComparing(Comparator.comparing(offer -> -offer.getUnitPrice()));
        else
            comparator = comparator.thenComparing(Comparator.comparing(offer -> offer.getUnitPrice()));

        // Sort the stream:
        Stream<Offer> offerStream = offersArray.stream().sorted(comparator);
        List<Offer> sortedOffers = offerStream.collect(Collectors.toList());

        ArrayList<Offer> orderedOffersArray = new ArrayList<Offer>(sortedOffers);

        return orderedOffersArray;
    }

//    private int isOfferSatisfied(Offer offer) {
//        if(offer.getOfferType().equals("sell")) {
//            /*Search for buy offers to satisfy*/
//
//        } else {
//            /*Search for sell offers to satisfy*/
//        }
//
////        return the difference between the offers
//    }

    private boolean ownerHasStockAvailable(Offer offer) {
        int auxCounter = offer.getStockCount();

        for(Stock stock : totalStocksArray) {
            if( stock.getOwner().equals(offer.getOwner()) ) {
                auxCounter--;
                if(auxCounter == 0){
                    return true;
                }
            }
        }

        return false;
    }

    public int createOffer(Offer offer) {
        // TODO: We want every incoming offer to receive an ID? Or only the valid ones
        offer.setID(++ID_sequence);

        // 1. If the offer is a sell offer then we want to make sure
        // the client actually has the stock in his name
        if(offer.getOfferType().equals("sell") && !ownerHasStockAvailable(offer)){
            System.out.println(offer.getOwner() + " does not have enough stock to create the offer\n" + offer);
            return -1;
        }

        // 2. The offer can take place, we then check if it can be satisfied
        // If it can be satisfied(*) we act on the offer and remove the existing offer from the pending pool
        // and the incoming offer disappears.
        // 2*. A offer is satisfied if at least one stock can be sold/bought. It should return how many stocks have
        // been acted upon. If the number of stocks acted upon is lower than the stockCount of the incoming offer
        // then the offer is only partially satisfied.
        // 2**. In case of a partially satisfied offer we modify the stockCount on the pending offer, and
        // we eliminate the incoming offer
        // 2**. In case of fully satisfied offers we assign the new owner to the stocks


//        if(isOfferSatisfied(offer)) {
//
//        }

        if(offer.getOfferType().equals("sell")){
            pendingSellOffersArray.add(offer);
            pendingSellOffersArray = orderOffers(pendingSellOffersArray, "sell");
        } else {
            pendingBuyOffersArray.add(offer);
            pendingBuyOffersArray = orderOffers(pendingBuyOffersArray, "buy");
        }

        return ID_sequence;
    }

    // This should not happen concurrently
    public boolean deleteOffer(int ID) {
        for(Offer offer : pendingBuyOffersArray) {
            if(offer.ID == ID){
                pendingBuyOffersArray.remove(offer);
                pendingBuyOffersArray = orderOffers(pendingBuyOffersArray, "buy");
                return true;
            }
        }

        for(Offer offer : pendingSellOffersArray) {
            if(offer.ID == ID){
                pendingSellOffersArray.remove(offer);
                pendingSellOffersArray = orderOffers(pendingSellOffersArray, "sell");
                return true;
            }
        }
        return false;
    }

    // This should not happen concurrently
    public boolean modifyOffer(
            /*to know which offer to modify*/ int ID,
            /*new values*/ int stockCount, double unitPrice) {

        // TODO: these loops are bad
        for(Offer offer : pendingBuyOffersArray) {
            if(offer.ID == ID){
                offer.setStockCount(stockCount);
                offer.setUnitPrice(unitPrice);
                pendingBuyOffersArray = orderOffers(pendingBuyOffersArray, "buy");
                return true;
            }
        }

        for(Offer offer : pendingBuyOffersArray) {
            if(offer.ID == ID){
                offer.setStockCount(stockCount);
                offer.setUnitPrice(unitPrice);
                pendingSellOffersArray = orderOffers(pendingSellOffersArray, "sell");
                return true;
            }
        }
        return false;
    }

    // Basically the corresponding stock index for the company, like a template
    public boolean addStock(String companyName, Client owner, int stockCount) {
        for(int i = 0; i < stockCount; ++i) {
            Stock tempStock = new Stock(companyName, owner);
            try {
                totalStocksArray.add(tempStock);
            } catch(Exception e) {
                System.out.println(e.toString());
                return false;
            }
        }
        return true;
    }

    public void printPendingBuy() {
        for(Offer buy : pendingBuyOffersArray){
            System.out.println(buy.toString());
            System.out.println("\n");
        }
    }

    public void printPendingSell() {
        for(Offer sell : pendingSellOffersArray) {
            System.out.println(sell.toString());
            System.out.println("\n");
        }
    }

    public void printTransactionsHistory() {
        for(Transaction transaction : transactionHistoryArray){
            System.out.println(transaction.toString());
            System.out.println("\n");
        }
    }

    public void printStocks() {
        for(Stock stock : totalStocksArray){
            System.out.println(stock.toString());
            System.out.println("\n");
        }
    }

}
