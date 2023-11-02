import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String [] str = br.readLine().split(":");
		
		int pre = Integer.parseInt(str[0]);
		int suf = Integer.parseInt(str[1]);
		int ori_pre =pre;
		int ori_suf =suf;
		
		//두 수의 최대 공약수로 나누기
		
		while(suf!=0) {
			int tmp = pre%suf;
			pre=suf;
			suf=tmp;
		}
		sb.append((ori_pre/pre)+":"+(ori_suf/pre));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	
}
