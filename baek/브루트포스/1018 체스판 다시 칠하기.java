import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb;
	static boolean [] [] map;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String [] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		map = new boolean [N][M];
		
		for(int i=0; i<N; i++) {
			String [] row = br.readLine().split("");
			for(int j=0; j<M; j++) {
				if(row[j].equals("W")) {
					map[i][j] = true;
				}
			}
		}
		
		int r = N-7;
		int c = M-7;
		ans=Integer.MAX_VALUE;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				check(i,j);
			}
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	static void check(int i, int j) {
		boolean st = map[i][j];
		int ed_i = i+8;
		int ed_j = j+8;
		int cnt =0;
		for(int k=i; k<ed_i; k++) {
			for(int l=j; l<ed_j; l++) {
				if(map[k][l]!=st) {
					cnt++;
				}
				
				st = !st;
			}
			st = !st;
		}
		
		cnt = Math.min(cnt, 64-cnt);
		ans = Math.min(cnt, ans);
	}

}
