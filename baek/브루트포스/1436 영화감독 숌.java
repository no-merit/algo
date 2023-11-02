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

		int N = Integer.parseInt(br.readLine());
		//N 1~10,000
		/*666 1666 5666  6660 6666 6669 7666 9666 10666 15666 16660 16666
		 * */
		int cnt=1;
		int num=666;
		while(true) {
			if(cnt==N) {
				sb.append(num);
				break;
			}
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}


}
