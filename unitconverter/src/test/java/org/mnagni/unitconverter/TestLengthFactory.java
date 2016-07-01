package org.mnagni.unitconverter;

import org.junit.Assert;
import org.junit.Test;
import org.mnagni.unitconverter.LengthFactory.Length;

public class TestLengthFactory {

	@Test
	public void testCreateLength() throws Exception {
		Unit unit = LengthFactory.createUnit(Length.METER);
		Assert.assertEquals(Length.METER, unit.getType());
	}
	
	@Test
	public void testCompareLengths() throws Exception {
		//Different Length types
		Unit meter = LengthFactory.createUnit(Length.METER);
		Unit inch = LengthFactory.createUnit(Length.INCH);
		Assert.assertFalse(meter.getType().equals(inch.getType()));
		
		//Same Length types
		Unit meter2 = LengthFactory.createUnit(Length.METER);
		Assert.assertTrue(meter.getType().equals(meter2.getType()));
	}
	
	@Test
	public void testConvertLengths() throws Exception {
		Measure<Length> distance = new Measure(LengthFactory.createUnit(Length.METER), 1.0);
		
		//Unitary conversion
		Measure<Length> distanceInMeter = distance.convertTo(LengthFactory.createUnit(Length.METER));
		Assert.assertEquals("Wrong conversion", 1.0, distanceInMeter.getValue(), 0.0);
		
		//Meter to Inch
		Measure<Length> distanceInInch = distanceInMeter.convertTo(LengthFactory.createUnit(Length.INCH));
		Assert.assertEquals("Wrong conversion", 39.37007874, distanceInInch.getValue(), 0.0);
		
		//Inch to meter		
		distanceInMeter = distanceInInch.convertTo(LengthFactory.createUnit(Length.METER));
		Assert.assertEquals("Wrong conversion", 1.0, distanceInMeter.getValue(), 0.0);
		
		//Inch to Yard		
		Measure<Length> distanceInYard = distanceInInch.convertTo(LengthFactory.createUnit(Length.YARD));
		Assert.assertEquals("Wrong conversion", 1.093613298, distanceInYard.getValue(), 0.0);
	}
	
	@Test
	public void testMeasureFormatString() throws Exception {
		Measure<Length> distance = new Measure(LengthFactory.createUnit(Length.METER), 1.0);
		Assert.assertEquals("Wrong string format", "1.0 m", distance.toString());
	}
}
