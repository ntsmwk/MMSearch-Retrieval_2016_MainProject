package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.List;

public class HistogramOfOrientedGradients {

	private static final int HISTOGRAM_OF_ORIENTED_GRADIENTS_SIZE = 9;
	List<Double> histogramOfOrientedGradients;

	public HistogramOfOrientedGradients(List<Double> histogramOfOrientedGradients) {
		if(histogramOfOrientedGradients.size()!= HISTOGRAM_OF_ORIENTED_GRADIENTS_SIZE){
			throw new UnsupportedOperationException("Only allowed size: " + HISTOGRAM_OF_ORIENTED_GRADIENTS_SIZE);
		}
		this.histogramOfOrientedGradients = histogramOfOrientedGradients;
	}	
}
