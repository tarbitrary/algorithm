package net.xicp.tarbitrary.graph;

import java.util.Scanner;

/**
 * <p>普拉姆算法可在加权连通图里搜索最小生成树。意即由此算法搜索到的边子集所构成的树中，不但包括了连通图里的所有顶点（英语：Vertex (graph theory)），且其所有边的权值之和亦为最小</p>
 *
 * @author tarbitrary
 * @version V1.0
 * @created_time 2019-11-04 10:52
 * @module 现货延期模块
 **/
public class Prim {
    private int[] vertexs;

    private int[][] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入顶点个数:");
        int vertexNums = sc.nextInt();
        System.out.println("请输入边的条数:");
        int edgeNums = sc.nextInt();


        String next = sc.next("%d");
    }

}
