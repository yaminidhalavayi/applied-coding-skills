class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move 1 step
            fast = fast.next.next;  // Move 2 steps
        }

        return slow;
    }
}