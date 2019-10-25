package swordtooffer;

import java.util.HashMap;

public class _7_ConstructTree {
    public int pre_idx = 0;
    public TreeNode construct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }

        if (preOrder.length <= 0 || inOrder.length <= 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return constructRecursive(preOrder, inOrder, map, 0, inOrder.length);
    }

    public TreeNode constructRecursive(int[] preOrder, int[] inOrder, HashMap<Integer, Integer> map, int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }

        int rootValue = preOrder[pre_idx];
        TreeNode root = new TreeNode(rootValue);

        int index = map.get(rootValue);
        pre_idx++;
        root.left = constructRecursive(preOrder, inOrder, map, inLeft, index);
        root.right = constructRecursive(preOrder, inOrder, map, index + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode tree = new _7_ConstructTree().construct(preOrder, inOrder);
        System.out.println();

    }
}
