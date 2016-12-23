package at.jku.mmsearchretrieval.project.features.image.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import at.jku.mmsearchretrieval.project.features.image.model.ColorMoment;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCM3x3;
import at.jku.mmsearchretrieval.project.features.image.model.RGBColorMoment;

public class ImageFeatureCM3x3Comparator extends ImageFeatureComparator<ImageFeatureCM3x3> {

	@Override
	public List<ImageFeatureCM3x3> compareImageFeature(ImageFeatureCM3x3 feature, List<ImageFeatureCM3x3> featureList) {
		SortedMap<Double, ImageFeatureCM3x3> sortedMap = new TreeMap<Double, ImageFeatureCM3x3>();
		for (ImageFeatureCM3x3 f : featureList) {
			sortedMap.put(compareRGBColorMoment3x3(f.getColorMoments(), feature.getColorMoments()), f);
		}

		return new ArrayList<ImageFeatureCM3x3>(sortedMap.values());

	}

	private double compareRGBColorMoment3x3(RGBColorMoment[][] colorMoment1, RGBColorMoment[][] colorMoment2) {
		double value = 0.0;
		for(int i = 0; i < colorMoment1.length; i++){
			for(int j = 0; j < colorMoment1[i].length; j++){
				value += compareRGBColorMoment(colorMoment1[i][j], colorMoment2[i][j]);
			}
		}
		return value/(colorMoment1.length * colorMoment1[0].length);
	}

	private double compareRGBColorMoment(RGBColorMoment colorMoment1, RGBColorMoment colorMoment2) {
		double value = 0.0;
		value += compareColorMoment(colorMoment1.getrColorMoment(), colorMoment1.getrColorMoment());
		value += compareColorMoment(colorMoment1.getgColorMoment(), colorMoment1.getgColorMoment());
		value += compareColorMoment(colorMoment1.getbColorMoment(), colorMoment1.getbColorMoment());

		return value / 3;
	}

	private double compareColorMoment(ColorMoment colorMoment1, ColorMoment colorMoment2) {
		double value = Math.pow(colorMoment1.getMean() - colorMoment2.getMean(), 2)
				+ Math.pow(colorMoment1.getStandardDeviation() - colorMoment2.getStandardDeviation(), 2)
				+ Math.pow(colorMoment1.getSkewness() - colorMoment2.getSkewness(), 2);
		return Math.sqrt(value);
	}

}
