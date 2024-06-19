package functions;
import java.util.LinkedList;

public class ChainedHashTable {
    private LinkedList<Integer>[] table;
    private int size;
    private int collisions;

    public ChainedHashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
        collisions = 0;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        if (table[index].contains(key)) {
            System.out.println("Elemento já existe na tabela: " + key);
            return;
        }
        if (!table[index].isEmpty()) {
            collisions++;
        }
        table[index].add(key);
    }

    public boolean search(int key) {
        int index = hashFunction(key);
        return table[index].contains(key);
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public int getCollisions() {
        return collisions;
    }

    // Método para imprimir a tabela hash (para depuração)
    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            for (int value : table[i]) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
