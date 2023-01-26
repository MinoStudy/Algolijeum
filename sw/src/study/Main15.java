package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
■ 회의실 배정
설명
회의실이 단 하나인 중소기업이 있습니다.
하나밖에 없는 회의실을 사용하기 위해, 여러 팀들이 예약을 합니다.

회의실 관리자는 한 회의가 얼마나 길고 짧은지는 고려하지 않고,
더욱 많은 회의가 이루어지길 원합니다.
예약 스케쥴을 입력받고, 최대 몇번의 회의가 가능한지 출력해 주세요.

image.png

위 이미지는 총 여섯 번 회의 예약의 예시입니다.

예약 신청 : 1 ~ 6시 까지
예약 신청 : 3 ~ 8시 까지
예약 신청 : 8 ~ 9시 까지
예약 신청 : 2 ~ 4시 까지
예약 신청 : 4 ~ 6시 까지
예약 신청 : 7 ~ 9시 까지
위와 같은 예시에서 최대 세 번의 회의가 가능하므로, 출력결과는 3 입니다.

입력
회의실 예약 스케쥴의 개수 N을 입력 받습니다. (1 <= N <= 100,000)
그 다음 줄 부터, N개의 예약스케쥴을 입력 받습니다. [시작값(a) ~ 끝값(b)]
(1 <= a, b <= 100,000,000)

출력
가능한 회의의 최대 개수를 출력해 주세요.

입력 예시 1 

6
1 6
3 8
8 9
2 4
4 6
7 9

출력 예시 1

3 
*/
public class Main15 {

    static class Node implements Comparable<Node>{
        int s;
        int e;
        Node(int s, int e)
        {
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Node right) {
            if(e < right.e) return -1; // 왼쪽이 빨리 끝나면 정상
            if(e > right.e) return 1; // 왼쪽이 늦게 끝나면 비정상

            if(s < right.s) return -1; // 왼쪽이 빨리 시작하면 정상
            if(s > right.s) return 1; // 왼쪽이 늦게 시작하면 비정상

            return 0;
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        Node node[] = new Node[n];
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            node[i] = new Node(s, e);
        }

        Arrays.sort(node);

        int now = 0; // 현재 회의가 끝나는 시간
        int cnt = 0;
        for(int i = 0; i < n; i++)
        {
            if(now <= node[i].s)
                // 현재 회의가 끝나는 시간 '이후에' 시작하는 회의
            {
                now = node[i].e;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}