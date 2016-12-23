package at.jku.mmsearchretrieval.project.features.image.model;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Hashtable;
import java.util.List;

/**
 * Represent 11 statistics  
 * - SRE   Short Run Emphasis
 * - LRE   Long Run Emphasis
 * - GLN   Gray-Level Non-uniformity
 * - RLN   Run Length Non-uniformity
 * - RP    Run Percentage
 * - LGRE  Low Gray-level Run Emphasis
 * - HGRE  High Gray-level Run Emphasis
 * - SRLGE Short Run Low Gray-level Emphasis
 * - SRHGE Short Run High Gray-level Emphasis
 * - LRLGE Long Run Low Gray-Level Emphasis
 * - LRHGE Long Run High Gray-Level Emphasis
 * for 4 different directions (0°, 45°, 90° and 135°)
 *
 */
public class ImageFeatureGLRLM extends ImageFeature {

	private Hashtable<Integer, GrayLevelRunLengthMatriceStatistic> grayLevelRunLengthMatriceStatistics = new Hashtable<Integer, GrayLevelRunLengthMatriceStatistic>();

	public ImageFeatureGLRLM(long imageId, List<GrayLevelRunLengthMatriceStatistic> grayLevelRunLengthMatriceStatistics){
		this.imageId = imageId;
		for(GrayLevelRunLengthMatriceStatistic statistic : grayLevelRunLengthMatriceStatistics){
			this.grayLevelRunLengthMatriceStatistics.put(statistic.getDegree(), statistic);
		}
	}

	public Hashtable<Integer, GrayLevelRunLengthMatriceStatistic> getGrayLevelRunLengthMatriceStatistics() {
		return grayLevelRunLengthMatriceStatistics;
	}
	
	public GrayLevelRunLengthMatriceStatistic getGrayLevelRunLengthMatriceStatisticByDegree(int degree){
		if(grayLevelRunLengthMatriceStatistics.containsKey(degree)){
			return grayLevelRunLengthMatriceStatistics.get(degree);
		}
		throw new UnsupportedOperationException("Degree is not allowed!");
	}
	
	
}
