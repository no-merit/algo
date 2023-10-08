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
class game{ //한 턴에 빨간 공과 파란 공의 상태, 몇번째 턴인지지
	int rr;
	int rc;
	int br;
	int bc;
	int turn;
	
	game(int rr, int rc, int br, int bc, int turn){
		this.rr = rr;
		this.rc = rc;
		this.br = br;
		this.bc = bc;
		this.turn = turn;
	}
}

public class Main {
	static StringBuilder sb;
	static int N, M,turn;
	static String[][] map;
	static int[] R, B;
	static int[] dr = new int[] { 0, 1, 0, -1 };
	static int[] dc = new int[] { 1, 0, -1, 0 };
	static boolean [] [] [] [] visited;

  
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		map = new String[N][M];
		visited = new boolean[N][M][N][M];

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = row[j];
				if (row[j].equals("R")) {
					R = new int[] { i, j };
				} else if (row[j].equals("B")) {
					B = new int[] { i, j };
				}
			}
		} // map 입력, R, B, O 의 좌표 입력
		//R이 갈 수 있는 방향을 찾아야함 델타, 지나온 길에 대해 방문체크
		//갈 수 있으면 그 방향으로 갈 수 없을 때까지 가야함 while
		//방향 바꿀 때마다 cnt ++ , cnt >10 이면 -1
		//가면서 O를 만나면 체크하는데 그때의 이동이 끝나기 전에 B가 O와 만나면 -1
		
		turn =0;
    //답, bfs로 최단 거리 탐색
		Queue<game> q = new LinkedList<>();//매 턴의 상태를 q에 담음
		q.add(new game(R[0],R[1],B[0],B[1],0)); //초기 상태
		checked[R[0]][R[1]][B[0]][B[1]] =true;
		problem :while(!q.isEmpty()) {
			game now = q.poll();
			//현재 빨간 구슬의 위치에서 사방탐색
			if(now.turn>10) {
				break problem;
			}//이번 턴이 10턴을 넘었으면 -1
      
			for(int k=0; k<4; k++) {//이번 턴의 위치에서 델타 탐색
				int rnr = now.rr;
				int rnc = now.rc;
				int bnr = now.br;
				int bnc = now.bc;
				int now_turn = now.turn;
        //이번 턴이 몇번째 턴인지
				while(!map[rnr+dr[k]][rnc+dc[k]].equals("#")) {
					rnr+=dr[k];
					rnc+=dc[k];
					if(map[rnr][rnc].equals("O"))
						break;
				}//빨간공이 벽을 만날 때까지 이동하는데 구멍에서는 멈춤춤
				while(!map[bnr+dr[k]][bnc+dc[k]].equals("#")) {
					bnr+=dr[k];
					bnc+=dc[k];
					if(map[bnr][bnc].equals("O"))
						break;
					
				}//파란공도 같음
				if(map[bnr][bnc].equals("O")) {
					continue;
				}//파란공이 구멍에 빠지면 게임 끝 다음 케이스로 넘어감
				if(map[rnr][rnc].equals("O")) {
					turn = now_turn+1;
					break problem;
				}//빨간공이 구멍에 빠지면 게임 끝 답을 냄
				
				if(rnr==bnr && rnc==bnc) {
					int red = Math.abs(rnr-now.rr)+Math.abs(rnc-now.rc);
					int blue = Math.abs(bnr-now.br)+Math.abs(bnc-now.bc);
					
					if(red>blue) {//빨간 공의 이동거리가 길다 = 늦게 왔다
						rnr -=dr[k];
						rnc -=dc[k];
					}else { // 늦게 온 구슬을 온 방향으로 한 칸 뒤로 배치
						bnr -=dr[k];
						bnc -=dc[k];
					}
					
				}//둘이 같은 위치면 먼저 온 공이 그 자리고 늦게 온 공은 그 뒤에 붙임
				
				if(!visited[rnr][rnc][bnr][bnc]) {//왔던 길을 돌아온 게 아니면 q.add
					visited[rnr][rnc][bnr][bnc]=true;
					q.add(new game(rnr, rnc, bnr, bnc, now_turn+1));
				}//직선으로 왔다 갔다해서 다음 위치에서 반대 방향으로 반복해버리면 같은 상황이 나옴. 그 경우를 제외함함
			}
		}
		if(turn >10 || turn ==0 ) {
			sb.append(-1);
		}else {
			sb.append(turn);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
}
