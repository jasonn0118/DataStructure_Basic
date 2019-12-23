
/**
 * Simple test of LetterGrade enum as a class
 * @author mhrybyk
 *
 */
public class LetterGradeDemo {

	public static void main(String[] args) {
		LetterGrade myGrade = LetterGrade.A_MINUS;

		System.out.println(myGrade);
		System.out.println(myGrade.getGrade());
		System.out.println(myGrade.getQualityPoints());
	}

}

/* output

A- 3.7
A-
3.7

*/