/*
 * Created on 22.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Selim HENDRICKSON
 *
 */
public class AllTests {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.iztek.dd.domain.test");
		//$JUnit-BEGIN$
		suite.addTestSuite(DisaAcikDuvarTest.class);
		suite.addTestSuite(BinaTest.class);
		suite.addTestSuite(IsitilmayanDuvarTest.class);
		suite.addTestSuite(GunesEnerjisiKazanciTest.class);
		suite.addTestSuite(TopragaTemasliDuvarTest.class);
		suite.addTestSuite(MekanikHavalandirmaTest.class);
		suite.addTestSuite(DogalHavalandirmaTest.class);
		//$JUnit-END$
		return suite;
	}
}
