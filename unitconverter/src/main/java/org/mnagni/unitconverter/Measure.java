package org.mnagni.unitconverter;

public class Measure<T extends UnitEnumInterface> {

	private final Unit<T> unit;
	private final double value;
	
	public Measure(Unit<T> unit, double value) {
		super();
		this.unit = unit;
		this.value = value;
	}
	
	public Measure<T> convertTo(Unit<T> unit) {
		return new Measure(unit, this.value * this.unit.getConversionFactor(unit));
	}

	public Unit<T> getUnit() {
		return unit;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%1$s %2$s", getValue(), unit.getType().getSymbol());
	}
}
