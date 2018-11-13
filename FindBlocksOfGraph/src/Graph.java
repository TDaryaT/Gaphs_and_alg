/*
 * Задание: Для зананного графа найти все его блкои и выдать их.
 */

import java.util.*;

class Graph {
    private int vertexCount; // - количество связей
    private LinkedList[] adj; // - лист связей

    /**
     * time - ипользуется как глобальная переменная для отслеживания
     * нумирации прохождения вершин (какая попала 1й.2й ...).
     * biconnectedComponentsCount - количество компонент связности графа.
     */

    int biconnectedComponentsCount = 0;
    private int time = 0;

    /**
     * Класс ребер, из которых будет состоять Граф
     */
    private class Edge {
        int u;
        int v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    /**
     * Данный конструктор создает пустой граф
     *
     * @param vertexCount - количество вершин в создоваемом графе
     */
    Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i)
            adj[i] = new LinkedList();
    }

    /**
     * функция добавления направленного ребра в граф
     *
     * @param vertexInput  - вершина, из которой выходит ребро
     * @param vertexOutput - вершина, в которую входит ребро
     */
    void addEdge(int vertexInput, int vertexOutput) {
        adj[vertexInput].add(vertexOutput);
    }

    /**
     * Конструктор графа по матрице смежности
     *
     * @param matrix - матрица смежности
     */
    Graph(double[][] matrix) {
        vertexCount = matrix.length;
        adj = new LinkedList[matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            adj[i] = new LinkedList();
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] != 0) {
                    adj[i].add(j);
                }
            }
        }
    }

    /**
     * Рекурсивная функция, которая находит и печатает компоненты связности, использующие обход DFS
     *
     * @param u             - посещаемая вершина
     * @param visitedVertex - массив для отслеживания посещенных вершин
     * @param low           - самая первая вершина (вершина с минимальным временем обнаружения),
     *                      которая может быть достигнута из поддерева
     * @param st            - стек, поддерево в глубину.
     * @param parent        - "родители вершины"
     */
    private void BCCUtil(int u, int visitedVertex[], int low[], LinkedList<Edge> st,
                         int parent[]) {
        //отмечаем, что поситили вершину и запомнили какой по счету пришла
        visitedVertex[u] = low[u] = ++time;
        //изначально детей у нее нет
        int children = 0;

        // проходим по всем вершинам, с которыми соеденина эта вершина ребрами
        Iterator<Integer> it = adj[u].iterator();
        while (it.hasNext()) {
            // v - вершина, смежная с u
            int v = it.next();

            // если мы ее (v) еще не посещали
            if (visitedVertex[v] == -1) {
                children++;
                parent[v] = u;

                // заносим в стек
                st.add(new Edge(u, v));
                // запускаем рекурсивно уже от v
                BCCUtil(v, visitedVertex, low, st, parent);


                //проверяем связанно ли поддерево из v с предками u (проверка определения точки сочлинения)
                if (low[u] > low[v]) {
                    low[u] = low[v];
                }

                //если u - точка сочлинения выводим все ребра из стека до ребра u-v
                if ((visitedVertex[u] == 1 && children > 1) || (visitedVertex[u] > 1 && low[v] >= visitedVertex[u])) {
                    while (st.getLast().u != u || st.getLast().v != v) {
                        System.out.print(st.getLast().u + "-" + st.getLast().v + " ");
                        st.removeLast();
                    }
                    System.out.println(st.getLast().u + "-" + st.getLast().v + " ");
                    st.removeLast();

                    biconnectedComponentsCount++;
                }
            }

            // изменяем значение low[u] если нашли более быстрый
            else if (v != parent[u] && visitedVertex[v] < low[u]) {
                if (low[u] > visitedVertex[v])
                    low[u] = visitedVertex[v];
                st.add(new Edge(u, v));
            }
        }
    }

    /**
     * Функция для обхода DFS.
     */
    void findBlocks() {
        int disc[] = new int[vertexCount];
        int low[] = new int[vertexCount];
        int parent[] = new int[vertexCount];
        LinkedList<Edge> st = new LinkedList<Edge>();

        // автозаполнение массивов -1-ми
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < vertexCount; i++) {
            //для каждой непосещенной вершины:
            if (disc[i] == -1)
                BCCUtil(i, disc, low, st, parent);

            boolean incBiconnectedComponent = false;

            // если стек не пустой, то печатаем его ребра
            while (st.size() > 0) {
                incBiconnectedComponent = true;
                System.out.print(st.getLast().u + "-" + st.getLast().v + " ");
                st.removeLast();
            }
            if (incBiconnectedComponent) {
                System.out.println();
                biconnectedComponentsCount++;
            }
        }
    }
}