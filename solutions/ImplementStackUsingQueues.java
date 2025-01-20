import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        if (q.isEmpty()) return -1;
        var len = q.size();
        for (int i=0; i<len-1; ++i) {
            q.add(q.poll());
        }
        var ret = q.peek();
        q.poll();
        
        return ret;
    }
    
    public int top() {
        if (q.isEmpty()) return -1;
        var len = q.size();
        for (int i=0; i<len-1; ++i) {
            q.add(q.poll());
        }
        var ret = q.peek();
        q.add(q.poll());
        
        return ret;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}