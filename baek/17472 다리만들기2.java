
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 공간의 크기 N
 * 
 * */
class edge implements Comparable<edge> {
	int from;
	int to;
	int length;

	edge(int from, int to, int length) {
		this.from = from;
		this.to = to;
		this.length = length;
	}

	@Override
	public int compareTo(edge o) {

		return this.length - o.length;
	}

}

public class Main {
	static StringBuilder sb;
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = new int[] { 0, 1, 0, -1 };
	static int[] dc = new int[] { 1, 0, -1, 0 }; // 동 남 서 북 탐색
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		} // map에 값 입력
//		

		PriorityQueue<edge> pq = new PriorityQueue<>();
		int island = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					// bfs로 섬 탐색
					bfs(i, j, island);
					island++;

				}
			}
		} // 섬들의 이름 붙이기

		// 직선으로 이었을 때 다른 섬에 닿을 수 있는 다리 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]!=0) {
					// 섬일 경우
					for (int k = 0; k < 4; k++) {
						int length = 0; // 다리의 길이
						int nr = i;
						int nc = j;
						while (true) {
							nr +=dr[k];
							nc +=dc[k];
							if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc]==map[i][j])
								break;
							if (map[nr][nc] != 0 && length < 2) break;
							// 범위 밖이면 break;
							// 다리가 뻗은 곳이 바다일 경우
							if (map[nr][nc] == 0)
								length++;// 다리의 길이 증가
							if (map[nr][nc] != 0) {
								// 다리가 닿은 곳이 섬이고 다리의 길이가 2이상일 때
								pq.add(new edge(map[i][j] - 1, map[nr][nc] - 1, length));
								break;
							} // pq에 넣음
						}
					}

				}
			}
		} // 다리 구하기
	
		p = new int[island - 1];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;// 자기 자신을 조상으로 초기화

		}

		int ans = 0;
		while (!pq.isEmpty()) {
			edge now = pq.poll();
			int a = find(now.from);
			int b = find(now.to);

			if (a != b) {
				// 조상이 다르면 union
				union(a, b);
				ans += now.length;// 해당하는 다리의 길이를 더함
			}

		}
		for(int i=2; i<p.length; i++) {
			if(find(p[i])!=p[1]) { //공통조상인지 확인 해야함
				ans=0;
				break;
			}
		}
		if (ans == 0) {
			sb.append(-1);
		} else {
			sb.append(ans);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}


	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		// 조상을 찾고
		if (pa > pb) {
			p[a] = pb;
		} else {
			p[b] = pa;
		} // 더 작은 값을 공통조상으로 입력함

	}

	static int find(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	static void bfs(int i, int j, int island) {
		// island는 섬의 이름 문제에서 섬을 1로 줬으니까 2부터 시작해서 네이밍. 섬의 번호는 이름보다 1작음
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		visited[i][j] = true;
		map[i][j] = island;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] != 1) {
					continue;
				}
				// continue 되지 않으면 범위 안이고 방문한적 없고 섬인 지역
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				map[nr][nc] = island;
			}
		}
	}

}
