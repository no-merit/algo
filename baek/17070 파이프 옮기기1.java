import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N, cnt;
	static int[][] pos, map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		// 맵 크기
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(row[j - 1]);
			}
		} // map 생성
		pos = new int[3][2];
		pos[0] = new int[] { 0, 1 };
		pos[1] = new int[] { 1, 0 };
		pos[2] = new int[] { 1, 1 };

		int pipe_x = 1;
		int pipe_y = 2;
		int state = 0;
		cnt = 0;
		dfs(pipe_x, pipe_y, state);
		
		sb.append(String.valueOf(cnt));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}// main 매서드

	private static void dfs(int pipe_x, int pipe_y, int state) {
		if (pipe_x == N && pipe_y == N) {
			cnt++;
			return;
		}
		boolean [] cango = new boolean[3];
    //그쪽 방향으로 갈 수 있는지 확인하는 배열 0: 왼 1: 아래 2: 대각
    
		for (int i = 0; i < 3; i++) {
			int nx = pipe_x + pos[i][0];
			int ny = pipe_y + pos[i][1];
			if (nx <= N && ny <= N && map[nx][ny] == 0) {
				cango[i]=true;
			}
		}
		
		if(state!=1 && cango[0]) {//세로가 아니고 
			dfs(pipe_x + pos[0][0],pipe_y + pos[0][1],0);
		}
		if(state!=0 && cango[1]) {//가로가 아니고
			dfs(pipe_x + pos[1][0],pipe_y + pos[1][1],1);
			//
		}
		if(cango[0] && cango[1] && cango[2]) {//대각선으로 갈 수 있으면
			dfs(pipe_x + pos[2][0],pipe_y + pos[2][1],2);
			//대각으로 가고 상태를 대각으로
		}

	}
}
