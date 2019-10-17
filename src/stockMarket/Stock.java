package stockMarket;

public class Stock {
    private String companyName;
    private String ownerName;

    public Stock(String _companyName, String _ownerName) {
        companyName = _companyName;
        ownerName = _ownerName;
    }

    public void changeOwner(String newOwner) {
        ownerName = newOwner;
    }

    public String toString() {
        return "Company name: " + companyName + "\nOwner name: " + ownerName;
    }
}
