import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//중복을 허용하지 않는 set과 앞에 들어간 요소를 체크할 stack을 이용해서 그 둘의 size를 비교했음 

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			Set<Character> map = new HashSet<>();
			for (int j = 0; j < str.length(); j++) {
				map.add(str.charAt(j));
			}
			Stack<Character> st = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				if (!st.isEmpty() && st.peek() == str.charAt(j)) {
					continue;
				} else {
					st.add(str.charAt(j));
				}
			}

			if (map.size() == st.size()) {
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
