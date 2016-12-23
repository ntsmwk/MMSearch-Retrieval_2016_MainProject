package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.List;

public class GrayLevelRunLengthMatriceStatistic {

	private static final int GRAY_LEVEL_RUN_LENGTH_MATRICE_STATISTIC_COUNT = 11;
	private int degree;
	private List<Double> grayLevelRunLengthMatriceStatistics;

	public GrayLevelRunLengthMatriceStatistic(int degree, List<Double> grayLevelRunLengthMatriceStatistics) {
		if (grayLevelRunLengthMatriceStatistics.size() != GRAY_LEVEL_RUN_LENGTH_MATRICE_STATISTIC_COUNT) {
			throw new UnsupportedOperationException(
					"Size has to be exactly " + GRAY_LEVEL_RUN_LENGTH_MATRICE_STATISTIC_COUNT);
		}
		this.degree = degree;
		this.grayLevelRunLengthMatriceStatistics = grayLevelRunLengthMatriceStatistics;
	}

	public List<Double> getGrayLevelRunLengthMatriceStatistics() {
		return grayLevelRunLengthMatriceStatistics;
	}

	public int getDegree() {
		return degree;
	}
}
