import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class edge implements Comparable<edge>{
	int ed;
	int time;

	edge(int ed, int time) {
		this.ed = ed;
		this.time = time;
	}

	@Override
	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		return this.time -o.time;
	}
}

public class Main {
	static StringBuilder sb;
	static int[] parent;
	static int N, M, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NMX = br.readLine().split(" ");

		N = Integer.parseInt(NMX[0]); // 학생, 마을, 정점
		M = Integer.parseInt(NMX[1]); // 도로, 간선
		X = Integer.parseInt(NMX[2]); // 타겟
		// N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 10,000)

		ArrayList<ArrayList<edge>> go_list = new ArrayList<ArrayList<edge>>();
		ArrayList<ArrayList<edge>> back_list = new ArrayList<ArrayList<edge>>();

		for (int i = 0; i <= N; i++) {
			go_list.add(new ArrayList<edge>());
			back_list.add(new ArrayList<edge>());
		}

		for (int i = 0; i < M; i++) {
			// 간선 입력 받기
			String[] ABT = br.readLine().split(" ");
			int A = Integer.parseInt(ABT[0]);
			int B = Integer.parseInt(ABT[1]);
			int T = Integer.parseInt(ABT[2]);
			go_list.get(A).add(new edge(B, T)); // X에서 정점으로가는
			back_list.get(B).add(new edge(A, T));// 정점에서 X로 가는
		}

		int[] go = dijkstra(go_list);
		int[] back = dijkstra(back_list);

		int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, go[i] + back[i]);
        }
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int[] dijkstra(ArrayList<ArrayList<edge>> list) {
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		PriorityQueue<edge> pq = new PriorityQueue<>();

		pq.add(new edge(X, 0));
		dp[X] = 0;
		boolean[] check = new boolean[N + 1];

		while (!pq.isEmpty()) {
			edge now = pq.poll();

			int ed = now.ed;
			if (!check[ed]) {
				check[ed]=true;
				
				for (edge e : list.get(ed)) {
					if(!check[e.ed] && dp[e.ed]>dp[ed]+e.time) {
						dp[e.ed]=dp[ed]+e.time;
						pq.add(new edge(e.ed, dp[e.ed]));
					}
				}
			}

		}

		return dp;
	}

}
