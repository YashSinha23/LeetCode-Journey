/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<lists.length; i++){
            while(lists[i]!=null){
                heap.offer(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!heap.isEmpty()){
            int val = heap.poll();
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }
}