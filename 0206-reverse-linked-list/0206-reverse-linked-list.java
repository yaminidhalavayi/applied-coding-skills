class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            
            // Save the next node
            ListNode nextNode = current.next;

            // Reverse the link
            current.next = previous;

            // Move previous and current forward
            previous = current;
            current = nextNode;
        }

        return previous;
    }
}