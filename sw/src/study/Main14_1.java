package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main14_1 {

	static class Node implements Comparable<Node> {
		int row;
		int col;

		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}

		// row가 오름차순, row가 같으면 col이 오름차순
		@Override
		public int compareTo(Node right) {
			if (row < right.row)
				return -1; // 왼쪽이 오른쪽보다 작으면 정상
			if (row > right.row)
				return 1; // 왼쪽이 오른쪽보다 크면 비정상

			// row == right.row
			if (col < right.col)
				return -1; // 왼쪽이 오른쪽보다 col이 작으면 정상
			if (col > right.col)
				return 1; // 왼쪽이 오른쪽보다 col이 크면 비정상

			return 0;
		}

		@Override
		public String toString() {
			return "Node [row=" + row + ", col=" + col + "]";
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		/*
		 * int a1; long a2; double a3; float a4; char a5; Integer, Long, Double, Float,
		 * String <- wrapping class String temp = br.readLine(); if(temp.equals("a") ||
		 * temp.compareTo("a") == 0) { }
		 */
		/*
		 * Integer a[] = {2,1,3,4,9,7,6,5,8}; // 1 2 3 4 5 6 7 8 9 Arrays.sort(a);
		 * Arrays.sort(a, Collections.reverseOrder());
		 * 
		 * 좌표 : row, col
		 */
		// default : 오름차순
		// 내림차순
		// 9 8 7 6 5 4 3 2 1

		/*
		 * Integer b = 5; Integer c = new Integer(5); if(b.compareTo(c) == 0)
		 * System.out.println("same"); else System.out.println("diff");
		 * 
		 * //int de = 1;
		 */
		/*
		 * Node node[] = new Node[4]; node[0] = new Node(5, 2); node[1] = new Node(4,
		 * 3); node[2] = new Node(5, 1); node[3] = new Node(4, 2); // row가 오름차순, row가
		 * 같으면 col이 오름차순 Arrays.sort(node, Collections.reverseOrder()); int de = 1;
		 */

		ArrayList<Integer> al = new ArrayList<>();
		al.add(5);
		al.add(1);
		al.add(3);
		al.add(4);
		al.add(7);
		al.add(6);
		Collections.sort(al);
		int de = 1;

		// Arrays.sort
		// Collections.sort
		// 공통 : Integer, Long과 같은 Wrapping class 정렬 가능
		// 차이점 - Arrays : int, long과 같은 단순 자료형 정렬 가능
		// - Collections : class 형태들을 정렬 가능
		// 어떤 방식을 사용하든 (Arrays, Collections) 시간복잡도가 NlogN 보장*****
	}
}