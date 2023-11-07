import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
	static StringBuilder sb;
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		sudoku(0, 0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static void sudoku(int row, int col) {
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}

		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		if (map[row][col] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (test(row, col, k)) {
					map[row][col] = k;
					sudoku(row, col+1);
				}
			}
			map[row][col]=0;
			return;
		}

		sudoku(row, col + 1);

	}

	private static boolean test(int row, int col, int value) {
			for (int i = 0; i < 9; i++) {
				if (map[row][i] == value) {
					return false;
				}
			}
	 
			for (int i = 0; i < 9; i++) {
				if (map[i][col] == value) {
					return false;
				}
			}
	 
			int set_row = (row / 3) * 3;
			int set_col = (col / 3) * 3; 
	 
			for (int i = set_row; i < set_row + 3; i++) {
				for (int j = set_col; j < set_col + 3; j++) {
					if (map[i][j] == value) {
						return false;
					}
				}
			}
	 
			return true;
		}
	

}
