package java23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class pos implements Comparable<pos>{
	int st;
	int amount;
	
	pos(int st, int amount){
		this.st = st;
		this.amount = amount;
		
	}
	@Override
	public int compareTo(pos o) {
		// TODO Auto-generated method stub
		return this.st-o.st;
	}//오름
	
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<pos> gas = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			String [] ab = br.readLine().split(" ");
			int a  = Integer.parseInt(ab[0]);
			int b  = Integer.parseInt(ab[1]);
			gas.add(new pos(a,b));
		}
		String [] lp = br.readLine().split(" ");
		int l = Integer.parseInt(lp[0]);//위 치
		int p = Integer.parseInt(lp[1]);//시작 연료
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int cnt=0;
		while(p<l) {
			while(!gas.isEmpty()&& gas.peek().st<=p) {
				pq.add(gas.poll().amount);
			}
			
			if(pq.isEmpty()) {
				System.out.println(-1);
				System.exit(0);
			}
			cnt++;
			p+=pq.poll();
		}
		System.out.println(cnt);
		
	}

}
