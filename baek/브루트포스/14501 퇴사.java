import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {
	static StringBuilder sb;
	static int N, tmp;
	static List<int []> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int [] T = new int [N+1];
		int [] P = new int [N+1];
		int [] dp = new int [N+1];
		for(int i=1; i<=N; i++) {
			String [] str = br.readLine().split(" ");
			T[i]= Integer.parseInt(str[0]); 
			P[i]= Integer.parseInt(str[1]); 
			dp[i]= P[i]; 
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				if(j+T[j]<=i) {
				dp[i]= Math.max(dp[i], dp[j]+P[i]) ;
				}
			}
		}
		
		int max =0;
		for(int i=1; i<=N; i++) {
			if(i+T[i]<=N+1) {
				max=Math.max(max, dp[i]);
			}
		}
		
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	
}
