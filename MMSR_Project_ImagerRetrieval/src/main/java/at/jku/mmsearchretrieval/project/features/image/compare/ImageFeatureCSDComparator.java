package at.jku.mmsearchretrieval.project.features.image.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import at.jku.mmsearchretrieval.project.features.image.model.ColorStructureDescriptor;
import at.jku.mmsearchretrieval.project.features.image.model.ImageFeatureCSD;

public class ImageFeatureCSDComparator extends ImageFeatureComparator<ImageFeatureCSD> {

	@Override
	public List<ImageFeatureCSD> compareImageFeature(ImageFeatureCSD feature, List<ImageFeatureCSD> featureList) {
		SortedMap<Double, ImageFeatureCSD> sortedMap = new TreeMap<Double, ImageFeatureCSD>();
		for (ImageFeatureCSD f : featureList) {
			sortedMap.put(compareColorStructureDescriptor(f.getColorStructureDescriptor(),
					feature.getColorStructureDescriptor()), f);
		}
		return new ArrayList<ImageFeatureCSD>(sortedMap.values());
	}

	private Double compareColorStructureDescriptor(ColorStructureDescriptor colorStructureDescriptor,
			ColorStructureDescriptor colorStructureDescriptor2) {
		double value = 0.0;
		for (int i = 0; i < colorStructureDescriptor.getColorStructureDescriptor().size(); i++) {
			value += Math.pow(colorStructureDescriptor.getColorStructureDescriptor().get(i)
					- colorStructureDescriptor2.getColorStructureDescriptor().get(i), 2);
		}
		return Math.sqrt(value);
	}

}
