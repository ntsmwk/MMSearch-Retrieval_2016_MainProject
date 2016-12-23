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
import at.jku.mmsearchretrieval.project.features.image.model.GrayLevelRunLengthMatriceStatistic;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCN;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureGLRLM;

public class ImageFeatureGLRLMExtractor extends ImageFeatureExtractor<ImageFeatureGLRLM> {

	@Override
	public List<ImageFeatureGLRLM> extract(String URL) throws FileNotFoundException, IOException {
		Reader in = new FileReader(URL);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
		ArrayList<ImageFeatureGLRLM> imageFeatures = new ArrayList<ImageFeatureGLRLM>();
		for (CSVRecord record : records) {
			imageFeatures.add(createImageFeatureGLRLM(record));
		}
		return imageFeatures;
	}

	private ImageFeatureGLRLM createImageFeatureGLRLM(CSVRecord record) {
		String imageId = record.get(0);
		List<GrayLevelRunLengthMatriceStatistic> grayLevelRunLengthMatriceStatisticList = new ArrayList<GrayLevelRunLengthMatriceStatistic>();
		List<Double> grayLevelRunLengthStatisticValues = new ArrayList<Double>();
		int degree = 0;
		for(int i = 1; i < record.size(); i++){
			grayLevelRunLengthStatisticValues.add(Double.parseDouble(record.get(i)));
			if(grayLevelRunLengthStatisticValues.size() == 11){
				grayLevelRunLengthMatriceStatisticList.add(new GrayLevelRunLengthMatriceStatistic(degree, grayLevelRunLengthStatisticValues));
				degree += 45;
				grayLevelRunLengthStatisticValues = new ArrayList<Double>();
			}
		}
		return new ImageFeatureGLRLM(imageId, grayLevelRunLengthMatriceStatisticList);
	}
}
