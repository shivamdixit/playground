/**
 * class CustomerOrderService
 *
 * Class to handle a request
 */
class CustomerOrderService
{
    // Returns the best Order
    public static Order run(String custName, Order[] orders)
    {
        // Calculate price for each order
        for (int i = 0; i < orders.length; i++) {
            PriceCalculator.run(orders[i]);
        }

        // Get details of the customer from the database
        CustomerDetails cust = CustomerInterface.getDetails(custName);

        return OrderSelector.select(cust, orders);
    }
}
