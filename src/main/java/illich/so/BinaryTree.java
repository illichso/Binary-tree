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
                    if (focusNode == null || focusNode.getKey() == key) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null || focusNode.getKey() == key) {
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

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode != null && focusNode.getKey() != key) {
            if (key > focusNode.getKey()) {
                focusNode = focusNode.getRightChild();
            } else if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            }
        }
        return focusNode;
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

    public void removeNode(int key) {
        if (root == null) {
            return;
        }
        Node focusNode = root;
        Node parent;

        while (true) {
            parent = focusNode;
            if (key == focusNode.getKey()) {
                removeSpecifiedNode(parent, focusNode);
                return;
            } else if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
                if (focusNode.getKey() == key) {
                    removeSpecifiedNode(parent, focusNode);
                    return;
                }
            } else {
                focusNode = focusNode.getRightChild();
                if (focusNode.getKey() == key) {
                    removeSpecifiedNode(parent, focusNode);
                    return;
                }
            }
        }
    }

    private void removeSpecifiedNode(Node parent, Node focusNode) {
        if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
            parent.setLeftChild(null);
        } else if (focusNode.getLeftChild() == null && focusNode.getRightChild() != null) {
            parent.setLeftChild(focusNode.getRightChild());
        } else if (focusNode.getLeftChild() != null && focusNode.getRightChild() == null) {
            parent.setLeftChild(focusNode.getLeftChild());
        } else {
            if (focusNode.getRightChild().getLeftChild() == null) {
                focusNode.getRightChild().setLeftChild(focusNode.getLeftChild());
                parent.setLeftChild(focusNode.getRightChild());
            } else {
                System.out.println(focusNode);
            }
        }
    }
}
