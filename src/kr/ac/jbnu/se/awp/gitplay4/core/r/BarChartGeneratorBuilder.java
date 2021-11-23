package kr.ac.jbnu.se.awp.gitplay4.core.r;

import kr.ac.jbnu.se.awp.gitplay4.core.ChartGenerator;
import kr.ac.jbnu.se.awp.gitplay4.model.ChartType;

public class BarChartGeneratorBuilder extends ChartGeneratorBuilder {

	public BarChartGeneratorBuilder() {
		this(null, null);
	}
	
	public BarChartGeneratorBuilder(String csvPath, String outputPath) {
		super(csvPath, outputPath);
	}
	
	@Override
	protected ChartGenerator createChratGenerator() {
		ChartGenerator toReturn = new ChartGenerator(csvPath, null, yName, outputPath, ChartType.BAR);
		
		return toReturn;
	}

}
