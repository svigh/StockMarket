package stockMarket;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Stock> StocksArray = new ArrayList<>();
        Stock appl = new Stock("Apple", "Bob");
        Stock msft = new Stock("Microsoft", "Jon");
        for (int i = 0; i < 10; ++i) StocksArray.add(appl);
        for (int i = 0; i < 10; ++i) StocksArray.add(msft);


        Offer off = new Offer(1, "sell", "Apple", 10, 9.5, "Bob");
        System.out.println(off.toString());

        StockMarket SM = new StockMarket(StocksArray);
        SM.printEverything();
    }
}
