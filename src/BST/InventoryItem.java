package BST;

public class InventoryItem implements java.lang.Comparable<InventoryItem>{
    public int itemNumber;
    public String type;
    public float price;

    public InventoryItem(int n, String t, float p) {
        this.itemNumber = n;
        this.type = t;
        this.price = p;

    }

    public int compareTo(InventoryItem anotherItem) {
        if(this.itemNumber > ((InventoryItem)anotherItem).itemNumber)
            return -1;
        if(this.itemNumber < ((InventoryItem)anotherItem).itemNumber)
            return 1;
        else return 0;
    }

    public String toString(){
        return "inventory item: " + this.itemNumber + " is " + this.type + " price " + this.price;
    }
}
