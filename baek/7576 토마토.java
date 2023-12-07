package java23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	static int [] [] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String [] MN = br.readLine().split(" ");
		
		int N = Integer.parseInt(MN[0]);
		int M = Integer.parseInt(MN[1]);
		map = new int[M][N];
		
		for(int i=0; i<M; i++) {
			String [] row = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]==1) {
					q.add(new int[] {i,j,0});
				}
			}
		}
		int [] dr = new int[] {0,1,0,-1};
		int [] dc = new int[] {1,0,-1,0}; //동 남 서 북
		int ans =1;
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			int r= now[0];
			int c= now[1];
			int day = now[2];
			ans = day+1;
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0 && nc>=0 && nr<M&& nc<N && map[nr][nc]==0) {
					map[nr][nc]=1;
					q.add(new int[] {nr,nc,ans});
				}
			}
			
		}
		
		boolean flag = true;
		
		for(int i=0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]==0) {
					flag = false;
				}
			}
		}
		
		if(flag) {
			sb.append(ans-1);
		}else {
			sb.append(-1);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
