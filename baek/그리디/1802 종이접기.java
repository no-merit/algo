package java23;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String now = br.readLine();
			if (check(now)) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.print(sb.toString());

	}

	static boolean check(String tc) {
		int len = tc.length();
		if (len > 1) {
			int half = len / 2;
			if (!check(tc.substring(0, half))) {
				return false;
			}
			if (!check(tc.substring(half + 1))) {
				return false;
			}
			for (int i = 1; i <= half; i++) {
				if (tc.charAt(half - i) == tc.charAt(half + i)) {
					return false;
				}
			}

		}

		return true;
	}

}
