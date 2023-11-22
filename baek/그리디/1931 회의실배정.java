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

		
		int N = Integer.parseInt(br.readLine());
		
		int [][] meeting = new int[N][2];
		for(int i=0; i<N; i++) {
			String [] se = br.readLine().split(" ");
			int st = Integer.parseInt(se[0]);
			int ed = Integer.parseInt(se[1]);
			meeting[i][0] = st;
			meeting[i][1] = ed;
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});
		
		int cnt =0;
		int end =0;
		for(int i=0; i<N; i++) {
			if(end<=meeting[i][0]) {
				end=meeting[i][1];
				cnt++;
			}
		}
		
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
