import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 공간의 크기 N
 * 
 * */

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] row = br.readLine().split(" ");

		int N = Integer.parseInt(row[0]);// 세로
		int M = Integer.parseInt(row[1]);// 가로
		int r = Integer.parseInt(row[2]);// x좌표
		int c = Integer.parseInt(row[3]);// y좌표
		int k = Integer.parseInt(row[4]);// 명령의 개수

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} // map 입력

		String[] command = br.readLine().split(" ");

		int[] cmd = new int[k];

		for (int i = 0; i < k; i++) {
			cmd[i] = Integer.parseInt(command[i]);
		}
		int[] dr = new int[] { 0, 0, -1, 1 };
		int[] dc = new int[] { 1, -1, 0, 0 };

		int[] dice = new int[6];

		for (int i = 0; i < k; i++) {
			int a = cmd[i];
			int nr = r + dr[a - 1];
			int nc = c + dc[a - 1];

			if (nr < N && nc < M && nr >= 0 && nc >= 0) {
				int bot=0;
				int top=0;
				int side1=0;
				int side2=0;
				
				if (a == 1) {//동
					bot = dice[5];
					top = dice[4];
					side1 = dice[1];
					side2 = dice[3];
					dice[1] = bot;
					dice[3] = top;
					dice[4] = side1;
					dice[5] = side2;
				} else if (a == 2) {//서
					bot = dice[4];
					top = dice[5];
					side1 = dice[3];
					side2 = dice[1];
					dice[1] = bot;
					dice[3] = top;
					dice[4] = side1;
					dice[5] = side2;
				} else if (a == 3) {//북
					bot = dice[0];
					top = dice[2];
					side1 = dice[3];
					side2 = dice[1];
					dice[1] = bot;
					dice[3] = top;
					dice[0] = side1;
					dice[2] = side2;
				} else if (a == 4) {//남
					bot = dice[2];
					top = dice[0];
					side1 = dice[1];
					side2 = dice[3];
					dice[1] = bot;
					dice[3] = top;
					dice[0] = side1;
					dice[2] = side2;
				}
				
				if(map[nr][nc]==0) {
					map[nr][nc]=dice[1];
				}else {
					dice[1]=map[nr][nc];
					map[nr][nc]=0;
				}
				
				sb.append(dice[3]).append("\n");
				r=nr;
				c=nc;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
