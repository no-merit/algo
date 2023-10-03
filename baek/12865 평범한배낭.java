import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 
 * 
 * */

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]); // 물품의 수
		int K = Integer.parseInt(NK[1]); // 버틸 수 있는 무게

		int[] W = new int[N + 1]; //물품의 무게를 담을 배열
		int[] V = new int[N + 1]; //물품의 가치를 담을 배열
		int[] dp = new int[K + 1]; //물품의 무게당 가치의 최적해를 담을 DP 배열
    
		for (int i = 1; i <= N; i++) {
			String[] read = br.readLine().split(" ");
			int weight = Integer.parseInt(read[0]);
			int value = Integer.parseInt(read[1]);

			W[i] = weight;
			V[i] = value;
		} // 배열 생성

		for(int i=1; i<=N; i++) {
      //해당 물품을 담을 때의 dp
			for(int j=K; j-W[i]>=0; j--) {
        //j-W[i]>=0 로 현재의 물건을 넣을 수 있을 때까지만 반복
				dp[j] = Math.max(dp[j], dp[j-W[i]]+V[i]);
			}
		}
		sb.append(dp[K]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
