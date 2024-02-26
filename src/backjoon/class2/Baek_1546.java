package src.backjoon.class2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 점수 중 최대값 = m
 * 그리고 모든 점수 = 점수 / m * 100
 */
public class Baek_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double result = 0;

        Arrays.sort(arr);
        int max = arr[n-1];

        for (int num : arr) {
            result += (double) num / max * 100;
        }

        result = result / (double) n;

        System.out.println(result);
    }
}