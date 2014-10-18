/**
 * Class item
 *
 * Items of a library
 */
class Item
{
    /**
     *@var int ID of the item
     */
    protected int ID;

    /**
     *@var String title of the item
     */
    protected String title;

    /**
     * Getter methods
     */
    public int getID()
    {
        return this.ID;
    }

    public String getTitle()
    {
        return this.title;
    }

    /**
     * Setter methods
     */
    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setTitle(String itemTitle)
    {
        this.title = itemTitle;
    }
}

/**
 * Printed class
 *
 * Class for printed items
 */
class Printed extends Item
{
    protected int noOfPages;

    protected String type;

    /**
     * Getter methods
     */
    public int getNoOfPages()
    {
        return this.noOfPages;
    }

    public String getType()
    {
        return this.type;
    }

    /**
     * Setter methods
     */
    public void setNoOfPages(int num)
    {
        this.noOfPages = num;
    }

    public void setType(String type)
    {
        // Check if type belongs to books, journals, magazines, and documents
        this.type = type;
    }
}

/**
 * Multimedia class
 *
 * class for multimedia items
 */
class Multimedia extends Item
{
    protected int length;

    protected String type;

    /**
     * Getter methods
     */
    public int getLength()
    {
        return this.length;
    }

    public String getType()
    {
        return this.type;
    }

    /**
     * Setter methods
     */
    public void setLength(int num)
    {
        this.length = num;
    }

    public void setType(String type)
    {
        // Check if type belongs to vinyl, tapes, CDs, and DVDs
        this.type = type;
    }
}
