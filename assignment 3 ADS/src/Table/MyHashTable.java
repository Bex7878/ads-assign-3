package Table;

public class MyHashTable<K, V> {
    public static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value, HashNode<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    public int getM() {
        return M;
    }

    public HashNode<K, V>[] getChainArray() {
        return chainArray;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        int i = hash(key);
        for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        chainArray[i] = new HashNode<K, V>(key, value, chainArray[i]);
    }

    public V get(K key) {
        int i = hash(key);
        for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int i = hash(key);
        HashNode<K, V> prev = null;
        for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    chainArray[i] = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                if (value.equals(node.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                if (value.equals(node.value)) {
                    return node.key;
                }
            }
        }
        return null;
    }
}
