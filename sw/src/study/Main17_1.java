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
        int MAP[][] = new int[1000][1000];
        /*
        for (int times = 1; times <= 1000; times++) {
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    // ���� ���� �� ����
                }
            }
        }*/

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // �ð����� � ��ǥ�� ������ �ϴ°�?
        // '� �ð��� � ��ǥ�� ��ź�� �����°�?'
        // �ð�, ��ǥ(row, col)

        // data�� ��� �־��ֱ��ߴµ�, �켱������ ��
        // �켱���� -> .compareTo()
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