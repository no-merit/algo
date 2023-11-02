
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String [] nums = br.readLine().split(" ");
		
		int A = Integer.parseInt(nums[0]);
		int B = Integer.parseInt(nums[1]);
		int ori_A = A;
		int ori_B = B;
		
		while(B!=0) {
			int tmp = A%B;
			A = B;
			B=tmp;
		}
		sb.append(A).append("\n");
		sb.append(ori_A*ori_B/A);
		
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
