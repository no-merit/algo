
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String origin = br.readLine();
		int[] arr = new int[26];
		int len = origin.length();
		int ans = 0;
		for (int i = 0; i < len; i++) {
			char idx = origin.charAt(i);
			arr[idx - 'A']++;
		}

		for (int i = 1; i < N; i++) {
			String now = br.readLine();
			int now_len = now.length();
			if (now_len > len + 1 || now_len < len - 1) {
				continue;
			} else if(now_len+1==len || now_len-1==len) {
				int[] tmp = new int[26];
				for (int j = 0; j < now_len; j++) {
					char idx = now.charAt(j);
					tmp[idx - 'A']++;
				}
				int cnt = 0;
				for (int j = 0; j < 26; j++) {
					cnt += Math.abs(arr[j] - tmp[j]);
				}
				if (cnt <= 1)
					ans++;
			}
				else {
				int[] tmp = new int[26];
				for (int j = 0; j < now_len; j++) {
					char idx = now.charAt(j);
					tmp[idx - 'A']++;
				}
				int cnt = 0;
				for (int j = 0; j < 26; j++) {
					cnt += Math.abs(arr[j] - tmp[j]);
				}
				if (cnt <= 2)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
