package hihoWeek;

import java.util.*;

/**
 * Created by mwindson on 2017/8/29.
 * https://hihocoder.com/contest/hiho59/problem/1
 */
public class the59th {
    static class log {
        String name;
        int time;
        String action;

        log(String n, int t, String a) {
            name = n;
            time = t;
            action = a;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<log> logs = new ArrayList<>();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String record = in.nextLine();
            String name = record.split(" ")[0];
            String timeStamp = record.split(" ")[1];
            String action = record.split(" ")[2];
            logs.add(new log(name, timeStampToSecond(timeStamp), action));
        }
        validLog(logs);
    }

    private static void validLog(List<log> logs) {
        List<String> output = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Stack<log> stack = new Stack<>();
        for (log log : logs) {
            if (Objects.equals(log.action, "START")) {
                stack.add(log);
                output.add(log.name);
            } else {
                if (stack.isEmpty() || !Objects.equals(stack.peek().name, log.name)) {
                    System.out.println("Incorrect performance log");
                    return;
                } else {
                    log l = stack.pop();
                    int delta = log.time - l.time;
                    if (delta < 0) {
                        System.out.println("Incorrect performance log");
                        return;
                    } else {
                        map.put(log.name, delta);
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Incorrect performance log");
        } else {
            for (String name : output) {
                int runtime = map.get(name);
                System.out.println(name + " " + String.format("%02d", (runtime / 3600)) + ":" + String.format("%02d", (runtime % 3600 / 60))
                        + ":" + String.format("%02d", (runtime % 3600 % 60)));
            }
        }
    }

    private static int timeStampToSecond(String timeStamp) {
        String[] ts = timeStamp.split(":");
        return Integer.valueOf(ts[0]) * 3600 + Integer.valueOf(ts[1]) * 60 + Integer.valueOf(ts[2]);
    }
}
