import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static StringBuilder sb;
	static int [] parent;
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String [] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]); //  3 ≤ n ≤ 500,000
		int M = Integer.parseInt(NM[1]); //  3 ≤ m ≤ 1,000,000 
		parent = new int[N];
		for(int i=0; i<N; i++) {
			parent[i]=i;
		}
		int ans =0;
		for(int i=0; i<M; i++) {
			String [] now = br.readLine().split(" ");
			int st = Integer.parseInt(now[0]);
			int ed = Integer.parseInt(now[1]);
			if(union(st, ed)) {
				ans=i+1;
				break;
			}
			
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}




	private static boolean union(int st, int ed) {
		st = find(st);
		ed = find(ed);
		
		if(st == ed) return false;
		
		if(st> ed) parent[st] = ed;
		else parent[ed] = st;
		
		return true;
	}




	private static int find(int st) {
		if(st!=parent[st]) {
			parent[st] = find(parent[st]);
		}
		return parent[st];
	}
	
	


}
