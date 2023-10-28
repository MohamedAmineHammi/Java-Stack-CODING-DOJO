import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil somme = new CafeUtil();
        somme.getStreakGoal(10);

        CafeUtil sommeOne = new CafeUtil();
        double[] prices = { 17.3, 12.5, 20.365 };
        sommeOne.getOrderTotal(prices);

        CafeUtil display = new CafeUtil();
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("drip coffee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");

        display.displayMenu(menuItems);

        /*
         * CafeUtil customersList = new CafeUtil();
         * ArrayList<String> customers = new ArrayList<String>();
         * for(int i = 0; i<4; i++){
         * 
         * customersList.addCustomer(customers);
         * System.out.println("\n");
         * }
         */

        CafeUtil priceQuantity = new CafeUtil();
        priceQuantity.printPriceChart("Columbian Coffee Grounds", 2, 6);

        CafeUtil displayMixte = new CafeUtil();
        ArrayList<String> menuItemsMixte = new ArrayList<String>();
        menuItemsMixte.add("drip coffee");
        menuItemsMixte.add("cappuccino");
        menuItemsMixte.add("latte");
        menuItemsMixte.add("mocha");
        ArrayList<Double> pricesMixte = new ArrayList<Double>();
        pricesMixte.add(1.50);
        pricesMixte.add(3.50);
        pricesMixte.add(4.50);
        pricesMixte.add(3.50);

        displayMixte.displayMenu(menuItemsMixte, pricesMixte);

        CafeUtil addNewCustomers = new CafeUtil();
        ArrayList<String> newCustomers = new ArrayList<String>();

        addNewCustomers.addCustomers(newCustomers);

    }

}
