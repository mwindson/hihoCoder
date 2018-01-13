package hihoWeek;

import java.util.*;

/**
 * Created by mwindson on 2018/1/12.
 * https://hihocoder.com/problemset/problem/1352
 */
// 并查集
public class Week183 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grid = new int[1000 * 1000];
        for (int i = 0; i < grid.length; i++) grid[i] = -1;
        for (int i = 0; i < n; i++) {
            int row = in.nextInt();
            int col = in.nextInt();
            System.out.println(numberOfIslands(grid, row, col));
        }
    }

    static int count = 0;

    private static int numberOfIslands(int[] roots, int row, int col) {
        int current = getPos(row, col);
        int root = findRoot(current, roots);
        count++;
        int[] nexts = {current + 1, current - 1, current - 1000, current + 1000};
        for (int next : nexts) {
            if (next >= 0 && next < 1000 * 1000 && roots[next] != -1) {
                merge(current, next, roots);
            }
        }

        return count;
    }

    private static void merge(int u, int v, int[] islands) {
        int root1 = islands[u];
        int root2 = islands[v];
        if (root1 == root2) return;
        islands[root1] = root2;
        count--;
    }

    private static int findRoot(int v, int[] islands) {
        if (islands[v] == v) {
            return v;
        } else {
            int root = findRoot(islands[v], islands);
            islands[v] = root;
            return root;
        }
    }

    private static int getPos(int row, int col) {
        return row * 1000 + col;
    }
}
