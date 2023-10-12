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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			list.add(str);
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}else {
					int sum1 =0;
					int sum2 =0;
					for(int i=0; i<o1.length(); i++) {
						if(o1.charAt(i)>='0' && o1.charAt(i)<='9') {
							sum1+=Integer.parseInt(String.valueOf(o1.charAt(i)));
						}
					}
					for(int i=0; i<o1.length(); i++) {
						if(o2.charAt(i)>='0' && o2.charAt(i)<='9') {
							sum2+=Integer.parseInt(String.valueOf(o2.charAt(i)));
						}
					}
					if(sum1 != sum2) {
						return sum1 -sum2;
					}else {
						return o1.compareTo(o2);
					}
				}
			}
			
		});
		for(int i=0; i<N; i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
