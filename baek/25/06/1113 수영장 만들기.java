import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        int totalWater = 0;

     
        for (int h = 2; h <= maxHeight; h++) {
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] < h && !visited[i][j]) {
                        totalWater += bfs(i, j, h);
                    }
                }
            }
        }

        System.out.println(totalWater);
    }

    public static int bfs(int r, int c, int h) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> poolCells = new ArrayList<>();

        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        poolCells.add(new int[]{r, c});

        boolean isLeaky = false;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curR = current[0];
            int curC = current[1];

            if (curR == 0 || curR == N - 1 || curC == 0 || curC == M - 1) {
                isLeaky = true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    if (map[nr][nc] < h) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        poolCells.add(new int[]{nr, nc});
                    }
                }
            }
        }

        if (isLeaky) {
            return 0;
        }

        int waterAmount = 0;
        for (int[] cell : poolCells) {
            waterAmount += (h - map[cell[0]][cell[1]]);
            map[cell[0]][cell[1]] = h;
        }

        return waterAmount;
    }
}
