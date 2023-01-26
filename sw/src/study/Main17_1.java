package study;

import java.io.*;
import java.util.*;

public class Main17_1 {
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
        public int compareTo(Node right) { // 우선순위 세팅
            // 우선순위가 높은 data : -1로 나옴
            if(time < right.time) return -1; // 정상
            if(time > right.time) return 1; // 비정상

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
        int MAP[][] = new int[1000][1000];
        /*
        for (int times = 1; times <= 1000; times++) {
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    // 제일 작은 값 갱신
                }
            }
        }*/

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시간별로 어떤 좌표가 터져야 하는가?
        // '어떤 시간에 어떤 좌표의 폭탄이 터지는가?'
        // 시간, 좌표(row, col)

        // data를 묶어서 넣어주긴했는데, 우선순위를 모름
        // 우선순위 -> .compareTo()
        pq.add(new Node(5,2,1));
        pq.add(new Node(4,5,2));
        pq.add(new Node(2,3,1));
        pq.add(new Node(3,1,5));
        pq.add(new Node(1,7,2));

        while(!pq.isEmpty())
        {
            Node now = pq.poll();
            int de = 1;
        }

    }
}