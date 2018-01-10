package hihoWeek; /**
 * Created by mwindson on 2017/6/23.
 */

import javafx.collections.transformation.SortedList;
import javafx.util.Pair;

import java.security.PublicKey;
import java.util.*;

/**
 * 描述
 * 给定 N 项任务的起至时间( S1, E1 ), ( S2, E2 ), ..., ( SN, EN )， 计算最少需要多少台机器才能按时完成所有任务。
 * 同一时间一台机器上最多进行一项任务，并且一项任务必须从头到尾保持在一台机器上进行。任务切换不需要时间。
 * 输入
 * 第一行一个整数 N，(1 ≤ N ≤ 100000)，表示任务的数目。 以下 N 行每行两个整数 Si, Ei，(0 ≤ Si < Ei ≤ 1000000000)，表示任务的起至时间。
 * 输出
 * 输出一个整数，表示最少的机器数目。
 * 5
 * 1 10
 * 2 7
 * 6 9
 * 3 4
 * 7 10
 */
public class Week155 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            tasks[i][0] = start;
            tasks[i][1] = end;
        }
        System.out.println(maxMachineCount(tasks));
    }

    public static int maxMachineCount(int[][] tasks) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            if (list.isEmpty()) {
                list.add(tasks[i][1]);
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) <= tasks[i][0])
                        list.remove(j);
                }
                list.add(tasks[i][1]);
            }
            max = Math.max(max, list.size());
        }
        return max;
    }
}
