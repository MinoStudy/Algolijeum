package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
�� õ��â��

����

õ��â���� ���� �ΰ��� ������ ����� ������ �Ҿ� �ִ� ���� ǥ���� �׸��Դϴ�.
�Ʒ� �׸����� �� �λ���� ���������� �� �� ���� �Ʒ� �𼭸��� ��ġ�Ǿ� �ֽ��ϴ�.

83784552f9f2a32af1c07c39c6f5c216.jfif


�Ʒ��� 8 x 9 Size�� pixel�� ǥ�� �� �����Դϴ�.

�� �ι��� �ݵ�� (7, 0) ��ǥ�� �����ϰ� �ֽ��ϴ�.

�� �� �ι��� �ݵ�� (0, 8) ��ǥ�� �����ϰ� �ֽ��ϴ�.

a5e546d120777d1a2c3796756849dd9a.png

�� �׸������� �� ����� �� �� ĭ �������ֽ��ϴ�.

(��, ��, ��, �� �������� ������ �ִ� ��츸, ���� ����� ����մϴ�.)



�� �ι��� �׷��� ��ȭ�� �Է¹ް�,

�� ����� ������ �Ÿ��� ���ϴ� ���α׷��� �ۼ��� �ּ���.


�Է�
8 x 9 ũ���� �׸� ������ �Է� ���ּ���.


���
�� ����� �����ϱ� ���� �ּ� �Ÿ��� ������ּ���.



�Է� ���� 1 

______###
______###
______###
_____####
____##___
#________
##_______
###______
��� ���� 1

4
��Ʈ

�� ����� �������� BFS���� �ѻ���� ��ǥ�� ť�� ��� �ֽ��ϴ�.
�ٽ� BFS�� ���� ���� ����� ���� �Ÿ��� ã���ϴ�.
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

    static Queue<Node> BFS1() // ���ʿ������� ������ �� ������ ã��
    {
        // 1. �׷��� ����

        // 2. Queue
        Queue<Node> q = new LinkedList<>();

        Queue<Node> ret = new LinkedList<>(); 
        // ������ ������ �� ���� ��ǥ�� ������ queue

        // 3. ������ ����
        q.add(new Node(7, 0));
        visited[7][0] = 1;

        // 7. 4~6�ܰ� �ݺ�
        while (!q.isEmpty()) {
            // 4. now������
            Node now = q.poll(); // now : ���ʾƷ��� ������ ��ǥ

            // 5. now -> nextã�� // next: now�� ������ ��ǥ
            int dr[] = { -1, 1, 0, 0 };
            int dc[] = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int n_row = now.row + dr[i];
                int n_col = now.col + dc[i];

                if(n_row < 0 || n_row >= 8 ||
                    n_col < 0 || n_col >= 9)
                    continue; // ���� ����� ��ǥ�ΰ�?

                if(MAP[n_row][n_col] != '#') 
                    // now��� ������ '������ �� ����'
                {
                    // BFS2�� 3�ܰ�
                    ret.add(new Node(n_row, n_col));
                    visited[n_row][n_col] = 1;
                    continue; // ���� ���̸� ����
                }

                if(visited[n_row][n_col] != 0)
                    continue; // ����� ������ ����

                // 6. next -> queue�� ����
                q.add(new Node(n_row, n_col));
                visited[n_row][n_col] = 1;
            }
        }
        return ret;
    }

    // �ٸ��� ���� : ���� �Ʒ� ���� X
    static int BFS2() // ���ʿ������� ������ �� ������ -> �ٸ��� ���� ã��
    {
        // 1. �׷��� ����

        // 2. Queue ����, 3. ������ ����
        Queue<Node> q = BFS1();

        // visited <- ���� �Ʒ� �������� ���� '����� �Ǿ� �ִ� ����'
        //            ������ �� ������ : ����� �ȵ��ִ� ����

        // 7. 4~6�ܰ� �ݺ�
        while (!q.isEmpty()) {
            // 4. now������
            Node now = q.poll();

            // 5. now -> nextã��
            int dr[] = { -1, 1, 0, 0 };
            int dc[] = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int n_row = now.row + dr[i];
                int n_col = now.col + dc[i];

                if(n_row < 0 || n_row >= 8||
                    n_col < 0 || n_col >= 9)
                    continue; // ���� ����� ���
                if(visited[n_row][n_col] != 0)
                    continue; // ã�Ҵ� ��ǥ�� ����
                if(MAP[n_row][n_col] == '#')
                {
                    if(visited[n_row][n_col] == 0) // ����� ����. = ������ �� ����
                    {
                        return visited[now.row][now.col];
                    }
                    // ��� �����̸� ����
                    continue;
                }
                // 6. next -> queue�� ����
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
1. �׷��� ����(���� ����)
2. Queue����
3. ������ ����
    - Queue�� ����
4. Queue�� �� ���� ��(now)�� ����
5. now���� �� �� �ִ� ��(next)�� ���� ã��
6. next�� queue�� ����
7. 4~6�� �ܰ� �ݺ�(Queue�� ����� ������)

�߰��۾� - ������ ���� �κ�Error�ذ�
1. 2���� ���� ����ϴ� ���
   - ���� ����� ��ǥ�ΰ� Ȯ��
2. ���� ���� �ٽ� �� �� �ִ� ���
   - � ���� ã�Ҿ����� ���
   - visited
�߰��۾� - upgrade
1. visited upgrade
   - '�� ��'���� ã�Ҵ��� ���

*/