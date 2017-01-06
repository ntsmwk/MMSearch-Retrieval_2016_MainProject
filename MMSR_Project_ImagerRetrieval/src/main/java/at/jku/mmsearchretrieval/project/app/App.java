package at.jku.mmsearchretrieval.project.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import at.jku.mmsearchretrieval.project.features.image.clustering.KMeansClustering;
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
		ArrayList<ImageFeatureCM> listCM = new ImageFeatureCMExtractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\cn_tower CM.csv");
		ArrayList<ImageFeatureCM3x3> listCM3x3 = new ImageFeatureCM3x3Extractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\cn_tower CM3x3.csv");
		ArrayList<ImageFeatureCN> listCN = new ImageFeatureCNExtractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\cn_tower CN.csv");
		ArrayList<ImageFeatureCN3x3> listCN3x3 = new ImageFeatureCN3x3Extractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\cn_tower CN3x3.csv");
		ArrayList<ImageFeatureCSD> listCSD = new ImageFeatureCSDExtractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\cn_tower CSD.csv");
		ArrayList<ImageFeatureGLRLM> listGLRLM = new ImageFeatureGLRLMExtractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\img\\cn_tower GLRLM.csv");

		ArrayList<ImageFeatureCM> wikiListCM = new ImageFeatureCMExtractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\cn_tower CM.csv");
		ArrayList<ImageFeatureCM3x3> wikiListCM3x3 = new ImageFeatureCM3x3Extractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\cn_tower CM3x3.csv");
		ArrayList<ImageFeatureCN> wikiListCN = new ImageFeatureCNExtractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\cn_tower CN.csv");
		ArrayList<ImageFeatureCN3x3> wikiListCN3x3 = new ImageFeatureCN3x3Extractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\cn_tower CN3x3.csv");
		ArrayList<ImageFeatureCSD> wikiListCSD = new ImageFeatureCSDExtractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\cn_tower CSD.csv");
		ArrayList<ImageFeatureGLRLM> wikiListGLRLM = new ImageFeatureGLRLMExtractor()
				.extract("C:\\Multimedia_Project\\div-2014\\devset\\descvis\\descvis\\imgwiki\\cn_tower GLRLM.csv");

		List<ImageFeatureCM> comparedListCM_1 = new ImageFeatureCMComparator().compareImageFeature(wikiListCM.get(1),
				listCM);
		List<ImageFeatureCM3x3> comparedListCM3x3_1 = new ImageFeatureCM3x3Comparator()
				.compareImageFeature(wikiListCM3x3.get(1), listCM3x3);
		List<ImageFeatureCN> comparedListCN_1 = new ImageFeatureCNComparator().compareImageFeature(wikiListCN.get(1),
				listCN);
		List<ImageFeatureCN3x3> comparedListCN3x3_1 = new ImageFeatureCN3x3Comparator()
				.compareImageFeature(wikiListCN3x3.get(1), listCN3x3);
		List<ImageFeatureCSD> comparedListCSD_1 = new ImageFeatureCSDComparator()
				.compareImageFeature(wikiListCSD.get(1), listCSD);
		List<ImageFeatureGLRLM> comparedListGLRLM_1 = new ImageFeatureGLRLMComparator()
				.compareImageFeature(wikiListGLRLM.get(1), listGLRLM);

		List<ImageFeatureCM> comparedListCM_2 = new ImageFeatureCMComparator().compareImageFeature(wikiListCM.get(2),
				listCM);
		List<ImageFeatureCM3x3> comparedListCM3x3_2 = new ImageFeatureCM3x3Comparator()
				.compareImageFeature(wikiListCM3x3.get(2), listCM3x3);
		List<ImageFeatureCN> comparedListCN_2 = new ImageFeatureCNComparator().compareImageFeature(wikiListCN.get(2),
				listCN);
		List<ImageFeatureCN3x3> comparedListCN3x3_2 = new ImageFeatureCN3x3Comparator()
				.compareImageFeature(wikiListCN3x3.get(2), listCN3x3);
		List<ImageFeatureCSD> comparedListCSD_2 = new ImageFeatureCSDComparator()
				.compareImageFeature(wikiListCSD.get(2), listCSD);
		List<ImageFeatureGLRLM> comparedListGLRLM_2 = new ImageFeatureGLRLMComparator()
				.compareImageFeature(wikiListGLRLM.get(2), listGLRLM);

		List<ImageFeatureCM> comparedListCM_3 = new ImageFeatureCMComparator().compareImageFeature(wikiListCM.get(3),
				listCM);
		List<ImageFeatureCM3x3> comparedListCM3x3_3 = new ImageFeatureCM3x3Comparator()
				.compareImageFeature(wikiListCM3x3.get(3), listCM3x3);
		List<ImageFeatureCN> comparedListCN_3 = new ImageFeatureCNComparator().compareImageFeature(wikiListCN.get(3),
				listCN);
		List<ImageFeatureCN3x3> comparedListCN3x3_3 = new ImageFeatureCN3x3Comparator()
				.compareImageFeature(wikiListCN3x3.get(3), listCN3x3);
		List<ImageFeatureCSD> comparedListCSD_3 = new ImageFeatureCSDComparator()
				.compareImageFeature(wikiListCSD.get(3), listCSD);
		List<ImageFeatureGLRLM> comparedListGLRLM_3 = new ImageFeatureGLRLMComparator()
				.compareImageFeature(wikiListGLRLM.get(3), listGLRLM);

		List<ImageFeatureCM> comparedListCM_4 = new ImageFeatureCMComparator().compareImageFeature(wikiListCM.get(4),
				listCM);
		List<ImageFeatureCM3x3> comparedListCM3x3_4 = new ImageFeatureCM3x3Comparator()
				.compareImageFeature(wikiListCM3x3.get(4), listCM3x3);
		List<ImageFeatureCN> comparedListCN_4 = new ImageFeatureCNComparator().compareImageFeature(wikiListCN.get(4),
				listCN);
		List<ImageFeatureCN3x3> comparedListCN3x3_4 = new ImageFeatureCN3x3Comparator()
				.compareImageFeature(wikiListCN3x3.get(4), listCN3x3);
		List<ImageFeatureCSD> comparedListCSD_4 = new ImageFeatureCSDComparator()
				.compareImageFeature(wikiListCSD.get(4), listCSD);
		List<ImageFeatureGLRLM> comparedListGLRLM_4 = new ImageFeatureGLRLMComparator()
				.compareImageFeature(wikiListGLRLM.get(4), listGLRLM);

		List<ImageFeatureCM> comparedListCM_0 = new ImageFeatureCMComparator().compareImageFeature(wikiListCM.get(0),
				listCM);
		List<ImageFeatureCM3x3> comparedListCM3x3_0 = new ImageFeatureCM3x3Comparator()
				.compareImageFeature(wikiListCM3x3.get(0), listCM3x3);
		List<ImageFeatureCN> comparedListCN_0 = new ImageFeatureCNComparator().compareImageFeature(wikiListCN.get(0),
				listCN);
		List<ImageFeatureCN3x3> comparedListCN3x3_0 = new ImageFeatureCN3x3Comparator()
				.compareImageFeature(wikiListCN3x3.get(0), listCN3x3);
		List<ImageFeatureCSD> comparedListCSD_0 = new ImageFeatureCSDComparator()
				.compareImageFeature(wikiListCSD.get(0), listCSD);
		List<ImageFeatureGLRLM> comparedListGLRLM_0 = new ImageFeatureGLRLMComparator()
				.compareImageFeature(wikiListGLRLM.get(0), listGLRLM);

		print(listCM, listCM3x3, listCN, listCN3x3, listCSD, listGLRLM, comparedListCM_1, comparedListCM3x3_1,
				comparedListCN_1, comparedListCN3x3_1, comparedListCSD_1, comparedListGLRLM_1);

		/*
		 * Together
		 */

		HashMap<String, Double> map_CM = new HashMap<String, Double>();
		HashMap<String, Double> map_CM3x3 = new HashMap<String, Double>();
		HashMap<String, Double> map_CN = new HashMap<String, Double>();
		HashMap<String, Double> map_CN3x3 = new HashMap<String, Double>();
		HashMap<String, Double> map_CSD = new HashMap<String, Double>();
		HashMap<String, Double> map_GLRLM = new HashMap<String, Double>();

		for (int i = 0; i < comparedListCM_0.size(); i++) {
			map_CM.put(comparedListCM_0.get(i).getImageId(), Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_1.size(); i++) {
			map_CM.replace(comparedListCM_1.get(i).getImageId(),
					map_CM.get(comparedListCM_1.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_2.size(); i++) {
			map_CM.replace(comparedListCM_2.get(i).getImageId(),
					map_CM.get(comparedListCM_2.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_3.size(); i++) {
			map_CM.replace(comparedListCM_3.get(i).getImageId(),
					map_CM.get(comparedListCM_3.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_4.size(); i++) {
			map_CM.replace(comparedListCM_4.get(i).getImageId(),
					map_CM.get(comparedListCM_4.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		//
		// ----
		// CM3x3
		// ----
		//
		for (int i = 0; i < comparedListCM3x3_0.size(); i++) {
			map_CM3x3.put(comparedListCM3x3_0.get(i).getImageId(), Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM3x3_1.size(); i++) {
			map_CM3x3.replace(comparedListCM3x3_1.get(i).getImageId(),
					map_CM3x3.get(comparedListCM3x3_1.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_2.size(); i++) {
			map_CM3x3.replace(comparedListCM3x3_2.get(i).getImageId(),
					map_CM3x3.get(comparedListCM3x3_2.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_3.size(); i++) {
			map_CM3x3.replace(comparedListCM3x3_3.get(i).getImageId(),
					map_CM3x3.get(comparedListCM3x3_3.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_4.size(); i++) {
			map_CM3x3.replace(comparedListCM3x3_4.get(i).getImageId(),
					map_CM3x3.get(comparedListCM3x3_4.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		//
		// ----
		// CN
		// ----
		//

		for (int i = 0; i < comparedListCN_0.size(); i++) {
			map_CN.put(comparedListCN_0.get(i).getImageId(), Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCN_1.size(); i++) {
			map_CN.replace(comparedListCN_1.get(i).getImageId(),
					map_CN.get(comparedListCN_1.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_2.size(); i++) {
			map_CN.replace(comparedListCN_2.get(i).getImageId(),
					map_CN.get(comparedListCN_2.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_3.size(); i++) {
			map_CN.replace(comparedListCN_3.get(i).getImageId(),
					map_CN.get(comparedListCN_3.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCM_4.size(); i++) {
			map_CN.replace(comparedListCN_4.get(i).getImageId(),
					map_CN.get(comparedListCN_4.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		//
		// ----
		// CN3x3
		// ----
		//

		for (int i = 0; i < comparedListCN3x3_0.size(); i++) {
			map_CN3x3.put(comparedListCN3x3_0.get(i).getImageId(), Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCN3x3_1.size(); i++) {
			map_CN3x3.replace(comparedListCN3x3_1.get(i).getImageId(),
					map_CN3x3.get(comparedListCN3x3_1.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCN3x3_2.size(); i++) {
			map_CN3x3.replace(comparedListCN3x3_2.get(i).getImageId(),
					map_CN3x3.get(comparedListCN3x3_2.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCN3x3_3.size(); i++) {
			map_CN3x3.replace(comparedListCN3x3_3.get(i).getImageId(),
					map_CN3x3.get(comparedListCN3x3_3.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCN3x3_4.size(); i++) {
			map_CN3x3.replace(comparedListCN3x3_4.get(i).getImageId(),
					map_CN3x3.get(comparedListCN3x3_4.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		//
		// ----
		// CSD
		// ----
		//

		for (int i = 0; i < comparedListCSD_0.size(); i++) {
			map_CSD.put(comparedListCSD_0.get(i).getImageId(), Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCSD_1.size(); i++) {
			map_CSD.replace(comparedListCSD_1.get(i).getImageId(),
					map_CSD.get(comparedListCSD_1.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCSD_2.size(); i++) {
			map_CSD.replace(comparedListCSD_2.get(i).getImageId(),
					map_CSD.get(comparedListCSD_2.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCSD_3.size(); i++) {
			map_CSD.replace(comparedListCSD_3.get(i).getImageId(),
					map_CSD.get(comparedListCSD_3.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListCSD_4.size(); i++) {
			map_CSD.replace(comparedListCSD_4.get(i).getImageId(),
					map_CSD.get(comparedListCSD_4.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		//
		// ----
		// GLRLM
		// ----
		//

		for (int i = 0; i < comparedListGLRLM_0.size(); i++) {
			map_GLRLM.put(comparedListGLRLM_0.get(i).getImageId(), Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListGLRLM_1.size(); i++) {
			map_GLRLM.replace(comparedListGLRLM_1.get(i).getImageId(),
					map_GLRLM.get(comparedListGLRLM_1.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListGLRLM_2.size(); i++) {
			map_GLRLM.replace(comparedListGLRLM_2.get(i).getImageId(),
					map_GLRLM.get(comparedListGLRLM_2.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListGLRLM_3.size(); i++) {
			map_GLRLM.replace(comparedListGLRLM_3.get(i).getImageId(),
					map_GLRLM.get(comparedListGLRLM_3.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		for (int i = 0; i < comparedListGLRLM_4.size(); i++) {
			map_GLRLM.replace(comparedListGLRLM_4.get(i).getImageId(),
					map_GLRLM.get(comparedListGLRLM_4.get(i).getImageId()) + Math.pow((i + 1), 2));
		}

		System.out.println("-------------");
		System.out.println("CM");
		for (Entry<String, Double> set : sortByValue(map_CM).entrySet()) {
			System.out.println(set.getKey() + " Rank: " + set.getValue());
		}

		System.out.println("CM3x3");
		for (Entry<String, Double> set : sortByValue(map_CM3x3).entrySet()) {
			System.out.println(set.getKey() + " Rank: " + set.getValue());
		}

		System.out.println("CN");
		for (Entry<String, Double> set : sortByValue(map_CN).entrySet()) {
			System.out.println(set.getKey() + " Rank: " + set.getValue());
		}

		System.out.println("CN3x3");
		for (Entry<String, Double> set : sortByValue(map_CN3x3).entrySet()) {
			System.out.println(set.getKey() + " Rank: " + set.getValue());
		}

		System.out.println("CSD");
		for (Entry<String, Double> set : sortByValue(map_CSD).entrySet()) {
			System.out.println(set.getKey() + " Rank: " + set.getValue());
		}

		System.out.println("GLRLM");
		for (Entry<String, Double> set : sortByValue(map_GLRLM).entrySet()) {
			System.out.println(set.getKey() + " Rank: " + set.getValue());
		}

		System.out.println("-------------");

		//
		// ----------------
		// Combine
		// ----------------
		//

		HashMap<String, Double> combinedMap = new HashMap<String, Double>();
		int i = 0;
		/*
		for (Entry<String, Double> set : sortByValue(map_CM).entrySet()) {
			combinedMap.put(set.getKey(), (double) (i + 1));
			i++;
		}

		i = 0;
		for (Entry<String, Double> set : sortByValue(map_CM3x3).entrySet()) {
			combinedMap.replace(set.getKey(), combinedMap.get(set.getKey()) + (i + 1));
			i++;
		}

		i = 0;
		for (Entry<String, Double> set : sortByValue(map_CN).entrySet()) {
			combinedMap.put(set.getKey(), (double) (i + 1));
			//combinedMap.replace(set.getKey(), combinedMap.get(set.getKey()) + (i + 1));
			i++;
		}

		i = 0;
		for (Entry<String, Double> set : sortByValue(map_CN3x3).entrySet()) {
			combinedMap.replace(set.getKey(), combinedMap.get(set.getKey()) + (i + 1));
			i++;
		}
*/
		i = 0;
		for (Entry<String, Double> set : sortByValue(map_CSD).entrySet()) {
			combinedMap.put(set.getKey(), (double) (i + 1));
			//combinedMap.replace(set.getKey(), combinedMap.get(set.getKey()) + (i + 1));
			i++;
		}

		i = 0;
		for (Entry<String, Double> set : sortByValue(map_GLRLM).entrySet()) {
			combinedMap.replace(set.getKey(), combinedMap.get(set.getKey()) + (i + 1));
			i++;
		}

		System.out.println("---------------------------\n\n\n\n----------------");

		Map<String, Double> sortedMap = sortByValue(combinedMap);

		for (Entry<String, Double> set : sortedMap.entrySet()) {
			System.out.println(set.getKey() + " Rank: " + set.getValue());
		}
		
		
		
		/*
		 * 
		 * Clustering
		 * 
		 */
		
		KMeansClustering kmeans = new KMeansClustering();
    	kmeans.init(listCM);
    	kmeans.calculate();
		
		
		

	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	private static void print(List<ImageFeatureCM> listCM, List<ImageFeatureCM3x3> listCM3x3,
			List<ImageFeatureCN> listCN, List<ImageFeatureCN3x3> listCN3x3, List<ImageFeatureCSD> listCSD,
			List<ImageFeatureGLRLM> listGLRLM, List<ImageFeatureCM> comparedListCM_1,
			List<ImageFeatureCM3x3> comparedListCM3x3_1, List<ImageFeatureCN> comparedListCN_1,
			List<ImageFeatureCN3x3> comparedListCN3x3_1, List<ImageFeatureCSD> comparedListCSD_1,
			List<ImageFeatureGLRLM> comparedListGLRLM_1) {

		// Combine List which contains all features.

		System.out.println("Color Moments");
		System.out.println("\tNumber\tOriginal\tSorted");
		for (int i = 0; i < 10; i++) {
			System.out.println(
					"\t" + (i + 1) + ")\t" + listCM.get(i).getImageId() + "\t" + comparedListCM_1.get(i).getImageId());
		}

		System.out.println("\n--------------------------\n");

		System.out.println("Color Moments 3x3");
		System.out.println("\tNumber\tOriginal\tSorted");
		for (int i = 0; i < 10; i++) {
			System.out.println("\t" + (i + 1) + ")\t" + listCM3x3.get(i).getImageId() + "\t"
					+ comparedListCM3x3_1.get(i).getImageId());
		}

		System.out.println("\n--------------------------\n");

		System.out.println("Color Histogram");
		System.out.println("\tNumber\tOriginal\tSorted");
		for (int i = 0; i < 10; i++) {
			System.out.println(
					"\t" + (i + 1) + ")\t" + listCN.get(i).getImageId() + "\t" + comparedListCN_1.get(i).getImageId());
		}

		System.out.println("\n--------------------------\n");

		System.out.println("Color Histogram 3x3");
		System.out.println("\tNumber\tOriginal\tSorted");
		for (int i = 0; i < 10; i++) {
			System.out.println("\t" + (i + 1) + ")\t" + listCN3x3.get(i).getImageId() + "\t"
					+ comparedListCN3x3_1.get(i).getImageId());
		}

		System.out.println("\n--------------------------\n");

		System.out.println("Color Structure Diagram");
		System.out.println("\tNumber\tOriginal\tSorted");
		for (int i = 0; i < 10; i++) {
			System.out.println("\t" + (i + 1) + ")\t" + listCSD.get(i).getImageId() + "\t"
					+ comparedListCSD_1.get(i).getImageId());
		}

		System.out.println("\n--------------------------\n");

		System.out.println("Gray-Level Run Length Matrice");
		System.out.println("\tNumber\tOriginal\tSorted");
		for (int i = 0; i < 10; i++) {
			System.out.println("\t" + (i + 1) + ")\t" + listGLRLM.get(i).getImageId() + "\t"
					+ comparedListGLRLM_1.get(i).getImageId());
		}

		System.out.println("\n--------------------------\n");

		System.out.println("finished!");
	}

}
