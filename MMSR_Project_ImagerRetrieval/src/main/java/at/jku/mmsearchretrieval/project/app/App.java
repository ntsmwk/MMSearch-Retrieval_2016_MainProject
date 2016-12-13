package at.jku.mmsearchretrieval.project.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import at.jku.mmsearchretrieval.project.features.image.extract.ImageFeatureCM3x3Extractor;
import at.jku.mmsearchretrieval.project.features.image.extract.ImageFeatureCMExtractor;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCM;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCM3x3;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<ImageFeatureCM> listCM = new ImageFeatureCMExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CM.csv");
		List<ImageFeatureCM3x3> listCM3x3 = new ImageFeatureCM3x3Extractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CM3x3.csv");

	}

}
