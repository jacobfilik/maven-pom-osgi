package org.dawnsci.janexpress.test;

import static org.junit.Assert.assertTrue;

import org.dawnsci.janexpress.JanuaryExpressionEngine;
import org.eclipse.january.dataset.Comparisons;
import org.eclipse.january.dataset.DatasetFactory;
import org.eclipse.january.dataset.DoubleDataset;
import org.junit.Test;

public class JanuaryExpressionEngineTest {
	
	@Test
	public void runTest() throws Exception {
		JanuaryExpressionEngine ee = new JanuaryExpressionEngine();
		
		DoubleDataset ones = DatasetFactory.ones(new int[] {4,4});
		DoubleDataset twos = ones.clone().iadd(1);
		
		ee.addLoadedVariable("ones", ones);
		ee.addLoadedVariable("twos", twos);
		
		ee.createExpression("ones+twos");
		
		Object evaluate = ee.evaluate();
		
		assertTrue(Comparisons.equalTo(evaluate, 3).all());
	}
	
	@Test
	public void runTest2() throws Exception {
		JanuaryExpressionEngine ee = new JanuaryExpressionEngine();
		
		DoubleDataset ones = DatasetFactory.ones(new int[] {4,4});
		DoubleDataset twos = ones.clone().iadd(1);
		
		ee.addLoadedVariable("ones", ones);
		ee.addLoadedVariable("twos", twos);
		
		ee.createExpression("ones+twos");
		
		Object evaluate = ee.evaluate();
		
		assertTrue(Comparisons.equalTo(evaluate, 4).all());
	}

}
