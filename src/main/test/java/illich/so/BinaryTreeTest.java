package illich.so;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class BinaryTreeTest {
    private static BinaryTree binaryTree;
    private static Node boss;
    private static Node visePres;
    private static Node officeManager;
    private static Node secretary;
    private static Node salesManager;
    private static Node salesman1;

    @BeforeClass
    public static void init() throws Exception {
        boss = new Node(50, "Boss");
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

        assertEquals(boss, binaryTree.getRoot());
        assertEquals(visePres, binaryTree.getRoot().getLeftChild());
        assertEquals(officeManager, binaryTree.getRoot().getLeftChild().getLeftChild());
        assertEquals(secretary, binaryTree.getRoot().getLeftChild().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getRightChild());

        assertEquals(salesManager, binaryTree.getRoot().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getLeftChild());
        assertEquals(salesman1, binaryTree.getRoot().getRightChild().getRightChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getRightChild());
    }

    private void addDefinedNodes() {
        binaryTree.addNode(boss.getKey(), boss.getName());
        binaryTree.addNode(visePres.getKey(), visePres.getName());
        binaryTree.addNode(officeManager.getKey(), officeManager.getName());
        binaryTree.addNode(secretary.getKey(), secretary.getName());
        binaryTree.addNode(salesManager.getKey(), salesManager.getName());
        binaryTree.addNode(salesman1.getKey(), salesman1.getName());
    }

    @Test
    public void testFindNodeByKey() throws Exception {
        addDefinedNodes();

        Node foundNodeOfficeManager = binaryTree.findNodeByKey(binaryTree.getRoot(), 15);
        Node foundBoss = binaryTree.findNodeByKey(binaryTree.getRoot(), 50);

        assertEquals(officeManager, foundNodeOfficeManager);
        assertEquals(boss, foundBoss);
    }

    @Test
    public void testInsertNode() throws Exception {
        addDefinedNodes();

        Node salesman2 = new Node(60, "Salesman 2");
        binaryTree.insertNode(salesman2);

        Node foundNode = binaryTree.findNodeByKey(binaryTree.getRoot(), salesman2.getKey());
        assertEquals(salesman2, foundNode);

    }

    @Test
    public void testOverrideNode() throws Exception {
        addDefinedNodes();

        Node salesman3 = new Node(30, "Secretary Substitute");
        binaryTree.insertNode(salesman3);

        Node foundNode = binaryTree.findNodeByKey(binaryTree.getRoot(), salesman3.getKey());
        assertEquals(salesman3, foundNode);
        assertEquals(salesman3.getKey(), foundNode.getKey());
        assertNotEquals(secretary, foundNode);
        assertEquals(secretary.getKey(), foundNode.getKey());
    }

    @Test
    public void testRemoveNode() throws Exception {
        addDefinedNodes();

        binaryTree.removeNode(visePres);

        assertEquals(boss, binaryTree.getRoot());
        assertEquals(officeManager, binaryTree.getRoot().getLeftChild());
        assertEquals(secretary, binaryTree.getRoot().getRightChild());

        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getLeftChild());
        assertNull(binaryTree.getRoot().getLeftChild().getLeftChild().getRightChild());

        assertEquals(salesManager, binaryTree.getRoot().getRightChild());

        assertNull(binaryTree.getRoot().getRightChild().getLeftChild());
        assertEquals(salesman1, binaryTree.getRoot().getRightChild().getRightChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getLeftChild());
        assertNull(binaryTree.getRoot().getRightChild().getRightChild().getRightChild());
    }
}
