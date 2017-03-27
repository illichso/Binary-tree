package illich.so;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BinaryTreeTest {
    private static BinaryTree binaryTree;
    private static Node root;
    private static Node visePres;
    private static Node officeManager;
    private static Node secretary;
    private static Node salesManager;
    private static Node salesman1;

    @BeforeClass
    public static void init() throws Exception {
        root = new Node(50, "Boss");
        visePres = new Node(25, "Vise Pres");
        officeManager = new Node(15, "Office Manager");
        secretary = new Node(30, "Secretary");
        salesManager = new Node(75, "Sales Manager");
        salesman1 = new Node(85, "Salesman 1");
    }

    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree();
    }

    @Test
    public void testAddNode() throws Exception {
        Node root = new Node(50, "Boss");
        Node visePres = new Node(25, "Vise Pres");
        Node officeManager = new Node(15, "Office Manager");
        Node secretary = new Node(30, "Secretary");
        Node salesManager = new Node(75, "Sales Manager");
        Node salesman1 = new Node(85, "Salesman 1");

        binaryTree.addNode(root.getKey(), root.getName());
        binaryTree.addNode(visePres.getKey(), visePres.getName());
        binaryTree.addNode(officeManager.getKey(), officeManager.getName());
        binaryTree.addNode(secretary.getKey(), secretary.getName());
        binaryTree.addNode(salesManager.getKey(), salesManager.getName());
        binaryTree.addNode(salesman1.getKey(), salesman1.getName());

        assertEquals(binaryTree.getRoot(), root);
        assertEquals(binaryTree.getRoot().getLeftChild(), visePres);
        assertEquals(binaryTree.getRoot().getLeftChild().getLeftChild(), officeManager);
        assertEquals(binaryTree.getRoot().getLeftChild().getRightChild(), secretary);

        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getRightChild());

        assertEquals(binaryTree.getRoot().getRightChild(), salesManager);

        assertNull(binaryTree.getRoot().getRightChild().getLeftChild());
        assertEquals(binaryTree.getRoot().getRightChild().getRightChild(), salesman1);
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void testFindNodeByKey() throws Exception {
        Node foundNode = binaryTree.findNodeByKey(15);
        assertEquals(foundNode, officeManager);
    }
}
