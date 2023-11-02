import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb;
	static int [] prime;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		//1~1,000,000
		String [] nums = br.readLine().split(" ");
		int [] num = new int [N];
		
		prime = new int[5000001];
		//500만까지의 최대공약수 구하기
    
		for(int i=2; i<prime.length; i++) {
			prime[i]=i;
		}//자기자신으로 초기화
		
		for(int i=2; i*i<prime.length; i++) {
			for(int j=i*i; j<prime.length; j+=i) {
				if(prime[j]==j) {
					prime[j]=i;
				}
			}
		}//최대공약수 구하기
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(nums[i]);
			prime_factorization(now);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void prime_factorization(int n) {
		while(n>1) {
			sb.append(prime[n]).append(" ");
			n = n/prime[n]; //최대공약수 입력하고 나누기
		}
		sb.append("\n");
	}
}
