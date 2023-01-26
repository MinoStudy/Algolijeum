package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
�� Sort Library

����
�Էµ� ������Sort Library �� ����Ͽ� ���� �� �ּ���.
�� �� ���� Ÿ������ ���� �� ��� �ϸ� �˴ϴ�.

���� ������ ���� �Է��� �޾Ҵٸ�,
dd1.png

[Type 1]
���ڸ� �������� �����Ͽ� ����մϴ�.
dd2.png

[Type 2]
���ڸ� �������� �����Ͽ� ����մϴ�.
dd3.png

[Type 3]
���ڿ� ���ڸ� ������ ���� �켱���� �������� ���߾� ���� �� ����մϴ�.
¦�� �켱
���� ��������
���� ��������
dd4.png

�� �ٿ� Type 1, 2, 3 �� ���ĵ� ����� ��� ���ֽø� �˴ϴ�.

�Է�
������ ���� ���� N �� �Է� �޽��ϴ�. (1 <= N <= 100,000)
�� ��° �ٿ� ���ڷ� ������ N���� ���� �Է� �޽��ϴ�.
�� ��° �ٿ� ���ڷ� ������ N���� ���� �Է� �޽��ϴ�.

���
ù ��° �ٿ��� [Type 1] �� ����� ��� �ϼ���.
�� ��° �ٿ��� [Type 2] �� ����� ����ϼ���.
�� ��°�� �� ��°�� [Type 3] �� ����� ����ϼ���.

�Է� ���� 1 
7
1 3 5 2 4 5 5
A B C D E G F

��� ���� 1

1 2 3 4 5 5 5 
5 5 5 4 3 2 1 
2 4 1 3 5 5 5 
D E A B C F G 

��Ʈ
�񱳰����� Ÿ�� ���� ���� (Node Class, �� ��������)

class Node implements Comparable<Node> {
	int n;
	char ch;
	
	@Override
	public int compareTo(Node a) {
		return Integer.compare(a.n, n);
	}
};


Main �Լ� �� �����

Arrays.sort(arr);
Arrays.sort(arr, Comparator.reverseOrder());
 * */

public class Main14 {

	static class Node implements Comparable<Node> {
		int num;
		char ch;

		Node(int num, char ch) {
			this.num = num;
			this.ch = ch;
		}

		@Override
		public int compareTo(Node right) {
			if (num % 2 == 0 && right.num % 2 == 1)
				return -1; // ����
			if (num % 2 == 1 && right.num % 2 == 0)
				return 1; // ������

			if (num < right.num)
				return -1;
			if (num > right.num)
				return 1;

			if (ch < right.ch)
				return -1;
			if (ch > right.ch)
				return 1;

			return 0;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		char ch[] = new char[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			ch[i] = st.nextToken().charAt(0);

		Node node[] = new Node[n];
		for (int i = 0; i < n; i++)
			node[i] = new Node(arr[i], ch[i]);

		// ��������
		Arrays.sort(arr);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");

		// ��������
		Arrays.sort(arr, Collections.reverseOrder());
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");

		Arrays.sort(node);
		for (int i = 0; i < n; i++)
			System.out.print(node[i].num + " ");
		System.out.println();
		for (int i = 0; i < n; i++)
			System.out.print(node[i].ch + " ");

	}
}