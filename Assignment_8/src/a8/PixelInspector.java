package a8;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspector extends JPanel implements MouseListener {
	private PictureView picture_view;
	private JLabel coordinate;
	private Picture p;
	DecimalFormat f = new DecimalFormat("##.00");
	public PixelInspector(Picture picture, String title) {
		setLayout(new BorderLayout());

		picture_view = new PictureView(picture.createObservable());
		picture_view.addMouseListener(this);
		add(picture_view, BorderLayout.CENTER);

		coordinate = new JLabel(title);
		add(coordinate, BorderLayout.WEST);

		p = picture;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		coordinate.setText("<html>X: " + e.getX() + "<br> Y: " + e.getY() + "<br> R: "
				+ f.format(p.getPixel(e.getX(), e.getY()).getRed()) + "<br> G: " + f.format(p.getPixel(e.getX(), e.getY()).getGreen())
				+ "<br> B: " + f.format(p.getPixel(e.getX(), e.getY()).getBlue()) + "<br> Brightness: "+f.format(p.getPixel(e.getX(), e.getY()).getIntensity())+"</html>");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
