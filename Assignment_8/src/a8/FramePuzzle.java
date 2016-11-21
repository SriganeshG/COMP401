package a8;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class FramePuzzle extends JPanel implements KeyListener,MouseListener {
	private PictureView picture_view;
	private Picture done, blank;
	private Picture[][] picPuzzle;
	private int tileWidth, tileHeight;
	private int blankX, blankY;
	
	public FramePuzzle(Picture p) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		//5x5 gride
		picPuzzle = new Picture[5][5];
		tileWidth = p.getWidth()/5;
		tileHeight = p.getHeight()/5;
		blankX = 4;
		blankY = 4;
		blank = new PictureImpl(tileWidth,tileHeight);
		//setting up the tiles

		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				Picture sectionPic = p.extract(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
				picPuzzle[i][j] = sectionPic;
			}
		}
		//empty square is now blue
		for(int i =0;i<blank.getWidth();i++){
			for(int j=0;j<blank.getHeight();j++){
				blank.setPixel(i,j, new ColorPixel(0.0,0.0,1.0)); //blue is best color
			}
		}
		picPuzzle[4][4] = blank; //blank
		done = setPicture(picPuzzle);//set picture creates puzzle
		picture_view = new PictureView(done.createObservable());
		picture_view.addMouseListener(this);
		picture_view.addKeyListener(this);
		picture_view.setFocusable(true);
		add(picture_view);
		
	}
	//after changes, this 
	private Picture setPicture(Picture[][] picture) {
		Picture pOut = new PictureImpl(tileWidth * 5, tileHeight * 5);
		for (int x = 0; x < pOut.getWidth(); x++) {
			for (int y = 0; y < pOut.getHeight(); y++) {
				Pixel p = picture[x / tileWidth][y / tileHeight].getPixel(x % tileWidth, y % tileHeight);
				pOut.setPixel(x, y, p);
			}
		}

		return pOut;
	}
	//this changes the tile order, by swapping with an adjacent tile
	private void changeUpdate(int x0, int y0, int x1, int y1) {
		Picture temp = blank;
		picPuzzle[x0][y0] = picPuzzle[x1][y1]; //the swappening
		picPuzzle[x1][y1] = temp;
		done = setPicture(picPuzzle);
		picture_view.setPicture(done.createObservable());
	}
	@Override
	//method for registering key presses
	public void keyPressed(KeyEvent e) {
		//when key gets pressed, which case will trigger
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT://left end
			if (blankX > 0) {
				changeUpdate(blankX, blankY, blankX - 1, blankY);
				blankX--;
			}
			break;
		case KeyEvent.VK_RIGHT://right end
			if (blankX < 4) {
				changeUpdate(blankX, blankY, blankX + 1, blankY);
				blankX++;
			}
			break;
		case KeyEvent.VK_UP://top end
			if (blankY > 0) {
				changeUpdate(blankX, blankY, blankX, blankY - 1);
				blankY--;
			}
			break;
			
		case KeyEvent.VK_DOWN://bottom end
			if (blankY < 4) {
				changeUpdate(blankX, blankY, blankX, blankY + 1);
				blankY++;
			}
			break;
		}
	}

	@Override
	//kind of like key presses, but for mouse
	//TODO: Diagonal swapping. Currently program cant swap blue tile if you click diagonally. can implement this later for fun 
	
	public void mouseClicked(MouseEvent e) {
		int clickedX = e.getX() / tileWidth;
		int clickedY = e.getY() / tileHeight;

		if (clickedX == blankX || clickedY == blankY) {
			//swaps on direction, left (click left, swap that direction)
			if (clickedX < blankX) {
				int timesSwapped = blankX - clickedX;
				for (int i = 0; i < timesSwapped; i++) {
					changeUpdate(blankX, blankY, blankX - 1, blankY);
					blankX--;
				}
			} else {//swap right
				int numberOfSwaps = clickedX - blankX;
				for (int i = 0; i < numberOfSwaps; i++) {
					changeUpdate(blankX, blankY, blankX + 1, blankY);
					blankX++;
				}
			}
			//same logic as above, vertical directions this time
			if (clickedY < blankY) {//swap up
				int numberOfSwaps = blankY - clickedY;
				for (int i = 0; i < numberOfSwaps; i++) {
					changeUpdate(blankX, blankY, blankX, blankY - 1);
					blankY--;
				}
			} else {//swap down
				int numberOfSwaps = clickedY - blankY;
				for (int i = 0; i < numberOfSwaps; i++) {
					changeUpdate(blankX, blankY, blankX, blankY + 1);
					blankY++;
				}
			}
		}

	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
