package ru.nsu.mmf.g16121.ddt.main;

public class Graph {
    private double[][] paths;
    private final int length;
    private static final double infinity = 10E5;
    private static final int infinityForInt = (int) infinity;
    private static final double eps = 1 / infinity;

    public Graph(double[][] paths) {
        length = paths.length;
        this.paths = new double[length][length];
        System.arraycopy(paths, 0, this.paths, 0, length);
    }

    public double[] getMinDistance() {
        double[] minDistance = new double[length];
        boolean[] visitedVertices = new boolean[length];

        //Изначальное объявление
        for (int i = 0; i < length; ++i) {
            minDistance[i] = infinity;
            visitedVertices[i] = false;
        }

        visitedVertices[0] = true;
        int minIndexNow;
        double minDistanceNow;

        //шаг алгоритма
        do {
            minIndexNow = infinityForInt;
            minDistanceNow = infinity;

            for (int i = 0; i < length; ++i) {
                if (visitedVertices[i] && Math.abs(minDistance[i] - infinity) < eps) {
                    minDistanceNow = minDistance[i];
                    minIndexNow = i;
                }
            }

            if (minIndexNow != infinityForInt) {
                double support;
                for (int i = 0; i < length; ++i) {
                    if (paths[minIndexNow][i] > eps) {
                        support = minDistanceNow + paths[minIndexNow][i];
                        if (support < minDistance[i]) {
                            minDistance[i] = support;
                        }
                    }
                }
            }
            //отмечаем, что поситили  вершину
            visitedVertices[minIndexNow] = true;
        } while (minIndexNow < infinityForInt);
        return minDistance;
    }

    public int[] getAndPrintMinPath(int endVertex) {
        int[] minPath = new int[length];
        minPath[0] = endVertex;
        double[] minDistance = this.getMinDistance();
        double weight = minDistance[endVertex];
        int endVertexNow = endVertex;
        int j = 1;
        while (endVertexNow > 0) {
            for (int i = 0; i < length; ++i) {
                if (Math.abs(this.paths[endVertexNow][i]) > eps) {
                    double support = weight - this.paths[endVertexNow][i];
                    if (Math.abs(support - minDistance[i]) < eps) {
                        weight = support;
                        endVertexNow = i;
                        minPath[j] = i;
                        ++j;
                    }
                }
            }
        }

        for (int i = j - 1; i >= 0; --i){
            System.out.print(minPath[i]+" ");
        }
        return minPath;
    }




}
