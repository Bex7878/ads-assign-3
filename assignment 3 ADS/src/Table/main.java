package Table;

public class main {
    public static void main(String[] args) {

        MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
        System.out.println("Testing MyHashTable:");
        for (int i = 0; i < 10; i++) {
            MyTestingClass key = new MyTestingClass(i);
            hashTable.put(key, "Value " + i);
        }


        for (int i = 0; i < 10; i++) {
            MyTestingClass key = new MyTestingClass(i);
            System.out.println("Key: " + i + ", Value: " + hashTable.get(key));
        }


        BST<Integer, String> bst = new BST<>();
        System.out.println("\nTesting BST:");
        for (int i = 0; i < 10; i++) {
            bst.put(i, "Value " + i);
        }


        for (Integer key : bst.iterator()) {
            System.out.println("Key: " + key + ", Value: " + bst.get(key));
        }


        int keyToDelete = 5;
        System.out.println("\nDeleting key " + keyToDelete + " from BST.");
        bst.delete(keyToDelete);
        System.out.println("Key: " + keyToDelete + " has been removed.");
        for (Integer key : bst.iterator()) {
            System.out.println("Key: " + key + ", Value: " + bst.get(key));
        }
    }
}
