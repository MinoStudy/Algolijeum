package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
■ 천지창조

설명

천지창조는 신이 인간을 흙으로 만들고 생명을 불어 넣는 것을 표현한 그림입니다.
아래 그림에서 이 두사람은 각각오른쪽 위 와 왼쪽 아래 모서리에 배치되어 있습니다.

83784552f9f2a32af1c07c39c6f5c216.jfif


아래는 8 x 9 Size의 pixel로 표현 한 예제입니다.

한 인물은 반드시 (7, 0) 좌표를 포함하고 있습니다.

또 한 인물은 반드시 (0, 8) 좌표를 포함하고 있습니다.

a5e546d120777d1a2c3796756849dd9a.png

위 그림에서는 두 사람이 총 네 칸 떨어져있습니다.

(상, 하, 좌, 우 방향으로 인접해 있는 경우만, 같은 사람을 취급합니다.)



두 인물이 그려진 벽화를 입력받고,

두 사람의 떨어진 거리를 구하는 프로그램을 작성해 주세요.


입력
8 x 9 크기의 그림 정보를 입력 해주세요.


출력
두 사람을 연결하기 위한 최소 거리를 출력해주세요.



입력 예시 1 

______###
______###
______###
_____####
____##___
#________
##_______
###______
출력 예시 1

4
힌트

한 사람을 기준으로 BFS돌려 한사람의 좌표를 큐에 모두 넣습니다.
다시 BFS를 돌려 가장 가까운 땅의 거리를 찾습니다.
 * */
public class Main27 {

    static class Node{
        int row;
        int col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static char MAP[][] = new char[8][9];

    static void input() throws IOException
    {
        for(int i = 0; i < 8; i++)
        {
            String temp = br.readLine();
            for(int j = 0; j < 9; j++)
            {
                MAP[i][j] = temp.charAt(j);
            }
        }
    }

    static int visited[][] = new int[8][9];

    static Queue<Node> BFS1() // 왼쪽영역에서 인접한 빈 공간들 찾기
    {
        // 1. 그래프 구성

        // 2. Queue
        Queue<Node> q = new LinkedList<>();

        Queue<Node> ret = new LinkedList<>(); 
        // 영역과 인접한 빈 공간 좌표를 저장할 queue

        // 3. 시작점 세팅
        q.add(new Node(7, 0));
        visited[7][0] = 1;

        // 7. 4~6단계 반복
        while (!q.isEmpty()) {
            // 4. now꺼내기
            Node now = q.poll(); // now : 왼쪽아래의 영역의 좌표

            // 5. now -> next찾기 // next: now와 인접한 좌표
            int dr[] = { -1, 1, 0, 0 };
            int dc[] = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int n_row = now.row + dr[i];
                int n_col = now.col + dc[i];

                if(n_row < 0 || n_row >= 8 ||
                    n_col < 0 || n_col >= 9)
                    continue; // 맵을 벗어나는 좌표인가?

                if(MAP[n_row][n_col] != '#') 
                    // now라는 영역과 '인접한 빈 공간'
                {
                    // BFS2의 3단계
                    ret.add(new Node(n_row, n_col));
                    visited[n_row][n_col] = 1;
                    continue; // 영역 밖이면 무시
                }

                if(visited[n_row][n_col] != 0)
                    continue; // 기록이 있으면 무시

                // 6. next -> queue에 삽입
                q.add(new Node(n_row, n_col));
                visited[n_row][n_col] = 1;
            }
        }
        return ret;
    }

    // 다른쪽 영역 : 왼쪽 아래 영역 X
    static int BFS2() // 왼쪽영역에서 인접한 빈 공간들 -> 다른쪽 영역 찾기
    {
        // 1. 그래프 구성

        // 2. Queue 생성, 3. 시작점 세팅
        Queue<Node> q = BFS1();

        // visited <- 왼쪽 아래 영역들이 전부 '기록이 되어 있는 상태'
        //            오른쪽 위 영역들 : 기록이 안되있는 상태

        // 7. 4~6단계 반복
        while (!q.isEmpty()) {
            // 4. now꺼내기
            Node now = q.poll();

            // 5. now -> next찾기
            int dr[] = { -1, 1, 0, 0 };
            int dc[] = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int n_row = now.row + dr[i];
                int n_col = now.col + dc[i];

                if(n_row < 0 || n_row >= 8||
                    n_col < 0 || n_col >= 9)
                    continue; // 맵을 벗어나는 경우
                if(visited[n_row][n_col] != 0)
                    continue; // 찾았던 좌표면 무시
                if(MAP[n_row][n_col] == '#')
                {
                    if(visited[n_row][n_col] == 0) // 기록이 없다. = 오른쪽 윗 영역
                    {
                        return visited[now.row][now.col];
                    }
                    // 어떠한 영역이면 무시
                    continue;
                }
                // 6. next -> queue에 삽입
                q.add(new Node(n_row, n_col));
                visited[n_row][n_col] = visited[now.row][now.col] + 1; 
                // visited upgrade
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(BFS2());
    }
}
/*
1. 그래프 구성(연결 정보)
2. Queue생성
3. 시작점 세팅
    - Queue에 삽입
4. Queue의 맨 앞의 점(now)을 꺼냄
5. now에서 갈 수 있는 점(next)을 전부 찾기
6. next를 queue에 삽입
7. 4~6번 단계 반복(Queue가 비워질 때까지)

추가작업 - 문제가 생길 부분Error해결
1. 2차원 맵을 사용하는 경우
   - 맵을 벗어나는 좌표인가 확인
2. 갔던 점을 다시 갈 수 있는 경우
   - 어떤 점을 찾았었는지 기록
   - visited
추가작업 - upgrade
1. visited upgrade
   - '몇 번'만에 찾았는지 기록

*/