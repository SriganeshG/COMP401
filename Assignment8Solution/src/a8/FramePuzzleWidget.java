package a8;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class FramePuzzleWidget extends JPanel implements MouseListener, KeyListener {

	private PictureView pictureView;
	private Picture empty;
	private Picture composed;
	private Picture[][] pictureGrid;
	private int singleWidth;
	private int singleHeight;
	private int emptyX;
	private int emptyY;

	public FramePuzzleWidget(Picture picture) {
		setLayout(new BorderLayout());

		pictureGrid = new Picture[5][5];
		singleWidth = picture.getWidth() / 5;
		singleHeight = picture.getHeight() / 5;
		emptyX = 4;
		emptyY = 4;
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				Picture extraction = picture.extract(x * singleWidth, y * singleHeight, singleWidth, singleHeight);
				pictureGrid[x][y] = extraction;
			}
		}
		empty = new PictureImpl(singleWidth, singleHeight);
		// Initialize empty square to green
		for (int x = 0; x < empty.getWidth(); x++) {
			for (int y = 0; y < empty.getHeight(); y++) {
				empty.setPixel(x, y, new ColorPixel(0.0, 1.0, 0.0));
			}
		}

		pictureGrid[4][4] = empty;
		composed = composePicture(pictureGrid);

		pictureView = new PictureView(composed.createObservable());
		pictureView.setFocusable(true);
		pictureView.addMouseListener(this);
		pictureView.addKeyListener(this);
		add(pictureView);

	}

	@Override
	// On mouse click, move empty square
	public void mouseClicked(MouseEvent e) {
		int clickedX = e.getX() / singleWidth;
		int clickedY = e.getY() / singleHeight;

		if (clickedX == emptyX || clickedY == emptyY) {

			if (clickedX < emptyX) { // Click left of empty square, swap left
				int numberOfSwaps = emptyX - clickedX;
				for (int i = 0; i < numberOfSwaps; i++) {
					swapAndUpdate(emptyX, emptyY, emptyX - 1, emptyY);
					emptyX--;
				}
			} else { // Click right of empty square, swap right
				int numberOfSwaps = clickedX - emptyX;
				for (int i = 0; i < numberOfSwaps; i++) {
					swapAndUpdate(emptyX, emptyY, emptyX + 1, emptyY);
					emptyX++;
				}
			}

			if (clickedY < emptyY) { // Click above empty square, swap up
				int numberOfSwaps = emptyY - clickedY;
				for (int i = 0; i < numberOfSwaps; i++) {
					swapAndUpdate(emptyX, emptyY, emptyX, emptyY - 1);
					emptyY--;
				}
			} else { // Click below empty square, swap down
				int numberOfSwaps = clickedY - emptyY;
				for (int i = 0; i < numberOfSwaps; i++) {
					swapAndUpdate(emptyX, emptyY, emptyX, emptyY + 1);
					emptyY++;
				}
			}
		}

	}

	@Override
	// On key press, swap square with adjacent square
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (emptyX > 0) { // Check left boundary
				swapAndUpdate(emptyX, emptyY, emptyX - 1, emptyY);
				emptyX--;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (emptyX < 4) { // Check right boundary
				swapAndUpdate(emptyX, emptyY, emptyX + 1, emptyY);
				emptyX++;
			}
			break;
		case KeyEvent.VK_UP:
			if (emptyY > 0) { // Check top boundary
				swapAndUpdate(emptyX, emptyY, emptyX, emptyY - 1);
				emptyY--;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (emptyY < 4) { // Check bottom boundary
				swapAndUpdate(emptyX, emptyY, emptyX, emptyY + 1);
				emptyY++;
			}
			break;
		}

	}

	// Helper method to compose new PictureView after changes
	private Picture composePicture(Picture[][] picture) {
		Picture temp = new PictureImpl(singleWidth * 5, singleHeight * 5);
		for (int x = 0; x < temp.getWidth(); x++) {
			for (int y = 0; y < temp.getHeight(); y++) {
				Pixel p = picture[x / singleWidth][y / singleHeight].getPixel(x % singleWidth, y % singleHeight);
				temp.setPixel(x, y, p);
			}
		}

		return temp;
	}

	// Helper method to swap grid pictures and update pictureView's picture
	private void swapAndUpdate(int x0, int y0, int x1, int y1) {
		Picture temp = empty;
		pictureGrid[x0][y0] = pictureGrid[x1][y1];
		pictureGrid[x1][y1] = temp;
		composed = composePicture(pictureGrid);
		pictureView.setPicture(composed.createObservable());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

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
