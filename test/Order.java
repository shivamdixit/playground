/**
 * class Order
 *
 * Class to store order details
 */
class Order
{
    private String[] items;

    private int[] quantity;

    private int numOfItems;

    private int totalPrice;

    Order(String[] nameOfItems, int[] orderQuantities)
    {
        numOfItems = nameOfItems.length;

        items = new String[numOfItems];
        quantity = new int[numOfItems];

        for (int i = 0; i < numOfItems; i++) {
            items[i] = nameOfItems[i];
        }

        for (int i = 0; i < numOfItems; i++) {
            quantity[i] = orderQuantities[i];
        }
    }

    public int getPrice()
    {
        return this.totalPrice;
    }

    public int getNumOfItems()
    {
        return this.numOfItems;
    }

    public void setPrice(int price)
    {
        this.totalPrice = price;
    }
}
