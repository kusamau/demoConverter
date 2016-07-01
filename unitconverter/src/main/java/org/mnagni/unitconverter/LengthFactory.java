package org.mnagni.unitconverter;

public class LengthFactory {

	public enum Length implements UnitEnumInterface{
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
	};

	public static Unit<Length> createUnit(Length length) {
		class LengthImpl extends AbstractUnit<Length> {

			public LengthImpl(Length length) {
				super(length);
			}

			public double getConversionFactor(Unit<Length> unit) {
				// convert from meter
				if (this.getType().equals(Length.METER)) {
					return unit.getType().getConversionFactor();
				}
				
				// convert to meter
				if (unit.getType().equals(Length.METER)) {
					return 1 / this.getType().getConversionFactor();	
				}

				// convert says from cm to yd
				return unit.getType().getConversionFactor() / this.getType().getConversionFactor();
			}

			public String getSymbol() {
				return this.getType().getSymbol();
			}
		}
		return new LengthImpl(length);
	}
}
