package org.jsystemtest;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;

import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.taskdefs.Classloader;

public class IconsMapContainer {
	
	private HashMap<String,ImageIcon> pausedNormalMap;
	private HashMap<String,ImageIcon> pausedMarkedNegMap;
	private HashMap<String,ImageIcon> pausedMarkedIsseuMap;
	private HashMap<String,ImageIcon> pausedMarkedNegIssueMap;
	
	private HashMap<String,ImageIcon> scenarioAsTestPausedNormalMap;
	private HashMap<String,ImageIcon> scenarioAsTestpausedMarkedNegMap;
	private HashMap<String,ImageIcon> scenarioAsTestpausedMarkedIsseuMap;
	private HashMap<String,ImageIcon> scenarioAsTestpausedMarkedNegIssueMap;
	
	public IconsMapContainer(){
		
		try {
			ClassLoader cl = this.getClass().getClassLoader();	
			
			pausedNormalMap = new HashMap<>();
			pausedNormalMap.put("pausedPlainRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/plainTest/pausedRunPlain.gif"))));
			pausedNormalMap.put("pausedPlain", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/plainTest/pausedPlain.gif"))));
			pausedNormalMap.put("pausedOk", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testSuccess/pausedOk.gif"))));
			pausedNormalMap.put("pausedErr", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testError/pausedError.gif"))));
			pausedNormalMap.put("pausedWarn", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testWarning/pausedWarning.gif"))));
			pausedNormalMap.put("pausedFail", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testFailure/pausedFail.gif"))));
			pausedNormalMap.put("pausedFailRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testFailure/pausedFailRun.gif"))));
			pausedNormalMap.put("pausedOkRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testSuccess/pausedOkRun.gif"))));
			pausedNormalMap.put("pausedErrRun",  new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testError/pausedErrorRun.gif"))));
			pausedNormalMap.put("pausedWarnRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testWarning/pausedWarningRun.gif"))));
			
			pausedMarkedNegMap = new HashMap<>();
			pausedMarkedNegMap.put("pausedPlainRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/plainTest/pausedRunNeg.gif"))));
			pausedMarkedNegMap.put("pausedPlain", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/plainTest/pausedTestNeg.gif"))));
			pausedMarkedNegMap.put("pausedOk", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testSuccess/pausedOkNeg.gif"))));
			pausedMarkedNegMap.put("pausedErr", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testError/pausedErrorNeg.gif"))));
			pausedMarkedNegMap.put("pausedWarn", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testWarning/pausedWarningNeg.gif"))));
			pausedMarkedNegMap.put("pausedFail", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testFailure/pausedFailNeg.gif"))));
			pausedMarkedNegMap.put("pausedFailRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testFailure/pausedFailRunNeg.gif"))));
			pausedMarkedNegMap.put("pausedOkRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testSuccess/pausedOkRunNeg.gif"))));
			pausedMarkedNegMap.put("pausedErrRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testError/pausedErrorRunNeg.gif"))));
			pausedMarkedNegMap.put("pausedWarnRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testWarning/pausedWarningRunNeg.gif"))));
			
			pausedMarkedIsseuMap = new HashMap<>();
			pausedMarkedIsseuMap.put("pausedPlainRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/plainTest/pausedRunIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedPlain", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/plainTest/pausedIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedOk", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testSuccess/pausedOkIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedErr", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testError/pausedErrorIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedWarn", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testWarning/pausedWarningIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedFail", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testFailure/pausedFailIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedFailRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testFailure/pausedFailRunIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedOkRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testSuccess/pausedOkRunIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedErrRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testError/pausedErrorRunIssue.gif"))));
			pausedMarkedIsseuMap.put("pausedWarnRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testWarning/pausedWarningRunIssue.gif"))));
			
			pausedMarkedNegIssueMap = new HashMap<>();
			pausedMarkedNegIssueMap.put("pausedPlainRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/plainTest/pausedRunNegIssue.gif"))));
			pausedMarkedNegIssueMap.put("pausedPlain", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/plainTest/pausedIssueNeg.gif"))));
			pausedMarkedNegIssueMap.put("pausedOk", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testSuccess/pausedOkIssueNeg.gif"))));
			pausedMarkedNegIssueMap.put("pausedErr", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testError/pausedErrorIssueNeg.gif"))));
			pausedMarkedNegIssueMap.put("pausedWarn", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testWarning/pausedWarningNegIssue.gif"))));
			pausedMarkedNegIssueMap.put("pausedFail", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testFailure/pausedFailNegIssue.gif"))));
			pausedMarkedNegIssueMap.put("pausedFailRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testFailure/pausedFailRunNegIssue.gif"))));
			pausedMarkedNegIssueMap.put("pausedOkRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testSuccess/pausedOkRunIssueNeg.gif"))));
			pausedMarkedNegIssueMap.put("pausedErrRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testError/pausedErrorRunIssueNeg.gif"))));
			pausedMarkedNegIssueMap.put("pausedWarnRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("testIconsByStatus/testWarning/pausedWarningRunNegIssue.gif"))));
			
			scenarioAsTestPausedNormalMap = new HashMap<>();
			scenarioAsTestPausedNormalMap.put("pausedPlainRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/plainTest/pausedRunPlain.gif"))));
			scenarioAsTestPausedNormalMap.put("pausedPlain", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/plainTest/pausedPlain.gif"))));
			scenarioAsTestPausedNormalMap.put("pausedOk", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testSuccess/pausedOk.gif"))));
			scenarioAsTestPausedNormalMap.put("pausedErr", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testError/pausedError.gif"))));
			scenarioAsTestPausedNormalMap.put("pausedWarn", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testWarning/pausedWarning.gif"))));
			scenarioAsTestPausedNormalMap.put("pausedFail", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testFailure/pausedFail.gif"))));
			
			scenarioAsTestpausedMarkedNegMap = new HashMap<>();
			scenarioAsTestpausedMarkedNegMap.put("pausedPlainRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/plainTest/pausedPlainNegRun.gif"))));
			scenarioAsTestpausedMarkedNegMap.put("pausedPlain", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/plainTest/pausedPlainNeg.gif"))));
			scenarioAsTestpausedMarkedNegMap.put("pausedOk", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testSuccess/pausedOkNeg.gif"))));
			scenarioAsTestpausedMarkedNegMap.put("pausedErr", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testError/pausedErrorNeg.gif"))));
			scenarioAsTestpausedMarkedNegMap.put("pausedWarn", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testWarning/pausedWarningNeg.gif"))));
			scenarioAsTestpausedMarkedNegMap.put("pausedFail", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testFailure/pausedFailNeg.gif"))));
			
			scenarioAsTestpausedMarkedIsseuMap = new HashMap<>();
			scenarioAsTestpausedMarkedIsseuMap.put("pausedPlainRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/plainTest/pausedIssueRun.gif"))));
			scenarioAsTestpausedMarkedIsseuMap.put("pausedPlain", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/plainTest/pausedIssue.gif"))));
			scenarioAsTestpausedMarkedIsseuMap.put("pausedOk", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testSuccess/pausedOkIssue.gif"))));
			scenarioAsTestpausedMarkedIsseuMap.put("pausedErr", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testError/pausedErrorIssue.gif"))));
			scenarioAsTestpausedMarkedIsseuMap.put("pausedWarn", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testWarning/pausedWarningIssue.gif"))));
			scenarioAsTestpausedMarkedIsseuMap.put("pausedFail", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testFailure/pausedFailIssue.gif"))));
			
			scenarioAsTestpausedMarkedNegIssueMap = new HashMap<>();
			scenarioAsTestpausedMarkedNegIssueMap.put("pausedPlainRun", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/plainTest/pausedRunIssueNeg.gif"))));
			scenarioAsTestpausedMarkedNegIssueMap.put("pausedPlain", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/plainTest/pausedIssueNeg.gif"))));
			scenarioAsTestpausedMarkedNegIssueMap.put("pausedOk", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testSuccess/pausedOkIssueNeg.gif"))));
			scenarioAsTestpausedMarkedNegIssueMap.put("pausedErr", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testError/pausedErrorIssueNeg.gif"))));
			scenarioAsTestpausedMarkedNegIssueMap.put("pausedWarn", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testWarning/pausedWarningIssueNeg.gif"))));
			scenarioAsTestpausedMarkedNegIssueMap.put("pausedFail", new ImageIcon(IOUtils.toByteArray(cl.getResourceAsStream("scenarioAsTestIcons/testFailure/pausedFailIssueNeg.gif"))));
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String,ImageIcon> getPausedNormalMap(){
		return pausedNormalMap;
	}
	public HashMap<String,ImageIcon> getPausedMarkedNegMap(){
		return pausedMarkedNegMap;
	}
	public HashMap<String,ImageIcon> getPausedMarkedIsseuMap(){
		return pausedMarkedIsseuMap;
	}
	public HashMap<String,ImageIcon> getPausedMarkedNegIssueMap(){
		return pausedMarkedNegIssueMap;
	}
	public HashMap<String,ImageIcon> getScenarioAsTestpausedMarkedNegIssueMap() {
		return scenarioAsTestpausedMarkedNegIssueMap;
	}
	public HashMap<String,ImageIcon> getScenarioAsTestpausedMarkedIsseuMap() {
		return scenarioAsTestpausedMarkedIsseuMap;
	}
	public HashMap<String,ImageIcon> getScenarioAsTestpausedMarkedNegMap() {
		return scenarioAsTestpausedMarkedNegMap;
	}
	public HashMap<String,ImageIcon> getScenarioAsTestPausedNormalMap() {
		return scenarioAsTestPausedNormalMap;
	}

	
	

	
}
