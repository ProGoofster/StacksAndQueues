import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BalancedBrackets {

    public static void main(String[] args){
        System.out.println(IsBalanced("{[()]}"));
        System.out.println(IsBalanced("{[(])}"));
        System.out.println(IsBalanced("{{[[(())]]}}"));
    }

    //time complexity: O(n) where n is the length of the string (it's O(n/2) but simplifies down)
    //space complexity: O(1), amount of variables declared doesn't grow with input
    public static String IsBalanced(String s){
        if(s.length() % 2 != 0) return "NO";
        int i = 0;
        int j = s.length()-1;

        while (i < (s.length()-1)/2 && j > (s.length()-1)/2) {
            if(!DoBracketsMatch(s.charAt(i), s.charAt(j))) return "NO";
            i++;
            j--;
        }

        return "YES"; //this is so dumb why can't I just return a boolean.
    }

    private static boolean DoBracketsMatch(char open, char close){
        return (open == '(' && close == ')') || ( open == '{' && close == '}') ||( open == '[' && close == ']');
    }
}
