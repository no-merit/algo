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

		//처음에 시작 시간 순으로 정렬해서 2중 for문을 썼는데 
		/*그러면 시간 초과가 생김. 
  			끝나는 시간 기준으로 정렬하면 끝나는 시간과 다음 시작하는 시간을 비교하면 되니까 1번 반복으로 끝남*/
		
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
