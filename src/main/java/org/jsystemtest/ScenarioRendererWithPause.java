package org.jsystemtest;

import java.awt.Component;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTree;

import jsystem.framework.scenario.JTest;
import jsystem.framework.scenario.RunnerTest;
import jsystem.framework.scenario.Scenario;
import jsystem.framework.scenario.ScenarioHelpers;
import jsystem.treeui.teststable.ScenarioRenderer;
import jsystem.treeui.teststable.ScenarioTreeNode;

public class ScenarioRendererWithPause extends ScenarioRenderer {

	private final List<JTest> selectedTests;
	private static IconsMapContainer iconsMapContainer;

	public ScenarioRendererWithPause(List<JTest> selectedTests) {

		this.selectedTests = selectedTests;
		if(iconsMapContainer == null)
			iconsMapContainer = new IconsMapContainer();
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		final Component component = super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row,
				hasFocus);

		ScenarioTreeNode node = (ScenarioTreeNode) value;
		if (!selectedTests.contains(node.getTest())) {
			return component;
		}
		ScenarioRenderer.TreeJPanel panel = ((ScenarioRenderer.TreeJPanel) component);

		if (ScenarioHelpers.isScenarioAsTestAndNotRoot(node.getTest())) {

			final Scenario scenarioAsTest = (Scenario) node.getTest();
			final boolean scenarioMarkedAsKnownIssue = scenarioAsTest.isMarkedAsKnownIssue();
			final boolean scenarioMarkedAsNegativeTest = scenarioAsTest.isMarkedAsNegativeTest();
			
			if (!scenarioMarkedAsKnownIssue && !scenarioMarkedAsNegativeTest) {
				scenarioIconStatusSetter(scenarioAsTest, panel, iconsMapContainer.getScenarioAsTestPausedNormalMap());
			} else if (!scenarioMarkedAsKnownIssue && scenarioMarkedAsNegativeTest) {
				scenarioIconStatusSetter(scenarioAsTest, panel, iconsMapContainer.getScenarioAsTestpausedMarkedNegMap());
			} else if (scenarioMarkedAsKnownIssue && !scenarioMarkedAsNegativeTest) {
				scenarioIconStatusSetter(scenarioAsTest, panel, iconsMapContainer.getScenarioAsTestpausedMarkedIsseuMap());
			} else if (scenarioMarkedAsKnownIssue && scenarioMarkedAsNegativeTest) {
				scenarioIconStatusSetter(scenarioAsTest, panel, iconsMapContainer.getScenarioAsTestpausedMarkedNegIssueMap());
			}
		} else if (node.getTest() instanceof RunnerTest) {

			RunnerTest test = (RunnerTest) node.getTest();

			if (!test.isMarkedAsKnownIssue() && !test.isMarkedAsNegativeTest()) {
				testIconStatusSetter(test, panel, iconsMapContainer.getPausedNormalMap());
			} else if (!test.isMarkedAsKnownIssue() && test.isMarkedAsNegativeTest()) {
				testIconStatusSetter(test, panel, iconsMapContainer.getPausedMarkedNegMap());
			} else if (test.isMarkedAsKnownIssue() && !test.isMarkedAsNegativeTest()) {
				testIconStatusSetter(test, panel, iconsMapContainer.getPausedMarkedIsseuMap());
			} else if (test.isMarkedAsKnownIssue() && test.isMarkedAsNegativeTest()) {
				testIconStatusSetter(test, panel, iconsMapContainer.getPausedMarkedNegIssueMap());
			}
		}

		return component;
	}

	private void scenarioIconStatusSetter(Scenario scenarioAsTest, TreeJPanel panel, HashMap<String, ImageIcon> pausedIconMap) {
		if (scenarioAsTest.isRunning()) {
			panel.label.setIcon(pausedIconMap.get("pausedPlainRun"));
		} else {
			panel.label.setIcon(pausedIconMap.get("pausedPlain"));
		}
		if (scenarioAsTest.isFail()) {
			panel.label.setIcon(pausedIconMap.get("pausedFail"));
		}
		if (scenarioAsTest.isWarning()) {
			panel.label.setIcon(pausedIconMap.get("pausedWarn"));
		}
		if (scenarioAsTest.isError()) {
			panel.label.setIcon(pausedIconMap.get("pausedErr"));
		}
		if (scenarioAsTest.isSuccess()) {
			panel.label.setIcon(pausedIconMap.get("pausedOk"));
		}
		
	}


	private void testIconStatusSetter(RunnerTest test, TreeJPanel panel, HashMap<String, ImageIcon> pausedIconMap) {
		if (test.isRunning()) {

			switch (test.getStatus()) {

			case RunnerTest.STAT_FAIL: {
				panel.label.setIcon(pausedIconMap.get("pausedFailRun"));
			}
				break;
			case RunnerTest.STAT_SUCCESS: {
				panel.label.setIcon(pausedIconMap.get("pausedOkRun"));
			}
				break;
			case RunnerTest.STAT_ERROR: {
				panel.label.setIcon(pausedIconMap.get("pausedErrRun"));
			}
				break;
			case RunnerTest.STAT_WARNING: {
				panel.label.setIcon(pausedIconMap.get("pausedWarnRun"));
			}
				break;
			default:
				panel.label.setIcon(pausedIconMap.get("pausedPlainRun"));
			}
		} else if (!test.isRunning()) {
			switch (test.getStatus()) {

			case RunnerTest.STAT_FAIL: {
				panel.label.setIcon(pausedIconMap.get("pausedFail"));
			}
				break;
			case RunnerTest.STAT_SUCCESS: {
				panel.label.setIcon(pausedIconMap.get("pausedOk"));
			}
				break;
			case RunnerTest.STAT_ERROR: {
				panel.label.setIcon(pausedIconMap.get("pausedErr"));
			}
				break;
			case RunnerTest.STAT_WARNING: {
				panel.label.setIcon(pausedIconMap.get("pausedWarn"));
			}
				break;
			default:
				panel.label.setIcon(pausedIconMap.get("pausedPlain"));
			}
		}
	}
}
