/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
                List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            result.add(currentNode.val); // Visit the node

            // Push children onto the stack from right to left
            // to ensure they are processed from left to right (LIFO).
            for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                stack.push(currentNode.children.get(i));
            }
        }

        return result;
    }
}