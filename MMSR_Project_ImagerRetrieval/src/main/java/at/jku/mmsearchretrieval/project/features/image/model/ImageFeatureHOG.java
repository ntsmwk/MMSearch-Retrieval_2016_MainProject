package at.jku.mmsearchretrieval.project.features.image.model;

/**
 * Represents a histogram of oriented gradients computed on 3x3 image regions.
 * We use 9 bin histogram for each cell which is (probably) L2 normalized 
 * @author Markus
 *
 */
public class ImageFeatureHOG extends ImageFeature {
	
	private HistogramOfOrientedGradients[][] histogramOfOrientedGradients;

	public ImageFeatureHOG(long imageId, HistogramOfOrientedGradients[][] histogramOfOrientedGradients) {
		this.imageId = imageId;
		this.histogramOfOrientedGradients = histogramOfOrientedGradients;
	}

	public HistogramOfOrientedGradients[][] getHistogramOfOrientedGradients() {
		return histogramOfOrientedGradients;
	}	
}
