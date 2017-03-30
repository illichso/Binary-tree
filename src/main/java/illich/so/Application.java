package illich.so;

public class Application {

    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vise Pres");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");

        theTree.inOrderTraverseTree(theTree.getRoot());
    }
}
