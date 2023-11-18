import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]); // 개수
		int K = Integer.parseInt(NK[1]); // 목표 돈
		int[] arr = new int[N + 1];
		int[] dp = new int[K + 1];
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		for (int i = 1; i <= K; i++) {
			dp[i] = 10001;
		}

		for (int i = 1; i <= N; i++) {
			for (int k = arr[i]; k <= K; k++) { // <<<<아이디어

				dp[k] = Math.min(dp[k], dp[k - arr[i]] + 1);

			}
		}
		if(dp[K]==10001) {
			sb.append(-1);
		}else {
			sb.append(dp[K]);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
