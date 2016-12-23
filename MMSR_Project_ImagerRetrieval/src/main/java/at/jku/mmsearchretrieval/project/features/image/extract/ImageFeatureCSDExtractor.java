package at.jku.mmsearchretrieval.project.features.image.extract;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import at.jku.mmsearchretrieval.project.features.image.model.ColorStructureDescriptor;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCSD;

public class ImageFeatureCSDExtractor extends ImageFeatureExtractor<ImageFeatureCSD> {

	@Override
	public List<ImageFeatureCSD> extract(String URL) throws FileNotFoundException, IOException {
		Reader in = new FileReader(URL);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		ArrayList<ImageFeatureCSD> imageFeatures = new ArrayList<ImageFeatureCSD>();
		for (CSVRecord record : records) {
			imageFeatures.add(createImageFeatureCSD(record));
		}
		return imageFeatures;
	}

	private ImageFeatureCSD createImageFeatureCSD(CSVRecord record) {
		long imageId = Long.parseLong(record.get(0));
		ArrayList<Double> colorStructureDescriptor = new ArrayList<Double>();
		for (int i = 1; i < record.size(); i++) {
			colorStructureDescriptor.add(Double.parseDouble(record.get(i)));
		}
		return new ImageFeatureCSD(imageId, new ColorStructureDescriptor(colorStructureDescriptor));
	}
}
