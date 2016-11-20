package a8;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class A8PixelInspector {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Picture p = A8Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		PixelInspector simple_widget = new PixelInspector(p, "<html>X: <br> Y: <br> R: <br> G: <br> B: <br> Brightness: </html>");
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 8 Pixel Inspector");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(simple_widget, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);

	}

}
