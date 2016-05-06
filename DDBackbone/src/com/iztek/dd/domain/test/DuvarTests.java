/*
 * Created on 16.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Selim HENDRICKSON
 *
 */
public class DuvarTests {

	public static void main(String[] args) {
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.iztek.dd.domain.test");
		//$JUnit-BEGIN$
		suite.addTest(new TestSuite(DisaAcikDuvarTest.class));
		suite.addTest(new TestSuite(IsitilmayanDuvarTest.class));
		suite.addTest(new TestSuite(TopragaTemasliDuvarTest.class));
		//$JUnit-END$
		return suite;
	}
}
