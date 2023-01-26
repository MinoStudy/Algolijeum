package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
■ Ugly Number

설명
Ugly Number는 숫자 2, 3, 5 를 사용하여 만들어 낼 수 있는 수를 뜻합니다.
예외로 숫자 1은 첫 번째 Ugly Number입니다.

Ugly Number들을 순서대로 나열해보면 다음과 같습니다.
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ...

number.png

a, b, c ... 등 n 개의 수를 입력받고,  a, b, c ... 번째 Ugly Number를 찾아 출력해 주세요.
만약 1 9 10 을 입력받았다면, 출력결과는 1 10 12 입니다.

입력
찾고자 하는 정수의 개수 N을 입력 받습니다. (1 <= N <= 10,000)
그 다음줄 부터 N개의 양의 정수들을 입력받습니다. (1 <= 양의정수 <= 1,500)

출력
N번째 양의 정수들을 모두 출력 해 주세요.

입력 예시 1 

3
1 9 10

출력 예시 1

1 10 12
 * */
public class Main17 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 1. pq생성
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long ugly[] = new long[1501];
        // index : ugly number의 번째
        // value : 해당 ugly number

        // 2. pq에 1(시작 값)을 넣음
        pq.add((long)1);
        int cnt = 1; // 몇 번째 ugly number인가?

        long prev = -1; // 이전 ugly number
        while(cnt <= 1500) { // 1500번까지 찾아라!
            // 3. pq에서 data를 하나 꺼냄
            long now = pq.poll();
            if (now == prev)
                continue; // 앞의 값과 같은 숫자면 무시
            ugly[cnt] = now; // 새로운 ugly number이면 기록
            cnt++; // 다음번째 준비
            //System.out.println(now);
            // 4. now에서 *2, *3, *5로 파생되는 값 찾기
            // 5. pq에 이번에 찾은 ugly number를 넣기
            long next;
            next = now * 2;
            pq.add(next);
            next = now * 3;
            pq.add(next);
            next = now * 5;
            pq.add(next);

            prev = now;
        }
        int de = 1;

        // 전처리 (사전에 모든 값을 계산)

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < n; i++)
        {
            int index = Integer.parseInt(st.nextToken());
            System.out.print(ugly[index] + " ");
        }

    }
}