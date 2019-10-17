package stockMarket;

import java.util.*;

public class StockMarket {
    private ArrayList<Stock> totalStocksArray = new ArrayList<>();
    private ArrayList<Offer> pendingBuyOffersArray = new ArrayList<>();
    private ArrayList<Offer> pendingSellOffersArray = new ArrayList<>();
    private ArrayList<Transaction> transactionHistoryArray = new ArrayList<>();

    public StockMarket(ArrayList<Stock> _totalStocksArray) {
        totalStocksArray = _totalStocksArray;
    }

    public void createOffer(Offer offer) {
        if(offer.getOfferType().equals("sell")){
            pendingSellOffersArray.add(offer);
        } else {
            pendingBuyOffersArray.add(offer);
        }
    }

    // This should not happen concurrently
    public boolean deleteOffer(int ID) {
        for(Offer offer : pendingBuyOffersArray) {

            if(offer.ID == ID){
                pendingBuyOffersArray.remove(offer);
                return true;
            }
        }

        for(Offer offer : pendingSellOffersArray) {

            if(offer.ID == ID){
                pendingSellOffersArray.remove(offer);
                return true;
            }
        }
        return false;
    }

    // This should not happen concurrently
    public boolean modifyOffer(
            /*to know which offer to modify*/ int ID,
            /*new values*/ int stockCount, double unitPrice, String companyName) {

        // TODO: these loops are bad
        for(Offer offer : pendingBuyOffersArray) {
            if(offer.ID == ID){
                offer.setStockCount(stockCount);
                offer.setUnitPrice(unitPrice);
                offer.setCompanyName(companyName);
                return true;
            }
        }

        for(Offer offer : pendingBuyOffersArray) {
            if(offer.ID == ID){
                offer.setStockCount(stockCount);
                offer.setUnitPrice(unitPrice);
                offer.setCompanyName(companyName);
                return true;
            }
        }
        return false;
    }

    // Basically the corresponding stock index for the company, like a template
    public boolean addStock(String companyName, String ownerName, int stockCount) {
        for(int i = 0; i < stockCount; ++i) {
            Stock tempStock = new Stock(companyName, ownerName);
            try {
                totalStocksArray.add(tempStock);
            } catch(Exception e) {
                System.out.println(e.toString());
                return false;
            }
        }
        return true;
    }

    public void printEverything() {
        for(Offer buy : pendingBuyOffersArray){
            System.out.println(buy.toString());
            System.out.println("\n");
        }
        System.out.println("\n");
        for(Offer sell : pendingSellOffersArray){
            System.out.println(sell.toString());
            System.out.println("\n");
        }
        System.out.println("\n");
        for(Transaction transaction : transactionHistoryArray){
            System.out.println(transaction.toString());
            System.out.println("\n");
        }
        System.out.println("\n");
        for(Stock stock : totalStocksArray){
            System.out.println(stock.toString());
            System.out.println("\n");
        }
    }



}
