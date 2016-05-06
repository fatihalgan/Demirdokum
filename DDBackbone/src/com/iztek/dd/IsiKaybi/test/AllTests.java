/*
 * Created on 27.Ara.2004
 *
 */
package com.iztek.dd.IsiKaybi.test;

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
        TestSuite suite = new TestSuite("Test for com.iztek.dd.IsiKaybi.test");
        //$JUnit-BEGIN$
        suite.addTestSuite(BilesikYapiElemaniTest.class);
        suite.addTestSuite(MahalTest.class);
        suite.addTestSuite(KritikhatTest.class);
        //$JUnit-END$
        return suite;
    }
}
