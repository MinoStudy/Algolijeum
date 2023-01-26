package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main16_1 {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // ����, default : MINHEAP '���� ���� �켱'
        // �񱳱��� : .compareTo() => -1�� ����
        // => ū������ �ϰ� ���� ���? Collections.reverseOrder()
        //PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder() );

        pq.add(1); // PriorityQueue.add(value) : value�� PriorityQueue�� �߰�(����)
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
        // PriorityQueue.poll() : PriorityQueue���� DATA�� Ȯ�� �� ����
        // PriorityQueue.peek() : PriorityQueue���� DATA�� Ȯ��
        // PriorityQueue.remove() : PriorityQueue���� DATA�� ����
        // PriorityQueue.isEmpty() : PriorityQueue�� ����°�?
        // PriorityQueue.size() : PriorityQueue�� DATA�� � �ִ°�?

    }
}