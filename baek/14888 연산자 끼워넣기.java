import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StringBuilder sb;
	static int[] op, tmp;
	static int N, max, min;
	static int[] q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		q = new int[N];
		String[] nums = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			q[i] = Integer.parseInt(nums[i]);
		}

		String[] operator = br.readLine().split(" ");

		op = new int[4];

		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(operator[i]);
		}
		tmp = new int[N - 1];

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(0);

		sb.append(max).append("\n").append(min);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int depth) {

		if (depth == N - 1) {

			int ans = q[0];
				for (int j = 0; j < N - 1; j++) {
					switch (tmp[j]) {
					case 0:
						ans +=  q[j+1];
						break;
					case 1:
						ans -= q[j+1];
						break;
					case 2:
						ans *= q[j+1];
						break;
					case 3:
						if (ans < 0) {
							ans *= -1;
							ans /= q[j+1];
							ans *= -1;
						} else {
							ans /=  q[j+1];
						}
						break;
					}
				}
			
			max = Integer.max(max, ans);
			min = Integer.min(min, ans);
			return;
		}
	
			for (int j = 0; j < 4; j++) {
				if (op[j] != 0) {
					op[j]--;
					tmp[depth] = j;
					dfs(depth + 1);
					op[j]++;
				}
			}
		

	}

}
