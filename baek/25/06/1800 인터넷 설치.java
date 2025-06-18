import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int ed;
    int cost;

    Edge(int ed, int cost) {
        this.ed = ed;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int N, P, K;
    static List<List<Edge>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NPK = br.readLine().split(" ");
        N = Integer.parseInt(NPK[0]);
        P = Integer.parseInt(NPK[1]);
        K = Integer.parseInt(NPK[2]);
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int maxCost = 0;
        for (int i = 0; i < P; i++) {
            String[] input = br.readLine().split(" ");
            int st = Integer.parseInt(input[0]);
            int ed = Integer.parseInt(input[1]);
            int value = Integer.parseInt(input[2]);
            list.get(st).add(new Edge(ed, value));
            list.get(ed).add(new Edge(st, value));
            maxCost = Math.max(maxCost, value);
        }

        int left = 0;
        int right = maxCost;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean dijkstra(int mid) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[1] = 0;
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
        	Edge current = pq.poll();

            if (dist[current.ed] < current.cost) {
                continue;
            }

            for (Edge next : list.get(current.ed)) {
                int nextCost = current.cost;
                if (next.cost > mid) {
                    nextCost += 1;
                }

                if (nextCost < dist[next.ed]) {
                    dist[next.ed] = nextCost;
                    pq.offer(new Edge(next.ed, nextCost));
                }
            }
        }
        return dist[N] <= K;
    }
}
