package illich.so;

import lombok.Getter;

public class BinaryTree {
    @Getter
    private Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;
                if (key < focusNode.getKey()) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }

    }


    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.getLeftChild());
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.getRightChild());

        }
    }

    public Node findNodeByKey(Node node, int key) {
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


    public void insertNode(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        Node focusNode = root;
        Node parent;

        while (true) {
            parent = focusNode;
            if (node.getKey() < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
                if (focusNode == null || focusNode.getKey() == node.getKey()) {
                    parent.setLeftChild(node);
                    return;
                }
            } else {
                focusNode = focusNode.getRightChild();
                if (focusNode == null || focusNode.getKey() == node.getKey()) {
                    parent.setRightChild(node);
                    return;
                }
            }
        }

    }

    public void removeNode(Node node) {
        if (root == null) {
            return;
        }
        Node focusNode = root;
        Node parent;

        while (true) {
            parent = focusNode;
            if (node.getKey() < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
                if (focusNode.getKey() == node.getKey()) {
                    parent.setLeftChild(null);
                    return;
                }
            } else {
                focusNode = focusNode.getRightChild();
                if (focusNode.getKey() == node.getKey()) {
                    parent.setRightChild(null);
                    return;
                }
            }
        }
    }
}
