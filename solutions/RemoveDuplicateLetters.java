import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        boolean[] dict = new boolean[26]; // 사전
        int[] counts = new int[26]; // 앞으로 나올 문자

        for (int i = 0; i < s.length(); ++i) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); ++i) {
            int t = s.charAt(i) - 'a';
            counts[t]--;

            // 이미 stack 에 출력시킨 여부. 중복해서 넣을 이유는 없다.
            if (dict[t])
                continue;

            // 1. 사전 순서 상으로 증가해야 좋은 방향
            // 2. 앞 과정에서부터 1번 과정을 처리했기 때문에, 굳이 사전 순서상으로 역순이나, 이후에 나올 문자는 한번만 빼면 된다.
            while (!st.isEmpty()) {
                char top = st.peek();

                // 이후에 나올 문자열이면서, 사전순으로 역순이면 나중에 넣으면 된다.
                // 동시에, 스택에 들어있는 역순 문자가 앞으로 나오지 않는 문자라면, 해당 문자는 현재 넣어진 순서가 최선이라는 뜻이 된다.
                if (top - 'a' > t && counts[top - 'a'] != 0) {
                    dict[top - 'a'] = false; // 스택에는 모든 문자는 중복해서 들어가지 않는다.
                    st.pop();
                } else {
                    break;
                }
            }

            st.push(s.charAt(i));
            dict[t] = true;
        }

        StringBuilder builder = new StringBuilder();

        dict = new boolean[26];

        while (!st.empty()) {
            builder.insert(0, st.peek());
            st.pop();
        }

        return builder.toString();
    }
}