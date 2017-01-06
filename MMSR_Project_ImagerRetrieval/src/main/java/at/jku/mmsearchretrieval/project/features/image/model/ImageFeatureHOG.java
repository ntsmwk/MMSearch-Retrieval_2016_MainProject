package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.ArrayList;

/**
 * Represents a histogram of oriented gradients computed on 3x3 image regions.
 * We use 9 bin histogram for each cell which is (probably) L2 normalized 
 * @author Markus
 *
 */
public class ImageFeatureHOG extends ImageFeature {
	
	private HistogramOfOrientedGradients[][] histogramOfOrientedGradients;

	public ImageFeatureHOG(String imageId, HistogramOfOrientedGradients[][] histogramOfOrientedGradients, ArrayList<Double> rawValues) {
		this.imageId = imageId;
		this.histogramOfOrientedGradients = histogramOfOrientedGradients;
		this.rawValues = rawValues;
	}

	public HistogramOfOrientedGradients[][] getHistogramOfOrientedGradients() {
		return histogramOfOrientedGradients;
	}	
}
