import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//1초 1억
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int N =Integer.parseInt(br.readLine());
		//이동하려는 채널
		int M = Integer.parseInt(br.readLine());
		//고장난 버튼의 개수
		String [] str = br.readLine().split(" ");
		boolean[] chk = new boolean[10];
		for(int i=0; i<str.length; i++) {
			int now = Integer.parseInt(str[i]);
			chk[now] = true;
		}
		int result = Math.abs(N-100);
		
		for(int i=0; i<=999999; i++) {
			String num = String.valueOf(i);
			int length = num.length();
			boolean flag = false;
			for(int j=0; j<length; j++) {
				char now = num.charAt(j);
				if(chk[now-'0']) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				int ans = Math.abs(N-i)+length;
				result = Math.min(result, ans);
			}
			
			
		}
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	
}
