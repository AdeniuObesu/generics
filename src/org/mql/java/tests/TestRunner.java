/**
 * 
 */
package org.mql.java.tests;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;

/**
 * @author MOUKHAFI Anass
 *
 * Oct 31, 2022
 */
public class TestRunner {
	
	void exp01() {
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
			.request()
			.selectors(DiscoverySelectors.selectClass(LinkedListTests.class))
			.build();
		Launcher launcher = LauncherFactory.create();
		SummaryGeneratingListener listener = new SummaryGeneratingListener();
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
		
		TestExecutionSummary summary = listener.getSummary();
		long fc = summary.getTotalFailureCount();
		if(fc > 0) {
			Failure f = summary.getFailures().get(0);
			System.out.println(f.getTestIdentifier() + " : " + f.getException());
		}
	}
	/**
	 * The public constructor
	 */
	public TestRunner() {
		exp01();
	}
	
	public static void main(String[] args) {
		new TestRunner();
	}
}
