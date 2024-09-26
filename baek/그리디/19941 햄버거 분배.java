import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] map, cnt;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String [] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		String row = br.readLine();
		boolean [] checked = new boolean [N];
		
		for(int i=0; i<N; i++) {
			char now = row.charAt(i);
			if(now=='P') checked[i] = true;
		}
		int cnt =0;
		loop: for(int i=0; i<N; i++) {
			char now = row.charAt(i);
			if(now=='P') {
				for(int j=-K; j<0; j++) {
					if(i+j>=0 && !checked[i+j]) {
						checked[i+j]=true;
						cnt++;
						continue loop;
					}
				}
				for(int j=1; j<=K; j++) {
					if(i+j<N && !checked[i+j]) {
						checked[i+j]=true;
						cnt++;
						continue loop;
					}
				}
			}
		}
		System.out.println(cnt);
		
	}

}
