import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());// 전기줄 개수 100 이하의 자연수

		int[][] pole = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			String[] AB = br.readLine().split(" ");

			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			pole[i][0] = A;
			pole[i][1] = B;
		}

		Arrays.sort(pole, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[0] - o2[0];
			}

		});
		int max =0;
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;

			for (int j = 1; j < i; j++) {
				if (pole[j][1] < pole[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		sb.append(N-max);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
