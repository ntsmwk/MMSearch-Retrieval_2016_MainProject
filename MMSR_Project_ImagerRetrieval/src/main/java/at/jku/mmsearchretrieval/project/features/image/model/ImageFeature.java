package at.jku.mmsearchretrieval.project.features.image.model;

import java.util.ArrayList;

public abstract class ImageFeature {
	protected String imageId;
	protected ArrayList<Double> rawValues;
	private int cluster_number = 0;
	
	public String getImageId() {
		return imageId;
	}

	public ArrayList<Double> getRawValues() {
		return rawValues;
	}

	public void setRawValues(ArrayList<Double> rawValues) {
		this.rawValues = rawValues;
	}

	public void setCluster(int n) {
		this.cluster_number = n;
	}

	public int getCluster() {
		return this.cluster_number;
	}

	// Calculates the distance between two points.
	public static double distance(ImageFeature p, ImageFeature centroid) {
		double distance = 0.0;
		for (int i = 0; i < p.getRawValues().size(); i++) {
			distance += Math.pow(centroid.getRawValues().get(i) - p.getRawValues().get(i), 2);
		}
		return Math.sqrt(distance);
	}
}
