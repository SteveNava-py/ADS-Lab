package BST;

import java.util.ArrayList;

public class BSTTest {
    public static void main(String[] args) {
        BSTree<InventoryItem> myBST = new BSTree<>();

        InventoryItem item1 = new InventoryItem(1, "hooman", 20);
        InventoryItem item2 = new InventoryItem(2, "rocks", 15);
        InventoryItem item3 = new InventoryItem(3, "liver", 6000);

        myBST.add(item1);
        myBST.add(item2);
        myBST.add(item3);

        ArrayList<InventoryItem> order = new ArrayList<>();
        myBST.inOrder(myBST.root, order);
        System.out.println(order);

//        myBST.add(100);
//        myBST.add(90);
//        myBST.add(120);
//        myBST.add(85);

//        System.out.println("Root is : " + myBST.getRoot().data);
//        System.out.println("Left node is : " + myBST.getRoot().leftChild.data);
//        System.out.println("Right node is : " + myBST.getRoot().rightChild.data);
//        System.out.println("Left of left is : " + myBST.getRoot().leftChild.leftChild.data);

//        ArrayList<Integer> order = new ArrayList<>();
//        myBST.inOrder(myBST.root, order);
//        System.out.println(order);

    }
}
