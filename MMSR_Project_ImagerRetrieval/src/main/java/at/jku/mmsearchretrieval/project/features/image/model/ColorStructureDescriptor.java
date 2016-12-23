package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.List;

/**
 * The CSD is calculated by dividing the picture into 8x8 rasters 
 * and increases the count by 1 of the color Cm if it is contained in the raster.
 * In our case we have 64 colors (m= 0 ... 63).
 * @author Markus
 *
 */
public class ColorStructureDescriptor {

	private static final int COLOR_STUCTURE_DESCRIPTOR_COLOR_BINS = 64;
	private List<Double> colorStructureDescriptor;

	public ColorStructureDescriptor(List<Double> colorStructureDescriptor) {
		if(colorStructureDescriptor.size() != COLOR_STUCTURE_DESCRIPTOR_COLOR_BINS){
			throw new UnsupportedOperationException("Only color structure descriptor with exactly 64 values is allowed!");
		}
		this.colorStructureDescriptor = colorStructureDescriptor;
	}

	public List<Double> getColorStructureDescriptor() {
		return colorStructureDescriptor;
	}
}
