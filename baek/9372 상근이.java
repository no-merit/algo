import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class plane {
	int st;
	int ed;

	plane(int st, int ed) {
		this.st = st;
		this.ed = ed;
	}
}

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);

			Queue<plane> q = new LinkedList<>();
			parent = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < M; i++) {
				String[] se = br.readLine().split(" ");
				int st = Integer.parseInt(se[0]);
				int ed = Integer.parseInt(se[1]);

				q.add(new plane(st, ed));
			}
			int ans = 0;
			while (!q.isEmpty()) {
				plane now = q.poll();

				int st = now.st;
				int ed = now.ed;
				if (find(st) != find(ed)) {
					union(st, ed);
					ans++;
				}
			}
			sb.append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void union(int st, int ed) {
		st = find(st);
		ed = find(ed);

		if (st < ed) {
			parent[ed] = st;
		} else {
			parent[st] = ed;
		}

	}

	private static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
}
