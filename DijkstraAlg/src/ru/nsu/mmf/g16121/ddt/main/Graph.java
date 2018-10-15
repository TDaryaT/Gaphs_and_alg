package ru.nsu.mmf.g16121.ddt.main;

/**
 * Класс Граф, основанный на матрице смежности, вершины отсчитываются начиная с нулевой.
 */
public class Graph {
    private double[][] paths;
    private final int vertexCount;

    private static final double infinity = 10E5;
    private static final int infinityForInt = (int) infinity;
    private static final double eps = 1 / infinity;

    /**
     * Конструктор графа
     *
     * @param paths - матрица смежности
     */
    public Graph(double[][] paths) {
        vertexCount = paths.length;
        this.paths = new double[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            System.arraycopy(paths[i], 0, this.paths[i], 0, vertexCount);
        }
    }

    /**
     * Поиск минимальных расстояний от 0 вершины до всех остальных с помощью алгорима Дейкстры.
     *
     * @return - возвращает матрицу минимальных расстояний до каждой из вершин
     */
    public double[] getMinDistance() {
        double[] minDistance = new double[vertexCount];
        boolean[] visitedVertices = new boolean[vertexCount];

        //Изначальное объявление
        for (int i = 0; i < vertexCount; ++i) {
            minDistance[i] = infinity;
            visitedVertices[i] = false;
        }

        minDistance[0] = 0;
        int minIndexNow;
        double minDistanceNow;

        //шаг алгоритма
        do {
            minIndexNow = infinityForInt;
            minDistanceNow = infinity;

            for (int i = 0; i < vertexCount; ++i) {
                if (!visitedVertices[i] && ((minDistance[i] - infinity) < -eps)) {
                    minDistanceNow = minDistance[i];
                    minIndexNow = i;
                    break;
                }
            }

            if (minIndexNow != infinityForInt) {
                for (int i = 0; i < vertexCount; ++i) {
                    if (paths[minIndexNow][i] > eps) {
                        double support = minDistanceNow + paths[minIndexNow][i];
                        if ((support - minDistance[i]) < -eps) {
                            minDistance[i] = support;
                        }
                    }
                }
                //отмечаем, что поситили  вершину
                visitedVertices[minIndexNow] = true;
            }
        } while (minIndexNow < infinityForInt);

        return minDistance;
    }

    /**
     * Данный метод выпалняет поиск минимального пути и пичатает минимальный путь (по вершинам)
     * с 1 й вершины до @param endVertex
     */
    public void printMinPath(int endVertex) {
        int[] minPath = new int[vertexCount];
        minPath[0] = endVertex;//так как отсчет вершин ведется с 0
        double[] minDistance = this.getMinDistance();
        double weight = minDistance[endVertex - 1];
        int endVertexNow = endVertex - 1;
        int vertexCountInPath = 1;
        boolean forStop = false;

        //записываем в массив minPath номера вершин через которве проходит мин путь
        while (endVertexNow > 0) {
            forStop = false;
            for (int i = 0; i < vertexCount; ++i) {
                if (Math.abs(paths[i][endVertexNow]) >= eps) {
                    double support = weight - paths[i][endVertexNow];
                    if (Math.abs(support - minDistance[i]) < eps) {
                        forStop = true;
                        weight = support;
                        endVertexNow = i;
                        minPath[vertexCountInPath] = i + 1;
                        ++vertexCountInPath;
                    }
                }
            }
            if (!forStop){
                System.out.println("пути нет");
                return;
            }
        }

        // выводим масив minPath на экран
        for (int i = vertexCountInPath - 1; i >= 0; --i) {
            System.out.print(minPath[i] + " ");
        }
    }
}
