package org.mnagni.unitconverter.core;

public interface Unit<T extends UnitEnumInterface> {
	T getType();
	double getConversionFactor(Unit<T> unit);
}
