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
        addDefinedNodes();

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

    private void addDefinedNodes() {
        binaryTree.addNode(root.getKey(), root.getName());
        binaryTree.addNode(visePres.getKey(), visePres.getName());
        binaryTree.addNode(officeManager.getKey(), officeManager.getName());
        binaryTree.addNode(secretary.getKey(), secretary.getName());
        binaryTree.addNode(salesManager.getKey(), salesManager.getName());
        binaryTree.addNode(salesman1.getKey(), salesman1.getName());
    }

    @Test
    public void testFindNodeByKey() throws Exception {
        addDefinedNodes();

        Node foundNode = BinaryTreeUtil.findNodeByKey(binaryTree.getRoot(), 15);
        assertEquals(officeManager, foundNode);
    }

    @Test
    public void testInsertNode() throws Exception {
        addDefinedNodes();

        Node salesman2 = new Node(60, "Salesman 2");
        BinaryTreeUtil.insertNode(salesman2);

        Node foundNode = BinaryTreeUtil.findNodeByKey(binaryTree.getRoot(), salesman2.getKey());
        assertEquals(salesman2, foundNode);

    }
}
