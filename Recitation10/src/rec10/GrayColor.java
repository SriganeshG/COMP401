package a8;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GrayColor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Picture p = A8Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		GrayColorWidget gc_widget = new GrayColorWidget(p);
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Recitation 10 Example");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(gc_widget, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
		
		
	}

}
