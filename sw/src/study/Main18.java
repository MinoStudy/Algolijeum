package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�� ���߾� ���б�

����
���߾� ���б��� ������ ��Ȯ�� �߾ӿ� �ִ� ����� ������ �� �ֽ��ϴ�.
���߾� ���б��� �����ϰ� ���� ���ϴ� ���� ������ �ǽð����� �ľ��ϰ� �;��մϴ�.
142743ce2d27e4dd447306fc1b692ddc.png

���߾� ���б���500�� �������� ���۵˴ϴ�.
���� �� ����� ���� ������ �Է� �޽��ϴ�.

700��, 600���� ���� ����� �����Ѵٸ�, ���� ���������� 600���� �˴ϴ�. (500,600, 700)
400��, 300���� ���� ����� �����Ѵٸ�, ���� ���������� 500���� �˴ϴ�. (300, 400,500, 600, 700)
100��, 200���� ���� ����� �����Ѵٸ�, ���� ���������� 400���� �˴ϴ�. (100, 200, 300,400, 500, 600, 700)
370��, 430���� ���� ����� �����Ѵٸ�, ���� ���������� 400���� �˴ϴ�. (100, 200, 300, 370,400, 430, 500, 600, 700)

�߾ӿ� �ִ� ������ ã�� ����� �ּ���.

[����]
50 500 1500 �ΰ��, ���߾ӿ� �ش�Ǵ� ���� 500�� �Դϴ�.
(50 + 1500) / 2 �� �߾Ӱ��� �ƴմϴ�.

�Է�
ù �ٿ��� ���� N�� �Է� �˴ϴ�.
�� ��� ��, N ȸ ������ �Է¹�������.
�Է��� ������ ����,���߾� ���б��� �����ϱ� ���� ���������� ����� �ּ���.

���
�� ������ �Է� �� �� ����,
�߾ӿ� �ִ� ������ ���پ� ����մϴ�.

�Է� ���� 1 

4
700 600
400 300
100 200
370 430

��� ���� 1

600
500
400
400
*/
public class Main18 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        // ���� ������ �����ϴ� MAXHEAP
        PriorityQueue<Integer> pq_low = new PriorityQueue<>(Collections.reverseOrder()); 
        // ū ������ �����ϴ� MINHEAP
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
            // �߸��� ����
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
