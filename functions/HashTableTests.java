package functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTests {

    private ChainedHashTable chainedHashTable;
    private DoubleHashingHashTable doubleHashingHashTable;
    private LinearProbingHashTable linearProbingHashTable;
    private QuadraticProbingHashTable quadraticProbingHashTable;

    @BeforeEach
    public void setUp() {
        chainedHashTable = new ChainedHashTable(10);
        doubleHashingHashTable = new DoubleHashingHashTable(10);
        linearProbingHashTable = new LinearProbingHashTable(10);
        quadraticProbingHashTable = new QuadraticProbingHashTable(10);
    }

    @Test
    public void chainedHashTableInsertAndSearch() {
        chainedHashTable.insert(5);
        chainedHashTable.insert(15);
        assertTrue(chainedHashTable.search(5));
        assertTrue(chainedHashTable.search(15));
        assertFalse(chainedHashTable.search(25));
    }

    @Test
    public void doubleHashingHashTableInsertAndSearch() {
        doubleHashingHashTable.insert(5);
        doubleHashingHashTable.insert(15);
        assertTrue(doubleHashingHashTable.search(5));
        assertTrue(doubleHashingHashTable.search(15));
        assertFalse(doubleHashingHashTable.search(25));
    }

    @Test
    public void linearProbingHashTableInsertAndSearch() {
        linearProbingHashTable.insert(5);
        linearProbingHashTable.insert(15);
        assertTrue(linearProbingHashTable.search(5));
        assertTrue(linearProbingHashTable.search(15));
        assertFalse(linearProbingHashTable.search(25));
    }

    @Test
    public void quadraticProbingHashTableInsertAndSearch() {
        quadraticProbingHashTable.insert(5);
        quadraticProbingHashTable.insert(15);
        assertTrue(quadraticProbingHashTable.search(5));
        assertTrue(quadraticProbingHashTable.search(15));
        assertFalse(quadraticProbingHashTable.search(25));
    }

    @Test
    public void collisionHandling() {
        // Test collision handling
        linearProbingHashTable.insert(5);
        linearProbingHashTable.insert(15);
        linearProbingHashTable.insert(25); // Collision with index 5
        assertTrue(linearProbingHashTable.search(5));
        assertTrue(linearProbingHashTable.search(15));
        assertTrue(linearProbingHashTable.search(25));
        assertFalse(linearProbingHashTable.search(35));
    }

    @Test
    public void rehashing() {
        // Test rehashing
        for (int i = 0; i < 20; i++) {
            quadraticProbingHashTable.insert(i);
        }
        assertTrue(quadraticProbingHashTable.search(15));
        assertFalse(quadraticProbingHashTable.search(25));
    }
}
