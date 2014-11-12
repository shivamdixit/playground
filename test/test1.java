class test1
{
    public static void main(String args[])
    {
	StringBuffer sb1 = new StringBuffer("Hello");
	StringBuffer sb2 = new StringBuffer("Hello");

	System.out.println(sb1.equals(sb2));
	System.out.println("You loose");
    }
}
