package functions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChainedHashTable {
    private int size;
    private List<LinkedList<Integer>> table;

    public ChainedHashTable(int size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<>());
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        table.get(index).add(key);
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        return table.get(index).contains(key);
    }
}