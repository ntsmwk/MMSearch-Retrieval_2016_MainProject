package at.jku.mmsearchretrieval.project.features.image.extract;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import at.jku.mmsearchretrieval.project.features.image.model.ColorHistogram;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCN3x3;

public class ImageFeatureCN3x3Extractor extends ImageFeatureExtractor<ImageFeatureCN3x3> {

	@Override
	public ArrayList<ImageFeatureCN3x3> extract(String URL) throws FileNotFoundException, IOException {
		Reader in = new FileReader(URL);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		ArrayList<ImageFeatureCN3x3> imageFeatures = new ArrayList<ImageFeatureCN3x3>();
		for (CSVRecord record : records) {
			imageFeatures.add(createImageFeatureCN3x3(record));
		}
		return imageFeatures;
	}

	private ImageFeatureCN3x3 createImageFeatureCN3x3(CSVRecord record) {
		String imageId = record.get(0);
		ColorHistogram[][] colorHistogram3x3 = new ColorHistogram[3][3];
		int i = 0;
		int j = 0;
		
		ArrayList<Double> colorList = new ArrayList<Double>();
		for (int k = 1; k < record.size(); k++) {
			colorList.add(Double.parseDouble(record.get(k)));
			if(colorList.size() == 11){
				colorHistogram3x3[i][j] = new ColorHistogram(colorList);
				colorList = new ArrayList<Double>();
				if(j == 2){
					j = 0;
					i++;
				}else{
					j++;
				}
			}
		}
		return new ImageFeatureCN3x3(imageId, colorHistogram3x3, transformToArrayList(record));
	}

}
