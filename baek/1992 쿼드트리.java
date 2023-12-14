import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Main {
	static StringBuilder sb;
	static int [] [] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String [] row = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		dv(0,0,N);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dv(int r, int c, int size) {
	
		int now = map[r][c];
		
		boolean flag = false;
		
		check: for(int i=r; i<r+size;i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j]!=now) {
					flag = true;
					break check;
				}
			}
		}
		if(flag) {
			int newsize = size/2;
			sb.append("(");
			dv(r,c,newsize);
			dv(r,c+newsize,newsize);
			dv(r+newsize,c,newsize);
			dv(r+newsize,c+newsize,newsize);
			sb.append(")");
		}else {
			sb.append(now);
		}
	}

}
