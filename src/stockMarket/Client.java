package stockMarket;

import stockMarket.Stock;
import stockMarket.StockMarket;

import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Runnable {
    private String name;
    private StockMarket stockMarket;

    public Client(String _name, StockMarket _SM) {
        name          = _name;
        stockMarket   = _SM;
    }

    // TODO: Make this work
    @Override
    public void run() {
        int selection = 0;
        String type;
        String stock;
        int stockCount, unitPrice, index;
        while( true ){

            System.out.println("Waiting for client input. Possible actions:\n" +
                    "1. Create offer\n" +
                    "2. Delete offer\n" +
                    "3. Modify offer\n" +
                    "4. Print Offers on StockMarket\n" +
                    "5. Get stock quote\n");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();
            switch ( selection ) {
                case 1:
                    System.out.println("You need to create an offer\n");

                    System.out.println("Type:");
                    type = input.next();

                    System.out.println("Stock:");
                    stock = input.next();

                    Stock tempStock = new Stock(stock, this);
                    System.out.println("Stock count:");

                    stockCount = input.nextInt();
                    System.out.println("Unit price:");

                    unitPrice = input.nextInt();
                    Offer tempOffer = new Offer(0, type, tempStock, stockCount, unitPrice, this);

                    createOffer(tempOffer);
                    System.out.println("Created offer " + tempOffer.toString());
                    break;
                case 2:
                    System.out.println("Give the offer index to delete\n");
                    index = input.nextInt();

                    deleteOffer(index);
                    break;
                case 3:
                    System.out.println("Which offer to modify and to what\n");
                    index = input.nextInt();

                    System.out.println("Stock count:");
                    stockCount = input.nextInt();

                    System.out.println("Unit price:");
                    unitPrice = input.nextInt();

                    System.out.println("Stock:");
                    stock = input.next();

                    modifyOffer(index, stockCount, unitPrice, stock);
                    break;
                case 4:
                    System.out.println("1. Sells\n2. Buys\n");
                    index = input.nextInt();
                    switch (index) {
                        case 1:
                            stockMarket.printPendingSell();
                            break;
                        case 2:
                            stockMarket.printPendingBuy();
                            break;
                        default:
                            System.out.println("Option doesn't exist\n");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Company name:");
                    stock = input.next();
                    System.out.println("1. Sells\n2. Buys\n");
                    index = input.nextInt();
                    switch (index) {
                        case 1:
                            System.out.println(stock + " " + stockMarket.getSellPrice(stock));
                            break;
                        case 2:
                            System.out.println(stock + " " +  stockMarket.getBuyPrice(stock));
                            break;
                        default:
                            System.out.println("Option doesn't exist\n");
                            break;
                    }
                    break;
                default:
                    System.out.println("Option doesn't exist\n");
                    break;
            }
        }
    }

    public int createOffer(Offer offer) {
        return stockMarket.createOffer(offer);
    }

    public boolean deleteOffer(int ID) {
        return stockMarket.deleteOffer(ID);
    }

    public boolean modifyOffer(
            /*to know which offer to modify*/ int ID,
            /*new values*/ int stockCount, double unitPrice, String companyName) {
        return stockMarket.modifyOffer(ID, stockCount, unitPrice);
    }

    public String toString() {
        return name;
    }
}
