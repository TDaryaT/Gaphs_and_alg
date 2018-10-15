package ru.nsu.mmf.g16121.ddt.math;

import ru.nsu.mmf.g16121.ddt.main.Graph;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        //Ex 1
        //обыкновенный граф
        double[][] adjacencyMatrix = {
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0}};

        Graph graph1 = new Graph(adjacencyMatrix);

        double[] minDistance = graph1.getMinDistance();
        System.out.println("Массив минимальных расстояний вершин:");
        System.out.println(Arrays.toString(minDistance));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер вершины, до которой хотите" +
                " постороить мин путь (отсчет с 1): ");
        int endVertex = scanner.nextInt();

        graph1.printMinPath(endVertex);
        System.out.println();

        //Ex 2
        //ориентированный граф
        double[][] adjacencyMatrix2 = {
                {0, 10, 30, 50, 10},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 10},
                {0, 40, 20, 0, 0},
                {10, 0, 10, 30, 0}};

        Graph graph2 = new Graph(adjacencyMatrix2);
        minDistance = graph2.getMinDistance();
        System.out.println("Массив минимальных расстояний вершин:");
        System.out.println(Arrays.toString(minDistance));

        System.out.print("Введите номер вершины, до которой хотите" +
                " постороить мин путь (отсчет с 1): ");
        endVertex = scanner.nextInt();

        graph2.printMinPath(endVertex);
        System.out.println();

        //Ex 3
        double[][] adjacencyMatrix3 = {
                {0,2,1,4,0,0},
                {2,0,0,7,2.5,0},
                {0,0,0,5,10,4},
                {0,0,0,0,0,5},
                {0,0,0,0,0,4},
                {0,0,0,0,0,0}
        };
        Graph graph3 = new Graph(adjacencyMatrix3);
        minDistance = graph3.getMinDistance();
        System.out.println("Массив минимальных расстояний вершин:");
        System.out.println(Arrays.toString(minDistance));

        System.out.print("Введите номер вершины, до которой хотите" +
                " постороить мин путь (отсчет с 1): ");
        endVertex = scanner.nextInt();

        graph3.printMinPath(endVertex);
        System.out.println();

        //Ex 4
        //с изолированными вершинами
        double[][] adjacencyMatrix4 = {
                {0,0,0},
                {0,0,0},
                {0,0,0},
        };
        Graph graph4 = new Graph(adjacencyMatrix4);
        minDistance = graph4.getMinDistance();
        System.out.println("Массив минимальных расстояний вершин:");
        System.out.println(Arrays.toString(minDistance));

        System.out.print("Введите номер вершины, до которой хотите" +
                " постороить мин путь (отсчет с 1): ");
        endVertex = scanner.nextInt();

        graph4.printMinPath(endVertex);
        System.out.println();
    }
}
