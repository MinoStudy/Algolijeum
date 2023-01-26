package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■ 폭탄 투하

설명

20180721224817_78285.jpg

4 x 5 사이즈의 문자열  배열을 준비합니다.
값은 '_' 언더바 문자로 꽉 채웁니다.

폭탄을 투하할 좌표 두 곳을 입력받아주세요.

예를들어,
만약 폭탄이(1,1)에 투하되면 8방향으로 폭탄이 터집니다.
20180721225427_50765.jpg

위 상황에서 (3,3)에 폭탄이 투하되면 8방향으로 폭탄이 터집니다.
20180721225436_32392.jpg

폭탄 2개가 투하 되었을때 그 현장을 출력 해주세요.

입력
첫 줄에는 첫번째 폭탄을 투하 할 좌표 (Y, X) 를 입력받습니다.
두 번째 줄에는 두 번째 폭탄을 투하 할 좌표 (Y, X)를 입력 받습니다.

출력
폭탄이 투하된 후 결과를 출력합니다.

입력 예시 1 

1 1
3 3

출력 예시 1

# # # _ _
# _ # _ _
# # # # #
_ _ # _ #
*/
public class Main23 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int Height = 4; // 높이 (0~3)
	static int Width = 5; // 너비 (0~4)

	static char MAP[][];

	static void sol() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		// 인접한 8방향의 좌표
		int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 }; // row쪽 보정값
		int dc[] = { 0, 0, -1, 1, 1, -1, 1, -1 }; // col쪽 보정값
		// 상 하 좌 우,우상,좌상,우하,좌하
		for (int i = 0; i < 8; i++) {
			int n_row = row + dr[i];
			int n_col = col + dc[i];

			if (n_row < 0 || n_col < 0 || n_row >= Height || n_col >= Width)
				// 문제가 생길 부분, 맵을 벗어나는 좌표
				continue;

			// -> 하고 싶은 일
			MAP[n_row][n_col] = '#';
		}
	}

	public static void main(String[] args) throws IOException {
		MAP = new char[Height][Width];
		// 현재 좌표
		for (int i = 0; i < Height; i++)
			for (int j = 0; j < Width; j++)
				MAP[i][j] = '_';
		sol();
		sol();

		for (int i = 0; i < Height; i++) {
			for (int j = 0; j < Width; j++)
				System.out.print(MAP[i][j] + " ");
			System.out.println();
		}

	}
}