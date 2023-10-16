import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//좌표 압축의 결과 X' 는 Xi>Xj를 만 족하는 서로 다른 좌표 Xj의 개수
		int N = Integer.parseInt(br.readLine());
		//숫자의 개수
		
		String [] nums = br.readLine().split(" ");
		
		int [] num = new int[N];
		int [] copy = new int [N];
		//숫자들의 순위를 매겨야함 
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(nums[i]);
			copy[i] = Integer.parseInt(nums[i]);
		}
		
		Arrays.sort(num);
		//오름차순으로 정렬해서 순위를 매김
		
		//중복되는 숫자가 있으므로 중복을 허용하지 않고 숫자를 key로 가지고 순위를 value로 가지는 map 생성 
		HashMap<Integer,Integer> map = new HashMap<>();
		int rank =0;
		
		for(int i=0; i<N; i++) {
			if(!map.containsKey(num[i])) {
			map.put(num[i],rank++);
			}
		}
		
		for(int i=0; i<N; i++) {
			copy[i] = map.get(copy[i]);
		}//숫자에 맞는 순위를 집어넣음
		
		for(int i=0; i<N; i++) {
			sb.append(copy[i]).append(" ");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
