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
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCN;

public class ImageFeatureCNExtractor extends ImageFeatureExtractor<ImageFeatureCN> {

	@Override
	public List<ImageFeatureCN> extract(String URL) throws FileNotFoundException, IOException {
		Reader in = new FileReader(URL);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		ArrayList<ImageFeatureCN> imageFeatures = new ArrayList<ImageFeatureCN>();
		for (CSVRecord record : records) {
			imageFeatures.add(createImageFeatureCN(record));
		}
		return imageFeatures;
	}

	private ImageFeatureCN createImageFeatureCN(CSVRecord record) {
		String imageId = record.get(0);
		List<Double> colorList = new ArrayList<Double>();
		for(int i = 1; i < record.size(); i++){
			colorList.add(Double.parseDouble(record.get(i)));
		}
		ColorHistogram colorHistogram = new ColorHistogram(colorList);
		return new ImageFeatureCN(imageId, colorHistogram);
	}

}
