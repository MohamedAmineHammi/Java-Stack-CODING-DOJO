public class Test {
    public static void main(String[] args) {
        Item item1 = new Item("degla", 12.5);
        Item item2 = new Item("Bsal", 18.5);
        Item item3 = new Item("Kefta", 20.5);

        // Create 2 orders for unspecified guests (without specifying a name);
        Order order1 = new Order();
        Order order2 = new Order();
        // Create 3 orders using the overloaded constructor to give each a name for the
        // order.
        Order order3 = new Order("Salah");
        Order order4 = new Order("Amine");
        Order order5 = new Order("Dali");
        /*
         * Add at least 2 items to each of the orders using the addItem method you
         * wrote, for example, to add item1 to order3 you would need to call the addItem
         * method from the order3 instance like so: order3.addItem(item1);
         */

        order3.addItem(item1);
        order3.addItem(item2);

        order4.addItem(item2);
        order5.addItem(item3);

        System.out.println(order3.getOrderTotal());

        order3.display();

    }

}
