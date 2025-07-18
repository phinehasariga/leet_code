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
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root,result);
        return result;
    }
    public static void postorder(Node node,List<Integer> result){
        if(node == null){
            return;
        }
        for (Node child : node.children) {
            postorder(child, result);  // Traverse all children
        }
        result.add(node.val); 
    }
}