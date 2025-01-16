import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class node implements Comparable<node>{
	int dis;
	int mem;
	
	
	node(int position, int member){
		this.dis = position;
		this.mem= member;
		
	}
	
	public int compareTo(node o) {
		return o.dis-this.dis;
	}


	
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String [] NKS = br.readLine().split(" ");
		int N = Integer.parseInt(NKS[0]); // 단지수
		int K = Integer.parseInt(NKS[1]); // 정원
		int S = Integer.parseInt(NKS[2]); // 학교 위치
		
		PriorityQueue<node> more = new PriorityQueue<>();
		PriorityQueue<node> less = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			String [] row = br.readLine().split(" ");
			int pos = Integer.parseInt(row[0]);
			int mem = Integer.parseInt(row[1]);
			
			if(pos<S) {//less
				less.add(new node(S-pos,mem));
			}else {//more
				more.add(new node(pos-S,mem));
			}
		}
		int ans =0;
		while(!less.isEmpty()) {
			int dist = 0;
			int bus = K;
			while(!less.isEmpty()) {
				node poll = less.poll();
				dist = Math.max(dist, poll.dis);
				if(poll.mem<=bus) {
					bus-=poll.mem;
				}else {
					int tmp = poll.mem-bus;
					less.add(new node(poll.dis,tmp));
					break;
				}
			}
			ans+=dist*2;
		}
		while(!more.isEmpty()) {
			int dist = 0;
			int bus = K;
			while(!more.isEmpty()) {
				node poll = more.poll();
				dist = Math.max(dist, poll.dis);
				if(poll.mem<=bus) {
					bus-=poll.mem;
				}else {
					int tmp = poll.mem-bus;
					more.add(new node(poll.dis,tmp));
					break;
				}
			}
			ans+=dist*2;
		}
		System.out.println(ans);
		
	}

}
