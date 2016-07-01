package org.mnagni.unitconverter;

public abstract class AbstractUnit<T extends UnitEnumInterface> implements Unit<T> {

	private final T unit;
	
	public AbstractUnit(T unit) {
		this.unit = unit;
	}
	
	public T getType() {
		return this.unit;
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
		AbstractUnit other = (AbstractUnit) obj;
		if (unit != other.unit)
			return false;
		return true;
	}
}
