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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> valuesToRemove = new HashSet<>();
        for (int num : nums){
            valuesToRemove.add(num);
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null){
            if (valuesToRemove.contains(curr.val)){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;  
    }
}
