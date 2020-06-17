package ru.nsu.mmf.g16121.ddt.main;

import ru.nsu.mmf.g16121.ddt.math.Graph;

public class Main {
    /**
     * ru.nsu.mmf.g16121.ddt.main.Main - функция с примерами
     */
    public static void main(String[] args) {
        //Пример 1
        Graph graph1 = new Graph(new double[][]{
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        });
        System.out.println("Пример 1:");
        graph1.findBlocks();
        System.out.println("Количество блоков = " + graph1.biconnectedComponentsCount);

        //Пример 2
        Graph graph2 = new Graph(7);
        System.out.println("Пример 2:");
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 3);
        graph2.addEdge(0, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 4);
        graph2.addEdge(4, 5);
        graph2.addEdge(2, 5);
        graph2.addEdge(5, 6);
        graph2.addEdge(1, 0);
        graph2.addEdge(3, 1);
        graph2.addEdge(3, 0);
        graph2.addEdge(4, 3);
        graph2.addEdge(4, 1);
        graph2.addEdge(4, 2);
        graph2.addEdge(5, 4);
        graph2.addEdge(5, 2);
        graph2.addEdge(6, 5);
        graph2.findBlocks();
        System.out.println("Количество блоков = " + graph2.biconnectedComponentsCount);
    }
}
