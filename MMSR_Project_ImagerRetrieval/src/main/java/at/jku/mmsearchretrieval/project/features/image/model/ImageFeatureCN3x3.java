package at.jku.mmsearchretrieval.project.features.image.model;

/**
 * Represents the color histogram of a given image which is split into a 3x3
 * blocks. Therefore we have 9 color histograms containing each 11 relative color values
 * 
 * @author Markus
 *
 */
public class ImageFeatureCN3x3 extends ImageFeature {

	private ColorHistogram[][] colorHistogram3x3;

	public ImageFeatureCN3x3(String imageId, ColorHistogram[][] colorHistogram3x3) {
		this.imageId = imageId;
		this.colorHistogram3x3 = colorHistogram3x3;
	}

	public ColorHistogram[][] getColorHistogram3x3() {
		return colorHistogram3x3;
	}
}
