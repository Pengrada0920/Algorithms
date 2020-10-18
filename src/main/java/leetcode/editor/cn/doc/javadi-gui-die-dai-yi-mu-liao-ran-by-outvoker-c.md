## 101. 对称二叉树

**题目：**

给定一个二叉树，检查它是否是镜像对称的。

**示例：**

```md
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
```

**进阶：**

你可以运用递归和迭代两种方法解决这个问题吗？

### 递归

一左一右，同时递归，不同*false*,相同*true*。

```java
class Solution {
    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && recur(left.left, right.right) && recur(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return recur(root, root);
    }
}
```

#### 复杂度分析

* 时间复杂度：*O(n)*
  
    遍历所有节点。
* 空间复杂度：*O(n)*

    栈深度不超过*O(n)*。

### 迭代

使用队列，开局放入两个*root*，每次取出两个节点判断是否相同，之后将左右子树对称位置分组放入队列。

```java
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll(), node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            else if ((node1 == null || node2 == null) || node1.val != node2.val) return false;
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
```

#### 复杂度分析

* 时间复杂度：*O(n)*
  
    遍历所有节点。
* 空间复杂度：*O(n)*

    最差情况递归栈深度为*O(n)*。

我的博客：<https://me.csdn.net/qq_20067165?ref=miniprofile>