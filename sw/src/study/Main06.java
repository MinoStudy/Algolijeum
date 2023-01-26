package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
■할아버지의 유산

설명
dd1.png
영오는 땅을 하루아침에 물려 받게 되었습니다.
할아버지가 소유한Width x Height사이즈의 부동산 가격 정보를 알고 있습니다.

할아버지 땅에서직사각형 모양으로 땅을 선택하면,자신의 땅이 됩니다.
아래는 4 x 8 사이즈일때 예시 이미지 입니다.

숫자 0이 써있는 곳은 소유할 수 없는 그린벨트 입니다.
따라서 0이 써있는곳을 선택하면 안됩니다.
dd2.png

위 예시에서 선택한 땅의 가치는 (5+1+4+2+6+9+8+1) + (6+5+1+3+2+6+3+2) = 64 입니다.
할아버지의 토지 정보가 주어질때,
영오가 가질 수 있는 최대 땅의 가치는 얼마인가요?

입력
첫 번째 줄에는 Heigth x Width (3 <= H, W <= 20) 을 입력 받습니다.
땅의 가치는 1 ~ 9 로 평가됩니다.
두 번째 줄 부터는 땅의 정보가 입력됩니다.

출력
영오가 가져갈 수 있는 토지의 최대 가치를 출력해 주세요.

입력 예시 1 

4 8
0 0 3 3 0 0 0 0
5 1 4 2 6 9 8 1
6 5 1 3 2 6 3 2
0 0 0 0 9 9 4 0

출력 예시 1

64
 * */
public class Main06 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 항상 꼭 있는 구문

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Height = Integer.parseInt(st.nextToken());
		int Width = Integer.parseInt(st.nextToken());
		int MAP[][] = new int[Height][Width];
		for (int i = 0; i < Height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Width; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 박스크기
		// 박스 위치
		// 해당 박스 내부 값들을 확인
		int ans = 0;
		for (int row_size = 1; row_size <= Height; row_size++)
			for (int col_size = 1; col_size <= Width; col_size++)
				// 박스 크기
				for (int row = 0; row <= Height - row_size; row++)
					for (int col = 0; col <= Width - col_size; col++)
					// 박스 왼쪽윗좌표 위치
					{
						int sum = 0;
						int flag = 0; // 박스 내부에 0이 있는지 확인
						for (int i = row; i < row + row_size; i++)
							for (int j = col; j < col + col_size; j++)
							// 박스 내부의 좌표
							{
								sum += MAP[i][j];
								if (MAP[i][j] == 0)
									flag = 1; // 박스 내부에 0이 있다.
							}
						if (flag == 0) // 내부에 0이 있다는 기록이 없을 때
							ans = Math.max(ans, sum); // sum의 최댓값 저장
					}
		System.out.println(ans);
	}
}