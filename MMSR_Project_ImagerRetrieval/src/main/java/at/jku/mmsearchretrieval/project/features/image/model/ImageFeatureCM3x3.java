package at.jku.mmsearchretrieval.project.features.image.model;

/**
 * Represents the color moment of a given image which is split into a 3x3
 * blocks. Therefore we have 9 color moments for each color component (R, G, B)
 * ==> 27 CM's The color moment consists of the three moments - Mean, Standard
 * Deviation and Skewness - for each RGB component.
 * 
 * @author Markus
 *
 */
public class ImageFeatureCM3x3 extends ImageFeature {

	private RGBColorMoment[][] colorMoments3x3;

	public ImageFeatureCM3x3(RGBColorMoment[][] colorMoments3x3) {
		super();
		this.colorMoments3x3 = colorMoments3x3;
	}

	public RGBColorMoment[][] getColorMoments() {
		return colorMoments3x3;
	}
}
