package stockMarket;

public class Transaction {
    private String buyerName;
    private String sellerName;
    private String companyName;
    private int stockCount;
    private double unitPrice;

    // This is so the StockMarket can keep records of the stock transactions
    public Transaction(String _buyerName, String _sellerName, String _companyName, int _stockCount, double _unitPrice) {
        buyerName = _buyerName;
        sellerName = _sellerName;
        companyName = _companyName;
        stockCount = _stockCount;
        unitPrice = _unitPrice;
    }

    public String toString() {
        return "Buyer name: " + buyerName + "\nSeller name: " + sellerName + "\nCompany name: " + companyName +
                "\nStock count: " + stockCount + "\nUnit price: " + unitPrice;
    }
}
