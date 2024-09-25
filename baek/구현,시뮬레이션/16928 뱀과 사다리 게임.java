import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int [] map,cnt;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		map = new int [101];
		cnt = new int [101];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		for(int i=0; i<101; i++) {
			map[i] = i;
		}
		
		String [] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		
		for(int i=0; i<N+M; i++) {
			String [] se = br.readLine().split(" ");
			int st = Integer.parseInt(se[0]);
			int ed = Integer.parseInt(se[1]);
			
			map[st] = ed;
		}
		
		
		max = Integer.MAX_VALUE;
		dfs(1,1);
		System.out.println(max);
		
	}
	private static void dfs(int st,int now) {
		if(map[st]==100) {
			max = Math.min(max,cnt[st]);
			return;
		}
		
		
		
		for(int i=1;i<7;i++) {
			if(st+i>100) continue;
			if(cnt[st+i]>now) {
				cnt[st+i] = now;
				dfs(map[st+i],now+1);
//				System.out.println("st: "+ st + " map[st+i]: "+ map[st+i]+ " cnt:" + cnt[st+i]+" now: "+ now);
			}
		}
		
	}

}
