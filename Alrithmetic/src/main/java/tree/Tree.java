package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree<T extends Comparable<? super T>> {

    private TreeNode<T> root;

    public void insert(T x) {
        root = insert(x, root);
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    private TreeNode<T> insert(T x, TreeNode<T> t) {
        if(t == null) {
            return new TreeNode<>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0) {
            t.left = insert(x, t.left);
        }
        else if(compareResult > 0) {
            t.right = insert(x, t.right);
        }

        return t;
    }

    /**
     * 前序遍历
     * 递归
     */
    public void preOrder(TreeNode<T> node)
    {
        if (node != null)
        {
            System.out.print(node.element + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     * 递归
     */
    public void midOrder(TreeNode<T> node)
    {
        if (node != null)
        {
            midOrder(node.left);
            System.out.print(node.element + " ");
            midOrder(node.right);
        }
    }

    /**
     * 后序遍历
     * 递归
     */
    public void posOrder(TreeNode<T> node)
    {
        if (node != null)
        {
            posOrder(node.left);
            posOrder(node.right);
            System.out.print(node.element + " ");
        }
    }

    /*
     * 层序遍历
     * 递归
     */
    public void levelOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }

        int depth = depth(node);

        for (int i = 1; i <= depth; i++) {
            levelOrder(node, i);
        }
    }

    private void levelOrder(TreeNode<T> node, int level) {
        if (node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(node.element + "  ");
            return;
        }

        // 左子树
        levelOrder(node.left, level - 1);

        // 右子树
        levelOrder(node.right, level - 1);
    }

    public int depth(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        int l = depth(node.left);
        int r = depth(node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    /**
     * 前序遍历
     * 非递归
     */
    public void preOrder1(TreeNode<T> node)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.empty())
        {
            while(node != null) {
                System.out.print(node.element + "   ");
                stack.push(node);
                node = node.left;
            }
            if(!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历
     * 非递归
     */
    public void midOrder1(TreeNode<T> node) {
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if(!stack.empty()) {
                node = stack.pop();
                System.out.print(node.element + "   ");
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     * 非递归
     */
    public void posOrder1(TreeNode<T> Node) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while(Node != null || !stack1.empty()) {
            while (Node != null) {
                stack1.push(Node);
                stack2.push(0);
                Node = Node.left;
            }

            while(!stack1.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.print(stack1.pop().element + "   ");
            }

            if(!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                Node = stack1.peek();
                Node = Node.right;
            }
        }
    }

    /*
     * 层序遍历
     * 非递归
     */
    public void levelOrder1(TreeNode<T> Node) {
        if (Node == null) {
            return;
        }

        TreeNode<T> binaryNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(Node);

        while (!queue.isEmpty()) {
            binaryNode = queue.poll();

            System.out.print(binaryNode.element + "  ");

            if (binaryNode.left != null) {
                queue.offer(binaryNode.left);
            }
            if (binaryNode.right != null) {
                queue.offer(binaryNode.right);
            }
        }
    }

    public static void main( String[] args ) {
        int[] input = {4, 2, 6, 1, 3, 5, 7, 8, 10};
        Tree<Integer> tree = new Tree<>();
        for (int i = 0; i < input.length; i++) {
            tree.insert(input[i]);
        }
        System.out.print("递归前序遍历 ：");
        tree.preOrder(tree.root);
        System.out.print("\n非递归前序遍历：");
        tree.preOrder1(tree.root);
        System.out.print("\n递归中序遍历 ：");
        tree.midOrder(tree.root);
        System.out.print("\n非递归中序遍历 ：");
        tree.midOrder1(tree.root);
        System.out.print("\n递归后序遍历 ：");
        tree.posOrder(tree.root);
        System.out.print("\n非递归后序遍历 ：");
        tree.posOrder1(tree.root);
        System.out.print("\n递归层序遍历：");
        tree.levelOrder(tree.root);
        System.out.print("\n非递归层序遍历 ：");
        tree.levelOrder1(tree.root);
    }
}
