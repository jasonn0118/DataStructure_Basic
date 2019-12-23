package HeapPackage;

/**
 * A class that represents an entry for a priority queue.
 * This is different from the Dictionary Entry, in that the second arg/type is the
 * priority which is compared.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @author Charles Hoot
 * @version 5.0
 */
public class PQEntry<E, P extends Comparable<? super P>>
             implements Comparable<PQEntry<E, P>>
{
   private E theItem;
   private P thePriority;

   public PQEntry(E item, P priority)
   {
      theItem = item;
      thePriority = priority;
   } 

   public E getItem()
   {
      return theItem;
   } 

   public P getPriority()
   {
      return thePriority;
   } 

   public int compareTo(PQEntry<E, P> other)
   {
      return thePriority.compareTo(other.thePriority);
   } 

   public String toString()
   {
      return "item/priority <" + theItem + ", " + thePriority + ">";
   } 
} 
