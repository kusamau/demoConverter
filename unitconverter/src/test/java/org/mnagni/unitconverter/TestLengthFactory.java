package org.mnagni.unitconverter;

import org.junit.Assert;
import org.junit.Test;
import org.mnagni.unitconverter.core.Unit;
import org.mnagni.unitconverter.units.UnitLength.Length;

public class TestLengthFactory {

	@Test
	public void testCreateLength() throws Exception {
		Unit unit = UnitFactory.createLength(Length.METER);
		Assert.assertEquals(Length.METER, unit.getType());
	}
	
	@Test
	public void testCompareLengths() throws Exception {
		//Different Length types
		Unit meter = UnitFactory.createLength(Length.METER);
		Unit inch = UnitFactory.createLength(Length.INCH);
		Assert.assertFalse(meter.getType().equals(inch.getType()));
		
		//Same Length types
		Unit meter2 = UnitFactory.createLength(Length.METER);
		Assert.assertTrue(meter.getType().equals(meter2.getType()));
	}
	
	@Test
	public void testConvertLengths() throws Exception {
		Measure<Length> distance = new Measure(UnitFactory.createLength(Length.METER), 1.0);
		
		//Unitary conversion
		Measure<Length> distanceInMeter = distance.convertTo(UnitFactory.createLength(Length.METER));
		Assert.assertEquals("Wrong conversion", 1.0, distanceInMeter.getValue(), 0.0);
		
		//Meter to Inch
		Measure<Length> distanceInInch = distanceInMeter.convertTo(UnitFactory.createLength(Length.INCH));
		Assert.assertEquals("Wrong conversion", 39.37007874, distanceInInch.getValue(), 0.0);
		
		//Inch to meter		
		distanceInMeter = distanceInInch.convertTo(UnitFactory.createLength(Length.METER));
		Assert.assertEquals("Wrong conversion", 1.0, distanceInMeter.getValue(), 0.0);
		
		//Inch to Yard		
		Measure<Length> distanceInYard = distanceInInch.convertTo(UnitFactory.createLength(Length.YARD));
		Assert.assertEquals("Wrong conversion", 1.093613298, distanceInYard.getValue(), 0.0);
	}
	
	@Test
	public void testMeasureFormatString() throws Exception {
		Measure<Length> distance = new Measure(UnitFactory.createLength(Length.METER), 1.0);
		Assert.assertEquals("Wrong string format", "1.0 m", distance.toString());
	}
}
