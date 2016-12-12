package at.jku.mmsearchretrieval.project.features.image.model;

/**
 * The RGBColorMoment represents a color moment for each color component.
 * @author Markus
 *
 */
public class RGBColorMoment {

	private ColorMoment rColorMoment;
	private ColorMoment gColorMoment;
	private ColorMoment bColorMoment;

	public RGBColorMoment(ColorMoment rColorMoment, ColorMoment gColorMoment, ColorMoment bColorMoment) {
		super();
		this.rColorMoment = rColorMoment;
		this.gColorMoment = gColorMoment;
		this.bColorMoment = bColorMoment;
	}

	public ColorMoment getrColorMoment() {
		return rColorMoment;
	}

	public void setrColorMoment(ColorMoment rColorMoment) {
		this.rColorMoment = rColorMoment;
	}

	public ColorMoment getgColorMoment() {
		return gColorMoment;
	}

	public void setgColorMoment(ColorMoment gColorMoment) {
		this.gColorMoment = gColorMoment;
	}

	public ColorMoment getbColorMoment() {
		return bColorMoment;
	}

	public void setbColorMoment(ColorMoment bColorMoment) {
		this.bColorMoment = bColorMoment;
	}

}
