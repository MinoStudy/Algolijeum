package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
■ Sort Library

설명
입력된 값들을Sort Library 를 사용하여 정렬 해 주세요.
총 세 가지 타입으로 정렬 후 출력 하면 됩니다.

만약 다음과 같이 입력을 받았다면,
dd1.png

[Type 1]
숫자만 오름차순 정렬하여 출력합니다.
dd2.png

[Type 2]
숫자만 내림차순 정렬하여 출력합니다.
dd3.png

[Type 3]
숫자와 문자를 다음과 같은 우선순위 조건으로 맞추어 정렬 후 출력합니다.
짝수 우선
숫자 오름차순
문자 오름차순
dd4.png

각 줄에 Type 1, 2, 3 의 정렬된 결과를 출력 해주시면 됩니다.

입력
정렬할 값의 개수 N 을 입력 받습니다. (1 <= N <= 100,000)
두 번째 줄에 숫자로 구성된 N개의 값을 입력 받습니다.
세 번째 줄에 문자로 구성된 N개의 값을 입력 받습니다.

출력
첫 번째 줄에는 [Type 1] 의 결과를 출력 하세요.
두 번째 줄에는 [Type 2] 의 결과를 출력하세요.
세 번째와 네 번째는 [Type 3] 의 결과를 출력하세요.

입력 예시 1 
7
1 3 5 2 4 5 5
A B C D E G F

출력 예시 1

1 2 3 4 5 5 5 
5 5 5 4 3 2 1 
2 4 1 3 5 5 5 
D E A B C F G 

힌트
비교가능한 타입 생성 예시 (Node Class, 수 내림차순)

class Node implements Comparable<Node> {
	int n;
	char ch;
	
	@Override
	public int compareTo(Node a) {
		return Integer.compare(a.n, n);
	}
};


Main 함수 내 사용방법

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
				return -1; // 정상
			if (num % 2 == 1 && right.num % 2 == 0)
				return 1; // 비정상

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

		// 오름차순
		Arrays.sort(arr);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");

		// 내림차순
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