package illich.so;


import lombok.Data;

@Data
public class Node {

    private int key;
    private String name;

    private Node leftChild;
    private Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }
}
