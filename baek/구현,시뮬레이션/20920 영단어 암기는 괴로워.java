import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		for(int i=0; i<100001; i++) {
			list.add(new ArrayList<>());
		}
		
		HashMap<String, Integer> map = new HashMap<>();
		int max = 1;
		for(int i=0; i<N; i++) {
			String now = br.readLine();
			int length = now.length();
			if(length>=M) {
				if(map.containsKey(now)) {
					int get = map.get(now);
					list.get(get).remove(now);
					map.put(now, get+1);
					list.get(get+1).add(now);
					if(max<get+1) max = get+1;
				}else {
					map.put(now, 1);
					list.get(1).add(now);
					
					
				}
			}
		}
		
		
		
		for(int i=max; i>=1; i--) {
			Collections.sort(list.get(i), new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o1.length()==o2.length()) {
						return o1.compareTo(o2);
					}
					return o2.length()-o1.length();
				}
				
			});

				
		}
			
		for(int i=max; i>=1; i--) {
			if(list.get(i).size()==0) continue;
			for(int j=0; j<list.get(i).size();j++) {
				sb.append(list.get(i).get(j)).append("\n");
			}
		
		}
		System.out.println(sb.toString());
	}

}
