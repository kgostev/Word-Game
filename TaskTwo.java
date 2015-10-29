import java.util.ArrayList;
import java.util.Vector;

public class TaskTwo {

	private ArrayList<ArrayList<Character>> table;
	private String keyword;

	public TaskTwo(ArrayList<ArrayList<Character>> table, String keyword) {
		this.table = table;
		this.keyword = keyword;
	}

	public int find() {
		int numberOfMatches = 0;
		numberOfMatches += findByRow();
		numberOfMatches += findByColumn();
		numberOfMatches += findByDiagonal();
		return numberOfMatches;
	}

	private int findByRow() {
		int numberOfMatches = 0;
		String rowWord = "";

		for (int i = 0; i < table.size(); i++) {
			for (int j = 0; j < table.get(i).size(); j++) {
				rowWord += table.get(i).get(j);
			}
			numberOfMatches += checkReverse(rowWord);
			if (rowWord.contains(keyword))
				numberOfMatches++;
			rowWord = "";
		}
		return numberOfMatches;
	}

	private int findByDiagonal() {
		int numberOfMatches = 0;
		String word = "";

		// left diagonal
		for (int counterY = 0; counterY < table.size(); counterY++) {
			for (int counterX = 0; counterX < table.get(counterY).size(); counterX++) {
				for (int i = counterY, j = counterX; i < table.size() && j < table.get(i).size(); i++, j++) {
					word += table.get(i).get(j);
				}
				// System.out.println(word);
				numberOfMatches += checkReverse(word);
				if (word.contains(keyword))
					numberOfMatches++;
				word = "";
			}
			// System.out.println();
		}

		// right diagonal
		for (int counterY = 0; counterY < table.size(); counterY++) {
			for (int counterX = table.get(counterY).size() - 1; counterX > -1; counterX--) {
				for (int i = counterY, j = counterX; i < table.size() && j > -1; i++, j--) {
					word += table.get(i).get(j);
				}
				// System.out.println(word);
				numberOfMatches += checkReverse(word);
				if (word.contains(keyword))
					numberOfMatches++;
				word = "";
			}
			// System.out.println();
		}

		return numberOfMatches;
	}

	private int findByColumn() {
		int numberOfMatches = 0;
		String columnWord = "";
		for (int i = 0; i < table.get(i).size(); i++) {
			for (int j = 0; j < table.size(); j++) {
				columnWord += table.get(j).get(i);
			}
			// System.out.println(columnWord);
			if (columnWord.contains(keyword))
				numberOfMatches++;
			columnWord = "";
		}
		for (int i = 0; i < table.get(i).size(); i++) {
			for (int j = table.size() - 1; j > -1; j--) {
				columnWord += table.get(j).get(i);
			}
			// System.out.println(columnWord);
			if (columnWord.contains(keyword))
				numberOfMatches++;
			columnWord = "";
		}

		return numberOfMatches;
	}

	private int checkReverse(String word) {
		String revercedWord = "";

		for (int i = word.length() - 1; i > -1; i--) {
			revercedWord += word.charAt(i);
		}
		// System.out.println(revercedWord);
		if (revercedWord.contains(keyword))
			return 1;
		else
			return 0;
	}
}
