package java23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String [] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		//N,M 1~1,000
		
		
		String [] As = br.readLine().split(" ");
		List<Integer> As_list = new ArrayList<>();
		//A 1~1,000
		for(int i=0; i<N; i++) {
			As_list.add(Integer.parseInt(As[i]));
		}
		
		Collections.sort(As_list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1%10==0 && o2%10==0) {
					return (o1/10)-(o2/10);
				}else if(o1%10==0) {
					return -1;
				}else if(o2%10==0) {
					return 1;
				}else {
					return o1-o2;
				}
				
			}
			
		});
		int cnt =0;
		for(int i=0; i<N; i++) {
			int cake = As_list.get(i);
			if(cake==10) {
				cnt++;
				continue;
			}
			if(cake%10==0) {
				int piece = cake/10;
				if(M-(piece-1)>=0) {
					cnt+=piece;
					M=M-(piece-1);
				}else {
					cnt+=M;
					M=0;
				}
			}else {
				int piece = cake/10;
				if(M-piece>=0) {
					cnt+=piece;
					M=M-piece;
				}else {
					cnt+=M;
					M=0;
				}
			}
			
			if(M==0) break;
		}
		
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
