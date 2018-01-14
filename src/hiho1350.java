import java.util.*;

/**
 * Created by mwindson on 2018/1/13.
 * https://hihocoder.com/problemset/problem/1350
 */
public class hiho1350 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        format(x);
    }

    private static void format(int x) {
        SortedSet<String> times = new TreeSet<>();
        for (int i = 0; i <= x && i <= 5; i++) {
            String[] hours = generate(i, 5);
            String[] minutes = generate(x - i, 6);
            for (String hh : hours) {
                for (String mm : minutes) {
                    times.add(hh + ":" + mm);
                }
            }
        }
        for (String t : times) System.out.println(t);
    }

    private static String[] generate(int num, int total) {
        List<Integer> result = new ArrayList<>();
        backTrack(result, 0, total, num, "");
        String[] strings = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) < 10) {
                strings[i] = "0" + result.get(i);
            } else {
                strings[i] = "" + result.get(i);
            }
        }
        return strings;
    }

    private static void backTrack(List<Integer> list, int i, int total, int num, String s) {
        if (i == total && num == 0) {
            int time = Integer.valueOf(s, 2);
            if (total == 5 && time <= 23) {
                if (!list.contains(time)) list.add(time);
            } else if (total == 6 && time <= 59) {
                if (!list.contains(time)) list.add(time);
            }
        } else if (i < total) {
            if (num > 0) {
                backTrack(list, i + 1, total, num - 1, s + "1");
            }
            backTrack(list, i + 1, total, num, s + "0");
        }
    }
}
