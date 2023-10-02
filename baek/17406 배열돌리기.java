import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static StringBuilder sb;
	static int N, M, K;
	static int min = Integer.MAX_VALUE;
	static int [] [] map,commands;
	static int [] [] copy ;//배열을 원래대로 초기화 시킬 copy
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String [] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);
		
		map = new int[N][M];
		copy = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String [] row = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(row[j]);
				copy[i][j] = Integer.parseInt(row[j]);
				
			}
		}//map에 값 입력
		
		commands = new int[K] [3];
		
		for(int k=0; k<K; k++) {
			String [] command = br.readLine().split(" ");
			int x = Integer.parseInt(command[0])-1;//문제에서 배열이 1,1에서 시작해서 -1씩 해줘야 함
			int y = Integer.parseInt(command[1])-1;
			int s = Integer.parseInt(command[2]);
			commands[k] = new int [] {x, y, s};
			
		}
		permutation(0 , new int[K], new boolean[K]);
    //순열과 방문 판별을 위한 배열
		
		sb.append(String.valueOf(min));
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void permutation(int depth, int[] arr, boolean[] visited) {//순열
		if(depth == K) {
			rotate(arr);
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			arr[depth]= i;
			permutation(depth+1,arr, visited);
			visited[i]=false;
		}
		
	}

	private static void rotate(int[] arr) {
		for(int k=0; k<K; k++) {//순열에 담긴 숫자만큼 반복 <<<<< 명령의 횟수만큼 돌림
			int r = commands[arr[k]][0];
			int c = commands[arr[k]][1];
			int S = commands[arr[k]][2];
			
			for(int s=1; s<=S; s++) {

        //회전을 함에 있어서 배열의 밖으로 나가지는 자리가 3개 있음음
				//위쪽의 회전
				int upTmp = map[r-s][c+s]; 
				for(int y= c+s; y>c-s; y--) {
					map[r-s][y] = map[r-s][y-1];
				}
				
				//오른쪽의 회전
				int rightTmp = map[r+s][c+s];
				for(int x = r+s; x>r-s; x--) {
					map[x][c+s] = map[x-1][c+s];
				}
				map[r-s+1][c+s] = upTmp;
				
				//아래
				int leftTmp = map[r+s][c-s];
				for(int y= c-s; y<c+s; y++) {
					map[r+s][y] = map[r+s][y+1];
				}
				map[r+s][c+s-1] = rightTmp;
				
				//왼쪽의 회전
				
				for(int x = r-s; x<r+s; x++) {
					map[x][c-s] = map[x+1][c-s];
				}
				map[r+s-1][c-s] = leftTmp;
				
			}
		}
		sum();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = copy[i][j];
			}
		}//처음으로 초기화
	}

	private static void sum() {
		
		for(int i=0; i<N; i++) {
			int sum=0;
			for(int j=0; j<M; j++) {
				sum+=map[i][j];
			}
			min = Math.min(min, sum);
		}
		
	}

	
	

}
