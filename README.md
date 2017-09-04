# JSystem BB Pause Plugin

The project aims to allow users to pause before executing building blocks when using the [JSystem](https://github.com/Top-Q/jsystem) test automation framework.

## Installation

* To use the plugin, first download the jar file from the [releases](https://github.com/Top-Q/jsystem-bb-pause-plugin/releases) page. 
* Copy the jar file to the *runner/thirdparty/commonLib* folder.
* Open the **jsystem.properties** file that is located in the root folder of the runner and add the following property
  `context.menu.plugin.classes=org.jsystemtest.PauseBBContextMenuPlugin`.
  You can also set this property from the jsystem properties dialog.
* Restart the runner if needed.

## Usage

Simply right click on one of the building blocks in the scenario tree and click on the *Pause Before This Item* item. JSystem will now pause the execution
before executing the selected building block. You can resume the execution by clicking on the *Play* button.













