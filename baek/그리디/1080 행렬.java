package java23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static StringBuilder sb;
	static int [] [] map, ans;
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String [] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		//행렬의 크기
		//NM은 1~50
		map = new int [N][M];
		ans = new int [N][M];
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split("");
			for(int j=0; j<M; j++) {
				ans[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		
		
		
		int cnt =0;
		boolean flag = false;
		for(int i=0; i<=N-3; i++) {
			//row 방향
			for(int j=0; j<=M-3; j++) {
			//col 방
				if(flipCheck(i,j))continue;
				flip(i,j);
				cnt++;
			}
		}
		
		if(check()) {
			flag = true;
		}
		if(!flag) {
			sb.append(-1);
		}else {
			sb.append(cnt);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}



	private static boolean flipCheck(int i, int j) {
		if(map[i][j]!=ans[i][j]) {
			return false;
		}
		return true;
	}



	private static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0;j<M; j++) {
				if(map[i][j]!=ans[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void flip(int row, int col) {
		for(int i=row; i<row+3; i++) {
			for(int j=col;j<col+3;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
				}else {
					map[i][j]=0;
					
				}
			}
		}
		
		
	}

}
