package at.jku.mmsearchretrieval.project.features.image.extract;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import at.jku.mmsearchretrieval.project.features.image.model.ColorMoment;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCM;
import at.jku.mmsearchretrieval.project.features.image.model.RGBColorMoment;

public class ImageFeatureCMExtractor extends ImageFeatureExtractor<ImageFeatureCM> {

	@Override
	public ArrayList<ImageFeatureCM> extract(String URL) throws FileNotFoundException, IOException {
		Reader in = new FileReader(URL);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		ArrayList<ImageFeatureCM> imageFeatures = new ArrayList<ImageFeatureCM>();
		for (CSVRecord record : records) {
			imageFeatures.add(createImageFeatureCM(record));
		}
		return imageFeatures;
	}

	private ImageFeatureCM createImageFeatureCM(CSVRecord record) {
		String imageId = record.get(0);
		ColorMoment rColorMoment = new ColorMoment(Double.parseDouble(record.get(1)), Double.parseDouble(record.get(2)),
				Double.parseDouble(record.get(3)));
		ColorMoment gColorMoment = new ColorMoment(Double.parseDouble(record.get(4)), Double.parseDouble(record.get(5)),
				Double.parseDouble(record.get(6)));
		ColorMoment bColorMoment = new ColorMoment(Double.parseDouble(record.get(7)), Double.parseDouble(record.get(8)),
				Double.parseDouble(record.get(9)));
		RGBColorMoment rgbColorMoment = new RGBColorMoment(rColorMoment, gColorMoment, bColorMoment);
		return new ImageFeatureCM(imageId, rgbColorMoment, transformToArrayList(record));
		
	}

}
