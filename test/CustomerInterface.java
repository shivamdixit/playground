/**
 * class Customer Interface
 *
 * Class to fetch customer details from database
 */
class CustomerInterface
{
    public static CustomerDetails getDetails(String name)
    {
        // Fetch details of the customer from the database
        CustomerDetails cus = new CustomerDetails();
        cus.setName("Shivam");   // Value fetched from the database
        cus.setRating(10);    // Value fetched from the database
        cus.setMaxAmt(100);    // Value fetched from the database
        return cus;
    }
}
