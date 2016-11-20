package a8;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePuzzleMain {

	public static void main(String[] args) throws IOException {
		Picture picture = A8Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		FramePuzzleWidget puzzle = new FramePuzzleWidget(picture);

		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 8 Frame Puzzle");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel main_panel = new JPanel();
		main_panel.setLayout(new BorderLayout());
		main_panel.add(puzzle, BorderLayout.CENTER);
		main_frame.setContentPane(main_panel);

		main_frame.pack();
		main_frame.setVisible(true);
	}

}
