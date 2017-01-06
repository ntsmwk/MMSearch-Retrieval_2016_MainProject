package at.jku.mmsearchretrieval.project.features.image.extract;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import at.jku.mmsearchretrieval.project.features.image.model.ColorMoment;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCM3x3;
import at.jku.mmsearchretrieval.project.features.image.model.RGBColorMoment;

public class ImageFeatureCM3x3Extractor extends ImageFeatureExtractor<ImageFeatureCM3x3> {

	@Override
	public ArrayList<ImageFeatureCM3x3> extract(String URL) throws FileNotFoundException, IOException {
		Reader in = new FileReader(URL);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		ArrayList<ImageFeatureCM3x3> imageFeatures = new ArrayList<ImageFeatureCM3x3>();
		for (CSVRecord record : records) {
			imageFeatures.add(createImageFeatureCM3x3(record));
		}
		return imageFeatures;
	}

	private ImageFeatureCM3x3 createImageFeatureCM3x3(CSVRecord record) {
		String imageId = record.get(0);
		RGBColorMoment[][] rgbColorMoments = new RGBColorMoment[3][3];

		// [0,0] ==> 1 - 9
		// [0,1] ==> 10 - 18
		// [0,2] ==> 19 - 27
		// [1,0] ==> 28 - 36
		// [1,1] ==> 37 - 45
		// [1,2] ==> 46 - 54
		// [2,0] ==> 55 - 63
		// [2,1] ==> 64 - 72
		// [2,2] ==> 73 - 81
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ColorMoment rColorMoment = new ColorMoment(Double.parseDouble(record.get(1 + 27 * i + 9 * j)),
						Double.parseDouble(record.get(2 + 27 * i + 9 * j)),
						Double.parseDouble(record.get(3 + 27 * i + 9 * j)));
				ColorMoment gColorMoment = new ColorMoment(Double.parseDouble(record.get(4 + 27 * i + 9 * j)),
						Double.parseDouble(record.get(5 + 27 * i + 9 * j)),
						Double.parseDouble(record.get(6 + 27 * i + 9 * j)));
				ColorMoment bColorMoment = new ColorMoment(Double.parseDouble(record.get(7 + 27 * i + 9 * j)),
						Double.parseDouble(record.get(8 + 27 * i + 9 * j)),
						Double.parseDouble(record.get(9 + 27 * i + 9 * j)));
				rgbColorMoments[i][j] = new RGBColorMoment(rColorMoment, gColorMoment, bColorMoment);
			}
		}
		return new ImageFeatureCM3x3(imageId, rgbColorMoments, transformToArrayList(record));
	}
}
