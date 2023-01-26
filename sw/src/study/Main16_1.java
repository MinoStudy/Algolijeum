package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main16_1 {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 선언, default : MINHEAP '작은 값이 우선'
        // 비교기준 : .compareTo() => -1이 정상
        // => 큰값부터 하고 싶은 경우? Collections.reverseOrder()
        //PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder() );

        pq.add(1); // PriorityQueue.add(value) : value를 PriorityQueue에 추가(삽입)
        pq.add(9); 
        pq.add(5); 
        pq.add(4); 
        pq.add(6); 
        pq.add(8); 
        pq.add(2); 
        pq.add(3); 


        int de = 1;
        while(!pq.isEmpty())
        {
            int now = pq.poll();
            System.out.print(now + " ");
        }
        // PriorityQueue.poll() : PriorityQueue에서 DATA를 확인 및 삭제
        // PriorityQueue.peek() : PriorityQueue에서 DATA를 확인
        // PriorityQueue.remove() : PriorityQueue에서 DATA를 삭제
        // PriorityQueue.isEmpty() : PriorityQueue가 비었는가?
        // PriorityQueue.size() : PriorityQueue에 DATA가 몇개 있는가?

    }
}