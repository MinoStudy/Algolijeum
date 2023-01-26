package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
■ 프린터 스케쥴링 시스템

설명
민코딩 사무실에는 프린터가 여러대 있습니다.
각 프린터는 한 번에 1개의 문서만 출력이 가능합니다.
여러 문서를 한 프린터로 모두 출력하기엔 시간이 너무 오래 걸리기에 최대한 문서들을 적절하게 분배할 필요가 있습니다.
민철이는 언제 출력을 요청해도 출력이 완료되는 시간이 최소가 되는 스케쥴링 시스템을 개발하고자 합니다.

image.png

각 문서가 출력을 요청한 시간과 출력을 하는데 필요한 시간이 주어집니다.
출력을 요청하고 출력이 완료될 때까지 걸리는 시간을 대기 시간이라고 할 때, 대기 시간의 합이 최소가 될 수 있도록 각 문서가 어떤 프린터로 출력해야 할지를 구해주는 프로그램을 작성해 주세요.

단, 총 대기 시간에 영향을 주지 않으며 어떤 문서 i가 출력할 수 있는 프린터가 2개 이상인 경우 프린터 번호가 작은 프린터에서 출력합니다.
반대로 어떤 프린터에서 출력할 수 있는 문서가 2개 이상인 경우 더 작은 번호의 문서부터 출력합니다.

입력
첫 번째 줄에 문서의 수 N과 프린터의 수 M를 입력받습니다.(1 <= N, M <= 200,000)
그 다음 줄부터 N개의 줄에 걸쳐 번호 순서대로문서의정보가 두 정수 A, B로 주어집니다. (1 <= A, B <= 1,000,000,000)
A는 출력을 요청한 시간, B는 출력이 시작되고 끝날 때까지 걸리는 시간입니다.
프린터 번호는 1 ~ M번까지 있습니다.

출력
N개의 줄에 걸쳐 각 문서를 출력할 프린터 번호를 출력합니다.

입력 예시 1 

5 3
1 1
1 2
1 3
2 4
3 2

출력 예시 1

1
2
3
1
2

입력 예시 2 

5 2
4 8
5 9
1 5
2 6
3 7

출력 예시 2

2
1
1
2
1
 * */
public class Main20 {

    static class Doc implements Comparable<Doc>{
        int start; // 요청시간
        int time; // 걸리는 시간
        int num; // 문서 번호
        Doc(int start, int time, int num){
            this.start= start;
            this.time = time;
            this.num = num;
        }
        @Override
        public int compareTo(Doc right) {
            //가장 빨리 요청한 문서
            if(start < right.start) return -1; // 왼쪽이 빠르면 정상
            if(start > right.start) return 1; // 오른쪽이 빠르면 비정상

            //출력하는데 걸리는 시간이 짧은 것을 먼저
            if(time < right.time) return -1; // 왼쪽 문서가 빠르면 정상
            if(time > right.time) return 1; //오른쪽 문서가 빠르면 비정상

            //'문서 번호가 작은 문서'
            if(num < right.num) return -1; // 왼쪽 문서가 빠르면 정상
            if(num > right.num) return 1; // 오른쪽 문서가 빠르면 비정상

            return 0;
        }
        @Override
        public String toString() {
            return "Doc [start=" + start + ", time=" + time + ", num=" + num + "]";
        }
    }

    static class Printer implements Comparable<Printer>{
        int end_time; // 출력이 완료되는 시간
        int num; // 프린터의 번호
        Printer(int end_time, int num){
            this.end_time = end_time;
            this.num = num;
        }
        @Override
        public int compareTo(Printer right) {
            // 출력이 '빨리'완료되는 프린터
            if(end_time < right.end_time) return -1;
            if(end_time > right.end_time) return 1;

            // 번호가 작은 순 
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
    // index : 문서 번호, value : 해당 문서를 출력하는 프린터 번호

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
            start = Integer.parseInt(st.nextToken()); // 요청 시간
            time = Integer.parseInt(st.nextToken()); // 출력하는데 걸리는 시간
            doc[i] = new Doc(start, time, i);
        }
    }

    static void solve() // 작업 처리
    {
        Arrays.sort(doc);
        PriorityQueue<Printer> pq = new PriorityQueue<>();
        for(int i = 1; i <= M; i++ ) // 모든 프린터를 세팅
            pq.add(new Printer(0, i));
        // 문서와 프린터를 준비

        // 문서를 프린터에 할당
        for(int i = 0; i < N; i++)
        {
            Printer printer = pq.poll(); // 이번에 할당할 프린터
            //doc[i]; // 이번에 출력할 문서
            DAT[ doc[i].num ] = printer.num; // 해당 문서가 어떤 프린터에서 출력을 하는지 기록
            if(printer.end_time < doc[i].start) // 앞의 문서가 출력이 완료된 후 요청
                printer.end_time = doc[i].start + doc[i].time;
                // 이번문서의 완료 시간 = 이번문서의 요청시간 + 출력하는데 걸리는 시간
            else // 앞의 문서가 출력이 완료되기 전 요청
                printer.end_time = printer.end_time + doc[i].time;
                // 이번 문서의 완료시간 = 앞의 문서가 완료되는 시간 + 출력하는데 걸리는 시간

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
