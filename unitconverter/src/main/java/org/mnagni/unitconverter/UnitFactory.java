package org.mnagni.unitconverter;

import org.mnagni.unitconverter.core.Unit;
import org.mnagni.unitconverter.core.UnitEnumInterface;
import org.mnagni.unitconverter.units.UnitLength.Length;

public class UnitFactory {
	
	public static Unit<Length> createLength(Length length) {
		return new UnitImpl<Length>(length);
	}

}


class UnitImpl<T extends UnitEnumInterface> implements Unit<T> {

	private final T unit;
	
	public UnitImpl(T unit) {
		this.unit = unit;
	}
	
	public T getType() {
		return this.unit;
	}
	
	public double getConversionFactor(Unit<T> unit) {
		// convert from meter
		if (this.getType().equals(getType().getReference())) {
			return unit.getType().getConversionFactor();
		}
		
		// convert to meter
		if (unit.getType().equals(getType().getReference())) {
			return 1 / this.getType().getConversionFactor();	
		}

		// convert says from cm to yd
		return unit.getType().getConversionFactor() / this.getType().getConversionFactor();
	}
	
	public String getSymbol() {
		return getType().getSymbol();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitImpl other = (UnitImpl) obj;
		if (unit != other.unit)
			return false;
		return true;
	}
}

