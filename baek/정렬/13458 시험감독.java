import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		String[] cr = br.readLine().split(" ");
		// cr.length() = N

		String[] sv = br.readLine().split(" ");
		// supervisor[0] = 총감독관, [1]부 감독관
		long cnt = 0; 
    
    // 사이즈가 너무 커서 long으로 했어야함
    
		int main_sv = Integer.parseInt(sv[0]);
		int sub_sv = Integer.parseInt(sv[1]);

		for (int i = 0; i < N; i++) {
			int st_cnt = Integer.parseInt(cr[i]);
			st_cnt -= main_sv;
			cnt++;

      //조건들 생각 잘해보기
      
			if (st_cnt > 0) {
				if (st_cnt / sub_sv <= 0) {
					cnt++;
					continue;
				} else {
					if ((st_cnt % sub_sv) == 0) {
						cnt += st_cnt / sub_sv;
					} else {
						cnt += st_cnt / sub_sv + 1;
					}
				}
			}
		}
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
