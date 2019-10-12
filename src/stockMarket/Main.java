package stockMarket;
//import StockMarket;
//import Company;

public class Main {

    public static void main(String[] args) {
        Company c1 = new Company("ABC", 10);
        Company c2 = new Company("DEF", 10);
        Company c3 = new Company("GHI", 10);
        Company c4 = new Company("JKL", 10);

        StockMarket st1 = new StockMarket();

        st1.addCompany(c1);
        st1.addCompany(c1);
        st1.addCompany(c2);
        st1.addCompany(c3);
        st1.addCompany(c4);

        st1.printCompanies();
        System.out.println("Paul e degeaba");
        System.out.println("Așa e.");
    }
}
