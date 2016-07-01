package org.mnagni.unitconverter;

public interface Unit<T extends UnitEnumInterface> {
	T getType();
	double getConversionFactor(Unit<T> unit);
}
