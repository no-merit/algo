import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;



public class Main {
	static StringBuilder sb;
	static int[] A, B, tmp;
	static int N, ans;
	static boolean[] checked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		tmp = new int[N];
		checked = new boolean[N];
		String[] arr1 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(arr1[i]);
		}

		B = new int[N];
		String[] arr2 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(arr2[i]);

		}
		Arrays.sort(A);
		Arrays.sort(B);
		ans =0;
		for(int i=0; i<N; i++) {
			ans+=A[i]*B[N-1-i];
		}
		
		sb.append(ans);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
