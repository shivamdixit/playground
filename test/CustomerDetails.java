/**
 * class Customer Details
 *
 * Class to store details of a customer
 */
class CustomerDetails
{
    private String name;

    private int rating;

    private int maxAmount;

    public String getName()
    {
        return this.name;
    }

    public int getRating()
    {
        return this.rating;
    }

    public int getMaxAmount()
    {
        return this.maxAmount;
    }

    public void setName(String customerName)
    {
        this.name = customerName;
    }

    public void setRating(int customerRating)
    {
        this.rating = customerRating;
    }

    public void setMaxAmt(int amount)
    {
        this.maxAmount = amount;
    }
}
