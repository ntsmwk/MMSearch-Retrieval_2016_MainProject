package at.jku.mmsearchretrieval.project.features.image.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import at.jku.mmsearchretrieval.project.features.image.model.ColorMoment;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCM;
import at.jku.mmsearchretrieval.project.features.image.model.RGBColorMoment;

public class ImageFeatureCMComparator extends ImageFeatureComparator<ImageFeatureCM> {

	@Override
	public List<ImageFeatureCM> compareImageFeature(ImageFeatureCM feature, List<ImageFeatureCM> featureList) {
		SortedMap<Double, ImageFeatureCM> sortedMap = new TreeMap<Double, ImageFeatureCM>();
		for (ImageFeatureCM f : featureList) {
			sortedMap.put(compareRGBColorMoment(f.getRgbColorMoment(), feature.getRgbColorMoment()), f);
		}

		return new ArrayList<ImageFeatureCM>(sortedMap.values());
	}

	private double compareRGBColorMoment(RGBColorMoment colorMoment1, RGBColorMoment colorMoment2) {
		double value = 0.0;
		value += compareColorMoment(colorMoment1.getrColorMoment(), colorMoment2.getrColorMoment());
		value += compareColorMoment(colorMoment1.getgColorMoment(), colorMoment2.getgColorMoment());
		value += compareColorMoment(colorMoment1.getbColorMoment(), colorMoment2.getbColorMoment());

		return value / 3.0;
	}

	private double compareColorMoment(ColorMoment colorMoment1, ColorMoment colorMoment2) {
		double value = Math.pow(colorMoment1.getMean() - colorMoment2.getMean(), 2)
				+ Math.pow(colorMoment1.getStandardDeviation() - colorMoment2.getStandardDeviation(), 2)
				+ Math.pow(colorMoment1.getSkewness() - colorMoment2.getSkewness(), 2);
		return Math.sqrt(value);
	}

}
