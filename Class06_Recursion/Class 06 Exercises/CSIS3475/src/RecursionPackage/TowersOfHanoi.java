package RecursionPackage;

/**
 * Solve the towers of hanoi puzzle
 * @author mhrybyk
 *
 */
public class TowersOfHanoi {

	public static void main(String[] args) {
		
		// solve the tower of hanoi with a pre-fixed number of disks
		
        int n = 6; // Number of disks 
        
        // name the rods A, B, and C. Note that the third arg is the temp rode
        // which to start is the middle one.
        
        towerOfHanoi(n, 'A', 'C', 'B');  

	}
	/**
	 * Solve the tower of hanoi using recursion
	 * 
	 * @param numberOfDisks number of disks
	 * @param startRod starting rod
	 * @param endRod ending rod
	 * @param tempRod temp rod
	 */
    static void towerOfHanoi(int numberOfDisks, char startRod, char endRod, char tempRod) 
    { 
        if (numberOfDisks == 1) 
        { 
            System.out.println("Move disk 1 from rod " +  startRod + " to rod " + endRod); 
            return; 
        } 
        
        // move all but one disk from startRod to tempRod using endRod as temp
        towerOfHanoi(numberOfDisks - 1, startRod, tempRod, endRod); 
        
        // move disk from startRod to endRod
        System.out.println("Move disk " + numberOfDisks + " from rod " +  startRod + " to rod " + endRod); 
        
        // move all but one disk from tempRod to endRod using startRod as temp
        towerOfHanoi(numberOfDisks - 1, tempRod, endRod, startRod); 
    } 

}
