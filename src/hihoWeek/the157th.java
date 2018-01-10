package hihoWeek;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/30.
 * https://hihocoder.com/problemset/problem/1311
 */
public class the157th {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigDecimal[] nums = new BigDecimal[n];
        for (int i = 0; i < n; i++) {
            BigDecimal num = in.nextBigDecimal();
            nums[i] = num;
        }
        for (BigDecimal i : nums) {
            toBinary(i);
        }
    }

    private static void toBinary(BigDecimal num) {
        int[] result = new int[500];
        int count = 0;
        for (int j = 0; j < num.scale(); j++) {
            num = num.multiply(new BigDecimal(2));
            result[count] = num.intValue();
            count++;
            num = num.subtract(new BigDecimal(num.intValue()));
        }
        if (num.compareTo(new BigDecimal(0.000000001)) == 1) {
            System.out.print("NO");
        } else {
            System.out.print("0.");
            for (int g = 0; g < count; g++) {
                System.out.print(result[g]);
            }
        }
        System.out.print("\n");
    }
}
