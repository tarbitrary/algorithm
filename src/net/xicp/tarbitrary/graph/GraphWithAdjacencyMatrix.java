package net.xicp.tarbitrary.graph;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>邻接矩阵表示图</p>
 *
 * @author tarbitrary
 * @version V1.0
 * @created_time 2019-11-04 11:14
 * @module 现货延期模块
 **/
public class GraphWithAdjacencyMatrix {
    private int[] vertexArray;

    private int[][] edgeWeightMatrix;

    private static final Pattern INPUT_REGEX_PATTERN = Pattern.compile("^\\s?(\\d\\s){2}\\d\\s?$");
    private static final String INFINITY = "infinity";

    public int[][] getEdgeWeightMatrix() {
        return edgeWeightMatrix;
    }

    public int[] getVertexArray() {
        return vertexArray;
    }

    private GraphWithAdjacencyMatrix() {

    }

    public static void assembelyGraphWithInput(GraphWithAdjacencyMatrix graph) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入顶点个数:");
        int vertexNums = sc.nextInt();
        System.out.println("请输入边的条数:");
        int edgeNums = sc.nextInt();

        int[] vertexArray = new int[vertexNums];
        int[][] edgeWeightMatrix = new int[vertexNums][vertexNums];
        Arrays.fill(vertexArray, 0);

        for (int i = 0; i < vertexNums; i++) {
            Arrays.fill(edgeWeightMatrix[i], Integer.MAX_VALUE);
            edgeWeightMatrix[i][i] = 0;
        }

        Matcher matcher = null;
        String s = null;
        String[] split = null;
        int from = -1;
        int to = -1;
        int weight = -1;
        for (int i = 1; i <= edgeNums; i++) {
            do {
                System.out.println("请输入第" + i + "条边的起点, 终点、权值(以逗号分割eg.0 1 12)");
                s = sc.nextLine();
                matcher = INPUT_REGEX_PATTERN.matcher(s);
                System.out.println("读到输入:" + s);
            } while (!matcher.matches());

            split = s.split("\\s");
            from = Integer.valueOf(split[0]);
            to = Integer.valueOf(split[1]);
            weight = Integer.valueOf(split[2]);
            edgeWeightMatrix[from][to] = weight;
        }

        graph.vertexArray = vertexArray;
        graph.edgeWeightMatrix = edgeWeightMatrix;
    }

    public static GraphWithAdjacencyMatrix buildGraphInstance() {

        GraphWithAdjacencyMatrix graphWithAdjacencyMatrix = new GraphWithAdjacencyMatrix();
        assembelyGraphWithInput(graphWithAdjacencyMatrix);

        printGraph(graphWithAdjacencyMatrix.vertexArray, graphWithAdjacencyMatrix.edgeWeightMatrix);

        return graphWithAdjacencyMatrix;
    }

    private static void printGraph(int[] vertexArray, int[][] edgeWeightMartix) {
        System.out.println("生成的图顶点");
        for (int vertex : vertexArray) {
            System.out.printf("%d ", vertex);
        }

        System.out.println();

        System.out.println("生成的图结构如下：");
        for (int[] colums : edgeWeightMartix) {
            for (int edgeWeight : colums) {
                if (edgeWeight == Integer.MAX_VALUE) {
                    System.out.printf("infinity   ", INFINITY);
                    continue;
                }
                System.out.printf("%8d   ", edgeWeight);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        GraphWithAdjacencyMatrix graphWithAdjacencyMatrix = GraphWithAdjacencyMatrix.buildGraphInstance();
    }
}
