
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static StringBuilder sb;
	static int N, M, D, max_cnt;
	static int[][] map, origin;
	static boolean[] archer_pos;
	static int[] archer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NMD = br.readLine().split(" ");
		N = Integer.parseInt(NMD[0]);
		M = Integer.parseInt(NMD[1]);
		D = Integer.parseInt(NMD[2]);

		map = new int[N + 1][M];
		origin = new int[N + 1][M];
		// 궁수가 있을 열까지 해서 N+1
		archer_pos = new boolean[M];

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(row[j]);
				origin[i][j] = Integer.parseInt(row[j]);
			}
		} // map 입력

		max_cnt = 0;
		setup(0, 0); // 궁수의 위치를 조합
		sb.append(String.valueOf(max_cnt));

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void setup(int depth, int st) {

		if (depth == 3) {// 궁수 3명의 위치가 정해지면
			archer = new int[3];
			int idx = 0;
			for (int i = 0; i < M; i++) {
				if (archer_pos[i]) {
					archer[idx++] = i;
				}
			}

			turn(archer);
			return;
		}

		if (st >= M)
			return;

		archer_pos[st] = true;
		setup(depth + 1, st + 1);
		archer_pos[st] = false;
		setup(depth, st + 1);

	}

	static void turn(int[] archer) {
		// 궁수의 위치를 받음
		// 시작은 012
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		for (int t = 0; t < N; t++) {// 시간이 지남, N번의 턴이 지날 수 있음
			for (int a = 0; a < 3; a++) {// 3명의 궁수가 모두 쏘면 턴이 지남
				int x = Integer.MAX_VALUE;  //col값
				int y = Integer.MAX_VALUE;	//row 값
				int dist = Integer.MAX_VALUE;
				for (int i = N - 1 - t; i >= 0; i--) {
					// 궁수 행 바로 위의 N-1 행부터 시작하는데
					// 턴이 지나면 한칸씩 당겨지는 것을 표현
					for (int j = 0; j < M; j++) {
						// 0~M의 열을 탐색
						if (map[i][j] != 0) {
							// 병사가 있으면
							int tmp_dist = Math.abs(N - i - t) + Math.abs(archer[a] - j);
							//거리계산
							if (tmp_dist <= D) {
								//거리가 사정거리 안이라면 
								if (dist == tmp_dist) {
									
									//이전까지 가장 가까운 거리랑 지금 거리가 같으면
									y = Math.min(y, j);
									//y값이 작은 값(가장 왼쪽에 있는 값)을 타겟으로 삼음
									if (y == j) {//현재 값이 타겟이면 x가 바라보는 값도 바꾸고 아니면 바꾸지 않음
										x = i;
									}
								} else {//거리가 다르면
									dist = Math.min(dist, tmp_dist);
									//더 가까운 적을 타켓으로 삼음
									if (dist == tmp_dist) {
										//지금의 적이 타겟이 되면 x와 y 가 바라보는 값도 바꿈
										x = i;
										y = j;
									}
								}
							}
						}
					}
				}
				if (dist <= D) {
					visited[x][y] = true;
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j]) {
						map[i][j]=0;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					cnt++;
			}
		}
		max_cnt = Math.max(max_cnt, cnt);
    //map 초기화
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = origin[i][j];
			}
		}
	}

}
