
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String [] nums = br.readLine().split(" ");
		
		int N = Integer.parseInt(nums[0]);
		int K = Integer.parseInt(nums[1]);
		
		boolean [] prime = new boolean[N+1];
		
		prime[0] = prime[1] = true;
		int cnt=0;
		loop: for(int i=2; i<=N; i++) {
			for(int j=i;j<=N;j+=i) {
				if(!prime[j]) {
					cnt++;
					prime[j]=true;
				}
				if(cnt==K) {
					sb.append(j);
					break loop;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
