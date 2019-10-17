package stockMarket;

public class Offer {
    int ID;
    private String offerType;   //Sell or Buy
    private String companyName; // TODO: Maybe have this be a Stock object
    private int stockCount;
    private double unitPrice;
    private String ownerName;   // Owner of the offer, to be able to modify it

    public Offer(int _ID, String _offerType, String _companyName, int _stockCount, double _unitPrice, String _ownerName) {
        if ( _offerType.toLowerCase().equals("buy") ) {
            offerType = "buy";
        } else {
            offerType = "sell";
        }
        companyName = _companyName;
        stockCount = _stockCount;
        unitPrice = _unitPrice;
        ownerName = _ownerName;
    }

    public void setStockCount(int newStockCount) {
        stockCount = newStockCount;
    }

    public void setCompanyName(String newCompanyName) {
        companyName = newCompanyName;
    }

    public void setUnitPrice(double newUnitPrice) {
        unitPrice = newUnitPrice;
    }

    public String getOfferType() {
        return offerType;
    }

    public String toString(){
        String temp = "";
        return "Company name: " + companyName + "\nStock count: " + stockCount +
            "\nUnit price: " + unitPrice + "\nOwner name: " + ownerName;
    }
}
