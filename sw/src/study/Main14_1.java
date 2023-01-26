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

		// row�� ��������, row�� ������ col�� ��������
		@Override
		public int compareTo(Node right) {
			if (row < right.row)
				return -1; // ������ �����ʺ��� ������ ����
			if (row > right.row)
				return 1; // ������ �����ʺ��� ũ�� ������

			// row == right.row
			if (col < right.col)
				return -1; // ������ �����ʺ��� col�� ������ ����
			if (col > right.col)
				return 1; // ������ �����ʺ��� col�� ũ�� ������

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
		 * ��ǥ : row, col
		 */
		// default : ��������
		// ��������
		// 9 8 7 6 5 4 3 2 1

		/*
		 * Integer b = 5; Integer c = new Integer(5); if(b.compareTo(c) == 0)
		 * System.out.println("same"); else System.out.println("diff");
		 * 
		 * //int de = 1;
		 */
		/*
		 * Node node[] = new Node[4]; node[0] = new Node(5, 2); node[1] = new Node(4,
		 * 3); node[2] = new Node(5, 1); node[3] = new Node(4, 2); // row�� ��������, row��
		 * ������ col�� �������� Arrays.sort(node, Collections.reverseOrder()); int de = 1;
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
		// ���� : Integer, Long�� ���� Wrapping class ���� ����
		// ������ - Arrays : int, long�� ���� �ܼ� �ڷ��� ���� ����
		// - Collections : class ���µ��� ���� ����
		// � ����� ����ϵ� (Arrays, Collections) �ð����⵵�� NlogN ����*****
	}
}