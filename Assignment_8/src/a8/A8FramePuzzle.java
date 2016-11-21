package a8;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class A8FramePuzzle {
	//thank you to some random sitterson person for helping me
	public static void main(String[] args) throws IOException{
	Picture picture = A8Helper.readFromURL("http://i.imgur.com/1vLLI3A.png");
	FramePuzzle puzzle = new FramePuzzle(picture);

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
