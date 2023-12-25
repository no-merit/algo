package java23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb;
	static int[][] dp;
	static String[] str1;
	static String[] str2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		str1 = br.readLine().split("");
		str2 = br.readLine().split("");

		dp = new int[str1.length+1][str2.length+1];
		
		for(int i=1; i<=str1.length; i++) {
			for(int j=1; j<=str2.length;j++) {
				if(str1[i-1].equals(str2[j-1])) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		sb.append(dp[str1.length][str2.length]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
