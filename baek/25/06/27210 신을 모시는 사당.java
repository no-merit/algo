import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String [] input = br.readLine().split(" "); 
		int [] origin = new int [N];
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(input[i]);
			origin[i] = now;
		}
		
		
		int [] dp_L = new int[N];//1
		int [] dp_R = new int[N];//2
		Arrays.fill(dp_L, Integer.MIN_VALUE);
		Arrays.fill(dp_R, Integer.MAX_VALUE);
		if(origin[0]==1) {
			dp_L[0]=1;
			dp_R[0]=0;
		}else {
			dp_L[0]=0;
			dp_R[0]=1;
		}
		for(int i =1; i<N;i++) {
			if(origin[i]==1) {//왼
				dp_L[i] = Math.max(dp_L[i-1]+1, 1);
				dp_R[i] = Math.max(dp_R[i-1]-1,-1);
			}else {//오
				dp_L[i] = Math.max(dp_L[i-1]-1, -1);
				dp_R[i] = Math.max(dp_R[i-1]+1,1);
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			ans = Math.max(dp_L[i], Math.max(dp_R[i], ans));
		}
		
		System.out.println(ans);
	}
}
