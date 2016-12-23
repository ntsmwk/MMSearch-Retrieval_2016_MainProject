package at.jku.mmsearchretrieval.project.features.image.model;

/**
 * Represents the color moment of a given image. The color moment consists of
 * the three moments - Mean, Standard Deviation and Skewness. for each RGB
 * component.
 * 
 * @author Markus
 *
 */
public class ImageFeatureCM extends ImageFeature {
	private RGBColorMoment rgbColorMoment;

	public ImageFeatureCM(String imageId, RGBColorMoment rgbColorMoment) {
		this.imageId = imageId;
		this.rgbColorMoment = rgbColorMoment;
	}

	public RGBColorMoment getRgbColorMoment() {
		return rgbColorMoment;
	}

	public void setRgbColorMoment(RGBColorMoment rgbColorMoment) {
		this.rgbColorMoment = rgbColorMoment;
	}

}
