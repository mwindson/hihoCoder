package hihoWeek;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/30.
 * https://hihocoder.com/contest/hiho56/problem/1
 */

public class the56th {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] comb = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 1; j++) {
                comb[i][j] = in.nextInt();
            }
        }
        calItemPrice(comb);
    }

    private static void calItemPrice(int[][] comb) {
        boolean isManySolution = false;
        for (int i = 0; i < comb[0].length - 1; i++) {
            boolean flag = false;
            for (int j = i; j < comb.length; j++) {
                if (comb[j][i] != 0) {
                    if (j != i) swapLine(i, j, comb);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                isManySolution = true;
            } else {
                for (int m = i + 1; m < comb.length; m++) {
                    for (int n = i + 1; n < comb[0].length; n++) {
                        comb[m][n] = comb[m][n] - comb[i][n] * (comb[m][i] / comb[i][i]);
                    }
                    comb[m][i] = 0;
                }
            }
        }
        for (int i = 0; i < comb.length; i++) {
            boolean flag = true;
            for (int j = 0; j < comb[0].length - 1; j++) {
                if (comb[i][j] != 0) {
                    flag = false;
                }
            }
            if (flag && comb[i][comb[0].length - 1] != 0) {
                System.out.println("No solutions");
                return;
            }
        }
        if (isManySolution) {
            System.out.println("Many solutions");
            return;
        }
        // 唯一解
        int[] value = new int[comb[0].length];
        for (int i = comb[0].length - 2; i >= 0; i--) {
            for (int j = i + 1; j < comb[0].length - 1; j++) {
                comb[i][comb[0].length - 1] = comb[i][comb[0].length - 1] - comb[i][j] * value[j];
                comb[i][j] = 0;
            }
            value[i] = comb[i][comb[0].length - 1] / comb[i][i];
        }
        for (int i = 0; i < value.length - 1; i++) {
            System.out.println(value[i]);
        }
    }


    // 交换第i行和第j行
    private static void swapLine(int i, int j, int[][] comb) {
        for (int k = i; k < comb[0].length; k++) {
            int tmp = comb[i][k];
            comb[i][k] = comb[j][k];
            comb[j][k] = tmp;
        }
    }
}
