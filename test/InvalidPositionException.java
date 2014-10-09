/**
 * class InvalidPositionException
 *
 * This exception is thrown if the position is invalid
 */
class InvalidPositionException extends Exception
{
    public String toString()
    {
        return "You have entered an invalid position";
    }
}
