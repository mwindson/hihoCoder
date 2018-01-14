import java.util.*;

/**
 * Created by mwindson on 2018/1/13.
 * https://hihocoder.com/problemset/problem/1093
 * SPFA =>最短路径更新算法
 */
public class hiho1093 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            u -= 1;
            v -= 1;
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        System.out.println(minDistance(graph, n, s - 1, t - 1));
    }

    private static int minDistance(List<List<int[]>> graph, int n, int start, int end) {
        boolean[] inQueue = new boolean[n]; // 记录是否在队列中,用于判断是否插入
        Arrays.fill(inQueue, false);
        int[] dis = new int[n]; // 记录start到该点的最小距离
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dis[start] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            inQueue[u] = false;
            for (int[] next : graph.get(u)) {
                // 比现有的小,更新距离数组
                if (dis[u] + next[1] < dis[next[0]]) {
                    dis[next[0]] = dis[u] + next[1];
                    // 下一个点未在队列中则插入,已在队列中则不用插入避免重复计算
                    if (!inQueue[next[0]]) {
                        inQueue[next[0]] = true;
                        q.offer(next[0]);
                    }
                }
            }
        }
        return dis[end];
    }

}
