package com.ubix.pages.modelSpace;

import com.ubix.base.TestBase;
import com.ubix.pages.dashboard.DashboardPage;

public class Helper extends TestBase {
	WorkSpaceListPage workSpaceList = new WorkSpaceListPage();
	DashboardPage dashboard = new DashboardPage();
	AddSolutionSpaceAppBuilderPage addSolutionSpaceBuilderApp = new AddSolutionSpaceAppBuilderPage();
	String widgetTitle = "Widget Title_" + currentDateTime();
	

	public void removeWorkSpace(String workspaceName) throws InterruptedException {

		// Navigate to the dashboard by clicking the Ubix logo
		dashboard.clickUbixLogo();

		// Click on the Model Space
		dashboard.clickModelSpace();

		// clear the search field and search for the
		workSpaceList.clearWorkSpaceSearch();

		// search workspace by name
		workSpaceList.typeWorkSpaceSearch(workspaceName);

		// click on the workspace delete button
		workSpaceList.clickDeleteWorkSpace();

		// click on the yes button from the delete workspace modal
		workSpaceList.clickDeleteWorkSpaceYes();

	}

	public void widgetDataMapping(String title) throws InterruptedException {
		// Enter the widget title
		addSolutionSpaceBuilderApp.typeWidgetTitle(title);

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_mapping_dataset_CSS");

		// wait for the element
		Thread.sleep(3000);

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// wait for the element
		Thread.sleep(3000);
	}

}
