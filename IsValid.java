import java.util.*;

class IsValid {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '(') {
                stack.push(')');
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (s.charAt(i) != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
            
        }
        return stack.size() == 0;
    }
}