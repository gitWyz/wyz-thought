package tree;

/**
 * @author wangyz
 * @date 2022/3/22
 */
public class TreeNode<T> {
    T element;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode(T element)
    {
        this(element, null, null);
    }
    TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
