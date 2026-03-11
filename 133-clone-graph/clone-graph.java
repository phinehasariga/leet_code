/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Map to store original -> clone
        Map<Node, Node> map = new HashMap<>();

        // Queue for BFS
        Queue<Node> queue = new LinkedList<>();

        // create clone of first node
        map.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {

                // if neighbor not cloned yet
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                // add cloned neighbor to cloned current node
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}