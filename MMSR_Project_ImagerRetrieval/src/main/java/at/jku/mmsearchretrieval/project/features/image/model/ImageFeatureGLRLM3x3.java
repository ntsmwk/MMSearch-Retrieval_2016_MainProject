package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.Hashtable;

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
 * for each of the 3x3 image parts ==> 9* 4 * 11 values
 *
 */
public class ImageFeatureGLRLM3x3 extends ImageFeature {

	Hashtable<Integer, GrayLevelRunLengthMatriceStatistic>[][] grayLevelRunLengthMatriceStatistics;

	public ImageFeatureGLRLM3x3(String imageId, 
			Hashtable<Integer, GrayLevelRunLengthMatriceStatistic>[][] grayLevelRunLengthMatriceStatistics) {
		this.imageId = imageId;
		this.grayLevelRunLengthMatriceStatistics = grayLevelRunLengthMatriceStatistics;
	}

	public Hashtable<Integer, GrayLevelRunLengthMatriceStatistic>[][] getGrayLevelRunLengthMatriceStatistics() {
		return grayLevelRunLengthMatriceStatistics;
	}	
}
