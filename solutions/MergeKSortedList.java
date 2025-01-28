import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = new ListNode();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int k = lists.length;
        for (int i=0; i<k; ++i) {
            while (lists[i] != null) {
                pq.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        while (!pq.isEmpty()) {
            ListNode newnode = new ListNode(pq.poll());
            newnode.next = ret;
            ret = newnode;
        }

        return ret;
    }
}