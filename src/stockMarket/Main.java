package stockMarket;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Stock> StocksArray = new ArrayList<>();

        Client cl1 = new Client("Bob");
        Client cl2 = new Client("Jon");

        Stock appl = new Stock("Apple", cl1);
        Stock msft = new Stock("Microsoft", cl2);

        StockMarket SM = new StockMarket(StocksArray);

        for (int i = 0; i < 10; ++i) StocksArray.add(appl);
        for (int i = 0; i < 10; ++i) StocksArray.add(msft);


        Offer sell1 = new Offer(0, "sell", appl, 10, 9.5, cl1);
        Offer sell2 = new Offer(0, "sell", appl, 10, 8, cl1);
        Offer sell3 = new Offer(0, "sell", appl, 10, 10, cl1);
        Offer sell4 = new Offer(0, "sell", msft, 10, 4, cl1);
        Offer sell5 = new Offer(0, "sell", msft, 10, 3, cl1);

        Offer buy1 = new Offer(0, "buy", msft, 10, 5, cl2);
        Offer buy2 = new Offer(0, "buy", appl, 10, 3, cl2);
        Offer buy3 = new Offer(0, "buy", msft, 10, 2, cl2);
        Offer buy4 = new Offer(0, "buy", msft, 10, 6, cl2);


        cl1.createOffer(SM, sell1);
        cl1.createOffer(SM, sell2);
        cl1.createOffer(SM, sell3);
        cl1.createOffer(SM, sell4);
        cl1.createOffer(SM, sell5);



        cl2.createOffer(SM, buy1);
        cl2.createOffer(SM, buy2);
        cl2.createOffer(SM, buy3);
        cl2.createOffer(SM, buy4);


        System.out.println("SELLS\n");
        SM.printPendingSell();

        System.out.println("BUYS\n");
        SM.printPendingBuy();

    }
}

