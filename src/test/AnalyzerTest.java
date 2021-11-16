package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import kr.ac.jbnu.se.awp.gitplay4.core.CsvAnalyzer;

public class AnalyzerTest {
	
	CsvAnalyzer analyzer;
	
	@Before
	public void setUp() {
		analyzer = new CsvAnalyzer("C:\\Users\\selab\\Downloads\\death-rates-from-air-pollution.csv", true);
	}
	
	@Test
	public void testIsNumeric() {
		assertFalse(analyzer.isNumericColumn(0));
		assertFalse(analyzer.isNumericColumn(1));
		assertTrue(analyzer.isNumericColumn(2));
		assertTrue(analyzer.isNumericColumn(3));
	}
}
