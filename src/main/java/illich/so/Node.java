package illich.so;


import lombok.EqualsAndHashCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (key != node.key) return false;
        return name != null ? name.equals(node.name) : node.name == null;
    }

    @Override
    public int hashCode() {
        int result = key;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
