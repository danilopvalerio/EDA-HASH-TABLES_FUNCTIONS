import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import functions.ChainedHashTable;
import functions.DoubleHashingHashTable;
import functions.LinearProbingHashTable;
import functions.QuadraticProbingHashTable;

public class Main {

    public static List<Integer> getRandomList100kNoRepetitions() {
        Random rand = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> randomList100k = new ArrayList<>(100000);

        while (randomList100k.size() < 100000) {
            int randomNumber = rand.nextInt(1000000);
            if (uniqueNumbers.add(randomNumber)) {
                randomList100k.add(randomNumber);
            }
        }

        return randomList100k;
    }

    public static List<Integer> getRandomList300k(){
        Random rand = new Random();
        List<Integer> randomList300k = new ArrayList<>(300000);
        for (int i = 0; i < 300000; i++) {
            randomList300k.add(rand.nextInt(1000000));
        }
        return randomList300k;
    }


    //OK
    public static void hashingComEncadeamento(List<Integer> randomList100k, List<Integer> randomList300k){
        System.out.println("Hashing com Encadeamento fechado");
        int size = 10000;
        ChainedHashTable hashTable = new ChainedHashTable(size);

        //Adicionando elementos
        long startTime = System.currentTimeMillis();
        for (int num : randomList100k) {
            hashTable.insert(num);
        }
        long insertionTime = System.currentTimeMillis() - startTime;
        System.out.println("Tempo de insercao: " + insertionTime + " ms");


        //Buscando elementos
        startTime = System.currentTimeMillis();
        for (int num : randomList300k) {
            hashTable.search(num);
        }
        long searchTime = System.currentTimeMillis() - startTime;
        System.out.println("Tempo de busca: " + searchTime + " ms");
    }

    //OK
    public static void linearProbingHashTable(List<Integer> randomList100k, List<Integer> randomList300k){
        int size = 10000;
        LinearProbingHashTable hashTable = new LinearProbingHashTable(size);


        //Adicionando elementos
        long startTime = System.currentTimeMillis();
        for (int num : randomList100k) {
            hashTable.insert(num);
        }
        long insertionTime = System.currentTimeMillis() - startTime;
        System.out.println("Tempo de insercao (Sondagem Linear): " + insertionTime + " ms");

        //Buscando elementos
        startTime = System.currentTimeMillis();
        for (int num : randomList300k) {
            hashTable.search(num);
        }
        long searchTime = System.currentTimeMillis() - startTime;


        System.out.println("Tempo de busca (Sondagem Linear): " + searchTime + " ms");
        System.out.println("Colisoes (Sondagem Linear): " + hashTable.getCollisions());
        System.out.println("Rehashes (Sondagem Linear): " + hashTable.getRehashCount());
    }

    public static void quadraticProbingHashTable(List<Integer> randomList100k, List<Integer> randomList300k){
        int size = 10000;
        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable(size);


        //Adicionando elementos
        long startTime = System.currentTimeMillis();
        for (int num : randomList100k) {
            hashTable.insert(num);
        }
        long insertionTime = System.currentTimeMillis() - startTime;
        System.out.println("Tempo de insercao (Sondagem Quadratica): " + insertionTime + " ms");


        //Buscando elementos
        startTime = System.currentTimeMillis();
        for (int num : randomList300k) {
            hashTable.search(num);
        }
        long searchTime = System.currentTimeMillis() - startTime;

        System.out.println("Tempo de busca (Sondagem Quadratica): " + searchTime + " ms");
        System.out.println("Colisoes (Sondagem Quadratica): " + hashTable.getCollisions());
        System.out.println("Rehashes (Sondagem Quadratica): " + hashTable.getRehashCount());
    }

    public static void doubleHashingHashTable(List<Integer> randomList100k, List<Integer> randomList300k){
    
        int size = 10000;
        DoubleHashingHashTable hashTable = new DoubleHashingHashTable(size);

        //Adicionando elementos
        long startTime = System.currentTimeMillis();
        for (int num : randomList100k) {
            hashTable.insert(num);
        }
        long insertionTime = System.currentTimeMillis() - startTime;
        System.out.println("Tempo de inserção (double hashing): " + insertionTime + " ms");


        //Buscando elementos
        startTime = System.currentTimeMillis();
        for (int num : randomList300k) {
            hashTable.search(num);
        }
        long searchTime = System.currentTimeMillis() - startTime;
        System.out.println("Tempo de busca (double hashing): " + searchTime + " ms");
        System.out.println("Colisoes (double hashing): " + hashTable.getCollisions());
        System.out.println("Rehashes (double hashing): " + hashTable.getRehashCount());
    }

    public static void hashingComEnderecamentoAberto(List<Integer> randomList100k, List<Integer> randomList300k){
        String result = ".".repeat(70);

        System.out.println("Hashing com enderecamento aberto");
        System.out.println("Sondagem Linear");
        linearProbingHashTable(randomList100k, randomList300k);

        System.out.println(result);
        System.out.println("Sondagem Quadratica");
        quadraticProbingHashTable(randomList100k, randomList300k);
        
        System.out.println(result);
        System.out.println("Sondagem Dupla");
        doubleHashingHashTable(randomList100k, randomList300k);
    }

    public static void main(String[] args) {
        List<Integer> randomList100k = getRandomList100kNoRepetitions();
        List<Integer> randomList300k = getRandomList300k();
        String result = "-".repeat(50);

        System.out.println("Iniciando...");
        hashingComEncadeamento(randomList100k, randomList300k);
        System.out.println(result);
        hashingComEnderecamentoAberto(randomList100k, randomList300k);
        System.out.println(result);
    }
}
