import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String N = br.readLine();
		
		int [] sum = new int[N.length()+1];
		int [] arr = new int[N.length()+1];
		for(int i=1; i<=N.length();i++) {
			int now = (int)N.charAt(i-1)-'0';
			arr[i] = now;
			sum[i]=sum[i-1]+now;
		}
		
		sum[0] = 0;
		int ans =0;
		for(int i=1; i<=N.length();i++) {
			for(int j=0;j<i;j++) {
				int left = sum[i]-sum[i-(j+1)];
				if(i+j+1>N.length()) break;
				int right = sum[i+j+1]-sum[i];
				if(left==right) ans = Math.max(ans, 2*(j+1));
			}
		}
		System.out.println(ans);
		
	}
}
