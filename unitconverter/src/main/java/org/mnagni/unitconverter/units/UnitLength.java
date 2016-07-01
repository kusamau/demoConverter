package org.mnagni.unitconverter.units;

import org.mnagni.unitconverter.core.UnitEnumInterface;

public final class UnitLength {

	public enum Length implements UnitEnumInterface {
		// Assumes meter as reference unit
		METER(1.0, "m"), CM(100.0, "cm"), INCH(39.37007874, "in"), YARD(1.093613298, "yd"), MILE(0.000621371, "mi");

		private final double convertionFactor;
		private final String symbol;

		Length(double conversionFactor, String symbol)  {
			this.convertionFactor = conversionFactor;
			this.symbol = symbol;
		}

		public double getConversionFactor() {
			return this.convertionFactor;
		}

		public String getSymbol() {
			return this.symbol;
		}
		
		public Enum getReference() {
			return Length.METER;
		}
	};
}
