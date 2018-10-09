package Default;
import java.util.Scanner;
public class Main {

    public static boolean isPalindrome(String word) {
        //sanitize the input to make it all lowercase and no spaces

        //check to see if the entered phrase is empty or just one letter
        if(word.length() == 0 || word.length() == 1){
            return true;
        }
        //check to see if the first and last char are the same then call do the same for the second and second last...
        //continue calling until no more letters
        if(word.charAt(0) == word.charAt(word.length()-1)){
            return isPalindrome(word.substring(1, word.length()-1));
        }
        return false;
    }

    //call isPalindrome and print out whether it returns tru or false
    public static String printOutcome(String x) {


        if(isPalindrome(x)){
            System.out.println(x + " is a palindrome.");
        } else {
            System.out.println(x + " is not a palindrome.");
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String word = keyboard.nextLine();

        word = word.toLowerCase();
        word = word.replaceAll("\\s", "");

        printOutcome(word);
    }
}
