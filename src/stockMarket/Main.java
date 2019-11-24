package stockMarket;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Stock> StocksArray = new ArrayList<>();

        // Actionable elements
        StockMarket SM = new StockMarket(StocksArray);
        Client cl1 = new Client("Bob", SM);
        Client cl2 = new Client("Jon", SM);

        // Each client is a thread
        Thread cl1_thread = new Thread(cl1);
        cl1_thread.start();
        Thread cl2_thread = new Thread(cl2);
        cl2_thread.start();

        // Add some Stocks in the names of each client
        Stock appl = new Stock("Apple", cl1);
        Stock msft = new Stock("Microsoft", cl2);

        for (int i = 0; i < 10; ++i) StocksArray.add(appl);
        for (int i = 0; i < 10; ++i) StocksArray.add(msft);


//********TESTING LOGIC****************************************
        // Create the test offers for client 1
        Offer buy1 = new Offer(0, "buy", appl, 3, 5, cl1);
//        Offer buy2 = new Offer(0, "buy", appl, 3, 5, cl1);
//        Offer buy3 = new Offer(0, "buy", msft, 5, 10, cl1);
//        Offer sell2 = new Offer(0, "sell", appl, 10, 8, cl1);
//        Offer sell3 = new Offer(0, "sell", appl, 10, 10, cl1);
//        Offer sell4 = new Offer(0, "sell", msft, 10, 4, cl1);
//        Offer sell5 = new Offer(0, "sell", msft, 10, 3, cl1);

        // Create te test offers for client 2
        Offer sell1 = new Offer(0, "sell", appl, 7, 3, cl2);
//        Offer buy2 = new Offer(0, "buy", appl, 10, 3, cl2);
//        Offer buy3 = new Offer(0, "buy", msft, 10, 2, cl2);
//        Offer buy4 = new Offer(0, "buy", msft, 10, 6, cl2);

        // Client 1 registers some offers
        cl1.createOffer(buy1);
//        cl1.createOffer(buy2);
//        cl1.createOffer(buy3);
//        cl1.createOffer(sell2);
//        cl1.createOffer(sell3);
//        cl1.createOffer(sell4);
//        cl1.createOffer(sell5);

        // Client 2 registers some offers
        cl2.createOffer(sell1);
//        cl2.createOffer(buy2);
//        cl2.createOffer(buy3);
//        cl2.createOffer(buy4);

//******PRINTING THE INNER INFO****************
        System.out.println("SELLS\n");
        SM.printPendingSell();

        System.out.println("BUYS\n");
        SM.printPendingBuy();

        System.out.println("TRANSACTIONS:\n");
        SM.printTransactionsHistory();

        System.out.println("STOCKS:\n");
        SM.printStocks();

        // Ask the StockMarket for some index price
        System.out.println("Buy price of Apple "  + SM.getBuyPrice("Apple"));
        System.out.println("Sell price of Apple " + SM.getSellPrice("Apple"));
    }
}

