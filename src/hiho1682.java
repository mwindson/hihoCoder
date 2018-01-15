import java.util.Scanner;

/**
 * Created by mwindson on 2018/1/15.
 * https://hihocoder.com/problemset/problem/1682
 */
public class hiho1682 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            matrix[i] = s.toCharArray();
        }
        sweepMine(matrix, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print('\n');
        }
    }

    private static void sweepMine(char[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '.') {
                    int count = 0;
                    int[] dirs = {-1, 0, 1};
                    for (int dirI : dirs) {
                        for (int dirJ : dirs) {
                            int nextI = i + dirI;
                            int nextJ = j + dirJ;
                            if (nextI == i && nextJ == j) continue;
                            if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n) {
                                if (matrix[nextI][nextJ] == '*') {
                                    count++;
                                }
                            }
                        }
                    }
                    matrix[i][j] = (char) ('0' + count);
                }
            }
        }
    }
}
