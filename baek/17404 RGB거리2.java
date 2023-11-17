import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] red = new int[N];
		int[] green = new int[N];
		int[] blue = new int[N];

		for (int i = 0; i < N; i++) {
			String[] score = br.readLine().split(" ");
			red[i] = Integer.parseInt(score[0]);
			green[i] = Integer.parseInt(score[1]);
			blue[i] = Integer.parseInt(score[2]);
		}
		int[][] dp = new int[N][3];
		
		int ans = Integer.MAX_VALUE;
		
		for (int k = 0; k < 3; k++) { // 첫집과 끝집이 같으면 안되서 고민했는데 반복문으로 첫집의 정보를 가지고 있으면 됨
			for (int i = 0; i < 3; i++) {
				if (k == i) {
					if (i == 0) {
						dp[0][i] = red[0];
					} else if (i == 1) {
						dp[0][i] = green[0];
					} else {
						dp[0][i] = blue[0];
					}
				} else
					dp[0][i] = 1000000; // integer.maxvalue로 하니까 터져서 -가 됨!!!!
			}
			
			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1] ,dp[i - 1][2])+red[i];
				dp[i][1] = Math.min(dp[i - 1][0] ,dp[i - 1][2])+green[i];
				dp[i][2] = Math.min(dp[i - 1][1] ,dp[i - 1][0]) +blue[i];
			}
			
			for(int i=0; i<3; i++) {
				if(i!=k) ans = Math.min(ans, dp[N-1][i]);
			}
		}
		sb.append(ans);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
