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
        System.out.println("Waiting for client input. Possible actions:\n" +
                "1. Create offer\n" +
                "2. Delete offer\n" +
                "3. Modify offer\n");

        while( true ){
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();
            if ( selection == 0 )
                break;
            if ( selection == 1 ) {
                System.out.println("\tYou need to create an offer\n");
                System.out.println("Type:");
                String type = input.next();
                System.out.println("Stock:");
                String stock = input.next();
                Stock tempStock = new Stock(stock, this);
                System.out.println("Stock count:");
                int stockCount = input.nextInt();
                System.out.println("Unit price:");
                int unitPrice = input.nextInt();
                Offer tempOffer = new Offer(0, type, tempStock, stockCount, unitPrice, this);
                createOffer(tempOffer);
                System.out.println("Created offer " + tempOffer.toString());
            }
            if ( selection == 2 ) {
                System.out.println("\tGive the offer index to delete\n");
                int index = input.nextInt();
                deleteOffer(index);
            }
            if ( selection == 3 ) {
                System.out.println("\tWhich offer to modify and to what\n");
                int index = input.nextInt();
                System.out.println("Stock count:");
                int stockCount = input.nextInt();
                System.out.println("Unit price:");
                int unitPrice = input.nextInt();
                System.out.println("Stock:");
                String stock = input.next();
                modifyOffer(index, stockCount, unitPrice, stock);
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
