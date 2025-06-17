import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] alphabet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		alphabet = new boolean[26];

		for (int i = 0; i < N; i++) {
			String[] now = br.readLine().split(" ");
			int len = now.length;// Save , Save As, Save All
			int init_idx = -1;
			for (int j = 0; j < len; j++) {
				String curr = now[j];
				char cap = curr.charAt(0);
				if (cap >= 'A' && cap <= 'Z') {
					if (!alphabet[cap - 'A']) {
						alphabet[cap - 'A'] = true;
						init_idx = j;
						break;
					}
				}else {
					if (!alphabet[cap - 'a']) {
						alphabet[cap - 'a'] = true;
						init_idx = j;
						break;
					}
				}
			}

			if (init_idx != -1) {
				for (int j = 0; j < len; j++) {
					String key = Character.toString(now[j].charAt(0));
					if (j == init_idx) {
						sb.append("[" + key + "]" + now[j].substring(1)+" ");
					} else {
						sb.append(now[j] + " ");
					}
				}
			} else {
				int piece = -1;
				int piece_idx= -1;
				loop : for (int j = 0; j < len; j++) {
					String curr = now[j];
					for(int k =0; k<curr.length();k++) {
						char cap = curr.charAt(k);
						if (cap >= 'A' && cap <= 'Z') {
							if (!alphabet[cap - 'A']) {
								alphabet[cap - 'A'] = true;
								piece = j;
								piece_idx = k;
								break loop;
							}
						}else {
							if (!alphabet[cap - 'a']) {
								alphabet[cap - 'a'] = true;
								piece = j;
								piece_idx = k;
								break loop;
							}
						}
					}
				}
				if(piece!=-1) {
					for(int j=0;j<len;j++) {
						if(j==piece) {
							String str = now[j];
							String key = Character.toString(str.charAt(piece_idx));
							sb.append(str.substring(0,piece_idx)+"["+key+"]"+str.substring(piece_idx+1)+" ");
						}else {
							sb.append(now[j]+" ");
						}
								
					}
				}else {
					for(int j=0;j<len;j++) {
						sb.append(now[j]+" ");
					}
				}
			}
			sb.append("\n");
		}
System.out.println(sb.toString());
	}
}
