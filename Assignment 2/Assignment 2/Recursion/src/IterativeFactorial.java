/**
 * Simple iterative factorial
 * @author mhrybyk
 *
 */
public class IterativeFactorial implements SequenceInterface {
	
	private String name;
	private int numberOfCalls = 0;
	
	// set the name of the sequence 
	public IterativeFactorial(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}
	
	/**
	 * Compute the factorial using iteration
	 * @param n
	 * @return factorial
	 */
	@Override
	public long compute(long n) {//**only code needs to do by myself.
		
		return 0;
	}

	@Override
	public void resetNumberOfCalls() {
		numberOfCalls = 0;
		
	}

	@Override
	public int getNumberOfCalls() {
		return numberOfCalls;
	}

}
