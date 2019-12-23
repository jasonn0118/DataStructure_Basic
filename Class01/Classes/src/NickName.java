/**
 * A class that represents a person's nickname. Appendix D.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class NickName {
	private NameUsingInterfaces nickName;

	public NickName() {
		nickName = new NameUsingInterfaces();
	} 
	
	/**
	 * Set a new nickname.
	 * 
	 * Note this is stored in the the firstName of a Name object
	 * @param newNickName
	 */
	public void setNickName(String newNickName) {
		nickName.setFirst(newNickName);
	} 

	/**
	 * Get a nickname
	 * @return
	 */
	public String getNickName() {
		return nickName.getFirst();
	} 
} 
