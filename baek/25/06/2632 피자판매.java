

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;



public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());//1~2_000_000
		String [] AB = br.readLine().split(" ");
		int A = Integer.parseInt(AB[0]);
		int B = Integer.parseInt(AB[1]);
		int [] A_pizza = new int[A];
		int [] B_pizza = new int[B];
		int A_sum=0;
		for(int i=0; i<A; i++) {
			int now = Integer.parseInt(br.readLine());
			A_sum+=now;
			A_pizza[i] = now;
		}
		int B_sum=0;
		for(int i=0; i<B; i++) {
			int now = Integer.parseInt(br.readLine());
			B_sum+=now;
			B_pizza[i] = now;
		}
		
		HashMap<Integer,Integer> A_map =new HashMap<>();
		for(int i=0;i<A;i++) {
			int tmp = 0;
			for(int j=i;j<i+A-1;j++) {
				int idx=j;
				if(j>=A) idx=idx%A;
				tmp+=A_pizza[idx];
				int cnt = A_map.getOrDefault(tmp, 0);
				A_map.put(tmp, cnt+1);
			}
		}
		A_map.put(A_sum, 1);
		
		HashMap<Integer,Integer> B_map =new HashMap<>();
		for(int i=0;i<B;i++) {
			int tmp = 0;
			for(int j=i;j<i+B-1;j++) {
				int idx=j;
				if(j>=B) idx=idx%B;
				tmp+=B_pizza[idx];
				int cnt = B_map.getOrDefault(tmp, 0);
				B_map.put(tmp, cnt+1);
			}
		}
		B_map.put(B_sum, 1);
		
		
		int ans =0;
		for(int amount : A_map.keySet()) {
			int sub = N-amount;
			if(sub==0) {
				ans+=A_map.get(amount);
				continue;
			}else if(sub<0) {
				continue;
			}else {
				if(B_map.get(sub)!=null) {
					ans+=A_map.get(amount)*B_map.get(sub);
				}
			}
		}
		if(B_map.get(N)!=null) ans+=B_map.get(N);
		System.out.println(ans);
		
	}

}
