import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class edge implements Comparable<edge>{
	int st;
	int ed;
	double dist;
	
	edge(int st, int ed, double dist) {
		this.st = st;
		this.ed = ed;
		this.dist = dist;
	}

	@Override
	public int compareTo(edge o) {
		
		return Double.compare(this.dist, o.dist);
	}
	
	

}

class god {
	int seq;
	int r;
	int c;

	god(int seq, int r, int c) {
		this.seq = seq;
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static StringBuilder sb;
	static int[] parent;
	public static god[] god_seq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");

		int N = Integer.parseInt(NM[0]); // N 신의 개수 정점
		int M = Integer.parseInt(NM[1]); // M 이미 연결된 통로의 수 간선
		
		god_seq = new god[N+1]; //1번부터 번호를 붙이기 때문에
		
		for(int i=1; i<=N; i++) {
			String [] rc = br.readLine().split(" ");
			god_seq[i]=new god(i,Integer.parseInt(rc[0]),Integer.parseInt(rc[1]));
		}
		 parent = new int[N+1];
		 
		 for(int i=1; i<=N; i++) {
			 parent[i]= i;
		 }
		
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				pq.add(new edge(i, j, weight(i,j)));
			}
		}
		double total =0;
		for(int i=0; i<M; i++) {
			String [] se = br.readLine().split(" ");
			int st = Integer.parseInt(se[0]);
			int ed = Integer.parseInt(se[1]);
			union(st,ed);
		}
		
		while(!pq.isEmpty()) {
			edge now = pq.poll();
			int st = now.st;
			int ed = now.ed;
			double dist = now.dist;
			if(find(st)!=find(ed)) {
				union(st, ed);
				total+=dist;
			}
		}
		
		bw.write(String.format("%.2f", total));
		bw.flush();
		bw.close();
		br.close();
	}

	private static double weight(int i, int j) {
		
		return Math.sqrt(Math.pow(god_seq[i].r-god_seq[j].r, 2)+Math.pow(god_seq[i].c-god_seq[j].c, 2));
	}

	private static void union(int st, int ed) {
		st = find(st);
		ed = find(ed);
		
		if (st < ed) {
			parent[ed] = st;
		} else {
			parent[st] = ed;
		}

	}

	private static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

}
