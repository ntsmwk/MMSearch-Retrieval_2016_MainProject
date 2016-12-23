package at.jku.mmsearchretrieval.project.features.image.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import at.jku.mmsearchretrieval.project.features.image.model.ColorHistogram;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCN3x3;

public class ImageFeatureCN3x3Comparator extends ImageFeatureComparator<ImageFeatureCN3x3> {

	@Override
	public List<ImageFeatureCN3x3> compareImageFeature(ImageFeatureCN3x3 feature, List<ImageFeatureCN3x3> featureList) {
		SortedMap<Double, ImageFeatureCN3x3> sortedMap = new TreeMap<Double, ImageFeatureCN3x3>();
		for (ImageFeatureCN3x3 f : featureList) {
			sortedMap.put(compareRGBColorMoment3x3(f.getColorHistogram3x3(), feature.getColorHistogram3x3()), f);
		}

		return new ArrayList<ImageFeatureCN3x3>(sortedMap.values());
	}

	private Double compareRGBColorMoment3x3(ColorHistogram[][] colorHistogram3x3,
			ColorHistogram[][] colorHistogram3x32) {
		double value = 0.0;
		for(int i = 0; i < colorHistogram3x3.length; i++){
			for(int j = 0; j < colorHistogram3x3[i].length; j++){
				value += compareColorHistogram(colorHistogram3x3[i][j], colorHistogram3x32[i][j]);
			}
		}
		return value/(colorHistogram3x3.length * colorHistogram3x3[0].length);
	}
	private Double compareColorHistogram(ColorHistogram colorHistogram, ColorHistogram colorHistogram2) {
		double value = 0.0;
		for(int i = 0; i < colorHistogram.getColorHistogramList().size(); i++){
			value += Math.pow(colorHistogram.getColorHistogramList().get(i) - colorHistogram2.getColorHistogramList().get(i), 2);
		}
		return Math.sqrt(value);
	}

}
