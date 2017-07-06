package org.jsystemtest;

import java.awt.Component;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTree;

import org.apache.commons.io.IOUtils;

import jsystem.framework.scenario.JTest;
import jsystem.framework.scenario.RunnerTest;
import jsystem.treeui.teststable.ScenarioRenderer;
import jsystem.treeui.teststable.ScenarioTreeNode;

public class ScenarioRendererWithPause extends ScenarioRenderer {

	private final List<JTest> selectedTests;
	private ImageIcon pausedTest;

	public ScenarioRendererWithPause(List<JTest> selectedTests) {
		this.selectedTests = selectedTests;
		try {
			pausedTest = new ImageIcon(
					IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("pausedTest.gif")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		final Component component = super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row,
				hasFocus);
		ScenarioTreeNode node = (ScenarioTreeNode) value;
		if (!(node.getTest() instanceof RunnerTest)) {
			return component;
		}
		RunnerTest test = (RunnerTest) node.getTest();
		if (!test.isRunning() && !test.isError() && !test.isFail() && !test.isWarning() && !test.isFailureOccurred()
				&& !test.isDisable() && !test.isHiddenInHTML() && !test.isMarkedAsKnownIssue() && !test.isSuccess()
				&& !test.isValidationErrorsFound()) {
			if (selectedTests.contains(test)) {
				ScenarioRenderer.TreeJPanel panel = ((ScenarioRenderer.TreeJPanel) component);
				panel.label.setIcon(pausedTest);
			}

		}

		return component;
	}

}
