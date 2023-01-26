package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■사원 출입관리 시스템

설명
사원관리 출입 관리 시스템을 제작해야 합니다.
이 시스템은 세 가지 기능이 존재합니다.

회원가입
사번을 인식하여 입장처리
사번을 인식하여 퇴장처리
cc5.png

[회원가입]
사원번호와 이름을 입력받고, 가입처리를 해줍니다.
가입이 완료되면"[사원번호] OK"문자열을 출력합니다.
만약 이미 등록된 사원번호인 경우는"[사원번호] ERROR"문자열을 출력합니다.

[사번을 인식하여 출입 처리]
사원 출결관리 시스템은사원번호를 인식하자마자, 출입 처리가 완료됩니다.
만약 처음 사번을 인식한다면,"[사원번호] [이름] ENTER" 문자열을 출력합니다.
만약 입장 된 상태에서, 사번을 한번 더 인식한다면, "[사원번호] [이름] EXIT" 문자열을 출력합니다.
만약 퇴장 된 상태에서, 사번을 한번 더 인식한다면 다시 입장처리를 합니다. (문자열 출력)
그리고 없는 사번으로 인식한다면 "[사원번호] ERROR" 문자열을 출력합니다.

빠른 속도로 동작하는
사원 출입관리 프로그램을 제작해 주세요.

입력
수 n을 입력 받습니다. (1 <= n <= 100,000)
다음 줄 부터 총 n개의 명령어가 입력됩니다.

회원가입을 하는 명령어는 "1[사번] [이름]" 형태로 입력이 주어집니다.(1000 <= 사번 <= 9999)
출입처리가 되는 명령어는 "2 [사번]" 형태로 입력이 주어집니다.(이름의 최대 길이 : 100글자)

출력
입력받은 명령어당 한줄씩, 처리 결과를 출력해 주세요.

입력 예시 1 

14
1 1000 TOM
1 1001 BOB
1 1001 JASON
1 1005 JASON
1 9000 JACKY
1 9001 SONEY
2 9000
2 9000
2 9000
2 5555
2 1001
2 1000
1 1000 SHOW
2 1000
출력 예시 1

1000 OK
1001 OK
1001 ERROR
1005 OK
9000 OK
9001 OK
9000 JACKY ENTER
9000 JACKY EXIT
9000 JACKY ENTER
5555 ERROR
1001 BOB ENTER
1000 TOM ENTER
1000 ERROR
1000 TOM EXIT
 * */
public class Main04 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 항상 꼭 있는 구문

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		String NAME[] = new String[10000];
		// value : 이름
		int check[] = new int[10000];
		// value : 가입안됨 - 0, 등록된 상태, 입장X - 1, 입장O - 2
		// index : 사번(1000~9999)

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (type == 1) {// 가입
				String name = st.nextToken();
				if (check[num] != 0) // 등록을 기록하기도 전에 '이미 기록이 있으면'
				{
					System.out.println(num + " ERROR");
					continue;
				}
				NAME[num] = name;
				check[num] = 1;
				System.out.println(num + " OK");
			} else if (type == 2) {// 출입
				if (check[num] == 1) // 아직 입장 X
				{
					System.out.println(num + " " + NAME[num] + " ENTER");
					check[num] = 2;
				} else if (check[num] == 2) // 입장 O
				{
					System.out.println(num + " " + NAME[num] + " EXIT");
					check[num] = 1;
				} else if (check[num] == 0) {
					System.out.println(num + " ERROR");
				}
			}
		}

	}
}