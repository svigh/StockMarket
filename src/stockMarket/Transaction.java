package stockMarket;

public class Transaction {
    private Client buyer;
    private Client seller;
    private String companyName;
    private int stockCount;
    private double unitPrice;

    // This is so the StockMarket can keep records of the stock transactions
    public Transaction(Client _buyer, Client _seller, String _companyName, int _stockCount, double _unitPrice) {
        buyer = _buyer;
        seller = _seller;
        companyName = _companyName;
        stockCount = _stockCount;
        unitPrice = _unitPrice;
    }

    public String toString() {
        return "Buyer name: " + buyer + "\nSeller name: " + seller + "\nCompany name: " + companyName +
                "\nStock count: " + stockCount + "\nUnit price: " + unitPrice;
    }
}
