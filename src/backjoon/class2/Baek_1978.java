package src.backjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 0;

        for (int num : arr) {
            if (isPrime(num)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
