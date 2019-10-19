package stockMarket;

public class Offer {
    int ID;
    private String offerType;   //Sell or Buy
    private Stock stock; // TODO: Maybe have this be a Stock object
    private int stockCount;
    private double unitPrice;
    private Client owner;   // Owner of the offer, to be able to modify it

    public Offer(int _ID, String _offerType, Stock _stock, int _stockCount, double _unitPrice, Client _owner) {
        if ( _offerType.toLowerCase().equals("buy") ) {
            offerType = "buy";
        } else {
            offerType = "sell";
        }
        stock = _stock;
        stockCount = _stockCount;
        unitPrice = _unitPrice;
        owner = _owner;
    }

    public void setID(int newID) { ID = newID; }

    public void setStockCount(int newStockCount) {
        stockCount = newStockCount;
    }

    public void setCompanyName(Stock newStock) {
        stock = newStock;
    }

    public void setUnitPrice(double newUnitPrice) {
        unitPrice = newUnitPrice;
    }

    public String getOfferType() {
        return offerType;
    }

    public Client getOwner() {
        return owner;
    }

    public int getStockCount() {
        return stockCount;
    }

    public Stock getStock() {
        return stock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String toString(){
        String temp = "";
        return "ID: " + ID + "\nOffer type: " + offerType + "\nStock name: " + stock + "\nStock count: " + stockCount +
            "\nUnit price: " + unitPrice + "\nOwner name: " + owner;
    }
}
