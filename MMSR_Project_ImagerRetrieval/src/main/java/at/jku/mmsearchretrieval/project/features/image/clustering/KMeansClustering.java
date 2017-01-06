package at.jku.mmsearchretrieval.project.features.image.clustering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import at.jku.mmsearchretrieval.project.features.image.model.ImageFeature;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCentroid;

public class KMeansClustering {
	// Number of Clusters. This metric should be related to the number of points
	private int NUM_CLUSTERS = 20;

	private ArrayList<? extends ImageFeature> points;
	private List<Cluster> clusters;

	public KMeansClustering() {
		this.points = new ArrayList<>();
		this.clusters = new ArrayList<>();
	}

	// Initializes the process
	public void init(ArrayList<? extends ImageFeature> imageList){
		{
			this.points = imageList;
			// Create Clusters
			// Set First values as Centroids
			for (int i = 0; i < NUM_CLUSTERS; i++) {
				Cluster cluster = new Cluster(i);
				ImageFeature centroid = new ImageFeatureCentroid(imageList.get(i).getRawValues());
				cluster.setCentroid(centroid);
				clusters.add(cluster);
			}

			// Print Initial state
			plotClusters();
		}
	}

	private void plotClusters() {
		for (int i = 0; i < NUM_CLUSTERS; i++) {
			Cluster c = clusters.get(i);
			c.plotCluster();
		}
	}

	// The process to calculate the K Means, with iterating method.
	public void calculate() {
        boolean finish = false;
        int iteration = 0;
        
        // Add in new data, one at a time, recalculating centroids with each new one. 
        while(!finish) {
        	//Clear cluster state
        	clearClusters();
        	
        	List<ImageFeature> lastCentroids = getCentroids();
        	
        	//Assign points to the closer cluster
        	assignCluster();
            
            //Calculate new centroids.
        	calculateCentroids();
        	
        	iteration++;
        	
        	List<ImageFeature> currentCentroids = getCentroids();
        	
        	//Calculates total distance between new and old Centroids
        	double distance = 0;
        	for(int i = 0; i < lastCentroids.size(); i++) {
        		distance += ImageFeature.distance(lastCentroids.get(i),currentCentroids.get(i));
        	}
        	System.out.println("#################");
        	System.out.println("Iteration: " + iteration);
        	System.out.println("Centroid distances: " + distance);
        	plotClusters();
        	        	
        	if(distance == 0) {
        		finish = true;
        	}
        }
    }

	private void clearClusters() {
		for (Cluster cluster : clusters) {
			cluster.clear();
		}
	}

	private List<ImageFeature> getCentroids() {
		List<ImageFeature> centroids = new ArrayList<>(NUM_CLUSTERS);
		for (Cluster cluster : clusters) {
			ImageFeature aux = cluster.getCentroid();
			ImageFeature point = new ImageFeatureCentroid(aux.getRawValues());
			centroids.add(point);
		}
		return centroids;
	}

	private void assignCluster() {
		double max = Double.MAX_VALUE;
		double min = max;
		int cluster = 0;
		double distance = 0.0;

		for (ImageFeature point : points) {
			min = max;
			for (int i = 0; i < NUM_CLUSTERS; i++) {
				Cluster c = clusters.get(i);
				distance = ImageFeature.distance(point, c.getCentroid());
				if (distance < min) {
					min = distance;
					cluster = i;
				}
			}
			point.setCluster(cluster);
			clusters.get(cluster).addPoint(point);
		}
	}

	private void calculateCentroids() {
		for (Cluster cluster : clusters) {
			List<ImageFeature> list = cluster.getVectors();
			double[] newRawValues = new double[list.get(0).getRawValues().size()];
			
			int n_points = list.size();

			
			for (ImageFeature point : list) {
				for(int i = 0; i < point.getRawValues().size(); i++){
					newRawValues[i] += point.getRawValues().get(i); 
				}
			}

			ImageFeature centroid = cluster.getCentroid();
			if (n_points > 0) {
				for(int i = 0; i < newRawValues.length; i++){
					newRawValues[i] = newRawValues[i]/n_points;
				}
				
				centroid.setRawValues((ArrayList<Double>) Arrays.stream(newRawValues)
					      .boxed()
					      .collect(Collectors.toList()));
			}
		}
	}
}
