package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
�� ������ �����층 �ý���

����
���ڵ� �繫�ǿ��� �����Ͱ� ������ �ֽ��ϴ�.
�� �����ʹ� �� ���� 1���� ������ ����� �����մϴ�.
���� ������ �� �����ͷ� ��� ����ϱ⿣ �ð��� �ʹ� ���� �ɸ��⿡ �ִ��� �������� �����ϰ� �й��� �ʿ䰡 �ֽ��ϴ�.
��ö�̴� ���� ����� ��û�ص� ����� �Ϸ�Ǵ� �ð��� �ּҰ� �Ǵ� �����층 �ý����� �����ϰ��� �մϴ�.

image.png

�� ������ ����� ��û�� �ð��� ����� �ϴµ� �ʿ��� �ð��� �־����ϴ�.
����� ��û�ϰ� ����� �Ϸ�� ������ �ɸ��� �ð��� ��� �ð��̶�� �� ��, ��� �ð��� ���� �ּҰ� �� �� �ֵ��� �� ������ � �����ͷ� ����ؾ� ������ �����ִ� ���α׷��� �ۼ��� �ּ���.

��, �� ��� �ð��� ������ ���� ������ � ���� i�� ����� �� �ִ� �����Ͱ� 2�� �̻��� ��� ������ ��ȣ�� ���� �����Ϳ��� ����մϴ�.
�ݴ�� � �����Ϳ��� ����� �� �ִ� ������ 2�� �̻��� ��� �� ���� ��ȣ�� �������� ����մϴ�.

�Է�
ù ��° �ٿ� ������ �� N�� �������� �� M�� �Է¹޽��ϴ�.(1 <= N, M <= 200,000)
�� ���� �ٺ��� N���� �ٿ� ���� ��ȣ ������ι����������� �� ���� A, B�� �־����ϴ�. (1 <= A, B <= 1,000,000,000)
A�� ����� ��û�� �ð�, B�� ����� ���۵ǰ� ���� ������ �ɸ��� �ð��Դϴ�.
������ ��ȣ�� 1 ~ M������ �ֽ��ϴ�.

���
N���� �ٿ� ���� �� ������ ����� ������ ��ȣ�� ����մϴ�.

�Է� ���� 1 

5 3
1 1
1 2
1 3
2 4
3 2

��� ���� 1

1
2
3
1
2

�Է� ���� 2 

5 2
4 8
5 9
1 5
2 6
3 7

��� ���� 2

2
1
1
2
1
 * */
public class Main20 {

    static class Doc implements Comparable<Doc>{
        int start; // ��û�ð�
        int time; // �ɸ��� �ð�
        int num; // ���� ��ȣ
        Doc(int start, int time, int num){
            this.start= start;
            this.time = time;
            this.num = num;
        }
        @Override
        public int compareTo(Doc right) {
            //���� ���� ��û�� ����
            if(start < right.start) return -1; // ������ ������ ����
            if(start > right.start) return 1; // �������� ������ ������

            //����ϴµ� �ɸ��� �ð��� ª�� ���� ����
            if(time < right.time) return -1; // ���� ������ ������ ����
            if(time > right.time) return 1; //������ ������ ������ ������

            //'���� ��ȣ�� ���� ����'
            if(num < right.num) return -1; // ���� ������ ������ ����
            if(num > right.num) return 1; // ������ ������ ������ ������

            return 0;
        }
        @Override
        public String toString() {
            return "Doc [start=" + start + ", time=" + time + ", num=" + num + "]";
        }
    }

    static class Printer implements Comparable<Printer>{
        int end_time; // ����� �Ϸ�Ǵ� �ð�
        int num; // �������� ��ȣ
        Printer(int end_time, int num){
            this.end_time = end_time;
            this.num = num;
        }
        @Override
        public int compareTo(Printer right) {
            // ����� '����'�Ϸ�Ǵ� ������
            if(end_time < right.end_time) return -1;
            if(end_time > right.end_time) return 1;

            // ��ȣ�� ���� �� 
            if(num < right.num) return -1;
            if(num > right.num) return 1;
            return 0;
        }
        @Override
        public String toString() {
            return "Printer [end_time=" + end_time + ", num=" + num + "]";
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static Doc doc[];
    static int DAT[]; 
    // index : ���� ��ȣ, value : �ش� ������ ����ϴ� ������ ��ȣ

    static void input() throws IOException
    {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        doc = new Doc[N];
        DAT = new int[N];
        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start, time;
            start = Integer.parseInt(st.nextToken()); // ��û �ð�
            time = Integer.parseInt(st.nextToken()); // ����ϴµ� �ɸ��� �ð�
            doc[i] = new Doc(start, time, i);
        }
    }

    static void solve() // �۾� ó��
    {
        Arrays.sort(doc);
        PriorityQueue<Printer> pq = new PriorityQueue<>();
        for(int i = 1; i <= M; i++ ) // ��� �����͸� ����
            pq.add(new Printer(0, i));
        // ������ �����͸� �غ�

        // ������ �����Ϳ� �Ҵ�
        for(int i = 0; i < N; i++)
        {
            Printer printer = pq.poll(); // �̹��� �Ҵ��� ������
            //doc[i]; // �̹��� ����� ����
            DAT[ doc[i].num ] = printer.num; // �ش� ������ � �����Ϳ��� ����� �ϴ��� ���
            if(printer.end_time < doc[i].start) // ���� ������ ����� �Ϸ�� �� ��û
                printer.end_time = doc[i].start + doc[i].time;
                // �̹������� �Ϸ� �ð� = �̹������� ��û�ð� + ����ϴµ� �ɸ��� �ð�
            else // ���� ������ ����� �Ϸ�Ǳ� �� ��û
                printer.end_time = printer.end_time + doc[i].time;
                // �̹� ������ �Ϸ�ð� = ���� ������ �Ϸ�Ǵ� �ð� + ����ϴµ� �ɸ��� �ð�

            pq.add(printer);
        }


    }

    static void print_ans()
    {
        for(int i = 0; i < N; i++)
            System.out.println(DAT[i]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print_ans();

    }
}
