import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] ABC = br.readLine().split(" ");
		int A = Integer.parseInt(ABC[0]);
		int B = Integer.parseInt(ABC[1]);
		int C = Integer.parseInt(ABC[2]);
		String[] As = br.readLine().split(" ");
		String[] Bs = br.readLine().split(" ");
		String[] Cs = br.readLine().split(" ");
		int[] A_arr = new int[A];
		int[] B_arr = new int[B];
		int[] C_arr = new int[C];

		for (int i = 0; i < A; i++) {
			A_arr[i] = Integer.parseInt(As[i]);
		}
		for (int i = 0; i < B; i++) {
			B_arr[i] = Integer.parseInt(Bs[i]);
		}
		for (int i = 0; i < C; i++) {
			C_arr[i] = Integer.parseInt(Cs[i]);
		}
		Arrays.sort(A_arr);
		Arrays.sort(B_arr);
		Arrays.sort(C_arr);
		int pa = 0, pb = 0, pc =0;
		int min = Integer.MAX_VALUE;
		while(pa<A &&pb<B &&pc<C) {
			int now_a = A_arr[pa];
			int now_b = B_arr[pb];
			int now_c = C_arr[pc];
			
			int tmp_max = Math.max(now_a, Math.max(now_b, now_c));
			int tmp_min = Math.min(now_a, Math.min(now_b, now_c));
			
			min  =Math.min(min, tmp_max-tmp_min);
			if(tmp_min==now_a) {
				pa++;
			}else if(tmp_min==now_b) {
				pb++;
			}else {
				pc++;
			}
		}
		System.out.println(min);
	}
}
