package at.jku.mmsearchretrieval.project.features.image.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import at.jku.mmsearchretrieval.project.features.image.model.ColorHistogram;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCN;

public class ImageFeatureCNComparator extends ImageFeatureComparator<ImageFeatureCN> {

	@Override
	public List<ImageFeatureCN> compareImageFeature(ImageFeatureCN feature, List<ImageFeatureCN> featureList) {
		SortedMap<Double, ImageFeatureCN> sortedMap = new TreeMap<Double, ImageFeatureCN>();
		for (ImageFeatureCN f : featureList) {
			sortedMap.put(compareColorHistogram(f.getColorHistogram(), feature.getColorHistogram()), f);
		}
		return new ArrayList<ImageFeatureCN>(sortedMap.values());
	}

	private Double compareColorHistogram(ColorHistogram colorHistogram, ColorHistogram colorHistogram2) {
		double value = 0.0;
		for(int i = 0; i < colorHistogram.getColorHistogramList().size(); i++){
			value += Math.pow(colorHistogram.getColorHistogramList().get(i) - colorHistogram2.getColorHistogramList().get(i), 2);
		}
		return Math.sqrt(value);
	}
}
