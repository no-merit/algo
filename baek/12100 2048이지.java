import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 공간의 크기 N
 * 
 * */

public class Main {
	static StringBuilder sb;
	static int[][] map;
	static int N,max;
	static int[] turn;
	static int [] dr = new int [] {0,1,0,-1};
	static int [] dc = new int [] {1,0,-1,0};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		} // map 입력

		turn = new int[5];
		max =0;
		dfs(0,4);
		
		sb.append(max);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int depth, int dir) {
		if (depth == 5) {
			for(int i=0; i<5; i++) {
				game(turn);
			}
			
			return;
		}
		for (int i = 0; i < 4; i++) {
			
				turn[depth] = i;
				dfs(depth + 1, i);
			
		}
	}

	static void game(int[] arr) {
		//방향 배열을 받음
		int [] [] tmp = new int [N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tmp[i][j] = map[i][j];
			}
		}//tmp 복사
		
		
		//map의 각 인덱스에 대해서 
		int nr =0;
		int nc =0;
		
		for(int i=0; i<5; i++) {
			boolean [] [] checked = new boolean[N][N];
			boolean [] [] flag = new boolean[N][N];
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					if(tmp[a][b]!=0) {
						checked[a][b]=true;
					}
				}
			}
			//arr의 값에 대해
			if(arr[i]==0) {//동
				
				for(int c=N-2; c>=0; c--) {
					for(int r =0; r<N; r++) {
						if(tmp[r][c] ==0) continue;
						nc = c+dc[arr[i]];
						while(nc<N) {
							if(checked[r][nc]) {
								//블록이 있으면
								if(tmp[r][nc]==tmp[r][nc-dc[arr[i]]]&&!flag[r][nc]) {
									tmp[r][nc]*=2;//합쳐
									flag[r][nc]=true;
									tmp[r][nc-dc[arr[i]]]=0;
									checked[r][nc-dc[arr[i]]]=false;
									//있는데 값이 같으면 
								}
								break;
							}else {
								tmp[r][nc]=tmp[r][nc-dc[arr[i]]];
								checked[r][nc]=true;
								tmp[r][nc-dc[arr[i]]]=0;
								checked[r][nc-dc[arr[i]]]=false;
							}//비어있으면 nc에 옮기고 처리
							
							nc+=dc[arr[i]];
							
						}//while
					}
				}
			}else if(arr[i]==1) {//남
				
				for(int r=N-2; r>=0; r--) {
					for(int c =0; c<N; c++) {
						if(tmp[r][c] ==0) continue;
						nr = r+dr[arr[i]];
						while(nr<N) {
							if(checked[nr][c]) {
								//블록이 있으면
								if(tmp[nr][c]==tmp[nr-dr[arr[i]]][c]&&!flag[nr][c]) {
									tmp[nr][c]*=2;//합쳐
									tmp[nr-dr[arr[i]]][c]=0;
									flag[nr][c]=true;
									checked[nr-dr[arr[i]]][c]=false;
									//있는데 값이 같으면 
								}
								break;
							}else {
								tmp[nr][c]=tmp[nr-dr[arr[i]]][c];
								checked[nr][c]=true;
								tmp[nr-dr[arr[i]]][c]=0;
								checked[nr-dr[arr[i]]][c]=false;
							}//비어있으면 nr에 옮기고 처리
							
							nr+=dr[arr[i]];
							
						}//while
					}
				}
			}else if(arr[i]==2) {//서
				
				for(int c=1; c<N; c++) {
					for(int r =0; r<N; r++) {
						if(tmp[r][c] ==0) continue;
						nc = c+dc[arr[i]];
						while(nc>=0) {
							if(checked[r][nc]) {
								//블록이 있으면
								if(tmp[r][nc]==tmp[r][nc-dc[arr[i]]]&&!flag[r][nc]) {
									tmp[r][nc]*=2;//합쳐
									tmp[r][nc-dc[arr[i]]]=0;
									flag[r][nc]=true;
									checked[r][nc-dc[arr[i]]]=false;
									//있는데 값이 같으면 
								}
								break;
							}else {
								tmp[r][nc]=tmp[r][nc-dc[arr[i]]];
								tmp[r][nc-dc[arr[i]]]=0;
								checked[r][nc-dc[arr[i]]]=false;
								checked[r][nc]=true;
							}//비어있으면 nc에 옮기고 처리
							
							nc+=dc[arr[i]];
							
						}//while
					}
				}
				
			}else if(arr[i]==3) {//북
				
				for(int r=1; r<N; r++) {
					for(int c =0; c<N; c++) {
						if(tmp[r][c] ==0) continue;
						nr = r+dr[arr[i]];
						while(nr>=0) {
							if(checked[nr][c]) {
								//블록이 있으면
								if(tmp[nr][c]==tmp[nr-dr[arr[i]]][c]&&!flag[nr][c]) {
									tmp[nr][c]*=2;//합쳐
									tmp[nr-dr[arr[i]]][c]=0;
									flag[nr][c]=true;
									checked[nr-dr[arr[i]]][c]=false;
									//있는데 값이 같으면 
								}
								break;
							}else {
								tmp[nr][c]=tmp[nr-dr[arr[i]]][c];
								tmp[nr-dr[arr[i]]][c]=0;
								checked[nr-dr[arr[i]]][c]=false;
								checked[nr][c]=true;
							}//비어있으면 nr에 옮기고 처리
							
							nr+=dr[arr[i]];
							
						}//while
					}
				}
			}
			
		}
		int tmp_max=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(tmp_max<tmp[i][j]) {
					tmp_max = tmp[i][j];
				}
			}
		}
		max = Math.max(tmp_max, max);
	}

}
