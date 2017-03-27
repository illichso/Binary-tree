package illich.so;

public class BinaryTreeUtil {

    public static Node findNodeByKey(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key == node.getKey()) {
            return node;
        } else if (key > node.getKey()) {
            return findNodeByKey(node.getRightChild(), key);
        } else {
            return findNodeByKey(node.getLeftChild(), key);
        }

    }

    public static void insertNode(Node salesman2) {

    }
}
