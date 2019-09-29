package stockMarket;

import java.util.*;

public class StockMarket {
    private ArrayList<Company> PartnerCompanies = new ArrayList<Company>();

    public StockMarket() {
        /*empty*/
    }

    public int addCompany(Company newCompany) {
        if( PartnerCompanies.contains(newCompany) ) {
            System.out.printf("stockMarket.Company already on this Stock Market\n");
            return 1;
        } else {
            PartnerCompanies.add(newCompany);
            System.out.printf("Added %s to the Stock Market\n", newCompany.getName());
            return 0;
        }
    }

    public void printCompanies(){
        for( Company comp : PartnerCompanies ) {
            System.out.println(comp.getName());
        }
    }
}
