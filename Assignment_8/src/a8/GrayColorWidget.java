package a8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.JToggleButton;

public class GrayColorWidget extends JPanel implements MouseListener, ActionListener {
	private PictureView picture_view;
	private Picture color;
	private Picture gray;
	private JToggleButton toggle;
	private JLabel coordinate;
	
	public GrayColorWidget(Picture picture) {
		setLayout(new BorderLayout());
		
		picture_view = new PictureView(picture.createObservable());
		picture_view.addMouseListener(this);
		add(picture_view, BorderLayout.CENTER);
		
		coordinate = new JLabel("X: , Y: ");
		add(coordinate, BorderLayout.SOUTH);
		
		toggle = new JToggleButton("Color");
		toggle.setPreferredSize(new Dimension(100, 40));
		toggle.addActionListener(this);
		add(toggle, BorderLayout.WEST);
		
		color = picture;
		gray = new PictureImpl(color.getWidth(), color.getHeight());
		for (int i = 0; i < gray.getWidth(); ++i) {
			for (int j = 0; j < gray.getHeight(); ++j) {
				gray.setPixel(i , j, new GrayPixel(color.getPixel(i, j).getIntensity()));
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		coordinate.setText("X: " + e.getX() + ", Y: " + e.getY());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        boolean selected = toggle.getModel().isSelected();
        if (selected) {
        	toggle.setText("grayscale");
        	picture_view.setPicture(gray.createObservable());
        } else {
        	toggle.setText("color");
        	picture_view.setPicture(color.createObservable());
        }
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
