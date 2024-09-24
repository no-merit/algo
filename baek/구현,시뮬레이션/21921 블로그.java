
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String [] NX = br.readLine().split(" ");
		int N = Integer.parseInt(NX[0]);
		int X = Integer.parseInt(NX[1]);
		
		
		String [] visitor =br.readLine().split(" ");
		int [] nums = new int [N];
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(visitor[i]);
		
			nums[i] = now;
		}
		int sum =0;
		for(int i=0; i<X; i++) {
			sum+=nums[i];
		}
		int max =sum;
		int cnt=1;
		for(int i=X; i<N; i++) {
			
			sum-=nums[i-X];
			sum+=nums[i];
			
			if(sum==max) {
				cnt++;
			}else if(max<sum){
				max =sum;
				cnt=1;
			}
		}
		if(max==0) {
			sb.append("SAD");
		}else {
			sb.append(max).append("\n");
			sb.append(cnt);
		}
		
		System.out.println(sb.toString());
	}

}
