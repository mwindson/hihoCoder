package hihoWeek;

import java.util.*;

/**
 * Created by mwindson on 2017/8/30.
 * https://hihocoder.com/contest/hiho49/problem/1
 */
public class the49th {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, List<Integer>> edge = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            List<Integer> l;
            if (edge.containsKey(u)) {
                l = edge.get(u);
            } else {
                l = new ArrayList<>();
            }
            l.add(v);
            edge.put(u, l);
            if (edge.containsKey(v)) {
                l = edge.get(v);
            } else {
                l = new ArrayList<>();
            }
            l.add(u);
            edge.put(v, l);
        }
        System.out.println(isEulerCircuit(edge, n) ? "Full" : "Part");
    }

    // 联通且仅有俩点度为奇数
    private static boolean isEulerCircuit(Map<Integer, List<Integer>> edge, int n) {
        boolean isLink = true;
        boolean twoPoint;
        int count = 0;
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : edge.entrySet()) {
            if (entry.getValue().size() % 2 == 1) {
                start = entry.getKey();
                count++;
            }
        }
        twoPoint = count == 2 | count == 0;
        if (!twoPoint) return false;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start - 1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nexts = edge.get(cur);
            for (int next : nexts) {
                if (!visited[next - 1]) queue.add(next);
                visited[next - 1] = true;
            }
        }
        for (boolean visit : visited) {
            if (!visit) isLink = false;
        }
        return isLink;
    }
}
