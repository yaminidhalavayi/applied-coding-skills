class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;

        for (int i = 0; i < k; i++) {
            if (current == null) {
                return head;
            }
            current = current.next;
        }

        ListNode prev = null;
        current = head;

        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

    
        head.next = reverseKGroup(current, k);

        return prev;
    }
}