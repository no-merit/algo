import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class wrap implements Comparable<wrap> {
	String value;
	int idx;

	wrap(String value, int idx) {
		this.value = value;
		this.idx = idx;
	}

	@Override
	public int compareTo(wrap o) {
		// TODO Auto-generated method stub
		return this.value.compareTo(o.value);
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<String> origin = new ArrayList<>();
		List<wrap> sortList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			origin.add(input);
			sortList.add(new wrap(input, i));
		}
		Collections.sort(sortList);
		int save = -1;
		int []save_arr=new int[] {}; 
		loop: for (int i = 0; i < N; i++) {
			wrap now = sortList.get(i);
			int next = i + 1;
			while (next < N) {
				wrap nxwr = sortList.get(next);
				int cnt = 0;
				for (int k = 0; k < now.value.length(); k++) {
					if (now.value.charAt(k) == nxwr.value.charAt(k)) {
						cnt++;
					} else {
						break;
					}
				}
				if (cnt > save) {
					save = cnt;
					if(now.idx<nxwr.idx) {
						save_arr = new int [] {now.idx,nxwr.idx};
					}else {
						save_arr = new int [] {nxwr.idx,now.idx};
					}
					next++;
				} else if (cnt == save) {
					if(now.idx<nxwr.idx) {
						if(save_arr[0]>now.idx) {
							save_arr = new int [] {now.idx,nxwr.idx};
						}else if(save_arr[0]==now.idx){
							if(save_arr[1]>nxwr.idx) {
								save_arr = new int [] {now.idx,nxwr.idx};
							}
						}
					}else {
						if(save_arr[0]>nxwr.idx) {
							save_arr = new int [] {nxwr.idx,now.idx};
						}else if(save_arr[0]==nxwr.idx){
							if(save_arr[1]>now.idx) {
								save_arr = new int [] {nxwr.idx,now.idx};
							}
						}
					}
					next++;
				} else {
					continue loop;
				}
			}
		}
		sb.append(origin.get(save_arr[0])).append("\n").append(origin.get(save_arr[1]));
		System.out.println(sb.toString());
	}
}
