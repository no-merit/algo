import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Main {
	static StringBuilder sb;
	static int N;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		//한번에 1개 or 2개 한 계단을 밟으면 이어서 다음/ 다다음 계단
		//연속된 세개의 계단을 밟는 경우는 없음
		//마지막 계단은 반드시 밟음
		
		//마지막 계단을 밟는 경우
		//전: 1전 밟는 경우 전전: 2전을 무조건 밟음
		//전: 2칸전을 밟는 경우 
		N = Integer.parseInt(br.readLine());
		int [] dp = new int [N+1];
		int [] stair = new int [N];
		for(int i=0; i<N; i++) {
			int sss = Integer.parseInt(br.readLine());
			stair[i]= sss; 
		}
		if(N<3) {
			int ans =0;
			for(int i=0; i<N; i++) {
				ans+=stair[i];
			}
			System.out.println(ans);
			System.exit(0);
		}
		dp[0]=0;
		dp[1]=stair[0];
		dp[2]=stair[0]+stair[1];
		for(int i=3; i<=N; i++) {
			dp[i]= Math.max(dp[i-3]+stair[i-2]+stair[i-1], dp[i-2]+stair[i-1]);
			
		}
		sb.append(dp[N]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}


}
