
import java.util.Stack;

class MyQueue {
    Stack<Integer> st = new Stack<>();
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        int[] container = new int[st.size() - 1];
        for (int i=0; i<container.length; ++i) {
            container[i] = st.pop();
        }
        int ret = st.pop();
        for (int i=container.length - 1; i>=0; --i) {
            st.push(container[i]);
        }
        return ret;
    }
    
    public int peek() {
        int[] container = new int[st.size() - 1];
        for (int i=0; i<container.length; ++i) {
            container[i] = st.pop();
        }
        int ret = st.peek();
        for (int i=container.length - 1; i>=0; --i) {
            st.push(container[i]);
        }
        return ret;
    }
    
    public boolean empty() {
        return st.empty();
    }
}