package src.backjoon.class2;

import java.util.*;

/**
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 * 중복 제거
 */
public class Baek_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            // 단어의 길이가 같을 경우 사전순으로 정렬
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });

        System.out.println(arr[0]);

        for (int i=1; i<arr.length; i++) {
            if (!arr[i].equals(arr[i-1])) System.out.println(arr[i]);
        }
    }
}