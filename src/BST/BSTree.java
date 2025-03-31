package BST;

import java.util.ArrayList;

public class BSTree<T extends Comparable<T>> {
    public Bnode<T> root;
    public int size;

    public BSTree(){

    }

    public BSTree(Bnode<T> r) {
        this.root = r;
    }

    public Bnode<T> getRoot(){
        return this.root;
    }

    public void addRoot(T data){
        if(this.root != null)
            return;

        Bnode<T> r = new Bnode<T>(data);
        this.root = r;
        size++;
    }

    public void add(T data){
        //This method will return the node where the new data will attach to
        Bnode<T> node = find(data);
        if(node == null) {
            addRoot(data);
        }
        else if(node.data.compareTo(data) > 0) {
            //ADD to the left of node
            addLeft(node, data);
        }
        else if(node.data.compareTo(data) < 0) {
            //ADD to the right of node
            addRight(node, data);
        }
    }

    public void addLeft(Bnode<T> parent, T data) {
        Bnode<T> left = new Bnode<T>(data);
        parent.leftChild = left;
        left.parent = parent;
        size++;
    }

    public void addRight(Bnode<T> parent, T data) {
        Bnode<T> right = new Bnode<T>(data);
        parent.rightChild = right;
        right.parent = parent;
        size++;
    }

    public Bnode<T> find(T data){
        if(getRoot() == null)
            return null;
        Bnode r = getRoot();
        return findRecursively(r, data);
    }

    public Bnode<T> findRecursively(Bnode<T> parent, T data){
        int comparison = data.compareTo(parent.data);
        if(comparison == 0)
            return parent;
        if(comparison < 0 && parent.leftChild != null)
            return findRecursively(parent.leftChild, data);
        if(comparison > 0 && parent.rightChild != null)
            return findRecursively(parent.rightChild, data);

        return parent;
    }

    public boolean contains(T data){
        Bnode<T> node = find(data);
        if(node == null)
            return false;
        if(node.data.compareTo(data) == 0) //node returned holds the data we are looking for
            return true;
        else return false;
    }

    // Traverse through the tree
    // This way is in order. The others are post order and pre-order
    public void inOrder(Bnode<T> root, ArrayList<InventoryItem> inOrderList) {
        if(root == null)
            return;
        inOrder(root.leftChild, inOrderList);
        inOrderList.add((InventoryItem) root.data);
        inOrder(root.rightChild, inOrderList);

    }

}
