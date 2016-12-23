package at.jku.mmsearchretrieval.project.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import at.jku.mmsearchretrieval.project.features.image.compare.ImageFeatureCM3x3Comparator;
import at.jku.mmsearchretrieval.project.features.image.compare.ImageFeatureCMComparator;
import at.jku.mmsearchretrieval.project.features.image.compare.ImageFeatureCN3x3Comparator;
import at.jku.mmsearchretrieval.project.features.image.compare.ImageFeatureCNComparator;
import at.jku.mmsearchretrieval.project.features.image.compare.ImageFeatureCSDComparator;
import at.jku.mmsearchretrieval.project.features.image.compare.ImageFeatureGLRLMComparator;
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
		List<ImageFeatureCM> listCM = new ImageFeatureCMExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CM.csv");
		List<ImageFeatureCM3x3> listCM3x3 = new ImageFeatureCM3x3Extractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CM3x3.csv");
		List<ImageFeatureCN> listCN = new ImageFeatureCNExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CN.csv");
		List<ImageFeatureCN3x3> listCN3x3 = new ImageFeatureCN3x3Extractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CN3x3.csv");
		List<ImageFeatureCSD> listCSD = new ImageFeatureCSDExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens CSD.csv");
		List<ImageFeatureGLRLM> listGLRLM = new ImageFeatureGLRLMExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\acropolis_athens GLRLM.csv");
		
		
		
		List<ImageFeatureCM> wikiListCM = new ImageFeatureCMExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\acropolis_athens CM.csv");
		List<ImageFeatureCM3x3> wikiListCM3x3 = new ImageFeatureCM3x3Extractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\acropolis_athens CM3x3.csv");
		List<ImageFeatureCN> wikiListCN = new ImageFeatureCNExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\acropolis_athens CN.csv");
		List<ImageFeatureCN3x3> wikiListCN3x3 = new ImageFeatureCN3x3Extractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\acropolis_athens CN3x3.csv");
		List<ImageFeatureCSD> wikiListCSD = new ImageFeatureCSDExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\acropolis_athens CSD.csv");
		List<ImageFeatureGLRLM> wikiListGLRLM = new ImageFeatureGLRLMExtractor().extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\acropolis_athens GLRLM.csv");
		
		List<ImageFeatureCM> comparedListCM = new ImageFeatureCMComparator().compareImageFeature(wikiListCM.get(1), listCM);
		List<ImageFeatureCM3x3> comparedListCM3x3 = new ImageFeatureCM3x3Comparator().compareImageFeature(wikiListCM3x3.get(1), listCM3x3);
		List<ImageFeatureCN> comparedListCN = new ImageFeatureCNComparator().compareImageFeature(wikiListCN.get(1), listCN);
		List<ImageFeatureCN3x3> comparedListCN3x3 = new ImageFeatureCN3x3Comparator().compareImageFeature(wikiListCN3x3.get(1), listCN3x3);
		List<ImageFeatureCSD> comparedListCSD = new ImageFeatureCSDComparator().compareImageFeature(wikiListCSD.get(1), listCSD);
		List<ImageFeatureGLRLM> comparedListGLRLM = new ImageFeatureGLRLMComparator().compareImageFeature(wikiListGLRLM.get(1), listGLRLM);
		
		
		System.out.println("Color Moments");
		System.out.println("\tNumber\tOriginal\tSorted");
		for(int i = 0; i < 10; i++){
			System.out.println("\t" + (i+1) + ")\t" + listCM.get(i).getImageId() + "\t" + comparedListCM.get(i).getImageId());
		}
		
		System.out.println("\n--------------------------\n");
		
		System.out.println("Color Moments 3x3");
		System.out.println("\tNumber\tOriginal\tSorted");
		for(int i = 0; i < 10; i++){
			System.out.println("\t" + (i+1) + ")\t" + listCM3x3.get(i).getImageId() + "\t" + comparedListCM3x3.get(i).getImageId());
		}
		
		System.out.println("\n--------------------------\n");
		
		System.out.println("Color Histogram");
		System.out.println("\tNumber\tOriginal\tSorted");
		for(int i = 0; i < 10; i++){
			System.out.println("\t" + (i+1) + ")\t" + listCN.get(i).getImageId() + "\t" + comparedListCN.get(i).getImageId());
		}
		
		System.out.println("\n--------------------------\n");
		
		System.out.println("Color Histogram 3x3");
		System.out.println("\tNumber\tOriginal\tSorted");
		for(int i = 0; i < 10; i++){
			System.out.println("\t" + (i+1) + ")\t" + listCN3x3.get(i).getImageId() + "\t" + comparedListCN3x3.get(i).getImageId());
		}
		
		System.out.println("\n--------------------------\n");
		
		System.out.println("Color Structure Diagram");
		System.out.println("\tNumber\tOriginal\tSorted");
		for(int i = 0; i < 10; i++){
			System.out.println("\t" + (i+1) + ")\t" + listCSD.get(i).getImageId() + "\t" + comparedListCSD.get(i).getImageId());
		}
		
		System.out.println("\n--------------------------\n");
		
		System.out.println("Gray-Level Run Length Matrice");
		System.out.println("\tNumber\tOriginal\tSorted");
		for(int i = 0; i < 10; i++){
			System.out.println("\t" + (i+1) + ")\t" + listGLRLM.get(i).getImageId() + "\t" + comparedListGLRLM.get(i).getImageId());
		}
		
		System.out.println("\n--------------------------\n");
		

		System.out.println("finished!");
		
	}
}
