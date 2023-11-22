import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		//동전은 N 종류, 가치의 합을 K로 만들려고함 동전 개수의 최솟값
		
		String [] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]); //동전의 종류 , 1~10
		int K = Integer.parseInt(NK[1]); //가치의 합 , 1~100,000,000
		
		//동전의 가치
		int [] Arr = new int[N];
		//동전의 가치 배열 1~1,000,000 Ao = 1
		for(int i=0; i<N;i++) {
			String coin = br.readLine();
			Arr[i] = Integer.parseInt(coin);
		}
		int cnt =0;
		for(int i=N-1; i>=0; i--) {
			if(K/Arr[i]<0) continue;
			else {
				int tmp=K/Arr[i];
				cnt+=tmp;
				K-=tmp*Arr[i];
			}
		}
			System.out.println(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	

}
