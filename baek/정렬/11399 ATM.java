
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		// 사람은 1번부터 N번까지 번호
		// i번 사람이 돈을 인출하는데 pi분이 걸림
		// 사람의 수 1~1000
		// 각 사람이 돈을 인출하는데 걸리는 시간 pi 1~1000

		int N = Integer.parseInt(br.readLine());
		// 사람의 수
		List<Integer> people = new ArrayList<>();

		String[] times = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			people.add(Integer.parseInt(times[i]));
		}

		Collections.sort(people, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}

		});
		int[] sum = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				sum[i] += people.get(j);
			}
		}
		int ans=0;
		for(int i=0; i<N; i++) {
			ans+=sum[i];
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
