package SwTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A_2042 {
	private static long[] arr;
	private static long[] tree;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		tree = new long[N*4];
		
		// ���� �Է¹ޱ�
		for(int i=1; i<=N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(1, N, 1);
	/*	
		for(int i=1; i<tree.length; i++) {
			System.out.println(tree[i]);
		}
		*/
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				long dif = c - arr[b];
				arr[b] = c;
				update(1, N, 1, b, dif);
			} else if (a == 2) {
				sb.append(sum(1, N, 1, b, (int) c) + "\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	// start : ���� �ε���, end : �� �ε���
	public static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		// ��� �� �κ� ������ ���� ����
		return tree[node] = init(start, mid,  node*2) + init(mid+1, end, node*2+1);
	}

	// start : ���� �ε���, end : �� �ε���
	// left, right : ���� ���� ���ϰ��� �ϴ� ����
	public static long sum(int start, int end, int node, int left, int right) {
		// ���� �ۿ� �ִ� ���
		if(left > end || right < start) {
			return 0;
		}
		
		// ���� �ȿ� �ִ� ���
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		// �׷��� �ʴٸ�, �� �κ����γ����� ���� ���ϱ�
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	
	// start : ���� �ε���, end : �� �ε���
	// idx : ���� ���� �����ϰ��� �ϴ� ���
	// dif : ������ ��
	public static void update(int start,  int end, int node, int idx, long dif) {
		// ���� �ۿ� �ִ� ���
		if(idx < start || idx > end) {
			return;
		}
		
		// ���� �ȿ� ������ �������� �ٸ� ���ҵ� ����
		tree[node] += dif;
		if(start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		update(start, mid, node*2, idx, dif);
		update(mid+1, end, node*2+1, idx, dif);
	}
}
