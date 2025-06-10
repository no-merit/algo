import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static List<List<Integer>> child;
	static int ans = 50;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] nodes = br.readLine().split(" ");
		child = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			child.add(new ArrayList<>());
		}

		for (int i = 1; i < N; i++) {
			int now = Integer.parseInt(nodes[i]);
			child.get(now).add(i);
		}

		System.out.println(dfs(0));
	}

	static int dfs(int st) {
		if (child.get(st).isEmpty()) {
			return 0;
		}

		List<Integer> childPropagateTimes = new ArrayList<>();
		for (int nowChild : child.get(st)) {
			childPropagateTimes.add(dfs(nowChild));
		}

		Collections.sort(childPropagateTimes, Collections.reverseOrder());

		int maxTotalTime = 0;
		for (int i = 0; i < childPropagateTimes.size(); i++) {
			maxTotalTime = Math.max(maxTotalTime, childPropagateTimes.get(i) + (i + 1));
		}
		
		return maxTotalTime;
	}
}
