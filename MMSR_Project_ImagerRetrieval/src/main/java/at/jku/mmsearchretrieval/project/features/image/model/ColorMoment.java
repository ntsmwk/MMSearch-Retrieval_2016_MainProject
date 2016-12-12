package at.jku.mmsearchretrieval.project.features.image.model;

/**
 * The color moment represents the three moments - mean, standard deviation and skewness
 * for one color.
 * @author Markus
 *
 */
public class ColorMoment {
	
	private double mean;
	private double standardDeviation;
	private double skewness;
	
	public ColorMoment(double mean, double standardDeviation, double skewness) {
		this.mean = mean;
		this.standardDeviation = standardDeviation;
		this.skewness = skewness;
	}
	
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public double getSkewness() {
		return skewness;
	}
	public void setSkewness(double skewness) {
		this.skewness = skewness;
	}
}
