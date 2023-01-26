package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ 금고
 
설명
민철이는 이번에 로또 1등에 당첨됐으나 사정상 바로 당첨금을 찾아가지 못하고 있다.
로또를 계속 들고 있기엔 불안해 갖고 있던 금고에 로또를 보관하려한다.

이 금고는 일반적인 금고와 다르게 좀 특이한 방식으로 작동한다.
금고에는M개의 눈금이 새겨진 다이얼과N개의 버튼으로 이루어져 있다.
다이얼의 눈금에는 0 ~ M-1의 정수가 시계방향으로 새겨져 있으며최초에는 0을 가르키고 있다.
버튼에는정수가 새겨져 있으며한 개의 버튼을 누를 때마다버튼에 새겨진 수 만큼 다이얼이 시계 방향(양수) 혹은 반시계 방향(음수)으로 회전한다.
금고를 열기 위해선 버튼을정확히 4번 눌러 다이얼이 K를 가르키게 만들어야 한다.

image.png

예를 들면, 0 ~ 3의 눈금이 새겨진 다이얼에 (4, 7, -2, -8, 3)의 5개 버튼을 갖는 금고가 있다고 하자.
가장 처음 7 버튼을 눌렀다면 다이얼은 시계 방향으로 7만큼 회전하여 3을 가르키게 된다.
그 다음 -2 버튼을 누른다면 다이얼은 반시계 방향으로 2만큼 회전하여 1을 가르키게 된다.

이 금고는여는 방법이 여러가지 존재할 수 있다.

예를 들어, 만약 금고의 (N, M, K)가 각각 (5, 12, 11)이고 각 버튼의 숫자가 (4, 7, -2, -8, 3)일 때, 가능한 경우는
(-2, 3, 3, 7), (-2, 3, 7, 3), (-2, 7, 3, 3), (3, -2, 3, 7), (3, -2, 7, 3), (3, 3, -2, 7)
(3, 3, 7, -2), (3, 7, -2, 3), (3, 7, 3, -2), (7, -2, 3, 3), (7, 3, -2, 3), (7, 3, 3, -2)
의 12가지가 존재할 수 있다.

민철이는 로또를 안전하게 지키기 위해 금고를 여는 방법의 경우의 수를 계산하고자 한다.
N, M, K와 각 버튼의 숫자가 주어질 때,금고를 여는 방법의 경우의 수를 구해주는 프로그램을 작성하시오.

입력
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.(1 ≤ T ≤ 100)
각 테스트 케이스는 두 줄로 이루어져 있다.
각 테스트 케이스의 첫 번째 줄에는 N, M, K가 순서대로 주어진다.(1 ≤ N ≤ 1,000 , 2 ≤ M ≤ 400,000 , 0 ≤ K ≤ M-1)
각 테스트 케이스의 두 번째 줄에는 N개의 버튼에 새겨진 정수들이 공백으로 구분하여 주어지며중복된 정수는 존재하지 않는다. (-1,000,000,000 ≤ 버튼에 새겨진 정수 ≤ 1,000,000,000)

출력
테스트 케이스 하나당 한 줄에 출력한다.
각 테스트 케이스에 대하여 #x (x는 테스트케이스의 번호로 1부터 시작)를 출력하고, 금고를 여는 방법의 경우의 수를 출력한다.


입력 예시 1 

4
5 12 11
4 7 -2 -8 3
6 6 5
1 -5 -11 7 0 13
6 6 4
1 -5 -11 7 0 13
6 13 10
-1000000000 -999999999 -1 1 999999999 1000000000

출력 예시 1

#1 12
#2 0
#3 625
#4 120
*/
public class Main13 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int num[] = new int[400001];
			int index = 0;
			long cnt[] = new long[400001];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(st.nextToken()) % m;
				if (temp < 0)
					temp += m;

				if (cnt[temp] == 0)
					num[index++] = temp;
				cnt[temp]++;
			}

			int hap_num[] = new int[800002];
			int hap_index = 0;
			long hap_cnt[] = new long[400001];
			for (int i = 0; i < index; i++) {
				for (int j = i; j < index; j++) {
					int temp = (num[i] + num[j]);
					if (temp >= m)
						temp -= m;

					if (hap_cnt[temp] == 0)
						hap_num[hap_index++] = temp;

					if (i == j)
						hap_cnt[temp] += cnt[num[i]] * cnt[num[j]];
					else
						hap_cnt[temp] += cnt[num[i]] * cnt[num[j]] * 2;
				}
			}

			int de = 1;
			long ans = 0;

			for (int i = 0; i < hap_index; i++) {
				int temp = k - hap_num[i];
				if (temp < 0)
					temp += m;
				if (hap_cnt[temp] != 0)
					ans += hap_cnt[temp] * hap_cnt[hap_num[i]];
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}