package at.jku.mmsearchretrieval.project.features.image.model;

/**
 * Represents the color naming histogram of a given image. The colorHistogram
 * consists of the relative values for the 11 colors - black, blue, brown, grey,
 * green, oragne, pink, purple, red, white, yellow.
 * 
 * @author Markus
 *
 */
public class ImageFeatureCN extends ImageFeature {

	private ColorHistogram colorHistogram;

	public ImageFeatureCN(String imageId, ColorHistogram colorHistogram) {
		this.imageId = imageId;
		this.colorHistogram = colorHistogram;
	}

	public ColorHistogram getColorHistogram() {
		return colorHistogram;
	}
}
