import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String [] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		HashSet<String> set = new HashSet<>();
		
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());	
		}
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			String str= br.readLine();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		//사전순으로 출력하기 위해
		sb.append(list.size()).append("\n");
		
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
