package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.ArrayList;

/**
 * This feature contains the color structure descriptor (CSD). 
 * The CSD is calculated by dividing the picture into 8x8 rasters 
 * and increases the count by 1 of the color Cm if it is contained in the raster.
 * In our case we have 64 colors (m= 0 ... 63).
 * Multiple occurrences of colors are not counted.
 * @author Markus
 *
 */
public class ImageFeatureCSD extends ImageFeature {
	private ColorStructureDescriptor colorStructureDescriptor;

	public ImageFeatureCSD(String imageId, ColorStructureDescriptor colorStructureDescriptor, ArrayList<Double> rawValues) {
		this.imageId = imageId;
		this.colorStructureDescriptor = colorStructureDescriptor;
		this.rawValues = rawValues;
	}

	public ColorStructureDescriptor getColorStructureDescriptor() {
		return colorStructureDescriptor;
	}
}
