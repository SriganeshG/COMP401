package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageAdjustor extends JPanel implements ChangeListener {
	private PictureView picture_view;
	private JLabel blurT;
	private JLabel saturationT;
	private JLabel brightnessT;
	private Picture p;
	private JSlider blurS;
	private JSlider saturationS;
	private JSlider brightnessS;

	public ImageAdjustor(Picture picture) {
		setLayout(new BorderLayout());
		picture_view = new PictureView(picture.createObservable());
		p = picture;

		add(picture_view, BorderLayout.CENTER);

		blurS = new JSlider(0, 5, 0);
		saturationS = new JSlider(-100, 100, 0);
		brightnessS = new JSlider(-100, 100, 0);

		blurS.setMajorTickSpacing(1);
		blurS.setPaintTicks(true);
		blurS.setPaintLabels(true);
		blurS.setSnapToTicks(true);
		blurS.addChangeListener(this);

		saturationS.setMajorTickSpacing(25);
		saturationS.setPaintTicks(true);
		saturationS.setPaintLabels(true);
		saturationS.addChangeListener(this);
		
		brightnessS.setMajorTickSpacing(25);
		brightnessS.setPaintTicks(true);
		brightnessS.setPaintLabels(true);
		brightnessS.addChangeListener(this);

		JPanel sliders = new JPanel();
		sliders.setLayout(new GridLayout(3, 2));
		blurT = new JLabel("Blur: ");
		sliders.add(blurT);
		sliders.add(blurS);
		saturationT = new JLabel("Saturation: ");
		sliders.add(saturationT);
		sliders.add(saturationS);
		brightnessT = new JLabel("Brightness: ");
		sliders.add(brightnessT);
		sliders.add(brightnessS);
		add(sliders, BorderLayout.SOUTH);

		// blurT = new JLabel("Blur");
		// add(blurT, BorderLayout.WEST);
		//
		// blur = new JLabel();
		// add(blurS);

		// saturationT = new JLabel("Saturation");
		// add(saturationT);

	}

	private Picture blurCalc(Picture p, int blurFactor) {
		Picture blurredPicture = new PictureImpl(p.getWidth(), p.getHeight());
		for (int i = 0; i < blurredPicture.getWidth(); i++) {
			for (int j = 0; j < blurredPicture.getHeight(); j++) {
				int left, right, top, bottom, size;
				// Check for exceeding picture boundaries
				left = i - blurFactor >= 0 ? i - blurFactor : 0;
				right = i + blurFactor <= blurredPicture.getWidth() - 1 ? i + blurFactor
						: blurredPicture.getWidth() - 1;
				top = j - blurFactor >= 0 ? j - blurFactor : 0;
				bottom = j + blurFactor <= blurredPicture.getHeight() - 1 ? j + blurFactor
						: blurredPicture.getHeight() - 1;
				// "Square" area centered around pixel to be blurred
				size = (right - left + 1) * (bottom - top + 1);
				double red = 0, green = 0, blue = 0;
				for (int x = left; x <= right; x++) {
					for (int y = top; y <= bottom; y++) {
						red += p.getPixel(x, y).getRed();
						green += p.getPixel(x, y).getGreen();
						blue += p.getPixel(x, y).getBlue();
					}
				}
				Pixel blurredPixel = new ColorPixel(red / size, green / size, blue / size);
				blurredPicture.setPixel(i, j, blurredPixel);
			}
		}
		return blurredPicture;
	}
	
	private static Picture saturatePicture(Picture picture, int factor) {
		Picture saturatedPicture = new PictureImpl(picture.getWidth(), picture.getHeight());
		for (int x = 0; x < picture.getWidth(); x++) {
			for (int y = 0; y < picture.getHeight(); y++) {
				saturatedPicture.setPixel(x, y, saturatePixel(picture.getPixel(x, y), factor));
			}
		}

		return saturatedPicture;
	}
	
	private static Pixel saturatePixel(Pixel p, int factor) {
		double red = computeSaturation(p, p.getRed(), factor);
		double green = computeSaturation(p, p.getGreen(), factor);
		double blue = computeSaturation(p, p.getBlue(), factor);

		return new ColorPixel(red, green, blue);
	}
	
	private static double computeSaturation(Pixel p, double color, int factor) {
		if (factor <= 0) {
			return color * (1.0 + (factor / 100.0)) - (p.getIntensity() * factor / 100.0);
		} else {
			double largestPixel = Math.max(p.getRed(), p.getGreen());
			largestPixel = Math.max(largestPixel, p.getBlue());
			return color * ((largestPixel + ((1.0 - largestPixel) * (factor / 100.0))) / largestPixel);
		}
	}
	
	private static Picture brightenPicture(Picture picture, double factor) {
		Picture brightenedPicture = new PictureImpl(picture.getWidth(), picture.getHeight());
		for (int x = 0; x < brightenedPicture.getWidth(); x++) {
			for (int y = 0; y < brightenedPicture.getHeight(); y++) {
				if (factor >= 0) {
					brightenedPicture.setPixel(x, y, picture.getPixel(x, y).lighten(factor / 100.0));
				} else {
					brightenedPicture.setPixel(x, y, picture.getPixel(x, y).darken(Math.abs(factor / 100.0)));
				}
			}
		}

		return brightenedPicture;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		if (!blurS.getValueIsAdjusting() && !saturationS.getValueIsAdjusting() && !brightnessS.getValueIsAdjusting()) {

			Picture temp = blurCalc(p, blurS.getValue());
			temp = saturatePicture(temp, saturationS.getValue());
			temp = brightenPicture(temp, brightnessS.getValue());
			picture_view.setPicture(temp.createObservable());

		}
	}
	
	private static Picture copy(Picture picture) {
		Picture copy = new PictureImpl(picture.getWidth(), picture.getHeight());
		for (int x = 0; x < copy.getWidth(); x++) {
			for (int y = 0; y < copy.getHeight(); y++) {
				copy.setPixel(x, y, picture.getPixel(x, y));
			}
		}

		return copy;
	}

}
