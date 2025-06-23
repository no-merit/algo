import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String [] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int [][] map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			String [] row = br.readLine().split("");
			for(int j=1;j<=M; j++) {
				map[i][j] = Integer.parseInt(row[j-1]);
			}
		}
		Queue<int[]> q = new LinkedList<>();
		int [][][] dist = new int[N+1][M+1][2]; 
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				for(int k=0;k<2;k++) {
					dist[i][j][k]=Integer.MAX_VALUE;
				}
			}
		}
		dist[1][1][0]=1;
		q.add(new int[] {1,1,0});
		int [] dr = new int [] {0,1,0,-1};
		int [] dc = new int [] {1,0,-1,0};
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int [] poll = q.poll();
			int r=poll[0];
			int c=poll[1];
			int block=poll[2];
			if(r==N && c==M) {
				ans= Math.min(ans,dist[r][c][block]);
			}
			for(int k=0;k<4;k++) {
				int nr = r+dr[k];
				int nc = c+dc[k];
				if(nr>=1 && nr<=N && nc>=1 && nc<=M) {
					if(map[nr][nc]==0 && dist[nr][nc][block]>dist[r][c][block]+1) {
						dist[nr][nc][block]=dist[r][c][block]+1;
						q.add(new int [] {nr,nc,block});
					}
					if(map[nr][nc]==1 && block==0 && dist[nr][nc][1]>dist[r][c][0]+1) {
						dist[nr][nc][1] = dist[r][c][0]+1;
						q.add(new int [] {nr,nc,1});
					}
						
				}
			}
		}
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
}
