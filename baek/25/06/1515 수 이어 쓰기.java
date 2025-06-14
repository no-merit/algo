import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int num_idx = 0;
		int input_idx = 0;
		while(input_idx<input.length()) {
			num_idx++;
			String num = String.valueOf(num_idx);
			for(int i=0;i<num.length();i++) {
				if(input_idx<input.length() && num.charAt(i)==input.charAt(input_idx)) {
					input_idx++;
				}
			}
		}
		System.out.println(num_idx);
	}
}
