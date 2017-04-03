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

    public int getDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.getLeftChild()), getDepth(node.getRightChild()));
    }

    public boolean removeNode(int key) {
        Node focusNode = root;
        Node parent = root;
        boolean isItALeftChild = true;

        while (focusNode.getKey() != key) {
            parent = focusNode;
            if (key < focusNode.getKey()) {
                isItALeftChild = true;
                focusNode = focusNode.getLeftChild();
            } else {
                isItALeftChild = false;
                focusNode = focusNode.getRightChild();
            }

            if (focusNode == null) {
                return false;
            }
        }

        if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (focusNode.getRightChild() == null) {
            if (focusNode == root) {
                root = focusNode.getLeftChild();
            } else if (isItALeftChild) {
                parent.setLeftChild(focusNode.getLeftChild());
            } else {
                parent.setRightChild(focusNode.getLeftChild());
            }
        } else if (focusNode.getLeftChild() == null) {
            if (focusNode == root) {
                root = focusNode.getRightChild();
            } else if (isItALeftChild) {
                parent.setLeftChild(focusNode.getRightChild());
            } else {
                parent.setRightChild(focusNode.getLeftChild());
            }
        } else {
            Node replacementNode = getReplacement(focusNode);
            if (focusNode == root) {
                root = replacementNode;
            } else if (isItALeftChild) {
                parent.setLeftChild(replacementNode);
            } else {
                parent.setRightChild(replacementNode);
            }
            replacementNode.setLeftChild(focusNode.getLeftChild());
        }

        return true;

    }

    private Node getReplacement(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.getRightChild();

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.getLeftChild();
        }

        if (replacement != replacedNode.getRightChild()) {
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(replacedNode.getRightChild());
        }
        return replacement;
    }

    public int findDepth(Node node) {
        int result = -1;
        boolean found = false;
        Node focusNode = root;
        while (true) {
            if (node == null || focusNode == null) {
                break;
            }
            result++;
            if (node.getKey() == focusNode.getKey()) {
                found = true;
                break;
            } else if (node.getKey() < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else {
                focusNode = focusNode.getRightChild();
            }
        }

        return found ? result : -1;

    }
}
