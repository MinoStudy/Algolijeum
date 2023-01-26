package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
�� ȸ�ǽ� ����
����
ȸ�ǽ��� �� �ϳ��� �߼ұ���� �ֽ��ϴ�.
�ϳ��ۿ� ���� ȸ�ǽ��� ����ϱ� ����, ���� ������ ������ �մϴ�.

ȸ�ǽ� �����ڴ� �� ȸ�ǰ� �󸶳� ��� ª������ ������� �ʰ�,
���� ���� ȸ�ǰ� �̷������ ���մϴ�.
���� �������� �Է¹ް�, �ִ� ����� ȸ�ǰ� �������� ����� �ּ���.

image.png

�� �̹����� �� ���� �� ȸ�� ������ �����Դϴ�.

���� ��û : 1 ~ 6�� ����
���� ��û : 3 ~ 8�� ����
���� ��û : 8 ~ 9�� ����
���� ��û : 2 ~ 4�� ����
���� ��û : 4 ~ 6�� ����
���� ��û : 7 ~ 9�� ����
���� ���� ���ÿ��� �ִ� �� ���� ȸ�ǰ� �����ϹǷ�, ��°���� 3 �Դϴ�.

�Է�
ȸ�ǽ� ���� �������� ���� N�� �Է� �޽��ϴ�. (1 <= N <= 100,000)
�� ���� �� ����, N���� ���ེ������ �Է� �޽��ϴ�. [���۰�(a) ~ ����(b)]
(1 <= a, b <= 100,000,000)

���
������ ȸ���� �ִ� ������ ����� �ּ���.

�Է� ���� 1 

6
1 6
3 8
8 9
2 4
4 6
7 9

��� ���� 1

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
            if(e < right.e) return -1; // ������ ���� ������ ����
            if(e > right.e) return 1; // ������ �ʰ� ������ ������

            if(s < right.s) return -1; // ������ ���� �����ϸ� ����
            if(s > right.s) return 1; // ������ �ʰ� �����ϸ� ������

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

        int now = 0; // ���� ȸ�ǰ� ������ �ð�
        int cnt = 0;
        for(int i = 0; i < n; i++)
        {
            if(now <= node[i].s)
                // ���� ȸ�ǰ� ������ �ð� '���Ŀ�' �����ϴ� ȸ��
            {
                now = node[i].e;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}