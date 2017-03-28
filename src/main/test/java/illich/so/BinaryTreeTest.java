package illich.so;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class BinaryTreeTest {
    private static BinaryTree binaryTree;
    private static Node boss50;
    private static Node visePres25;
    private static Node officeManager15;
    private static Node secretary30;
    private static Node salesManager75;
    private static Node salesman85;

    @BeforeClass
    public static void init() throws Exception {
        boss50 = new Node(50, "Boss");
        visePres25 = new Node(25, "Vise Pres");
        officeManager15 = new Node(15, "Office Manager");
        secretary30 = new Node(30, "Secretary");
        salesManager75 = new Node(75, "Sales Manager");
        salesman85 = new Node(85, "Salesman 1");
    }

    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree();
    }

    private void addDefinedNodes() {
        binaryTree.addNode(boss50.getKey(), boss50.getName());
        binaryTree.addNode(visePres25.getKey(), visePres25.getName());
        binaryTree.addNode(officeManager15.getKey(), officeManager15.getName());
        binaryTree.addNode(secretary30.getKey(), secretary30.getName());
        binaryTree.addNode(salesManager75.getKey(), salesManager75.getName());
        binaryTree.addNode(salesman85.getKey(), salesman85.getName());

        printTree();
    }

    private void printTree() {
        binaryTree.inOrderTraverseTree(binaryTree.getRoot());
        System.out.println("=====================================");
    }

    @Test
    public void testCreateBinaryTree() throws Exception {
        addDefinedNodes();

        assertEquals(boss50, binaryTree.getRoot());

        assertEquals(visePres25, binaryTree.getRoot().getLeftChild());
        assertEquals(salesManager75, binaryTree.getRoot().getRightChild());

        assertEquals(officeManager15, binaryTree.getRoot().getLeftChild().getLeftChild());
        assertEquals(secretary30, binaryTree.getRoot().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getLeftChild());
        assertEquals(salesman85, binaryTree.getRoot().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void testInsertNode() throws Exception {
        addDefinedNodes();

        Node salesman3 = new Node(35, "Secretary2");

        binaryTree.addNode(salesman3.getKey(), salesman3.getName());

        printTree();

        assertEquals(boss50, binaryTree.getRoot());

        assertEquals(visePres25, binaryTree.getRoot().getLeftChild());
        assertEquals(salesManager75, binaryTree.getRoot().getRightChild());

        assertEquals(officeManager15, binaryTree.getRoot().getLeftChild().getLeftChild());
        assertEquals(secretary30, binaryTree.getRoot().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getLeftChild());
        assertEquals(salesman3, binaryTree.getRoot().getLeftChild().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getLeftChild());
        assertEquals(salesman85, binaryTree.getRoot().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void testInsertNodeWithTheSameKey() throws Exception {
        addDefinedNodes();

        Node salesman3 = new Node(30, "Secretary Substitute");
        binaryTree.insertNode(salesman3);

        printTree();

        assertEquals(boss50, binaryTree.getRoot());

        assertEquals(visePres25, binaryTree.getRoot().getLeftChild());
        assertEquals(salesManager75, binaryTree.getRoot().getRightChild());

        assertEquals(officeManager15, binaryTree.getRoot().getLeftChild().getLeftChild());
        assertEquals(salesman3, binaryTree.getRoot().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getLeftChild());
        assertEquals(salesman85, binaryTree.getRoot().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void testFindNodeWithRootByKey() throws Exception {
        addDefinedNodes();

        Node foundNodeOfficeManager = binaryTree.findNodeByKey(binaryTree.getRoot(), 15);
        Node foundBoss = binaryTree.findNodeByKey(binaryTree.getRoot(), 50);

        assertEquals(officeManager15, foundNodeOfficeManager);
        assertEquals(boss50, foundBoss);
    }

    @Test
    public void testFindNodeByKey() throws Exception {
        addDefinedNodes();

        Node foundNodeOfficeManager = binaryTree.findNodeByKey(15);
        Node foundBoss = binaryTree.findNodeByKey(binaryTree.getRoot(), 50);

        assertEquals(officeManager15, foundNodeOfficeManager);
        assertEquals(boss50, foundBoss);
    }

    @Test
    public void testRemoveMiddleNodeWithoutChildren() throws Exception {
        addDefinedNodes();

        binaryTree.removeNode(officeManager15.getKey());

        printTree();

        assertEquals(boss50, binaryTree.getRoot());

        assertEquals(visePres25, binaryTree.getRoot().getLeftChild());
        assertEquals(salesManager75, binaryTree.getRoot().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild());
        assertEquals(secretary30, binaryTree.getRoot().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getLeftChild());
        assertEquals(salesman85, binaryTree.getRoot().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getRightChild());
    }

    @Test
    public void testRemoveMiddleNodeWithoutLeftChild() throws Exception {
        addDefinedNodes();
        printTree();
        binaryTree.removeNode(salesManager75.getKey());
        printTree();

        assertEquals(boss50, binaryTree.getRoot());

        assertEquals(visePres25, binaryTree.getRoot().getLeftChild());
        assertEquals(salesman85, binaryTree.getRoot().getRightChild());

        assertEquals(officeManager15, binaryTree.getRoot().getLeftChild().getLeftChild());
        assertEquals(secretary30, binaryTree.getRoot().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getRightChild().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild());
    }
}
