/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int prevCritical = -1;
        int firstCritical = -1;

        ListNode prev = head;
        ListNode curr = head.next;
        int minDist = Integer.MAX_VALUE;

        int idx = 2;
        while (curr.next != null) {

            if (curr.val > prev.val && curr.val > curr.next.val || curr.val < prev.val && curr.val < curr.next.val) {
                if (firstCritical == -1) {
                    firstCritical = idx;
                } else {
                    minDist = Math.min(minDist, idx - prevCritical);
                }
                prevCritical = idx;
            }

            prev = curr;
            curr = curr.next;
            idx++;
        }

        if (firstCritical == -1 || prevCritical == firstCritical) {
            return new int[] { -1, -1 };
        }

        int maxDist = prevCritical - firstCritical;

        return new int[] { minDist, maxDist };
    }
}