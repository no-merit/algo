import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
	static StringBuilder sb;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		//N 1 ~ 1,500,000 일 수
		int [] [] arr = new int [N+2][2];
		//상담 소요 시간과 보상
		
		for(int i=1; i<=N; i++) {
			String [] TP = br.readLine().split(" ");
			int T = Integer.parseInt(TP[0]); // time
			int P = Integer.parseInt(TP[1]); // price
			
			arr[i][0] = T;
			arr[i][1] = P;
		}
		int [] dp = new int [N+2];
		
		int max = -1;
		for(int i=1; i<N+2; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
			//arr[i][0]은 상담 소요 시간
			int day = arr[i][0]+i;
			if(day<N+2) {
				//N일 안에 상담을 완료할 수 있다.
				
				dp[day] = Math.max(dp[day],max+arr[i][1]);
			}
			
		}
		
		
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}


}
