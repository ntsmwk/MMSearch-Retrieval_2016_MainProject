package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.ArrayList;

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

	public ImageFeatureCM(String imageId, RGBColorMoment rgbColorMoment, ArrayList<Double> rawValues) {
		this.imageId = imageId;
		this.rgbColorMoment = rgbColorMoment;
		this.rawValues = rawValues;
	}

	public RGBColorMoment getRgbColorMoment() {
		return rgbColorMoment;
	}

	public void setRgbColorMoment(RGBColorMoment rgbColorMoment) {
		this.rgbColorMoment = rgbColorMoment;
	}

}
