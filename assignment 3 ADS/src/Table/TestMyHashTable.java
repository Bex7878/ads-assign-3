package Table;

public class TestMyHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i);
            table.put(key, "Student #" + i);
        }

        int[] counts = new int[table.getM()];
        for (int i = 0; i < table.getM(); i++) {
            int count = 0;
            for (MyHashTable.HashNode<MyTestingClass, String> node = table.getChainArray()[i]; node != null; node = node.next) {
                count++;
            }
            counts[i] = count;
            System.out.println("Chain " + i + " has " + count + " elements.");
        }

        MyTestingClass testKey = new MyTestingClass(100);
        String value = table.get(testKey);
        System.out.println("Value for key 100 is: " + value);

        table.remove(testKey);
        System.out.println("Value for key 100 after removal: " + table.get(testKey));

        boolean contains = table.contains("Student #999");
        System.out.println("Table contains 'Student #999': " + contains);
    }
}
