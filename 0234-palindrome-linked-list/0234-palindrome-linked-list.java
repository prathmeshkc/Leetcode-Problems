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
//mid
//rev
//comp
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        return compare(head, revLL(findMid(head)));
        
    }
    
    private ListNode findMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    
    private ListNode revLL(ListNode head) {
        if(head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    
    private boolean compare(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        
        while((p1 != null && p2 != null)) {

            if((p1 == null && p2 != null) || (p2 == null && p1 != null)) {
                p1 = p1.next;
                p2 = p2.next;
            }
            
            if(p1.val != p2.val) return false;
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
}
