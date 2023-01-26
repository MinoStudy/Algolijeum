package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
■ SPY와 조직도

설명

그래프는 세 가지 Type으로 표현할 수 있습니다.

인접행렬
인접리스트
1차원 배열 (2진트리 한정)

민코딩 Company는 아래와 같이 이진트리 형태로 조직도가 구성 되어 있고, 항상 부하 직원은 두명입니다.
SPY가 알아낸 조직도 정보를 하드코딩 해주세요.
세 가지 Type 중, 본인에게 가장 익숙하지 않은 방법으로 하드코딩을 하면 됩니다.
그림6.png

이제 사원번호 입력 받습니다.
해당 사원번호의직속 상사 /동료 /직속 부하들이 누구인지 출력해 주세요.

입력
네 자리 사원 번호가 입력됩니다.
존재하지 않는 사원 번호가 입력될수도 있습니다.

출력
첫 줄에는입력 받은 사원의 직속 상사 사번을 출력합니다.
만약 직속 상사가 없다면 "no boss"를 출력합니다.

두번째 줄에는 동료의 사번을 출력합니다.
만약 동료가 없다면 "no company"를 출력합니다.

세 번째 줄에는 직속 부하들의 사번을 출력합니다.
만약 직속 부하가 없다면 "no junior"를 출력합니다.

만약 존재하지 않는 사원을 입력받았다면, "no person" 만 출력합니다.

입력 예시 1 

1680

출력 예시 1

1004
9941
3367 3261

입력 예시 2 

1004

출력 예시 2

no boss
no company
1680 9941

입력 예시 3 

9999
출력 예시 3

no person
*/
public class Main22 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int DAT[] = { 0, 1004, 1680, 9941, 3367, 3261, 2976, 4889, 1234, 6461, 7329, 5518 };
		ArrayList<Integer> al[] = new ArrayList[12];
		for (int i = 0; i < 12; i++)
			al[i] = new ArrayList<>();
		// 저장할 ArrayList만들기

		al[1].add(2);
		al[1].add(3);
		al[2].add(4);
		al[2].add(5);
		al[3].add(6);
		al[3].add(7);
		al[5].add(8);
		al[5].add(9);
		al[6].add(10);
		al[6].add(11);

		int id = Integer.parseInt(br.readLine());
		int node = -1;
		for (int i = 1; i <= 11; i++)
			if (id == DAT[i])
				node = i;
		// 사번 -> node번호 검색

		if (node == -1) {
			System.out.println("no person");
			return;
		}

		int boss = -1;
		for (int from = 1; from <= 11; from++) {
			for (int i = 0; i < al[from].size(); i++) {
				int to = al[from].get(i);
				if (to == node)
					// 입력받았던 사람을 부하직원으로 발견했다.
					boss = from;
			}
		}
		if (boss == -1) {
			System.out.println("no boss");
			System.out.println("no company");
		} else {
			System.out.println(DAT[boss]);

			int company = -1;
			for (int i = 0; i < al[boss].size(); i++) {
				int to = al[boss].get(i);
				if (to != node)
					// 내 boss의 부하직원 중 내가 아닌 다른 사람은 동료이다.
					company = to;
			}
			if (company == -1)
				System.out.println("no company");
			else
				System.out.println(DAT[company]);
		}

		if (al[node].size() == 0)
			System.out.println("no junior");
		else {
			for (int i = 0; i < al[node].size(); i++) {
				int to = al[node].get(i);
				System.out.print(DAT[to] + " ");
			}
		}
	}
}