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
	private IconsMapContainer iconsMapContainer;

	public ScenarioRendererWithPause(List<JTest> selectedTests) {

		this.selectedTests = selectedTests;
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
				scenarioIconStatusSetter(scenarioAsTest, panel, iconsMapContainer.getPausedNormalMap());
			} else if (!scenarioMarkedAsKnownIssue && scenarioMarkedAsNegativeTest) {
				scenarioIconStatusSetter(scenarioAsTest, panel, iconsMapContainer.getPausedMarkedNegMap());
			} else if (scenarioMarkedAsKnownIssue && !scenarioMarkedAsNegativeTest) {
				scenarioIconStatusSetter(scenarioAsTest, panel, iconsMapContainer.getPausedMarkedIsseuMap());
			} else if (scenarioMarkedAsKnownIssue && scenarioMarkedAsNegativeTest) {
				scenarioIconStatusSetter(scenarioAsTest, panel, iconsMapContainer.getPausedMarkedNegIssueMap());
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
			System.out.println("********** Running");
		} else {
			System.out.println("********** Not Running");
		}
		if (scenarioAsTest.isFail()) {
			System.out.println("********** Fail");
		}
		if (scenarioAsTest.isWarning()) {
			System.out.println("********** Warning");
		}
		if (scenarioAsTest.isError()) {
			System.out.println("********** Error");
		}
		if (scenarioAsTest.isSuccess()) {
			System.out.println("********** Success");
		}
		
	}


	// private void scenarioIconStatusSetter(Scenario test, TreeJPanel panel,
	// HashMap<String, ImageIcon> pausedIconMap) {
	//
	// ScenarioAsTest scenarioAsTest = new ScenarioAsTest();
	// scenarioAsTest.setCurrentRunnerTest(test);
	// RunnerTest test2 = scenarioAsTest.getCurrentRunnerTest();
	//
	// if (test2.isRunning()) {
	//
	// switch (test2.getStatus()) {
	//
	// case RunnerTest.STAT_FAIL: {
	// panel.label.setIcon(pausedIconMap.get("pausedFailRun"));
	// }
	// break;
	// case RunnerTest.STAT_SUCCESS: {
	// panel.label.setIcon(pausedIconMap.get("pausedOkRun"));
	// }
	// break;
	// case RunnerTest.STAT_ERROR: {
	// panel.label.setIcon(pausedIconMap.get("pausedErrRun"));
	// }
	// break;
	// case RunnerTest.STAT_WARNING: {
	// panel.label.setIcon(pausedIconMap.get("pausedWarnRun"));
	// }
	// break;
	// default:
	// panel.label.setIcon(pausedIconMap.get("pausedPlainRun"));
	// }
	// } else if (!test2.isRunning()) {
	// switch (test2.getStatus()) {
	//
	// case RunnerTest.STAT_FAIL: {
	// panel.label.setIcon(pausedIconMap.get("pausedFail"));
	// }
	// break;
	// case RunnerTest.STAT_SUCCESS: {
	// panel.label.setIcon(pausedIconMap.get("pausedOk"));
	// }
	// break;
	// case RunnerTest.STAT_ERROR: {
	// panel.label.setIcon(pausedIconMap.get("pausedErr"));
	// }
	// break;
	// case RunnerTest.STAT_WARNING: {
	// panel.label.setIcon(pausedIconMap.get("pausedWarn"));
	// }
	// break;
	// default:
	// panel.label.setIcon(pausedIconMap.get("pausedPlain"));
	// }
	// }
	// }

	//

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
