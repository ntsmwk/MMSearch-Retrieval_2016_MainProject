package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.List;

/**
 * The colorHistogram consists of the relative values for the 11 colors - black,
 * blue, brown, grey, green, oragne, pink, purple, red, white, yellow.
 * 
 * @author Markus
 *
 */
public class ColorHistogram {

	private List<Double> colorHistogramList;

	public ColorHistogram(List<Double> colorHistogramList) {
		if (colorHistogramList.size() != 11) {
			throw new UnsupportedOperationException("Color histogram consists has to consist of exactly 11 values");
		}
		this.colorHistogramList = colorHistogramList;
	}

	public List<Double> getColorHistogramList() {
		return colorHistogramList;
	}

	public double getSingleColorHistogramValue(ColorIndex index) {
		return colorHistogramList.get(index.value);
	}

	public enum ColorIndex {
		BLACK(0), BLUE(1), BROWN(2), GREY(3), GREEN(4), ORANGE(5), PINK(6), PURPLE(7), RED(8), WHITE(9), YELLOW(10);

		private final int value;

		private ColorIndex(int value) {
			this.value = value;
		}
	}
}
