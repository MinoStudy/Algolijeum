package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ 글귀 찾기

설명
남편은 글을 읽고, 독후감을 쓰는 것을 좋아합니다.
좋아하는 시, 소설 등을 읽고 마음에 드는 글귀를 독후감에 적어두곤합니다.

cc2.png

남편 책상을 청소하던 중, 그 독후감을 읽어보았고,
그곳에 내 마음에 쏙 든 문구가 적혀있습니다.
남편이 읽는 책에서 어느 부분의 글귀였는지 찾아보려고 합니다.

gg3.png
만약 "booms." 라는 글귀가 마음에 들었고,
이 글귀는 책 (3,3)과 책 (3,8) 에서 찾을 수 있습니다.

2차원 배열의 장문의 내용과찾아야하는 글귀를 입력받고,
글귀가 장문 어느 좌표에 존재하는지 찾아 출력해 주세요.

[예시]
만약 아래와 같이 AAA 글귀를 찾아야한다면,
총 4개를 발견할 수 있습니다.
(0,0) / (0,1) / (1,0) / (1,1)
cc3.png

입력
첫 줄에는 H, W (Height, Width)를 입력받습니다. (1 <= Height, Width <= 1,000)
다음 줄에는 H x W 사이즈의 책 내용을 입력 받습니다.
띄어쓰기는 '_' (언더바)로 표기되며, 빈 칸은 없습니다.

그 다음줄에는 찾아야하는 글귀의 길이 n을 입력 받습니다.(1 <= n <= 100)
다음줄에는 n 글자의 글귀를 입력 받습니다.

출력
글귀가 책 어느 좌표에 있는지 찾아,좌표를 출력해 주세요.

만약여러 좌표에서 글귀가 발견된다면y 좌표가 작고,x 좌표가 작은 순서대로 출력해 주세요.
만약 (3,1) /(1,2) /(3,5) 에서 발견되었다면,출력하는 순서는 (1,2) / (3,1) / (3,5) 입니다.

입력 예시 1 

5 9
This_is_o
n..I_love
_your_sou
nd.boom.b
oom.he___
5
boom.

출력 예시 1

(3,3)
(3,8)

입력 예시 2 

3 2
AA
AA
AA
3
AAA

출력 예시 2

(0,0)
(0,1)
(1,0)
(1,1)

*/
public class Main05 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 항상 꼭 있는 구문

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Height = Integer.parseInt(st.nextToken());
		int Width = Integer.parseInt(st.nextToken());
		String oneLine = "";
		for (int i = 0; i < Height; i++) {
			String temp = br.readLine();
			oneLine += temp;
		}
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		for (int i = 0; i <= oneLine.length() - n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (str.charAt(j) == oneLine.charAt(i + j)) {
					cnt++;
				}
			}
			if (cnt == n) {
				int row = i / Width;
				int col = i % Width;
				System.out.println("(" + row + "," + col + ")");
			}
		}

	}
}