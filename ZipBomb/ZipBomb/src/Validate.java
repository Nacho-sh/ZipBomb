import java.util.Arrays;

public class Validate {
    static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = {'2', 'p', 'e', 't', 'a', 's'};
 
        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }
 
        //Zero out the password.
        Arrays.fill(correctPassword,'0');
 
        return isCorrect;
    }
 
}
