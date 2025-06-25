import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class data implements Comparable<data> {
	int st;
	int ed;

	data(int st, int ed) {
		this.st = st;
		this.ed = ed;
	}

	@Override
	public int compareTo(data o) {
		if (this.st == o.st) {
			return o.ed - this.ed;
		}
		return this.st - o.st;
	}

}

public class Main {
	static int[] month = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int[] prefix_sum;
	static final int START = 60, END = 334;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prefix_sum = new int[13];
		for (int i = 1; i <= 12; i++) {
			prefix_sum[i] = prefix_sum[i - 1] + month[i-1];
		}
		int N = Integer.parseInt(br.readLine());
		List<data> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] flower = br.readLine().split(" ");
			int st_month = Integer.parseInt(flower[0]);
			int st_day = Integer.parseInt(flower[1]);
			int ed_month = Integer.parseInt(flower[2]);
			int ed_day = Integer.parseInt(flower[3]);
			int st = tranfer(st_month, st_day);
			int ed = tranfer(ed_month, ed_day);
			list.add(new data(st, ed));
		}
		
		Collections.sort(list);
		
		int current_end = START;
        int count = 0;
        int idx = 0;

        while (current_end <= END) {
            int max_reach_this_step = current_end;

            while (idx < N && list.get(idx).st <= current_end) {
                max_reach_this_step = Math.max(max_reach_this_step, list.get(idx).ed);
                idx++;
            }

            if (max_reach_this_step == current_end) {
                count = 0;
                break;
            }

            count++;
            current_end = max_reach_this_step;
        }

        if (current_end <= END) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
	}

	static int tranfer(int month, int day) {
		return prefix_sum[month - 1] + day;
	}
}
