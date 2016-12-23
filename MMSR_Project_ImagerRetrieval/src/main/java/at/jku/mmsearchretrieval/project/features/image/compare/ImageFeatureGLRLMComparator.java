package at.jku.mmsearchretrieval.project.features.image.compare;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import at.jku.mmsearchretrieval.project.features.image.model.GrayLevelRunLengthMatriceStatistic;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureGLRLM;

public class ImageFeatureGLRLMComparator extends ImageFeatureComparator<ImageFeatureGLRLM> {

	@Override
	public List<ImageFeatureGLRLM> compareImageFeature(ImageFeatureGLRLM feature, List<ImageFeatureGLRLM> featureList) {
		SortedMap<Double, ImageFeatureGLRLM> sortedMap = new TreeMap<Double, ImageFeatureGLRLM>();
		for (ImageFeatureGLRLM f : featureList) {
			sortedMap.put(compareGLRLMs(f.getGrayLevelRunLengthMatriceStatistics(),
					feature.getGrayLevelRunLengthMatriceStatistics()), f);
		}
		return new ArrayList<ImageFeatureGLRLM>(sortedMap.values());
	}

	private Double compareGLRLMs(
			Hashtable<Integer, GrayLevelRunLengthMatriceStatistic> grayLevelRunLengthMatriceStatistics,
			Hashtable<Integer, GrayLevelRunLengthMatriceStatistic> grayLevelRunLengthMatriceStatistics2) {
		double value = 0.0;
		for (int i : grayLevelRunLengthMatriceStatistics.keySet()) {
			value += compareGLRLM(grayLevelRunLengthMatriceStatistics.get(i),
					grayLevelRunLengthMatriceStatistics2.get(i));
		}
		return value / grayLevelRunLengthMatriceStatistics.size();
	}

	private double compareGLRLM(GrayLevelRunLengthMatriceStatistic grayLevelRunLengthMatriceStatistic,
			GrayLevelRunLengthMatriceStatistic grayLevelRunLengthMatriceStatistic2) {
		double value = 0.0;
		for (int i = 0; i < grayLevelRunLengthMatriceStatistic.getGrayLevelRunLengthMatriceStatistics().size(); i++) {
			value += Math.pow(grayLevelRunLengthMatriceStatistic.getGrayLevelRunLengthMatriceStatistics().get(i)
					- grayLevelRunLengthMatriceStatistic2.getGrayLevelRunLengthMatriceStatistics().get(i), 2);
		}
		return Math.sqrt(value);
	}

}
