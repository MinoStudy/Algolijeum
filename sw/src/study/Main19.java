package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
■ 연쇄폭탄

설명
N x N 필드 지역에 폭탄을 설치 하였습니다.
폭탄은 위, 아래, 왼쪽, 오른쪽 영역으로 터지게 됩니다.
번호 순서대로 폭탄을 설치했고, 1초에 하나씩 폭탄이 터집니다.
1 초가 되면, 1번 폭탄이 터집니다.
1 번 폭탄에 의하여, 14, 8, 7 번 지역도 터졌으며, 그곳에 있는 폭탄은 사라지게 됩니다.
2656630281c73294b6a21bcfdba16472.png

2 초가 되었고, 아직 2번 폭탄은 동작되고 있는 상태입니다.
10, 13, 9, 11, 2번 지역에 폭탄이 터지게 되었습니다.
c689568420d8195c545c6cd3a71ace0f.png

3초가 되었고, 아직 3번 폭탄은 동작되고 있는 상태입니다.
3번과 6번 지역에 폭탄이 터지게 되었습니다.
c26579ea87cbf0c5551d41288ac2f67c.png

4초가 되었고, 4번과 15번 지역에 폭탄이 터지게 되었습니다.
a2a2c54461ee3d9ea69ad45e5e88d4c9.png

5초가 되었고, 5번과 16번 지역에 폭탄이 터지게 되었습니다.
86e617dbf651342237cb1f3001471db6.png

12초가 될 때 까지, 아무런 폭탄이 터지지 않습니다.
그리고 12초가 되어 남은 지역까지 모두 폭탄이 터지게 되었습니다.
efc47034d618f7616e92f388767aa329.png

적군 필지에 모든 폭탄이 터질 때 까지 걸리는 시간을 구해 출력해 주세요.

입력
첫 줄에는 N이 입력되며,
N x N 사이즈의 폭탄 설치 정보가 입력됩니다.
(1 <= N <= 1,000)

출력
총 몇 초만에 모든 폭탄이 터지는지 구하여 출력해 주세요.

입력 예시 1 

4
16 14 1 8
5 10 7 3
13 2 9 6
12 11 4 15

출력 예시 1

12초
 * */
public class Main19 {
    static class Node implements Comparable<Node>{
        int time;
        int row;
        int col;
        Node(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
        @Override
        public int compareTo(Node right) { // 우선순위 세팅
            // 우선순위가 높은 data : -1로 나옴
            if(time < right.time) return -1; // 정상
            if(time > right.time) return 1; // 비정상

            if(row < right.row) return -1;
            if(row > right.row) return 1;

            if(col < right.col) return -1;
            if(col > right.col) return 1;

            return 0;
        }
        @Override
        public String toString() {
            return "Node [time=" + time + ", row=" + row + ", col=" + col + "]";
        }


    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시간별로 어떤 좌표가 터져야 하는가?
        // '어떤 시간에 어떤 좌표의 폭탄이 터지는가?'
        // 시간, 좌표(row, col)

        // data를 묶어서 넣어주긴했는데, 우선순위를 모름
        // 우선순위 -> .compareTo()
        int n = Integer.parseInt(br.readLine());
        int MAP[][] = new int[n][n];
        for(int i = 0; i <n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {
                MAP[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new Node(MAP[i][j], i, j));
            }
        }
        int ans = 0;
        while(!pq.isEmpty())
        {
            Node now = pq.poll(); // 폭탄을 하나 꺼냄
            if(MAP[now.row][now.col] == 0) // 이미 터져서 없어진 곳인가?
                continue; // 무시

            //상하좌우
            MAP[now.row][now.col] = 0; // MAP에 0의 값이 있으면 터져서 없어졌다.
            if(now.row > 0)
                MAP[now.row - 1][now.col] = 0; // 윗 좌표
            if(now.row < n - 1)
                MAP[now.row + 1][now.col] = 0; // 아랫 좌표
            if(now.col > 0)
                MAP[now.row][now.col - 1] = 0; // 왼쪽 좌표
            if(now.col < n - 1)
                MAP[now.row][now.col + 1] = 0; // 오른쪽 좌표

            ans = now.time;
        }
        System.out.println(ans+"초");
    }
}
