package kr.ac.jbnu.se.awp.gitplay4.core.r;

import kr.ac.jbnu.se.awp.gitplay4.core.ChartGenerator;
import kr.ac.jbnu.se.awp.gitplay4.core.LineGenerator;

public class LineChartGeneratorBuilder extends ChartGeneratorBuilder {

	public LineChartGeneratorBuilder() {
		this(null, null);
	}
	
	public LineChartGeneratorBuilder(String csvPath, String outputPath) {
		super(csvPath, outputPath);
	}

	@Override
	protected ChartGenerator createChratGenerator() {
		LineGenerator toReturn = new LineGenerator(csvPath, xName, yName, outputPath);
		
		return toReturn;
	}

}
