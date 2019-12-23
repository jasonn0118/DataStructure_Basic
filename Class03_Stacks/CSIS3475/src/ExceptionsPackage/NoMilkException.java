package ExceptionsPackage;

/**
   A class of runtime exceptions thrown when no milk
   is in the refrigerator.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class NoMilkException extends RuntimeException
{
   public NoMilkException()
   {
      super("Out of milk!");
   } // end default constructor
 
   public NoMilkException(String message)
   {
      super(message);
   } 
} 
