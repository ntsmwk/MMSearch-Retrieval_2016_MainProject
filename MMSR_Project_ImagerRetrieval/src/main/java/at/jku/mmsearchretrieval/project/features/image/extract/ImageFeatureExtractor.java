package at.jku.mmsearchretrieval.project.features.image.extract;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import at.jku.mmsearchretrieval.project.features.image.model.ImageFeature;

public abstract class ImageFeatureExtractor<T extends ImageFeature> {
	public abstract List<T> extract(String URL) throws FileNotFoundException, IOException;
}
