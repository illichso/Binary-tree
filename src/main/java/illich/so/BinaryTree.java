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

//    public void removeNode(int key) {
//        Node focusNode = root;
//        Node parent;
//
//        while (true) {
//            parent = focusNode;
//            if (key < focusNode.getKey()) {
//                focusNode = focusNode.getLeftChild();
//                if (focusNode.getKey() == key) {
//                    if (focusNode.getLeftChild() != null) {
//                        Node leftFocusNode = focusNode.getLeftChild();
//                        focusNode = focusNode.getRightChild();
//                        focusNode.setLeftChild(leftFocusNode);
//                        parent.setLeftChild(focusNode);
//                        return;
//                    } else {
//                        focusNode = focusNode.getRightChild();
//                        parent.setLeftChild(focusNode);
//                    }
//                    parent.setLeftChild(focusNode);
//                    return;
//                }
//            } else {
//                focusNode = focusNode.getRightChild();
//                if (focusNode.getKey() == key) {
//                    if (focusNode.getRightChild() != null) {
//                        Node leftFocusNode = focusNode.getLeftChild();
//                        focusNode = focusNode.getRightChild();
//                        focusNode.setLeftChild(leftFocusNode);
//                        parent.setLeftChild(focusNode);
//                        return;
//                    } else {
//                        focusNode = focusNode.getRightChild();
//                        parent.setLeftChild(focusNode);
//                    }
//                    parent.setLeftChild(focusNode);
//                    return;
//                }
//            }
//        }
//
////        while (true) {
////            parent = focusNode;
////            if (focusNode != null && key == focusNode.getKey()) {
////                if (focusNode.getRightChild() != null) {
////                    if (focusNode.getLeftChild() != null) {
////                        Node leftFocusNode = focusNode.getLeftChild();
////                        focusNode = focusNode.getRightChild();
////                        focusNode.setLeftChild(leftFocusNode);
////                        return;
////                    } else {
////                        focusNode = focusNode.getRightChild();
////                        return;
////                    }
////                } else {
////                    focusNode = null;
////                    return;
////                }
////            } else if (focusNode != null && key < focusNode.getKey() && focusNode.getLeftChild() != null) {
////                focusNode = focusNode.getLeftChild();
////            } else if (focusNode != null && key > focusNode.getKey() && focusNode.getRightChild() != null) {
////                focusNode = focusNode.getRightChild();
////            }
////        }
//
////    }
//
////    public void removeNode(int key) {
////        if (root == null) {
////            return;
////        }
////        Node focusNode = root;
////        Node parent;
////
////        while (true) {
////            parent = focusNode;
////            if (key == focusNode.getKey()) {
////                removeSpecifiedNode(parent, focusNode);
////                return;
////            } else if (key < focusNode.getKey()) {
////                focusNode = focusNode.getLeftChild();
////                if (focusNode.getKey() == key) {
////                    removeSpecifiedNode(parent, focusNode);
////                    return;
////                }
////            } else {
////                focusNode = focusNode.getRightChild();
////                if (focusNode.getKey() == key) {
////                    removeSpecifiedNode(parent, focusNode);
////                    return;
////                }
////            }
////        }
////    }
////
////    private void removeSpecifiedNode(Node parent, Node focusNode) {
////        if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
////            parent.setLeftChild(null);
////        } else if (focusNode.getLeftChild() == null && focusNode.getRightChild() != null) {
////            parent.setLeftChild(focusNode.getRightChild());
////        } else if (focusNode.getLeftChild() != null && focusNode.getRightChild() == null) {
////            parent.setLeftChild(focusNode.getLeftChild());
////        } else {
////            if (focusNode.getRightChild().getLeftChild() == null) {
////                focusNode.getRightChild().setLeftChild(focusNode.getLeftChild());
////                parent.setLeftChild(focusNode.getRightChild());
////            } else {
////                System.out.println(focusNode);
////            }
////        }
////    }
}
