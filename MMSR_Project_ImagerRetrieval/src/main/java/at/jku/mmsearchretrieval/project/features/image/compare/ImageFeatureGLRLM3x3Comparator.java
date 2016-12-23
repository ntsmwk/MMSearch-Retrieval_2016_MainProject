package at.jku.mmsearchretrieval.project.features.image.compare;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import at.jku.mmsearchretrieval.project.features.image.model.GrayLevelRunLengthMatriceStatistic;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureGLRLM3x3;

public class ImageFeatureGLRLM3x3Comparator extends ImageFeatureComparator<ImageFeatureGLRLM3x3> {

	@Override
	public List<ImageFeatureGLRLM3x3> compareImageFeature(ImageFeatureGLRLM3x3 feature,
			List<ImageFeatureGLRLM3x3> featureList) {
		SortedMap<Double, ImageFeatureGLRLM3x3> sortedMap = new TreeMap<Double, ImageFeatureGLRLM3x3>();
		for (ImageFeatureGLRLM3x3 f : featureList) {
			sortedMap.put(compareGLRLM3x3(f.getGrayLevelRunLengthMatriceStatistics(),
					feature.getGrayLevelRunLengthMatriceStatistics()), f);
		}

		return new ArrayList<ImageFeatureGLRLM3x3>(sortedMap.values());
	}

	private Double compareGLRLM3x3(
			Hashtable<Integer, GrayLevelRunLengthMatriceStatistic>[][] grayLevelRunLengthMatriceStatistics,
			Hashtable<Integer, GrayLevelRunLengthMatriceStatistic>[][] grayLevelRunLengthMatriceStatistics2) {
		double value = 0.0;
		for (int i = 0; i < grayLevelRunLengthMatriceStatistics.length; i++) {
			for (int j = 0; j < grayLevelRunLengthMatriceStatistics[i].length; j++) {
				value += compareGLRLMs(grayLevelRunLengthMatriceStatistics[i][j],
						grayLevelRunLengthMatriceStatistics2[i][j]);
			}
		}
		return value / (grayLevelRunLengthMatriceStatistics.length * grayLevelRunLengthMatriceStatistics[0].length);
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
