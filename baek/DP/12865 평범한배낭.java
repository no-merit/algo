import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Main {
	static StringBuilder sb;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String [] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]); // 1~100
		int K = Integer.parseInt(NK[1]); // 1 ~100,000
		
		int []Ws = new int[N+1]; //무게
		int []Vs = new int[N+1]; //가치
		
		for(int i=1; i<=N; i++) {
			String [] WV = br.readLine().split(" ");
			int W = Integer.parseInt(WV[0]);
			int V = Integer.parseInt(WV[1]);
			
			Ws[i]= W;
			Vs[i]= V; 
		}
		
		int [][] dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(Ws[i]<=j) { 
					dp[i][j]= Math.max(dp[i-1][j-Ws[i]]+Vs[i], dp[i-1][j]); 
				}else {
					dp[i][j]= dp[i-1][j]; 
				}
			}
		}
		sb.append(dp[N][K]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}


}
