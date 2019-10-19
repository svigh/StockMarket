package stockMarket;

public class Stock {
    private String companyName;
    private Client owner;

    public Stock(String _companyName, Client _owner) {
        companyName = _companyName;
        owner = _owner;
    }

    public void changeOwner(Client newOwner) {
        owner = newOwner;
    }

    public Client getOwner() {
        return owner;
    }

    public String toString() {
        return companyName;
    }
}
