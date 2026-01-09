/*
Title: Smallest Subtree with All the Deepest Nodes

Approach:
1. Use Depth-First Search (DFS) to traverse the binary tree.
2. For each node, compute two pieces of information:
   - The depth of the deepest node in its subtree.
   - The subtree root that contains all the deepest nodes.
3. Create a helper class `Result` to store:
   - node  → the root of the subtree containing all deepest nodes.
   - depth → the maximum depth from the current node.
4. During DFS:
   - If the current node is null, return depth = 0 and node = null.
   - Recursively compute results for left and right subtrees.
   - If left depth > right depth:
       → return left subtree’s result and increment depth.
   - If right depth > left depth:
       → return right subtree’s result and increment depth.
   - If both depths are equal:
       → current node is the lowest common ancestor of deepest nodes.
5. The final answer is the node returned from the DFS call on the root.

Time Complexity: O(n)
- Each node in the tree is visited exactly once.

Space Complexity: O(h)
- Due to recursive DFS call stack, where h is the height of the tree.
- In the worst case (skewed tree), h = n.
*/

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode node){
        if(node == null){
            return new Result(null,0);
        }
        Result left = dfs(node.left);
        Result right = dfs(node.right);

        if(left.depth > right.depth){
            return new Result(left.node, left.depth + 1);
        }
        else if(right.depth > left.depth){
            return new Result(right.node,right.depth + 1);
        }
        else{
            return new Result(node, left.depth + 1);
        }
    }
    private static class Result{
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}