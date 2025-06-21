package sudoku;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Sudoku {
	
	int boardWidth = 600;
	int boardHeight = 650;
	
	JFrame frame = new JFrame("SUDOKU GAME");
	
	public Sudoku(){
		frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
	}
}
