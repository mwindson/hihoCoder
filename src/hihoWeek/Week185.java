package hihoWeek;

import java.util.*;

/**
 * Created by mwindson on 2018/1/14.
 */
public class Week185 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] B = new int[n - 1];
        for (int i = 0; i < n - 1; i++) B[i] = in.nextInt();
        int[] A = new int[m - 1];
        for (int i = 0; i < m - 1; i++) A[i] = in.nextInt();
        int k = in.nextInt();
        boolean[][] block = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            x -= 1;
            y -= 1;
            block[x][y] = true;
        }
        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            x -= 1;
            y -= 1;
            p -= 1;
            q -= 1;
            System.out.println(minDistance(x, y, p, q, n, m, A, B, block));
        }

    }

    private static int minDistance(int si, int sj, int ti, int tj, int n, int m, int[] a, int[] b, boolean[][] block) {
        int[][] dis = new int[n][m];
        for (int[] d : dis) Arrays.fill(d, Integer.MAX_VALUE);
        boolean[][] inQueue = new boolean[n][m];
        for (boolean[] in : inQueue) Arrays.fill(in, false);
        Queue<int[]> queue = new LinkedList<>();
        dis[si][sj] = 0;
        inQueue[si][sj] = true;
        queue.add(new int[]{si, sj});
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            inQueue[s[0]][s[1]] = false;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int[] next = {s[0] + dir[0], s[1] + dir[1]};
                if (next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < m && !block[next[0]][next[1]]) {
                    int w = Integer.MAX_VALUE;
                    if (dir[0] == -1 && dir[1] == 0) {
                        w = b[next[0]];
                    } else if (dir[0] == 1 && dir[1] == 0) {
                        w = b[s[0]];
                    } else if (dir[0] == 0 && dir[1] == 1) {
                        w = a[s[1]];
                    } else if (dir[0] == 0 && dir[1] == -1) {
                        w = a[next[1]];
                    }
                    if (dis[s[0]][s[1]] + w < dis[next[0]][next[1]]) {
                        dis[next[0]][next[1]] = dis[s[0]][s[1]] + w;
                        // 更新距离
                        if (!inQueue[next[0]][next[1]]) {
                            inQueue[next[0]][next[1]] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return dis[ti][tj] == Integer.MAX_VALUE ? -1 : dis[ti][tj];
    }

}