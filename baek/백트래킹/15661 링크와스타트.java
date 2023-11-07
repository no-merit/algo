import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static StringBuilder sb;
	static int N, cnt, Min;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		// 사람의 수. 4~20
		// 두 팀은 인원수가 같지 않아도 되지만 한 명 이상이어야 함.

		// 팀의 능력치는 팀에 속한 모든 쌍의 능력치 sij의 합
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		Min = Integer.MAX_VALUE;
		visited = new boolean[N];
		dfs(0);
		sb.append(Min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int depth) {
		if (depth == N) {
		//모든 사람의 팀을 정했으면
			Min = Math.min(Min, game());

			return;
		}
		//a 팀에 속하는지 
		visited[depth] = true;
		dfs(depth + 1);
		visited[depth] = false;
		dfs(depth + 1);

	}

	static int game() {
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				//둘다 a 팀인 경우
				if (visited[i] && visited[j]) {
					a+=map[i][j]+map[j][i];
				} else if (!visited[i] && !visited[j]) {
					b+=map[i][j]+map[j][i];
				}
			}
		}
		return Math.abs(a-b);
	}

}
