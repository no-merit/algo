import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 
 * 
 * */
public class Main {
	static StringBuilder sb;
	static int N;
	static int Max = Integer.MIN_VALUE;
	static int[][] inning;
	static int[] sequence;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		// 이닝 수
		inning = new int[N + 1][10];
		sequence = new int[10];
		visited = new boolean[10];

		for (int i = 1; i <= N; i++) {
			String[] innings = br.readLine().split(" ");
			for (int j = 1; j <= 9; j++) {
				inning[i][j] = Integer.parseInt(innings[j - 1]);
			}
		}

		sequence[4] = 1;
		visited[4] = true;
		dfs(2);
		sb.append(Max);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int depth) {
		if (depth == 10) {
				game(sequence);
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (visited[i])
				continue;

			sequence[i] = depth;
			visited[i] = true;
			dfs(depth + 1);
			visited[i] = false;

		}

	}

	static void game(int[] seq) {
		// 순열로 만든 타순대로 야구 시작
		// sequence 1번부터 침
		int now = 1;//지금 치는 타자의 타순
		
		int score =0;
		
		
		for (int k = 1; k <= N; k++) { // inning[][]
			//inning[k][hitter]
			boolean [] base = new boolean[4];
			int out =0;
			while(out<3) {
				int hitter = seq[now++];
				if(now>=10) {
					now=1;
				}
				int hit = inning[k][hitter];//k번 이닝에서 히터의 상태
				switch (hit) {
				case 1:
					if(base[3]) {
						base[3]=false;
						score++;
					}
					for(int b=2;b>=1;b--) {
						if(base[b]) {
							base[b+1]=true;
							base[b]=false;
						}
					}
					base[1]=true;
					break;
				case 2:
					if(base[3]) {
						base[3]=false;
						score++;
					}
					if(base[2]) {
						base[2]=false;
						score++;
					}
					if(base[1]) {
						base[1]=false;
						base[3]=true;
					}
					
					base[2]=true;
					break;
				case 3:
					for(int b=3; b>=1;b--) {
						if(base[b]) {
							base[b] = false;
							score++;
						}
					}
					base[3]=true;
					break;
				case 4:
					for(int b=1; b<=3; b++) {
						if(base[b]) {
							base[b]=false;
							score++;
						}
					}
					score++;
					break;
				case 0:
					out++;
					break;

				}
			}
		}
		
		Max = Math.max(Max, score);
	}

}
