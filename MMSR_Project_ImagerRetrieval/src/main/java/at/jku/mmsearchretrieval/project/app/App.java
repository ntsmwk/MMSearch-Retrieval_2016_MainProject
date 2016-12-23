package at.jku.mmsearchretrieval.project.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import at.jku.mmsearchretrieval.project.features.image.extract.ImageFeatureCM3x3Extractor;
import at.jku.mmsearchretrieval.project.features.image.extract.ImageFeatureCMExtractor;
import at.jku.mmsearchretrieval.project.features.image.extract.ImageFeatureCN3x3Extractor;
import at.jku.mmsearchretrieval.project.features.image.extract.ImageFeatureCNExtractor;
import at.jku.mmsearchretrieval.project.features.image.extract.ImageFeatureCSDExtractor;
import at.jku.mmsearchretrieval.project.features.image.extract.ImageFeatureGLRLMExtractor;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCM;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCM3x3;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCN;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCN3x3;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCSD;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureGLRLM;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		List<ImageFeatureCM> listCM = new ImageFeatureCMExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CM.csv");
//		List<ImageFeatureCM3x3> listCM3x3 = new ImageFeatureCM3x3Extractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CM3x3.csv");
//		List<ImageFeatureCN> listCN = new ImageFeatureCNExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CN.csv");
//		List<ImageFeatureCN3x3> listCN3x3 = new ImageFeatureCN3x3Extractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CN3x3.csv");
//		List<ImageFeatureCSD> listCSD = new ImageFeatureCSDExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CSD.csv");
		List<ImageFeatureGLRLM> listGLRLM = new ImageFeatureGLRLMExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens GLRLM.csv");
		
		
	}

}
