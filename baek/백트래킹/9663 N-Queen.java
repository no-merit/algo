import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.ScatteringByteChannel;

public class Main {
	static StringBuilder sb;
	static int N, cnt;
	static int[] table;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		// NxN의 체스판위에 퀸 N개가 서로 공격할 수 없게
		table = new int[N];
		cnt=0;
		dfs(0);
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int depth) {
		if(depth==N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check(depth,i)) {
				table[depth] = i;  
				dfs(depth+1);
			}
		}

	}

	static boolean check(int depth,int i) {
		
		for(int j=depth-1;j>=0; j--) {
			int c = depth - j;
			int r = Math.abs(i-table[j]);
			if(r==0 || (c-r)==0) {
				return false;
			}
		}
		return true;
	}

}
