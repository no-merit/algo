import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int [][] origin = new int[N][3];
		for(int i=0; i<N; i++) {
			String [] row = br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				origin[i][j] = Integer.parseInt(row[j]);
			}
		}
		int [][] max_dp = new int[N][3];
		int [][] min_dp = new int[N][3];
		for(int i=1; i<N; i++) {
			for(int j=0;j<3;j++) {
				max_dp[i][j]=Integer.MIN_VALUE;
			}
		}
		for(int i=1; i<N; i++) {
			for(int j=0;j<3;j++) {
				min_dp[i][j]=Integer.MAX_VALUE;
			}
		}
		max_dp[0][0] = origin[0][0];
		max_dp[0][1] = origin[0][1];
		max_dp[0][2] = origin[0][2];
		min_dp[0][0] = origin[0][0];
		min_dp[0][1] = origin[0][1];
		min_dp[0][2] = origin[0][2];
		for(int i=1; i<N; i++) {
				max_dp[i][0] = Math.max(max_dp[i-1][0],max_dp[i-1][1])+origin[i][0];
				max_dp[i][1] = Math.max(max_dp[i-1][0],Math.max(max_dp[i-1][1], max_dp[i-1][2]))+origin[i][1];
				max_dp[i][2] = Math.max(max_dp[i-1][1],max_dp[i-1][2])+origin[i][2];
				min_dp[i][0] = Math.min(min_dp[i-1][0],min_dp[i-1][1])+origin[i][0];
				min_dp[i][1] = Math.min(min_dp[i-1][0],Math.min(min_dp[i-1][1], min_dp[i-1][2]))+origin[i][1];
				min_dp[i][2] = Math.min(min_dp[i-1][1],min_dp[i-1][2])+origin[i][2];
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3;i++) {
			max = Math.max(max, max_dp[N-1][i]);
			min = Math.min(min, min_dp[N-1][i]);
		}
		System.out.println(max+" "+min);
		
	}
}
