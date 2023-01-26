package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�� Priority Queue

����
Priority Queue �� �̿��Ͽ� ���� ��ɾ���� ó���ϴ� ���α׷��� �ۼ����ּ���

push A
���� A �� Priority Queue �� �ֽ��ϴ�.

pop B
B ���� ���� Priority Queue ���� ���� ����մϴ�. ( B �� ���� Priority Queue ũ�⺸�� ���� ���� �Էµ˴ϴ�.) ��� �� ������ �����մϴ�.

add C
Priority Queue ���� �� ���� ������ C�� ���� �� �ٽ� ���� �ֽ��ϴ�

Priority Queue �� Max Heap ���� ������ �մϴ�.

��ɾ� ���� )

push 2
push 3
pop 2 
push 10
push 5
push 12
add -3
pop 3
�� ��ɾ ���� ������ ���� ��µ˴ϴ�.

3 2
10 9 5

�Է�
��ɾ� ���� N �� �Է¹޽��ϴ�.

�� N ���ٿ� ���� ����� �Էµ˴ϴ�.

���
��ɾ �˸´� ó���� �ϰ� ����� ���ּ���

�Է� ���� 1 

8
push 2
push 3
pop 2 
push 10
push 5
push 12
add -3
pop 3

��� ���� 1

3 2
10 9 5



������ : '����' �켱������� ���� �����ų� ����

sort
���� ������ ���� ���(�� 1�� �����صΰ� �� ���� ��� ���)
'�߰��� �ִ� data���� ȣ���ϴ� ���'

priorityqueue
���� ����ϴ� ���߿� '�ش� ������ ���� ������ �ִ� ���'
'�߰��� �ִ� data'�� �ƴ� '�켱������ ���� ���� data���� ������ ���'

ex1 ) ���� �߰��߰� �߰��Ǽ� ����ؾ� �ϴ� ���
   - 100�� data�� ����
   - 100�� ���ο� data�� �߰��ϸ鼭, ���� ���� ���� ã�´�.
ex2) 1000000���� data�� ����
   - �߰� ��° i��°�� ���� ���� ã�� ��� -> (5����)
     arr[50000] <- 1
     pq.poll() <- �� i�� �ݺ��ؼ� �������� <- 50000 * logN
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