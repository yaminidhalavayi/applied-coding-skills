class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        // Check if there are at least k nodes
        ListNode current = head;
        int count = 0;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // If less than k nodes remain, do not reverse
        if (count < k) {
            return head;
        }

        // Reverse k nodes
        ListNode previous = null;
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        // Recursively reverse the remaining nodes
        head.next = reverseKGroup(current, k);

        // previous is the new head of this group
        return previous;
    }
}