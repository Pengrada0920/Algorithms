package leetcode.editor.cn;
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics 链表 数学 
// 👍 5108 👎 0

public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(9);
//        ListNode l1111 = new ListNode(3);

        l1.next = l11;
        l11.next = l111;
//        l111.next = l1111;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l222 = new ListNode(4);
        ListNode l2222 = new ListNode(9);

        l2.next = l22;
        l22.next = l222;
        l222.next = l2222;

        ListNode result = solution.addTwoNumbers(l1, l2);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode first = dummy;
            dummy.next = first;
            int addOne = 0;
            while (l1 != null || l2 != null) {
                int v1 = 0;
                int v2 = 0;
                if (l1 != null) {
                    v1 = l1.val;
                }
                if (l2 != null) {
                    v2 = l2.val;
                }

                int sum = v1 + v2 + addOne;
                addOne = sum / 10;
                int curr = sum % 10;
                ListNode currNode = new ListNode(curr);
                first.next = currNode;
                first = first.next;
                if(l1 != null){
                    l1 = l1.next;
                }
                if(l2 != null){
                    l2 = l2.next;
                }
            }
            if (addOne != 0) {
                first.next = new ListNode(1);
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}