package stockMarket;

import stockMarket.Stock;
import stockMarket.StockMarket;

import java.util.ArrayList;

public class Client {
    private String name;

    public Client(String _name) {
        name = _name;
    }

    public int createOffer(StockMarket stockMarket, Offer offer) {
        return stockMarket.createOffer(offer);
    }

    public boolean modifyOffer(StockMarket stockMarket,
            /*to know which offer to modify*/ int ID,
            /*new values*/ int stockCount, double unitPrice, String companyName) {
        return stockMarket.modifyOffer(ID, stockCount, unitPrice);
    }

    public boolean deleteOffer(StockMarket stockMarket, int ID) {
        return stockMarket.deleteOffer(ID);
    }

    public String toString() {
        return name;
    }
}
