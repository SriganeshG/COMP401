package a8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorWidget extends JPanel implements MouseListener {

	private PictureView pictureView;
	private JPanel infoPanel;
	private JLabel xLabel;
	private JLabel yLabel;
	private JLabel redLabel;
	private JLabel greenLabel;
	private JLabel blueLabel;
	private JLabel brightnessLabel;

	public PixelInspectorWidget(Picture picture) {

		setLayout(new BorderLayout());

		pictureView = new PictureView(picture.createObservable());
		pictureView.addMouseListener(this);

		// Create left panel of information
		infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(150, picture.getHeight()));
		infoPanel.setLayout(new GridLayout(6, 1));

		// Create labels for left panel
		xLabel = new JLabel("X: ");
		yLabel = new JLabel("Y: ");
		redLabel = new JLabel("Red: ");
		greenLabel = new JLabel("Green: ");
		blueLabel = new JLabel("Blue: ");
		brightnessLabel = new JLabel("Brightness: ");

		// Add all labels to left panel
		infoPanel.add(xLabel);
		infoPanel.add(yLabel);
		infoPanel.add(redLabel);
		infoPanel.add(greenLabel);
		infoPanel.add(blueLabel);
		infoPanel.add(brightnessLabel);

		// Add left panel and picture to widget
		add(infoPanel, BorderLayout.WEST);
		add(pictureView, BorderLayout.EAST);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Coordinate selected = new Coordinate(e.getX(), e.getY());

		// Get RGB component information
		String redInfo = String.format("Red: %.2f", pictureView.getPicture().getPixel(selected).getRed());
		String greenInfo = String.format("Green %.2f", pictureView.getPicture().getPixel(selected).getGreen());
		String blueInfo = String.format("Blue: %.2f", pictureView.getPicture().getPixel(selected).getBlue());
		String brightnessInfo = String.format("Brightness: %.2f",
				pictureView.getPicture().getPixel(selected).getIntensity());

		// Set to display X, Y position and RGB information
		xLabel.setText("X: " + e.getX());
		yLabel.setText("Y: " + e.getY());
		redLabel.setText(redInfo);
		greenLabel.setText(greenInfo);
		blueLabel.setText(blueInfo);
		brightnessLabel.setText(brightnessInfo);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
