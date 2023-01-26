package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�� Ugly Number

����
Ugly Number�� ���� 2, 3, 5 �� ����Ͽ� ����� �� �� �ִ� ���� ���մϴ�.
���ܷ� ���� 1�� ù ��° Ugly Number�Դϴ�.

Ugly Number���� ������� �����غ��� ������ �����ϴ�.
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ...

number.png

a, b, c ... �� n ���� ���� �Է¹ް�,  a, b, c ... ��° Ugly Number�� ã�� ����� �ּ���.
���� 1 9 10 �� �Է¹޾Ҵٸ�, ��°���� 1 10 12 �Դϴ�.

�Է�
ã���� �ϴ� ������ ���� N�� �Է� �޽��ϴ�. (1 <= N <= 10,000)
�� ������ ���� N���� ���� �������� �Է¹޽��ϴ�. (1 <= �������� <= 1,500)

���
N��° ���� �������� ��� ��� �� �ּ���.

�Է� ���� 1 

3
1 9 10

��� ���� 1

1 10 12
 * */
public class Main17 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 1. pq����
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long ugly[] = new long[1501];
        // index : ugly number�� ��°
        // value : �ش� ugly number

        // 2. pq�� 1(���� ��)�� ����
        pq.add((long)1);
        int cnt = 1; // �� ��° ugly number�ΰ�?

        long prev = -1; // ���� ugly number
        while(cnt <= 1500) { // 1500������ ã�ƶ�!
            // 3. pq���� data�� �ϳ� ����
            long now = pq.poll();
            if (now == prev)
                continue; // ���� ���� ���� ���ڸ� ����
            ugly[cnt] = now; // ���ο� ugly number�̸� ���
            cnt++; // ������° �غ�
            //System.out.println(now);
            // 4. now���� *2, *3, *5�� �Ļ��Ǵ� �� ã��
            // 5. pq�� �̹��� ã�� ugly number�� �ֱ�
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

        // ��ó�� (������ ��� ���� ���)

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < n; i++)
        {
            int index = Integer.parseInt(st.nextToken());
            System.out.print(ugly[index] + " ");
        }

    }
}