package src.backjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11050 이항 계수
 * nCr = n! / ((n-r)! * r!) 공식
 * 입력값 : 5 2
 */
public class Baek_11050 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 5
        int b = Integer.parseInt(st.nextToken()); // 2

        dp = new int[a+1];

        // dp[0], dp[1]은 Factorial 기본값인 1로 초기화
        dp[0]=1;
        dp[1]=1;

        System.out.println(factorial(a) / (factorial(a-b) * factorial(b)));
        br.close();
    }

    static int factorial(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = n * factorial(n-1);
    }
}