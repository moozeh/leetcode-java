import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    st.push(c);
                    break;
                case ')':
                    if (st.peek() != '(') return false;
                    st.pop();
                    break;
                case '{':
                    st.push(c);
                    break;
                case '}':
                    if (st.peek() != '{') return false;
                    st.pop();
                    break;
                case '[':
                    st.push(c);
                    break;
                case ']':
                    if (st.peek() != '[') return false;
                    st.pop();
                    break;
                default:
                    return false;
            }
        }

        return st.empty();
    }
}