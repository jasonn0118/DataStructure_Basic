/** 
   A driver that demonstrates the class NickName.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class NickNameDemo
{
	public static void main(String[] args) 
	{
		NickName jane = new NickName();
		jane.setNickName("Jane");

		System.out.println("Hi, " + jane.getNickName());

		System.out.println("\n\nDone.");
	}  
}  

/*
Hi, Jane


Done.
*/
