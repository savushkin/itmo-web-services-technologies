package me.savushkin.wst;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple InitializerBean.
 */
public class InitializerBeanTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InitializerBeanTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(InitializerBeanTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
