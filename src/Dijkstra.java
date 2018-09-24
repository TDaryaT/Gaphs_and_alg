/**
 * Поиск минимального пути в графе с помощью алгоритма Дейкстры:
 * <p>
 * Input: матрица смежности, которую можно изменить внутри функции <main></main> и
 * вершина от которой начинаем путь (отсчет вершин от 0 .. n)
 * Output: длина кратчайшего расстояния до каждой из вершин
 * visitedVertex: 1 - if this vertex are visited; 0 - if not;
 * a - vertex index of the start way
 */
public class Dijkstra {
    public static double[] getMinWay(int a, double[][] adjacencyMatrix) {
        int length = adjacencyMatrix.length;

        double infinity = 10E10;
        double[] minDistance = new double[length];
        double[] visitedVertex = new double[length];
        for (int i = 0; i < length; i++) {
            visitedVertex[i] = 0;
            minDistance[i] = infinity;
        }




    }

    public static void main(String[] args) {
        double[][] adjacencyMatrix = {
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0}};
        int initialVertexIndex = 0;

    }
}
