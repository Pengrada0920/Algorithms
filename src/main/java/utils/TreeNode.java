package utils;

import lombok.Data;

/**
 * @author wangpeng
 * @date 2020-10-12
 */
@Data
public class TreeNode {

    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

}
