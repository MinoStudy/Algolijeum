package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
■ Priority Queue

설명
Priority Queue 를 이용하여 다음 명령어들을 처리하는 프로그램을 작성해주세요

push A
정수 A 를 Priority Queue 에 넣습니다.

pop B
B 개의 값을 Priority Queue 에서 빼서 출력합니다. ( B 는 현재 Priority Queue 크기보다 작은 수가 입력됩니다.) 출력 후 한줄을 개행합니다.

add C
Priority Queue 에서 한 개를 꺼내서 C를 더한 후 다시 집어 넣습니다

Priority Queue 는 Max Heap 으로 구성을 합니다.

명령어 예시 )

push 2
push 3
pop 2 
push 10
push 5
push 12
add -3
pop 3
위 명령어에 대해 다음과 같이 출력됩니다.

3 2
10 9 5

입력
명령어 갯수 N 을 입력받습니다.

총 N 개줄에 걸쳐 명령이 입력됩니다.

출력
명령어에 알맞는 처리를 하고 출력을 해주세요

입력 예시 1 

8
push 2
push 3
pop 2 
push 10
push 5
push 12
add -3
pop 3

출력 예시 1

3 2
10 9 5



공통점 : '기준' 우선순위대로 값이 나오거나 정리

sort
값의 변경이 없는 경우(딱 1번 정리해두고 그 값을 계속 사용)
'중간에 있는 data들을 호출하는 경우'

priorityqueue
값을 사용하는 도중에 '해당 값들의 변경 사항이 있는 경우'
'중간에 있는 data'가 아닌 '우선순위가 가장 높은 data만을 꺼내는 경우'

ex1 ) 값이 중간중간 추가되서 사용해야 하는 경우
   - 100개 data가 있음
   - 100번 새로운 data를 추가하면서, 제일 작은 값을 찾는다.
ex2) 1000000개의 data가 있음
   - 중간 번째 i번째로 작은 값을 찾아 사용 -> (5만번)
     arr[50000] <- 1
     pq.poll() <- 총 i번 반복해서 꺼내봐야 <- 50000 * logN
*/
public class Main16 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // default : MIN
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(query.compareTo("push") == 0 )
            {
                pq.add(num);
            }
            else if(query.compareTo("pop") == 0)
            {
                for(int j = 0; j < num; j++)
                    System.out.print(pq.poll() + " ");
                System.out.println();
            }
            else if(query.compareTo("add") == 0)
            {
                int now = pq.poll();
                pq.add(now + num);
            }
        }
    }
}