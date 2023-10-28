import java.util.ArrayList;

public class CafeUtil {

    // Get Streak Goal

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 0; i <= numWeeks; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
        return sum;

    }

    /*
     * Given an array of prices for products purchased, lineItems,
     * sum the amounts to return the order total
     */

    public double getOrderTotal(double[] prices) {
        double sum1 = 0;
        for (int i = 0; i < prices.length; i++) {
            sum1 = sum1 + prices[i];

        }
        System.out.println(sum1);
        return sum1;

    }

        // Display Coffee Menu


    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }

    }

        // addCustomer


    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);

        System.out.println("There are " + (customers.size()) + " people in front of you!");
        customers.add(userName);

        System.out.println(customers);

    }

        // Price chart
    // Ninja bonus: Format for currency

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        if (maxQuantity <= 3) {

            for (int i = 1; i <= maxQuantity; i++) {

                System.out.println(i + " - " + "$ " + price * i);
            }
        } else {

            for (int i = 1; i <= maxQuantity; i++) {

                System.out.println(i + " - " + "$ " + ((price * i) - (0.5 * (i - 1))));

            }
        }

    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            System.out.println("What are Doing (Just for FUN) !! ");
            return false;
        } else {

            for (int i = 0; i < menuItems.size() && i < prices.size(); i++) {
                System.out.println(i + " " + menuItems.get(i) + " -- " + "$" + prices.get(i));
            }

        }

        return true;

    }
        /* Sensei bonus:
    Make a method addCustomers where a barista can enter multiple customers. 
    Hint: You can use a while loop and ask the user to type q when they are finished entering names.
    */

    public void addCustomers(ArrayList<String> customerList) {
        boolean finished = false;
        String input;
        while (!finished) {
            System.out.println("Please enter a customer name or press Q to quit:");
            input = System.console().readLine();
            if (input.equals("Q")) {
                finished = true;
                return;
            }
            customerList.add(input);
            System.out.printf("%s was added to the list.", input);
            System.out.println(customerList);
        }
    }



    
}
