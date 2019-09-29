package stockMarket;

public class Company {
    private String name;
    private int numberOfShares;

    public Company(String _name, int _numberOfShares) {
        name = _name;
        numberOfShares = _numberOfShares;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }
}
