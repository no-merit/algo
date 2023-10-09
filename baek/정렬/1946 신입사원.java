import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 공간의 크기 N
 * 
 * */



public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			// 지원자의 수. 1~100,000
			int [] vt = new int[N+1];
			for(int i=0; i<N; i++) {
				String [] row = br.readLine().split(" ");
				vt[Integer.parseInt(row[0])] = Integer.parseInt(row[1]);
			}//서류심사 성적을 idx로 해서 입력해서 서류성적 순 정렬이됨
			int average = vt[1];
			int ans = 1;

      //서류 점수를 인덱스로 삼으면 값을 입력받으면서 자동으로 정렬됨 << 발상이 대단하다
      //적어도 하나라도 다른 지원자보다 순위가 높다면 합격
      //서류 순으로 정렬했으니 서류 1등의 면접 순위보다 높은 애는 살아남음 << 서류 2등이 1등보다 면접이 낮다면 죽음
      //서류 1등보다 면접이 낮은 (내림차순 정렬했으니까 그런 애들중에서는 서류가 제일 높은) 애들 중 1등보다 면접이 높은 애를 이제 다음 기준으로 삼음
      //그 다음 애보다 면접이 높은 애(다음 기준보다 서류는 낮지만 면접은 높은 애를 찾아야함<- 1등보다는 면접이 당연히 높아짐. 다음 기준이 된 애가 1등보다 면접이 높으므로)

      
			for(int i=2;i<=N; i++ ) {
				if(vt[i] < average) {
					ans++;
					average = vt[i];
				}
			}
			
			
			sb.append(ans).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
