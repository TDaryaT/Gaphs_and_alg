package ru.nsu.mmf.g16121.ddt.math;


import ru.nsu.mmf.g16121.ddt.main.Graph;

import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        double[][] adjacencyMatrix = {
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0}};
        Graph graph1 = new Graph(adjacencyMatrix);

        double[] minDistance = graph1.getMinDistance();
        System.out.println(minDistance.toString());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер вершины, до которой хотите постороить мин путь: ");
        int endVertex = scanner.nextInt();

        graph1.getAndPrintMinPath(endVertex);
    }
}
