import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int H,W,N,M;
	static int [][] prefix_sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		int[][] map = new int[N+1][M+1];
		prefix_sum = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(row[j-1]);
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				prefix_sum[i][j] = prefix_sum[i-1][j]+prefix_sum[i][j-1]-prefix_sum[i-1][j-1]+map[i][j];
			}
		}
		
		String[] HWSE = br.readLine().split(" ");
		H = Integer.parseInt(HWSE[0]);
		W = Integer.parseInt(HWSE[1]);
		int SR = Integer.parseInt(HWSE[2]);
		int SC = Integer.parseInt(HWSE[3]);
		int ER = Integer.parseInt(HWSE[4]);
		int EC = Integer.parseInt(HWSE[5]);
		
		Queue<int []> q = new ArrayDeque<int[]>();
		q.add(new int [] {SR,SC,0});
		int [] dr = new int [] {0,1,0,-1};
		int [] dc = new int [] {1,0,-1,0};
		boolean [][] visited = new boolean[N+1][M+1];
		visited[SR][SC] = true;
		int ans = -1;
		while(!q.isEmpty()) {
			int [] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			int move = poll[2];
			if(r==ER && c==EC) {
				ans=move;
				break;
			}
			for(int k=0;k<4;k++) {
				int nr = r+dr[k];
				int nc = c+dc[k];
				if(nr>=1 && nr+H-1<=N &&nc>=1 && nc+W-1<=M && !visited[nr][nc]) {
					visited[nr][nc]=true;
					if(isAreaValid(nr,nc)) {
						q.add(new int [] {nr,nc,move+1});
					}
				}
			}
		}
		System.out.println(ans);
		
	}
	 private static boolean isAreaValid(int r, int c) {
	        if (r < 1 || r + H - 1 > N || c < 1 || c + W - 1 > M) {
	            return false;
	        }
	        int r2 = r + H - 1;
	        int c2 = c + W - 1;
	        int wallCount = prefix_sum[r2][c2] - prefix_sum[r - 1][c2] - prefix_sum[r2][c - 1] + prefix_sum[r - 1][c - 1];
	        return wallCount == 0;
	    }
}
