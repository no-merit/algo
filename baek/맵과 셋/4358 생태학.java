
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		HashMap<String, Integer> map = new HashMap<>();
		int cnt=0;
		String str;
		while ((str = br.readLine())!=null) {
			map.put(str, map.getOrDefault(str, 0)+1);
			//getOrDefault 값이 있으면 get(str)을 하고 없으면 default 값인 0을 반환
			cnt++;
		}
		
		List<String> list = new ArrayList<>();
		for (String s : map.keySet()) {
			list.add(s);
		}
		
		Collections.sort(list);
		
		for (String tree : list) {
			int count = map.get(tree)*100;
			
			sb.append(tree+" "+String.format("%.4f", (double)count/(double)cnt)).append("\n");
			//String.format("%.4f", args)
		}
		

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
