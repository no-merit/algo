import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 첫 줄

		int K = Integer.parseInt(br.readLine()); // 둘째줄

		boolean[][] appleMap = new boolean[N + 2][N + 2];
		boolean[][] map = new boolean[N + 2][N + 2];

		int[] dr = new int[] { 0, 1, 0, -1 }; // 동 남 서 북
		int[] dc = new int[] { 1, 0, -1, 0 };

		for (int i = 0; i < K; i++) {
			String[] RC = br.readLine().split(" ");

			int R = Integer.parseInt(RC[0]);
			int C = Integer.parseInt(RC[1]);
			appleMap[R][C] = true;
		}

		int L = Integer.parseInt(br.readLine());
		// 뱀의 방향 변환 횟수

		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (i == 0 || j == 0 || i == N + 1 || j == N + 1) {
					map[i][j] = true;
				}
			}
		}
				
		map[1][1] = true;
		Deque<int[]> dq = new LinkedList<>();
		dq.add(new int[] { 1, 1 });

		int time = 0;
		int idx = 0;
		int nr = 1;
		int nc = 1;
		snake: for (int i = 0; i < L; i++) {
			String[] XC = br.readLine().split(" ");
			int X = Integer.parseInt(XC[0]);
			String C = XC[1];
			
			while (true) {
				time++;
				// 시간이 늘음
				nr = nr + dr[idx];
				nc = nc + dc[idx];
				if (map[nr][nc]) {
					break snake;
				}
				
				// 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
				// 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
				// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
				if (appleMap[nr][nc]) {
					appleMap[nr][nc] = false;
					dq.add(new int[] { nr, nc });
					map[nr][nc] = true;
				} else {
					int[] tmp = dq.pollFirst();
					map[tmp[0]][tmp[1]] = false;
					dq.add(new int[] { nr, nc });
					map[nr][nc] = true;
				}
				
				if (time == X) {
					if (C.equals("L")) {// 왼쪽
						idx = idx - 1;
						if (idx < 0) {
							idx = 3;
						}
					} else if(C.equals("D")){// 오른쪽
						idx = idx + 1;
						if (idx > 3) {
							idx = 0;
						}
					}
					if(i==L-1) {
						continue;
					}else {
						break;
					}
				}
			}
		}
		System.out.println(time);

		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
