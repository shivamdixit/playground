/**
 * class Business
 *
 * Main class of the application
 */
class Business
{
    public static void main()
    {
        String s1 = "Shivam";   // Enter this value from the keyboard
        int numOfOrders = 10;   // Enter this value from the keyboard
        Order[] orders = new Order[numOfOrders];

        // Get details of the orders from the users

        CustomerOrderService.run(s1, orders);
    }
}
