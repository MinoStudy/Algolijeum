package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�� ������ź

����
N x N �ʵ� ������ ��ź�� ��ġ �Ͽ����ϴ�.
��ź�� ��, �Ʒ�, ����, ������ �������� ������ �˴ϴ�.
��ȣ ������� ��ź�� ��ġ�߰�, 1�ʿ� �ϳ��� ��ź�� �����ϴ�.
1 �ʰ� �Ǹ�, 1�� ��ź�� �����ϴ�.
1 �� ��ź�� ���Ͽ�, 14, 8, 7 �� ������ ��������, �װ��� �ִ� ��ź�� ������� �˴ϴ�.
2656630281c73294b6a21bcfdba16472.png

2 �ʰ� �Ǿ���, ���� 2�� ��ź�� ���۵ǰ� �ִ� �����Դϴ�.
10, 13, 9, 11, 2�� ������ ��ź�� ������ �Ǿ����ϴ�.
c689568420d8195c545c6cd3a71ace0f.png

3�ʰ� �Ǿ���, ���� 3�� ��ź�� ���۵ǰ� �ִ� �����Դϴ�.
3���� 6�� ������ ��ź�� ������ �Ǿ����ϴ�.
c26579ea87cbf0c5551d41288ac2f67c.png

4�ʰ� �Ǿ���, 4���� 15�� ������ ��ź�� ������ �Ǿ����ϴ�.
a2a2c54461ee3d9ea69ad45e5e88d4c9.png

5�ʰ� �Ǿ���, 5���� 16�� ������ ��ź�� ������ �Ǿ����ϴ�.
86e617dbf651342237cb1f3001471db6.png

12�ʰ� �� �� ����, �ƹ��� ��ź�� ������ �ʽ��ϴ�.
�׸��� 12�ʰ� �Ǿ� ���� �������� ��� ��ź�� ������ �Ǿ����ϴ�.
efc47034d618f7616e92f388767aa329.png

���� ������ ��� ��ź�� ���� �� ���� �ɸ��� �ð��� ���� ����� �ּ���.

�Է�
ù �ٿ��� N�� �ԷµǸ�,
N x N �������� ��ź ��ġ ������ �Էµ˴ϴ�.
(1 <= N <= 1,000)

���
�� �� �ʸ��� ��� ��ź�� �������� ���Ͽ� ����� �ּ���.

�Է� ���� 1 

4
16 14 1 8
5 10 7 3
13 2 9 6
12 11 4 15

��� ���� 1

12��
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
        public int compareTo(Node right) { // �켱���� ����
            // �켱������ ���� data : -1�� ����
            if(time < right.time) return -1; // ����
            if(time > right.time) return 1; // ������

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
        // �ð����� � ��ǥ�� ������ �ϴ°�?
        // '� �ð��� � ��ǥ�� ��ź�� �����°�?'
        // �ð�, ��ǥ(row, col)

        // data�� ��� �־��ֱ��ߴµ�, �켱������ ��
        // �켱���� -> .compareTo()
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
            Node now = pq.poll(); // ��ź�� �ϳ� ����
            if(MAP[now.row][now.col] == 0) // �̹� ������ ������ ���ΰ�?
                continue; // ����

            //�����¿�
            MAP[now.row][now.col] = 0; // MAP�� 0�� ���� ������ ������ ��������.
            if(now.row > 0)
                MAP[now.row - 1][now.col] = 0; // �� ��ǥ
            if(now.row < n - 1)
                MAP[now.row + 1][now.col] = 0; // �Ʒ� ��ǥ
            if(now.col > 0)
                MAP[now.row][now.col - 1] = 0; // ���� ��ǥ
            if(now.col < n - 1)
                MAP[now.row][now.col + 1] = 0; // ������ ��ǥ

            ans = now.time;
        }
        System.out.println(ans+"��");
    }
}
