package at.jku.mmsearchretrieval.project.features.image.compare;

import java.util.List;

import at.jku.mmsearchretrieval.project.features.image.model.ImageFeature;

public abstract class ImageFeatureComparator<T extends ImageFeature> {

	public abstract List<T>  compareImageFeature(T feature, List<T> featureList);
}
