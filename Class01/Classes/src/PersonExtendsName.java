
public class PersonExtendsName extends Name {

	int age;
	public PersonExtendsName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonExtendsName(String firstName, String lastName, int age) {
		super(firstName, lastName);
		this.age = age;
		// TODO Auto-generated constructor stub
	}
	public int getAge() {
		return age;
	}

	/**
	 * Gets the person's age
	 * @param age person's age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonExtendsName [age=" + age + ", name= " + super.toString() + "]";
	}
	
	

}
