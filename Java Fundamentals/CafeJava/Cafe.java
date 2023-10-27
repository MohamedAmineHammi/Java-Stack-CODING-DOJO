public class Cafe {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 4.5;
        double lattePrice = 5.5;
        double capuccinoPrice = 6.5;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        // System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe
        // Java, Cindhuri"
        // ** Your customer interaction print statements will go here ** //
        // Etat de la commande de Cindhuri:
        // System.out.println(customer1 + (isReadyOrder1 ? readyMessage :
        // pendingMessage));

        // Commande de Noah:
        //System.out.println(customer4  + (isReadyOrder4 ? (readyMessage + ", " + displayTotalMessage + capuccinoPrice) : pendingMessage));
        // Commande de Sam:
        //System.out.println(customer2 + (isReadyOrder2 ? (readyMessage + ", " + displayTotalMessage + lattePrice*2) : pendingMessage));
        //Commande de Jimmy:
                System.out.println(customer3 + displayTotalMessage + (dripCoffeePrice - lattePrice) );


    }
}
