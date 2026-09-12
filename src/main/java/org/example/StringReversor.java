package org.example;
import java.util.Stack;

public class StringReversor {
    public static String reverseString(String str) {
        //Handle Edge Cases
        if (str == null || str.isEmpty()) {
            return str;
        }

        Stack<Character> stack = new Stack<>();

        // Step 1: Push all characters onto the stack
        for(char c : str.toCharArray()) {
            stack.push(c);
        }

        // Step 2: Pop them off to build the reversed string
        StringBuilder reversedString = new StringBuilder();
        while(!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Karla"));
    }
}
