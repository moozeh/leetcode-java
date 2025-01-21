import java.util.Stack;

class Solution {
    class Pair {
        int idx;
        int value;

        public Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<>();
        int[] ret = new int[temperatures.length];
        
        for (int i = temperatures.length - 1; i >= 0; --i) {
            while (true) {
                if (st.empty()) {
                    ret[i] = 0;
                    break;
                }

                if (st.peek().value > temperatures[i]) {
                    ret[i] = st.peek().idx - i + 1;
                    break;
                }
                else {
                    st.pop();
                }
            }

            st.push(new Pair(temperatures[i], i));
        }

        return ret;
    }
}