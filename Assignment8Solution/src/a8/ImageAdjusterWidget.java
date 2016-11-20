package a8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageAdjusterWidget extends JPanel implements ChangeListener {

	private PictureView pictureView;
	private Picture originalPicture;
	private JSlider blurSlider;
	private JSlider saturationSlider;
	private JSlider brightnessSlider;

	public ImageAdjusterWidget(Picture picture) {

		setLayout(new BorderLayout());

		pictureView = new PictureView(picture.createObservable());
		originalPicture = copy(picture);

		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridLayout(3, 1));

		// Create blur panel holding blur slider
		JPanel blurPanel = new JPanel();
		JLabel blurLabel = new JLabel("Blur: ");
		blurSlider = new JSlider(0, 5, 0);
		blurSlider.setMajorTickSpacing(1);
		blurSlider.setPaintTicks(true);
		blurSlider.setPaintLabels(true);
		blurSlider.setPreferredSize(new Dimension(picture.getWidth() - 30, 50));
		blurPanel.add(blurLabel, BorderLayout.WEST);
		blurPanel.add(blurSlider, BorderLayout.EAST);
		blurSlider.setSnapToTicks(true);
		blurSlider.addChangeListener(this);

		// Create saturation panel holding saturation slider
		JPanel saturationPanel = new JPanel();
		JLabel saturationLabel = new JLabel("Saturation: ");
		saturationSlider = new JSlider(-100, 100, 0);
		saturationSlider.setMajorTickSpacing(25);
		saturationSlider.setPaintTicks(true);
		saturationSlider.setPaintLabels(true);
		saturationSlider.setPreferredSize(new Dimension(picture.getWidth() - 70, 50));
		saturationPanel.add(saturationLabel, BorderLayout.WEST);
		saturationPanel.add(saturationSlider, BorderLayout.EAST);
		saturationSlider.addChangeListener(this);

		// Create brightness panel holding brightness slider
		JPanel brightnessPanel = new JPanel();
		JLabel brightnessLabel = new JLabel("Brightness: ");
		brightnessSlider = new JSlider(-100, 100, 0);
		brightnessSlider.setMajorTickSpacing(25);
		brightnessSlider.setPaintTicks(true);
		brightnessSlider.setPaintLabels(true);
		brightnessSlider.setPreferredSize(new Dimension(picture.getWidth() - 70, 50));
		brightnessPanel.add(brightnessLabel, BorderLayout.WEST);
		brightnessPanel.add(brightnessSlider, BorderLayout.EAST);
		brightnessSlider.addChangeListener(this);

		// Add all panels to main slider panel
		sliderPanel.add(blurPanel);
		sliderPanel.add(saturationPanel);
		sliderPanel.add(brightnessPanel);

		// Add picture and main slider panel to widget
		add(sliderPanel, BorderLayout.SOUTH);
		add(pictureView, BorderLayout.NORTH);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (!blurSlider.getValueIsAdjusting() && !saturationSlider.getValueIsAdjusting()
				&& !brightnessSlider.getValueIsAdjusting()) {

			Picture temp = blurPicture(originalPicture, blurSlider.getValue());
			temp = saturatePicture(temp, saturationSlider.getValue());
			temp = brightenPicture(temp, brightnessSlider.getValue());
			pictureView.setPicture(temp.createObservable());

		}

	}

	// Returns the blurred picture
	private static Picture blurPicture(Picture picture, int factor) {
		Picture blurredPicture = new PictureImpl(picture.getWidth(), picture.getHeight());
		for (int x = 0; x < blurredPicture.getWidth(); x++) {
			for (int y = 0; y < blurredPicture.getHeight(); y++) {

				int left, right, top, bottom, size;

				// Check for exceeding picture boundaries
				left = x - factor >= 0 ? x - factor : 0;
				right = x + factor <= blurredPicture.getWidth() - 1 ? x + factor : blurredPicture.getWidth() - 1;
				top = y - factor >= 0 ? y - factor : 0;
				bottom = y + factor <= blurredPicture.getHeight() - 1 ? y + factor : blurredPicture.getHeight() - 1;

				// "Square" area centered around pixel to be blurred
				size = (right - left + 1) * (bottom - top + 1);

				double red = 0, green = 0, blue = 0;

				for (int i = left; i <= right; i++) {
					for (int j = top; j <= bottom; j++) {
						red += picture.getPixel(i, j).getRed();
						green += picture.getPixel(i, j).getGreen();
						blue += picture.getPixel(i, j).getBlue();
					}
				}

				Pixel blurredPixel = new ColorPixel(red / size, green / size, blue / size);
				blurredPicture.setPixel(x, y, blurredPixel);
			}
		}

		return blurredPicture;
	}

	// Returns the saturated picture
	private static Picture saturatePicture(Picture picture, int factor) {
		Picture saturatedPicture = new PictureImpl(picture.getWidth(), picture.getHeight());
		for (int x = 0; x < picture.getWidth(); x++) {
			for (int y = 0; y < picture.getHeight(); y++) {
				saturatedPicture.setPixel(x, y, saturatePixel(picture.getPixel(x, y), factor));
			}
		}

		return saturatedPicture;
	}

	// Returns the brightened or darkened picture
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

	// Helper method for returning a single saturated pixel
	private static Pixel saturatePixel(Pixel p, int factor) {
		double red = computeSaturation(p, p.getRed(), factor);
		double green = computeSaturation(p, p.getGreen(), factor);
		double blue = computeSaturation(p, p.getBlue(), factor);

		return new ColorPixel(red, green, blue);
	}

	// Helper method for saturation formula
	private static double computeSaturation(Pixel p, double color, int factor) {
		if (factor <= 0) {
			return color * (1.0 + (factor / 100.0)) - (p.getIntensity() * factor / 100.0);
		} else {
			double largestPixel = Math.max(p.getRed(), p.getGreen());
			largestPixel = Math.max(largestPixel, p.getBlue());
			return color * ((largestPixel + ((1.0 - largestPixel) * (factor / 100.0))) / largestPixel);
		}
	}

	// Helper method for creating a copy of original picture
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
