import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));       // Output: "aaabcbc"
        System.out.println(decodeString("3[a2[c]]"));        // Output: "accaccacc"
        System.out.println(decodeString("2[abc]3[cd]ef"));   // Output: "abcabccdcdcdef"
    }

    // Time Complexity O(n⋅m^k) where n is the length of the string, and m is largest number, and k is the depth
    // Space Complexity O(n) where n
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();

        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');

            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for (int i = 0; i < count; i++) decodedString.append(currentString);
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}