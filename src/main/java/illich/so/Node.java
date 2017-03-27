package illich.so;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude={"leftChild", "rightChild"})
public class Node {

    private int key;
    private String name;

    private Node leftChild;
    private Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }
}
