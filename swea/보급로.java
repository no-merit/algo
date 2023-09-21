import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class node implements Comparable<node>{
	int x,y, W;
	
	public node(int x,int y, int W) {
		this.x = x;
		this.y = y;
		this.W = W;
	}

	@Override
	public int compareTo(node o) {
		
		return this.W-o.W;
	}
}

public class Solution {
	static int N;
	static int [] [] map;
	static int [] [] dist;
	static int [] dx, dy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc =1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			//지도의 크기
			
			for(int i=0; i<N; i++) {
				String [] input = br.readLine().split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}//map 입력
			
			
			
			dist = new int [N][N];
			dx = new int[] {0,1,0,-1};
			dy = new int[] {1,0,-1,0};
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i][j]=Integer.MAX_VALUE;
				}
			}
			
			dijstra(0, 0);
			sb.append(dist[N-1][N-1]).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}// main
	
	static void dijstra(int nx, int ny) {
		//시작점 정하고 시작
		PriorityQueue<node> pq = new PriorityQueue<>();
		
		pq.add(new node(nx, ny, 0));
		//시작노드를 queue에 넣기
		dist[nx][ny]=0;
		//시작노드 가중치 입력
		while(!pq.isEmpty()) {
			node now = pq.poll();
			
			for(int k=0; k<4; k++) {
				int x = now.x+dx[k];
				int y = now.y+dy[k];
				//갈 수 있는 노드 탐색하고 
				if(x>=0 && x<N && y>=0 && y<N) {
					//들어오면 갈 수 있는 노드임
					if(dist[x][y]>dist[now.x][now.y]+map[x][y]) {
						dist[x][y]=dist[now.x][now.y]+map[x][y];
						//갈 수 있는 노드로 갈 때까지의 가중치 입력
						pq.add(new node(x, y, map[x][y]));
					//갈 수 있으면 싹다 queue에 넣기
					}
				}
			}//델타
			
			
			
			
		}
	}

}
