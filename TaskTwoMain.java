import java.util.ArrayList;
import java.util.Vector;

public class TaskTwoMain {
	public static void main(String[] args) {
		String keyword = "ivan";

		String s = "ivan\n" + "evnh\n" + "inav\n" + "mvvn\n" + "qrit\n" + "navi";

		TaskTwo tt = new TaskTwo(convert(s), keyword);
		System.out.println("Result: " + tt.find());
	}

	private static ArrayList<ArrayList<Character>> convert(String table) {
		ArrayList<ArrayList<Character>> convertedTable = new ArrayList<ArrayList<Character>>();
		String keyword = "ivan";
		int rowCounter = 0;
		convertedTable.add(new ArrayList<Character>());

		for (int i = 0; i < table.length(); i++) {
			if (table.charAt(i) != '\n') {
				convertedTable.get(rowCounter).add(table.charAt(i));
				// System.out.println(table.get(rowCounter));
			} else {
				rowCounter++;
				convertedTable.add(new ArrayList<Character>());
			}
		}
		return convertedTable;
	}
}
