package leetcode.editor.cn;
//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 
// 👍 453 👎 0

import java.util.Stack;

public class P456One32Pattern {
    public static void main(String[] args) {
        Solution solution = new P456One32Pattern().new Solution();
        int[] arr = new int[]{3, 1, 4, 2};
        System.err.println(solution.find132pattern(arr));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            int[] min = new int[n];
            min[0] = nums[0];   // 第一个位置的最小数肯定就是它自己了
            // 将前一个位置的最小数和当前位置的数比较，找到当前位置的最小数
            for (int i = 1; i < n; ++i) min[i] = Math.min(min[i - 1], nums[i]);
            Stack<Integer> stack = new Stack<>();
            // 从后往前遍历，stack 中的数字表示的是从位置 i 到 n 中，大于 min[i] 且小于 nums[i] 的数
            for (int i = n - 1; i >= 0; --i) {
                if (nums[i] > min[i]) {
                    // 如果栈中的数字比 min[i] 还小或者相同，那么说明不可能是 ak，就弹出来
                    while (!stack.isEmpty() && stack.peek() <= min[i]) {
                        stack.pop();
                    }
                    // 检查一下栈顶元素是不是满足 ai<stack.peek()<aj，如果满足就说明找到了
                    if (!stack.isEmpty() && stack.peek() < nums[i]) {
                        return true;
                    }
                    // 不管怎样都要push进来当前的数，因为当前的数满足了大于 min[i]
                    stack.push(nums[i]);
                }
            }
            // 到最后都没找到，肯定只能返回false了
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}