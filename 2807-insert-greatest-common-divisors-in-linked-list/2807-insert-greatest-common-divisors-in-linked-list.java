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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode curr = head;
        ListNode temp = curr.next;
        
        while(temp != null) {
            int a = curr.val;
            int b = temp.val;
            ListNode gcdNode = new ListNode(gcd(a, b));
            gcdNode.next = temp;
            curr.next = gcdNode;
            curr = temp;
            temp = temp.next;
        }
        
        
        return head;
    }
    
    
    private int gcd(int a, int b) {
        if(b == 0) return a;
        
        return gcd(b, a % b);
    }
}