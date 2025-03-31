package BST;

public class Bnode <T extends Comparable<T>> {
    public T data;
    public Bnode<T> parent;
    public Bnode<T> leftChild;
    public Bnode<T> rightChild;

    public Bnode(T data) {
        parent = leftChild = rightChild = null;
        this.data = data;
    }

    public Bnode(Bnode<T> p, Bnode<T> lc, Bnode<T> rc) {
        this.data = data;
        this.leftChild = lc;
        this.rightChild = rc;
        this.parent = p;
    }

    public void removeChild(Bnode<T> child) {
        if(child == null)
            return;
        if(child == this.leftChild) {
            this.leftChild = null;
            return;
        }

        if(child == this.rightChild)
            this.rightChild = null;
    }
}

