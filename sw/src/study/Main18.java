package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
■ 정중앙 대학교

설명
정중앙 대학교는 성적이 정확히 중앙에 있는 사람만 입학할 수 있습니다.
정중앙 대학교에 입학하고 싶은 준하는 기준 점수를 실시간으로 파악하고 싶어합니다.
142743ce2d27e4dd447306fc1b692ddc.png

정중앙 대학교는500점 기준으로 시작됩니다.
이제 두 사람씩 수능 점수를 입력 받습니다.

700점, 600점을 받은 사람이 등장한다면, 수능 기준점수는 600점이 됩니다. (500,600, 700)
400점, 300점을 받은 사람이 등장한다면, 수능 기준점수는 500점이 됩니다. (300, 400,500, 600, 700)
100점, 200점을 받은 사람이 등장한다면, 수능 기준점수는 400점이 됩니다. (100, 200, 300,400, 500, 600, 700)
370점, 430점을 받은 사람이 등장한다면, 수능 기준점수는 400점이 됩니다. (100, 200, 300, 370,400, 430, 500, 600, 700)

중앙에 있는 점수를 찾아 출력해 주세요.

[예시]
50 500 1500 인경우, 정중앙에 해당되는 값은 500점 입니다.
(50 + 1500) / 2 가 중앙값이 아닙니다.

입력
첫 줄에는 숫자 N이 입력 됩니다.
두 사람 씩, N 회 점수를 입력받으세요.
입력을 받을때 마다,정중앙 대학교에 입학하기 위한 기준점수를 출력해 주세요.

출력
두 점수가 입력 될 때 마다,
중앙에 있는 점수를 한줄씩 출력합니다.

입력 예시 1 

4
700 600
400 300
100 200
370 430

출력 예시 1

600
500
400
400
*/
public class Main18 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        // 작은 값들을 저장하는 MAXHEAP
        PriorityQueue<Integer> pq_low = new PriorityQueue<>(Collections.reverseOrder()); 
        // 큰 값들을 저장하는 MINHEAP
        PriorityQueue<Integer> pq_high = new PriorityQueue<>();

        pq_high.add(500);
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            pq_low.add(num1);
            pq_high.add(num2);
            if(pq_low.peek() >= pq_high.peek() )
            // 잘못된 형태
            {
                int temp = pq_low.poll();
                pq_low.add(pq_high.poll());
                pq_high.add(temp);
                // swap
            }
            System.out.println(pq_high.peek());
        }
    }
}
