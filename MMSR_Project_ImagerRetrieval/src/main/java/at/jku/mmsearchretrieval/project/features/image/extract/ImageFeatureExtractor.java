package at.jku.mmsearchretrieval.project.features.image.extract;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import at.jku.mmsearchretrieval.project.features.image.model.ImageFeature;

public abstract class ImageFeatureExtractor<T extends ImageFeature> {
	public abstract ArrayList<T> extract(String URL) throws FileNotFoundException, IOException;

	protected ArrayList<Double> transformToArrayList(CSVRecord record){
		ArrayList<Double> list = new ArrayList<>();
		for(int i = 1; i < record.size(); i++){
			list.add(Double.parseDouble(record.get(i)));
		}
		return list;
	}
}
