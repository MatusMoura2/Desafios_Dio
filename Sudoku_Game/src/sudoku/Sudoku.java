package sudoku;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sudoku {
	class Tille extends JButton {
		int rowNumber;
		int columnNumber;

		public Tille(int rowNumber, int columnNumber) {
			super();
			this.rowNumber = rowNumber;
			this.columnNumber = columnNumber;
		}

	}

	int boardWidth = 600;
	int boardHeight = 650;

	String[] puzzle = { "--74916-5", "2---6-3-9", "-----7-1-", "-586---4-", "---3--9--", "--62-187-", "9-4-7---2",
			"67-83----", "81--45---" };

	String[] solution = { "387491625", "241568379", "569327418", "758612934", "123784596", "496253187", "934176852",
			"675832941", "812945763" };

	JFrame frame = new JFrame("SUDOKU GAME");
	JLabel textLabel = new JLabel();
	JPanel textPanel = new JPanel();
	JPanel boardPanel = new JPanel();

	public Sudoku() {
		frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		textLabel.setFont(new Font("Arial", Font.BOLD, 30));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setText("Sudoku: 0");

		textPanel.add(textLabel);
		frame.add(textPanel, BorderLayout.NORTH);

		boardPanel.setLayout(new GridLayout(9, 9));
		setupTiles();
		frame.add(boardPanel,BorderLayout.CENTER);
	}

	void setupTiles() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				Tille tille = new Tille(r, c);
				char tilleChar = puzzle[r].charAt(c);
				tille.setText(String.valueOf(tilleChar));
				boardPanel.add(tille);
			}
		}
	}
}
