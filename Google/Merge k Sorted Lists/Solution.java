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
        if(lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
    
    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start >= end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1), iter = dummy;
        while(left != null || right != null){
            if(left == null){
                iter.next = right;
                right = right.next;
            } else if(right == null){
                iter.next = left;
                left = left.next;
            } else if(left.val <= right.val){
                iter.next = left;
                left = left.next;
            } else {
                iter.next = right;
                right = right.next;
            }
            
            iter = iter.next;
        }    
        return dummy.next;
    }
}
