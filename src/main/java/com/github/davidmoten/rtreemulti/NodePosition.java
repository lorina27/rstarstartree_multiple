package main.java.com.github.davidmoten.rtreemulti;

import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.geometry.Geometry;

//Mutable, not thread-safe
final class NodePosition<T, S extends Geometry> {

    private Node<T, S> node;
    private int position;

    NodePosition(Node<T, S> node, int position) {
        Preconditions.checkNotNull(node);
        this.node = node;
        this.position = position;
    }

    Node<T, S> node() {
        return node;
    }

    int position() {
        return position;
    }
    
    boolean hasRemaining() {
        return position != node.count();
    }
    
    void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        String builder = "NodePosition [node=" +
                node +
                ", position=" +
                position +
                "]";
        return builder;
    }

}
