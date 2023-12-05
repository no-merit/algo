import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StringBuilder sb;
	static int[][] map;
	static boolean [] [] check;
	static int N, M, ans,cnt;

	static int[] dr = new int[] {-1, 0, 1, 0};//북 동 남 서
	static int[] dc = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		//1. 현재 칸이 청소안됐으면 현재 칸 청소
		//2. 현재 칸의 주변 4칸 탐색
		//	1)방향을 유지한 채 후진 가능시 후진
		//  2)후진할 수 없으면 작동 중지
		//3. 청소 안 된 칸이 있으면 반시계 방향 회전한 후 그 칸으로 전진
		
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]); // 세로크기
		M = Integer.parseInt(NM[1]); // 가로크기
		// N,M 3~8

		int [] robot = new int[3];
		
		
		String [] robot_data = br.readLine().split(" ");
		for(int i=0; i<3; i++) {
			robot[i] = Integer.parseInt(robot_data[i]);
		}
		//0은 청소 안 된 칸, 1은 벽
		map = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(row[j]);
				if(map[i][j]==0) {
					check[i][j]=true;
				}
			}
		}
		
		cnt =0;
		bfs(robot);
		System.out.println(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int[] robot) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {robot[0],robot[1],robot[2]});
		
		while(!q.isEmpty()) {
			
			int [] now = q.poll();
			int nr = now[0];
			int nc = now[1];
			int dir = now[2];
			
			if(map[nr][nc]==0 && check[nr][nc]) {//빈칸이고 청소해야하면
				check[nr][nc]=false; //청소했음
				cnt++; 				//카운트
			}
			
			//청소가 끝났든, 처음 로봇 위치가 벽이든
			//사방탐색
			boolean flag = false;
			for(int k=0; k<4; k++) {
				int tr = nr+dr[k];
				int tc = nc+dc[k];
				if(tr<N && tc< M && tr>=0 && tc>=0 && map[tr][tc]==0 && check[tr][tc]) {//범위 내에 있고 , 청소가 가능하면
					flag=true;
					break;
				}
			}
			
			if(flag){
				//청소되지 않은 빈칸이 있을 때
				while(true) {
					dir-=1;//반시계 90회전
					if(dir<0) {
						dir=3;
					}//0 이하가 되면 3으로 돌리고
					int tr = nr+dr[dir];
					int tc = nc+dc[dir];
					if(tr<N && tc< M && tr>=0 && tc>=0 && map[tr][tc]==0 && check[tr][tc]) {//범위 내에 있고 , 청소가 가능하면
						q.add(new int[] {tr, tc, dir}); // 청소 가능한 빈칸으로 이동
						break;
					}
				}
			}else {
				//청소되지 않은 빈칸이 없을 때
				int tr = nr-dr[dir];
				int tc = nc-dc[dir]; //후진
				if(tr<N && tc< M && tr>=0 && tc>=0 && map[tr][tc]==0) {//범위 내에 있고 , 후진이 가능하면
					q.add(new int[] {tr, tc, dir}); // 청소 가능한 빈칸으로 이동
					continue;
				}
				//후진이 불가능하면
				return;
			}
			
			
			
		}
		
	}



}
