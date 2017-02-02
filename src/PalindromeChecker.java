import java.util.Scanner;

public class PalindromeChecker{
	String innerStr = "";
	public PalindromeChecker(String str){
		innerStr = str;
	}
	public String operation(){
		int length = innerStr.length();
		String reverse = "";
		for(int j=length-1; j>=0; j--){
			reverse = reverse + innerStr.charAt(j);
		}
		if (innerStr.equals(reverse)){
			//System.out.println("Entered string is a palindrome.");
			return "String is palindrome.";
		}
		else{
			//System.out.println("Entered string is not a palindrome.");
			return "String is not palindrome.";
		}
	}
}
