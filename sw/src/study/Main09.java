package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■카드발급기

설명
카드 발급기는 N 명의 학생들에게1 ~ N 번 까지 카드를 발급해 주는 장치입니다.

이 카드 발급기에는 규칙이 있습니다.
카드 번호를 배급할 때, 학생의 키를 기준으로 발급합니다.
키가 작은 학생에게는 높은 번호를 배급하고 키가 같거나 큰 학생에게는 더 낮은 번호를 발급합니다.
즉, n번 카드를 들고있는 학생은 n + 1번 카드를 들고있는 사람보다 키가 같거나 큽니다.

ㅍ1.png

예를 들어, N = 5 이고 다섯명의 학생들의 키를 아래와 같이 입력 받습니다.
첫번째로 입력된 학생의 키는 202 cm 입니다.
두번째에 입력된 학생의 키는 195 cm 입니다.
세번째에 입력된 학생의 키는 191 cm 입니다.
네번째에 입력된 학생의 키는 195 cm 입니다.
마지막 다섯번째에 입력된 학생의 키는 232 cm 입니다.

학생들의 키를 입력 받은 후, 발급이 완료된 카드 번호를 입력 받습니다.
발급 받은 카드 번호의 순서가 올바르다면 'YES'를, 아니라면 'NO'를 출력해 주세요.

입력
테스트 케이스의 수 T가 첫 줄에 입력 됩니다. (1 <= T <= 100)
다음 줄에는 학생 수 N이 입력 됩니다. (1 <= N <= 1,000,000)
다음 줄에는 N명의 키가 입력됩니다.
다음 줄에는 N명의 학생에게 배부한 카드 번호가 순서대로 입력 됩니다.

출력
각 테스트 케이스에 대한 각각의 답을 출력 해주세요.
카드 번호가 올바르다면 'YES',
올바르지 않다면 'NO' 를 출력 해주세요.

입력 예시 1 

2
5
202 195 191 195 232
2 3 5 1 4
5
202 195 191 195 232
2 3 5 4 1

출력 예시 1

NO
YES
 * */
public class Main09 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void sol() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int Height[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			Height[i] = Integer.parseInt(st.nextToken());
		}

		int DAT[] = new int[n + 1];
		// index : 카드 번호 1 ~ n
		// value : 해당 카드 번호를 갖는 사람의 키
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int card = Integer.parseInt(st.nextToken());
			DAT[card] = Height[i]; // DAT구성
		}
		for (int i = 1; i < n; i++)
		// i : 카드 번호
		{
			if (DAT[i] < DAT[i + 1]) {
				System.out.println("NO");
				return;
			}
		}
		// return에 걸리지 않고, 잘 통과했다. 정상적인 형태다.
		System.out.println("YES");
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sol();
		}
	}
}