
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution {
	
	static int [] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			
			String [] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);//원소의 개수
			int M = Integer.parseInt(NM[1]);//명령의 개수
			
			p = new int [N+1];
			
			for(int i=1; i<=N; i++) {
				p[i]=i;
			}
			
			for(int i=0; i<M; i++) {
				
				String [] commands = br.readLine().split(" ");
				int command = Integer.parseInt(commands[0]);
				int A = Integer.parseInt(commands[1]);
				int B = Integer.parseInt(commands[2]);
				if(command==0) {
					union(A,B);
				}else {
					if(find(A)==find(B))sb.append(String.valueOf(1));
					else sb.append(String.valueOf(0));
				}
			}
			sb.append("\n");
		}
			
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}// main
	
	static int find(int idx) {
		if(p[idx]!=idx) {
			p[idx]=find(p[idx]);
		}
		return p[idx];
	}
	static void union(int A, int B) {
		int C = find(A);
		int D = find(B);
		p[D]=C;
	}

}
