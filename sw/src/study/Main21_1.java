package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
인접 리스트 sample code JAVA
*/
public class Main21_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = 5; // node개수
		int arr[][] = new int[N][N];
		// arr[from][to]

		ArrayList<Integer> al[] = new ArrayList[N];
		for (int i = 0; i < N; i++)
			al[i] = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			al[from].add(to);
			arr[from][to] = 1;
		}

		for (int now = 0; now < N; now++) {
			System.out.print(now + " : ");
			for (int i = 0; i < al[now].size(); i++) {
				int next = al[now].get(i);
				System.out.print(next + " ");
			}
			System.out.println();
		}
	}
}
