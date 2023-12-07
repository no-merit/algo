import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;


class star{
	int seq;
	double row;
	double col;
	
	star(int seq, double row, double col){
		this.seq = seq;
		this.row = row;
		this.col = col;
	}
}
class edge implements Comparable<edge>{
	
	int st;
	int ed;
	double dist;
	
	edge(int st, int ed, double dist){
		this.st = st;
		this.ed = ed;
		this.dist = dist;
	}

	@Override
	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		return Double.compare(this.dist, o.dist);
	}
	
}

public class Main {
	static StringBuilder sb;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		star [] star_arr = new star[N];
		parent = new int[N];
		
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			String [] RC = br.readLine().split(" ");
			double R = Double.parseDouble(RC[0]);
			double C = Double.parseDouble(RC[1]);
			star_arr[i] = new star(i,R,C);
		}
		
		PriorityQueue<edge> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N;j++) {
				pq.add(new edge(i,j,Math.sqrt(Math.pow(star_arr[i].row-star_arr[j].row, 2)+Math.pow(star_arr[i].col-star_arr[j].col, 2))));
			}
		}
		double ans =0;
 		while(!pq.isEmpty()) {
 			edge now = pq.poll();
 			int st = now.st;
 			int ed = now.ed;
 			double dist =  now.dist;
 			
 			if(find(st)!=find(ed)) {
 				union(st,ed);
 				ans += dist;
 			}
 			
 		}
		
		bw.write(String.format("%.2f", ans));
		bw.flush();
		bw.close();
		br.close();
	}
	private static void union(int st, int ed) {
		st = find(st);
		ed = find(ed);
		
		if(st<ed) {
			parent[ed] = st;
		}else {
			parent[st] = ed;
		}
		
	}
	private static int find(int x) {

		if(x!=parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}


}
