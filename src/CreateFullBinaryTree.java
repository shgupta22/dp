import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateFullBinaryTree {

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }


        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        if (n <= 0 || n % 2 == 0) return new ArrayList<>();

        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int i = 1; i < n; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode curr = new TreeNode(0);
                    curr.left = l;
                    curr.right = r;
                    res.add(curr);
                }
            }
        }

        return res;
    }

    static Map<Integer, List<TreeNode>> map = new HashMap<>();

    public static List<TreeNode> allPossibleFBT_Memo(int n) {
        if (map.containsKey(n)) return map.get(n);

        if (n <= 0 || n % 2 == 0) return new ArrayList<>();

        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            map.put(n, res);
            return res;
        }

        for (int i = 1; i < n; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode curr = new TreeNode(0);
                    curr.left = l;
                    curr.right = r;
                    res.add(curr);
                }
            }
        }

        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(allPossibleFBT(7));
    }
}
