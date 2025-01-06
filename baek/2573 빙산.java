package java23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] yoko = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(yoko[j]);
			}
		}
		int[] dr = new int[] { 0, 1, 0, -1 };
		int[] dc = new int[] { 1, 0, -1, 0 };
		int year =0;
		while (true) {
			
			int cnt = 0;
			int[][] melt = new int[N][M];
			boolean[][] checked = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !checked[i][j]) {
						cnt++;
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] { i, j });
						checked[i][j] = true;
						while (!q.isEmpty()) {
							int[] now = q.poll();
							for (int k = 0; k < 4; k++) {
								int nr = now[0] + dr[k];
								int nc = now[1] + dc[k];
								if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
									if (map[nr][nc] == 0) {
										melt[now[0]][now[1]]++;
									} else if(!checked[nr][nc]){
										q.add(new int[] { nr, nc });
										checked[nr][nc]= true;
									}
								}
							}
						}
					}
				}
			}
			if(cnt==0) {
				System.out.println(0);
				System.exit(0);
			}
			if(cnt>=2) break;
			year++;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M;j++) {
					if(map[i][j]-melt[i][j] <=0) {
						map[i][j]=0;
					}else {
						map[i][j]-=melt[i][j];
					}
							
				}
			}
			
			
		}
		System.out.println(year);
	}

}
