package functions;

public class QuadraticProbingHashTable {
    private int size;
    private Integer[] table;
    private int rehashCount;
    private int collisions;

    public int getRehashCount() {
        return rehashCount;
    }

    public int getCollisions() {
        return collisions;
    }

    public QuadraticProbingHashTable(int size) {
        this.size = size;
        this.table = new Integer[size];
        this.rehashCount = 0;
        this.collisions = 0;
    }

    private int hashFunction(int key) {
        return key % size;
    }

    private int quadraticProbe(int hash, int i) {
        return (hash + i * i) % size;
    }

    public void insert(int key) {
        int i = 0;
        int hash = hashFunction(key);
        while (i < size) {
            int index = (quadraticProbe(hash, i) + size) % size; // Garantir que o índice seja positivo
            if (table[index] == null) {
                table[index] = key;
                return;
            } else {
                collisions++;
                i++;
            }
        }
        rehash();
        insert(key);
    }

    public boolean search(int key) {
        int i = 0;
        int hash = hashFunction(key);
        while (i < size) {
            int index = (quadraticProbe(hash, i) + size) % size; // Garantir que o índice seja positivo
            if (table[index] != null && table[index].equals(key)) {
                return true;
            } else if (table[index] == null) {
                return false;
            }
            i++;
        }
        return false;
    }

    private void rehash() {
        rehashCount++;
        size *= 2;
        Integer[] oldTable = table;
        table = new Integer[size];
        collisions = 0; // Reset collisions for new table
        for (Integer key : oldTable) {
            if (key != null) {
                insert(key);
            }
        }
    }
}
