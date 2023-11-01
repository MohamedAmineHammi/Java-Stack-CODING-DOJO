import java.util.ArrayList;

// Here we're creating a new data type called Order
public class Order {

    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null

    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
        this.items = items;

    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.

    public Order(String name) {
        this.name = name;
        this.ready = ready;
        this.items = new ArrayList<Item>();
    }

    // ORDER METHODS

    public void addItem(Item Item) {

        items.add(Item);

    }

    public String getStatusMessage(boolean ready) {
        return (this.ready ? "Your order is ready" : "Thank you for waiting. Your order will be ready soon.");

    }

    public double getOrderTotal() {
        double sums = 0;
        for (Item item : items) {
            sums += item.getPrice();

        }
        return sums;

    }

    public void display() {
        System.out.println("Customer Name: " + this.name);
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal());

    }

    // GETTERS & SETTERS

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

}
