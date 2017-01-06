package at.jku.mmsearchretrieval.project.features.image.clustering;

import java.util.ArrayList;
import java.util.List;

import at.jku.mmsearchretrieval.project.features.image.model.ImageFeature;

public class Cluster {
	public List<ImageFeature> vectors;
	public ImageFeature centroid;
	public int id;

	// Creates a new Cluster
	public Cluster(int id) {
		this.id = id;
		this.vectors = new ArrayList<>();
		this.centroid = null;
	}

	public List<ImageFeature> getVectors() {
		return vectors;
	}

	public void addPoint(ImageFeature point) {
		vectors.add(point);
	}

	public void setPoints(List<ImageFeature> vectors) {
		this.vectors = vectors;
	}

	public ImageFeature getCentroid() {
		return centroid;
	}

	public void setCentroid(ImageFeature centroid) {
		this.centroid = centroid;
	}

	public int getId() {
		return id;
	}

	public void clear() {
		vectors.clear();
	}

	public void plotCluster() {
		System.out.println("[Cluster: " + id + "]");
		System.out.println("[Centroid: " + centroid + "]");
		System.out.println("[Points: \n");
		for (ImageFeature p : vectors) {
			System.out.println(p.getRawValues());
		}
		System.out.println("]");
	}
}
