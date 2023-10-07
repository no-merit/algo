import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 공간의 크기 N
 * 
 * */

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		// 크기 N의 2차 배열 map 생성

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		} // map에 값 입력
		
		int r = 0;
		int c = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 9) {
					r = i;
					c = j;
					map[i][j]=0; //자기 자신을 0으로 안 바꿔줘서 장애물로 남았고 그래서 2시간 낭비함
				}
			}
		} // 아기상어의 시작 위치 찾기
		int[] dr = new int[] { 0, 1, 0, -1 };
		int[] dc = new int[] { 1, 0, -1, 0 };// 동남서북

		// 더 이상 먹을 것이 없으면 끝
		// 가장 가까이 있는 물고기를 먹는데 같은 거리인 물고기가 있으면 가장 위쪽 ,그것도 같으면 가장 왼쪽
		// 물고기의 크기가 작거나 같으면 통과가능, 물고기를 자기 크기만큼 먹으면 크기가 커짐, 먹힌 자리는 0이 됨
		// 몇 초 동안 돌아다닐 수 있는지
		int[] now = new int[] { r, c };
		int size = 2;
		int cnt = 0;
		int move = 0;
		while (true) {// flag가 true 인 동안 반복. flag는 먹을 수 있는 먹이가 없거나 갈 수 있는 곳이 없을 때 false
			// x , y 상어의 위치 size 상어의 크기 cnt 먹은 먹이
			PriorityQueue<int[]> pq  = new PriorityQueue<>((o1, o2) ->
            o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
    );
			boolean[][] visited = new boolean[N][N];

			pq.add(new int[] { now[0], now[1], 0 });

			visited[now[0]][now[1]] = true;

			boolean flag = false;

			while (!pq.isEmpty()) {

				now = pq.poll();
				if (map[now[0]][now[1]] != 0 && map[now[0]][now[1]] < size) {

					map[now[0]][now[1]] = 0;
					cnt++;
					move += now[2];
					flag = true;
					break;
				}

				for (int k = 0; k < 4; k++) {
					int nr = now[0] + dr[k];
					int nc = now[1] + dc[k];
					if (nr < N && nc < N && nr >= 0 && nc >= 0 && !visited[nr][nc] && map[nr][nc] <= size) {
						pq.add(new int[] { nr, nc, now[2] + 1 });
						visited[nr][nc] = true;
					}
				}
			}
			if (!flag)
				break;
			if (size == cnt) {
				size++;
				cnt = 0;
			}

		}

		// 아기 상어의 위치를 찾기, 먹이의 위치 찾기,
		sb.append(String.valueOf(move));

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
