package com.ubix.testcases.modelSpace;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ubix.base.TestBase;
import com.ubix.pages.dashboard.DashboardPage;
import com.ubix.pages.modelSpace.AddSolutionPage;
import com.ubix.pages.modelSpace.AddSolutionSpaceAppBuilderPage;
import com.ubix.pages.modelSpace.AddWorkSpacePage;
import com.ubix.pages.modelSpace.DatasetPage;
import com.ubix.pages.modelSpace.Helper;
import com.ubix.pages.modelSpace.WorkSpaceListPage;
import com.ubix.pages.modelSpace.WorkSpaceSchemaPage;
import com.ubix.pages.modelSpaceLibrary.CreateModelSpaceLibraryPage;
import com.ubix.pages.modelSpaceLibrary.ModelSpaceLibraryListPage;

public class Smoke2Test extends TestBase {
	DashboardPage dashboard;
	AddSolutionPage addSolution;
	AddSolutionSpaceAppBuilderPage addSolutionSpaceBuilderApp;
	AddWorkSpacePage addworkSpace;
	DatasetPage dataset;
	WorkSpaceListPage workSpaceList;
	WorkSpaceSchemaPage workSpaceSchema;
	CreateModelSpaceLibraryPage createModelSpaceLibrary;
	ModelSpaceLibraryListPage modelSpaceLibraryList;

	Helper helper = new Helper();

	String formattedDateTime;
	String workSpaceName;
	String solutionName;
	String widgetTitle;
	String tagName;

	@BeforeMethod
	public void pageInit() {
		formattedDateTime = currentDateTime();
		workSpaceName = "Automation_" + formattedDateTime;
		solutionName = "Solution_" + formattedDateTime;
		widgetTitle = "Widget_" + formattedDateTime;
		tagName = "Tag_" + formattedDateTime;
		dashboard = new DashboardPage();
		addSolution = new AddSolutionPage();
		addSolutionSpaceBuilderApp = new AddSolutionSpaceAppBuilderPage();
		addworkSpace = new AddWorkSpacePage();
		dataset = new DatasetPage();
		workSpaceList = new WorkSpaceListPage();
		workSpaceSchema = new WorkSpaceSchemaPage();
		createModelSpaceLibrary = new CreateModelSpaceLibraryPage();
		modelSpaceLibraryList = new ModelSpaceLibraryListPage();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		// Navigate on Home page
		dashboard.clickUbixLogo();

	}

	@Test()
	public void smoke2Test() throws IOException, InterruptedException {

		// CREATED THE NEW WORKSPACE

		// click on the work space card
		dashboard.clickModelSpace();

		// wait for the element
		Thread.sleep(3000);

		// click on create model space button
		workSpaceList.clickCreateWorkSpace();

		// wait for the element
		Thread.sleep(3000);

		// type name of the work space
		addworkSpace.typeWorkSpaceName(workSpaceName);

		Thread.sleep(3000);

		// type description of the work space
		addworkSpace.typeDescription(testData.getProperty("addworkspace_description"));

		// select the user from drop down
		addworkSpace.selectUserFromDropdown();

		// select the permission from drop down
		addworkSpace.selectPermissionFromDropdown();

		// select the permission type from drop down
		addworkSpace.selectPermissionTypeFromDropdown();

		// click on the add user button
		addworkSpace.clickAddUser();

		// click on the add workspace button
		addworkSpace.clickAddWorkspace();

		// refresh the workspace page
		// addworkSpace.refreshWorkSpacePage();

		// validate the success message
		addworkSpace.verifyWorkSpaceAddedSuccessMsg();

		// wait for the element
		Thread.sleep(3000);

		// search the newly created workspace
		workSpaceList.typeWorkSpaceSearch(workSpaceName);

		// wait for the element
		Thread.sleep(3000);

		// validate the newly created workspace
		addworkSpace.validateNewlyCreatedWorkSpace(workSpaceName);

		// ADD THE DATASET IN THE WORKSPACE

		// click on the newly created workspace
		addworkSpace.clickNewlyCreatedWorkSpace(workSpaceName);

		// wait for the element
		Thread.sleep(3000);

		// search the required attribute
		dataset.typeAvailableAttributeSearch(testData.getProperty("attribute_insurance_data"));

		// wait for the element
		Thread.sleep(5000);

		// click on the checkbox of the searched result
		dataset.checkInsuranceData();

		// wait for the element
		Thread.sleep(2000);

		// type the available attribute in the search field
		dataset.typeAvailableAttributeSearch(testData.getProperty("attribute_electronics_store"));

		// wait for the element
		Thread.sleep(2000);

		// click on the checkbox of the searched result
		dataset.checkOnlineElectronicsStoreData();

		// wait for the element
		Thread.sleep(5000);

		// click on the add to workspace button
		dataset.clickAddToWorkspace();

		// verify the success message
		dataset.verifyWorkSpaceDataUpdatedSuccessMsg();

		// ADD THE SOLUTION

		// wait for the element
		Thread.sleep(3000);

		// click on the add solution button
		dataset.clickAddSolutionTab();

		// enter the name of the solution
		addSolution.typeSolutionName(solutionName);

		// select the solution type from the dropdown
		addSolution.selectSolutionType(testData.getProperty("solution_type_general_clustering_model"));

		// click on the add solution button
		addSolution.clickAddSolution();

		// verify the success message
		addSolution.verifySolutionAddedSuccessMsg();

		// ADD THE ACTION IN THE SOLUTION

		// wait for the element
		Thread.sleep(5000);

		// click on the plus button
		addSolution.clickPlusSign();

		// wait for the element
		Thread.sleep(3000);

		// perform drag and drop action for for select the dataset
		dragAndDrop("lbl_dataAccess_option1_XPATH", "ele_dataAccess_destination_CSS");

		// wait for the element
		Thread.sleep(2000);

		// perform drag and drop action for for select the dataset
		dragAndDrop("lbl_dataAccess_option2_XPATH", "ele_dataAccess_destination_CSS");

		// wait for the element
		Thread.sleep(2000);

		// click on the save button
		addSolution.clickDataAccessSave();

		// wait for the element
		Thread.sleep(2000);

		// verify the success message
		dataset.verifyWorkSpaceDataUpdatedSuccessMsg();

		// wait for the element
		Thread.sleep(2000);

		// doubleClick on newly created action
		addSolution.doubleClickNewlyCreatedAction1();

		// wait for the element
		Thread.sleep(2000);

		// click on save changes button
		addSolution.clickSaveChanges();

		// click on execute button
		addSolution.clickExecute();

		// validate the Provisioning Execution Resources progress bar
		addSolution.verifyProvisioningExecutionResourcesProgressBar();

		// validate the Loading & Preparing Input datasets progress bar
		addSolution.verifyLoadingAndPreparingInputDatasetsProgressBar();

		// validate the Loading Function to memory progress bar
		addSolution.verifyLoadingFunctionToMemoryProgressBar();

		// validate the Processing Data and Running Computations progress bar
		addSolution.verifyProcessingDataAndRunningComputationsProgressBar();

		// validate the Saving Features progress bar
		addSolution.verifySavingFeaturesProgressBar();

		// validate the Generating Results progress bar
		addSolution.verifyGeneratingResultsProgressBar();

		// click on accept execution button
		addSolution.clickAcceptExecution();

		// verify the success message
		addSolution.verifyAcceptedMsg();

		// click on close action space button
		addSolution.clickCloseActionSpace();

		// wait for the element
		Thread.sleep(3000);

		// doubleClick on newly created action
		addSolution.doubleClickNewlyCreatedAction2();

		// click on save changes button
		addSolution.clickSaveChanges();

		// click on execute button
		addSolution.clickExecute();

		// validate the Provisioning Execution Resources progress bar
		addSolution.verifyProvisioningExecutionResourcesProgressBar();

		// validate the Loading & Preparing Input datasets progress bar
		addSolution.verifyLoadingAndPreparingInputDatasetsProgressBar();

		// validate the Loading Function to memory progress bar
		addSolution.verifyLoadingFunctionToMemoryProgressBar();

		// validate the Processing Data and Running Computations progress bar
		addSolution.verifyProcessingDataAndRunningComputationsProgressBar();

		// validate the Saving Features progress bar
		addSolution.verifySavingFeaturesProgressBar();

		// validate the Generating Results progress bar
		addSolution.verifyGeneratingResultsProgressBar();

		// click on accept execution button
		addSolution.clickAcceptExecution();

		// verify the success message
		addSolution.verifyAcceptedMsg();

		// click on close action space button
		addSolution.clickCloseActionSpace();

		// ADD THE SOLUTION SPACE APP BUILDER

		// wait for the element
		Thread.sleep(3000);

		// add solution space app builder button
		dataset.clickAddSolutionSpaceAppBuilder();

		// wait for the element
		Thread.sleep(3000);

		// STARTED TO ADDING LAYOUT ON TABS

		// click on the four section layout
		addSolutionSpaceBuilderApp.clickSixSectionLayout();

		// wait for the element
		Thread.sleep(5000);

		// click on data selection plus button
		addSolutionSpaceBuilderApp.clickDataSelectionPlusSign();

		// wait for the element
		Thread.sleep(3000);

		// click on top drag bottom 2
		addSolutionSpaceBuilderApp.clickTopDragBottom2Layout();

		// wait for the element
		Thread.sleep(5000);

		// click on the six section layout tab
		addSolutionSpaceBuilderApp.clicksixSectionLlayoutTab();

		// click on the widgets tab
		addSolutionSpaceBuilderApp.clickWidgetsTab();

		// wait for the element
		Thread.sleep(3000);

		// click on the visualization option
		addSolutionSpaceBuilderApp.clickVisualizationWidgets();

		// wait for the element
		Thread.sleep(2000);

		// click on the distribution option
		addSolutionSpaceBuilderApp.clickDistributionWidgets();

		// wait for the element
		Thread.sleep(2000);

		// perform drag and drop action for first section of the four section layout
		dragAndDrop("lbl_histogramChartWidgets_XPATH", "ele_sixSectionWidgets_sectionOne_XPATH");

		// wait for the element
		Thread.sleep(2000);

		// verify the histogram chart after dropped
		addSolutionSpaceBuilderApp.verifyHistogramChartAfterDropped();

		// wait for the element
		Thread.sleep(2000);

		// click on the flow and parallel sets option
		addSolutionSpaceBuilderApp.clickFlowAndParallelSetsWidgets();

		// wait for the element
		Thread.sleep(2000);

		// scroll to the dependency wheel chart
		addSolutionSpaceBuilderApp.scrollToDependencyWheelChart();

		// wait for the element
		Thread.sleep(2000);

		// perform drag and drop action for first section of the four section layout
		dragAndDrop("lbl_dependencyWheelChartWidgets_XPATH", "ele_sixSectionWidgets_sectionTwo_XPATH");

		// wait for the element
		Thread.sleep(2000);

		// verify the dependency chart after dropped
		addSolutionSpaceBuilderApp.verifyDependencyChartAfterDropped();

		// wait for the element
		Thread.sleep(2000);

		// perform drag and drop action for second section of the four section layout
		dragAndDrop("lbl_funnelSeriesWidgets_XPATH", "ele_sixSectionWidgets_sectionThree_XPATH");

		// wait for the element
		Thread.sleep(2000);

		// verify the funnel chart after dropped
		addSolutionSpaceBuilderApp.verifyFunnelChartAfterDropped();

		// wait for the element
		Thread.sleep(2000);

		// perform drag and drop action for fourth section of the four section layout
		dragAndDrop("lbl_sankeyChartWidgets_XPATH", "ele_sixSectionWidgets_sectionFour_XPATH");

		// wait for the element
		Thread.sleep(2000);

		// verify the sankey chart after dropped
		addSolutionSpaceBuilderApp.verifySankeyChartAfterDropped();

		// wait for the element
		Thread.sleep(2000);

		// click on the heat maps option
		addSolutionSpaceBuilderApp.clickHeatMapsWidgets();

		// wait for the element
		Thread.sleep(3000);

		// perform drag and drop action for first section of the single section layout
		dragAndDrop("lbl_heatmapWidgets_XPATH", "ele_sixSectionWidgets_sectionFive_XPATH");

		// wait for the element
		Thread.sleep(2000);

		// verify the heat map after dropped
		addSolutionSpaceBuilderApp.verifyHeatmapAfterDropped();

		// wait for the element
		Thread.sleep(2000);

		// click on line and area option
		addSolutionSpaceBuilderApp.clickLineAndAreaWidgets();

		// wait for the element
		Thread.sleep(2000);

		// scroll to line chart widgets
		addSolutionSpaceBuilderApp.scrollToLineChartWidgets();

		// perform drag and drop action for line chart
		dragAndDrop("lbl_lineChartWidgets_XPATH", "ele_sixSectionWidgets_sectionSix_XPATH");

		// wait for the element
		Thread.sleep(2000);

		addSolutionSpaceBuilderApp.verifyLineChartAfterDropped();

		// wait for the element
		Thread.sleep(2000);

		// click on the top drag bottom 2 layout tab
		addSolutionSpaceBuilderApp.clickTopDragBottom2LayoutTab();

		// wait for the element
		Thread.sleep(2000);

		// perform drag and drop action for network graph
		dragAndDrop("lbl_networkGraphWidgets_XPATH", "ele_TopDragBottomLayout_sectionOne_XPATH");

		// wait for the element
		Thread.sleep(2000);

		addSolutionSpaceBuilderApp.verifyNetworGraphChartAfterDropped();

		// wait for the element
		Thread.sleep(2000);

		// perform drag and drop action for stacked area
		dragAndDrop("lbl_stackedAreaWidgets_XPATH", "ele_TopDragBottomLayout_sectionTwo_XPATH");

		// wait for the element
		Thread.sleep(2000);

		addSolutionSpaceBuilderApp.verifyStackAreaChartAfterDropped();

		// wait for element
		Thread.sleep(2000);

		// click on the maps and geography
		addSolutionSpaceBuilderApp.clickMapsAndGeographyWidgets();

		// wait for the element
		Thread.sleep(2000);

		scrollToElement("lbl_treemapGraphWidgets_XPATH");

		// wait for the element
		Thread.sleep(1000);

		// perform drag and drop action for tree map
		dragAndDrop("lbl_treemapGraphWidgets_XPATH", "ele_TopDragBottomLayout_sectionThree_XPATH");

		// wait for the element
		Thread.sleep(2000);

		// verify the tree map chart after dropped
		addSolutionSpaceBuilderApp.verifyTreeMapChartAfterDropped();

		// wait for the element
		Thread.sleep(2000);

		// click on the six section layout tab
		addSolutionSpaceBuilderApp.clicksixSectionLlayoutTab();

		// wait for the element
		Thread.sleep(3000);

		// click on the workspace data set
		addSolutionSpaceBuilderApp.clickWorkSpaceDataSet();

		// double click on the first section of the four section layout
		addSolutionSpaceBuilderApp.doubleClickSixSectionWidgetsSectionOneAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the quantity value from the number value drop down
		addSolutionSpaceBuilderApp.selectNumberValues();

		// type the number of bins
		addSolutionSpaceBuilderApp.typeNumberOfBins();

		// select the category value from the drop down
		addSolutionSpaceBuilderApp.selectCategoryValue(2);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the second section of the four section layout
		addSolutionSpaceBuilderApp.doubleClickSixSectionWidgetsSectionTwoAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the from category value from the drop down
		addSolutionSpaceBuilderApp.selectFromCategoryValue(1);

		// select the to category value from the drop down
		addSolutionSpaceBuilderApp.selectToCategoryValue(1);

		// select the quanity value from the number value drop down
		addSolutionSpaceBuilderApp.selectNumberValues();

		// select the aggregation value from the drop down
		addSolutionSpaceBuilderApp.selectAggregationValues(1);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the third section of the four section layout
		addSolutionSpaceBuilderApp.doubleClickSixSectionWidgetsSectionThreeAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the category value from the drop down
		addSolutionSpaceBuilderApp.selectCategoryValue(1);

		// select the quanity value from the number value drop down
		addSolutionSpaceBuilderApp.selectNumberValue(2);

		// select the aggregation value from the drop down
		addSolutionSpaceBuilderApp.selectAggregationValues(2);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the fourth section of the four section
		addSolutionSpaceBuilderApp.doubleClickSixSectionWidgetsSectionFourAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the from category value from the drop down
		addSolutionSpaceBuilderApp.selectFromCategoryValue(3);

		// select the to category value from the drop down
		addSolutionSpaceBuilderApp.selectToCategoryValue(2);

		// select the quanity value from the number value drop down
		addSolutionSpaceBuilderApp.selectNumberValue(2);

		// select the aggregation value from the drop down
		addSolutionSpaceBuilderApp.selectAggregationValues(4);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// wait for the element
		Thread.sleep(3000);

		// double click on the first section of the single section layout
		addSolutionSpaceBuilderApp.doubleClickSixSectionWidgetsSectionFiveAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the from category value from the drop down
		addSolutionSpaceBuilderApp.selectXAxisForCategoricalValue(3);

		// select the to category value from the drop down
		addSolutionSpaceBuilderApp.selectYAxisForCategoricalValue(2);

		// select the value from the number value drop down
		addSolutionSpaceBuilderApp.selectNumberValue(2);

		// select the aggregation value from the drop down
		addSolutionSpaceBuilderApp.selectAggregationValues(3);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the first section of the single section layout
		addSolutionSpaceBuilderApp.doubleClickSixSectionWidgetsSectionSixAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select category value from the drop down
		addSolutionSpaceBuilderApp.selectXAxisForOrderValue(1);

		// select all values from Y axis
		addSolutionSpaceBuilderApp.selectYAxisForNumberValue();

		// click on the y axis for number value drop down
		addSolutionSpaceBuilderApp.clickYAxisForNumberValueDropDown();

		// select the aggregation value from the drop down
		addSolutionSpaceBuilderApp.selectAggregationValues(3);

		// select category value from the drop down
		addSolutionSpaceBuilderApp.selectLegendCategory(1);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// click on the top drag bottom 2 layout tab
		addSolutionSpaceBuilderApp.clickTopDragBottom2LayoutTab();

		// wait for the element
		Thread.sleep(2000);

		// double click on the top drag bottom 2 layout section one
		addSolutionSpaceBuilderApp.doubleClickTopDragBottomLayoutSectionOne();

		// wait for the element
		Thread.sleep(3000);

		// Enter the widget title
		addSolutionSpaceBuilderApp.typeWidgetTitle(widgetTitle);

		// wait for the element
		Thread.sleep(3000);

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet1_XPATH", "ele_mapping_dataset_CSS");

		// wait for the element
		Thread.sleep(3000);

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// wait for the element
		Thread.sleep(3000);

		// select the from category value from the drop down
		addSolutionSpaceBuilderApp.selectFromCategoricalValue(1);

		// wait for the element
		Thread.sleep(2000);

		// select the to category value from the drop down
		addSolutionSpaceBuilderApp.selectToCategoricalValue(2);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// wait for the element
		Thread.sleep(2000);

		// double click on the top drag bottom 2 layout section one
		addSolutionSpaceBuilderApp.doubleClickTopDragBottomLayoutSectionTwo();

		// Enter the widget title
		addSolutionSpaceBuilderApp.typeWidgetTitle(widgetTitle);

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet1_XPATH", "ele_mapping_dataset_CSS");

		// wait for the element
		Thread.sleep(3000);

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// select the from category value from the drop down
		addSolutionSpaceBuilderApp.selectXAxisForOrderValue(1);

		// select all values from Y axis
		addSolutionSpaceBuilderApp.selectYAxisForNumberValue();

		// click on the y axis for number value drop down
		addSolutionSpaceBuilderApp.clickYAxisForNumberValueDropDown();

		// select the aggregation value from the drop down
		addSolutionSpaceBuilderApp.selectAggregationValues(3);

		Thread.sleep(2000);
		// select category value from the drop down
		addSolutionSpaceBuilderApp.selectLegendCategory(2);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// click on the submit button
		addSolutionSpaceBuilderApp.clickSubmit();

		// verify the success message
		addSolutionSpaceBuilderApp.veriryNewTabAddeSuccessMsg();

		// wait for element
		Thread.sleep(2000);

		// click on close solution space app builder button
		addSolutionSpaceBuilderApp.clickCloseSolutionSpaceAppBuilder();

		// click production space button
		addSolutionSpaceBuilderApp.clickProductionSpace();

		// click productionize confirmation yes button
		addSolutionSpaceBuilderApp.clickProductionizeConfirmationYes();

		// verify the production space done message
		addSolutionSpaceBuilderApp.verifyProductionSpaceDoneMsg();

		// wait for element
		Thread.sleep(2000);

		// validate the production space button is displayed disabled
		addSolutionSpaceBuilderApp.verifyproductionSpaceDisable();

		// click on the publish button
		dataset.clickPublish();

		// ADD DETAILS IN WORKSPACE SCHEMA PAGE

		// wait for element
		Thread.sleep(5000);

		// add the tag value in the workspace schema page
		workSpaceSchema.enterTag(tagName);

		// wait for element
		Thread.sleep(2000);

		// click on the save button
		workSpaceSchema.clickSave();

		// wait for element
		Thread.sleep(2000);

		// verify the success message
		workSpaceSchema.verifySaveWorkSpaceSchema();

		// click on the publish button
		workSpaceSchema.clickPublish();

		// CREATE THE CREATE MODEL SPACE LIBRARY

		// wait for element
		Thread.sleep(5000);

		// validate create model space library title
		createModelSpaceLibrary.verifyCreateModelSpaceLibraryTitle();

		// select the option from the Distribution drop down
		createModelSpaceLibrary.selectDistribution(testData.getProperty("distribution"));

		// select the option from the Product Item Categories drop down
		createModelSpaceLibrary.selectProductItemCategories(testData.getProperty("productitemcategories"));

		// enter the detals in the Product Item Description field
		createModelSpaceLibrary.typeProductItemDescription(testData.getProperty("productitemdescription"));

		// scroll to the submit button
		createModelSpaceLibrary.scrollToSubmitButton();

		// wait for element
		Thread.sleep(3000);

		// click on the submit button
		createModelSpaceLibrary.clickCreateModelSpaceLibrarySubmit();

		// VALIDATE NEWLY CREATED MODEL SPACE LIBRARY
		
		// enter the newly created model space library in search field
		modelSpaceLibraryList.typeWorkSpaceLibraryListSearch(workSpaceName);

		// click on the model space library tab
		modelSpaceLibraryList.clickModelSpaceLibraryTab();

		// wait for element
		Thread.sleep(3000);

		// verify newly created model space library in model space library tab
		modelSpaceLibraryList.verifyWorkspaceAvailabilityInModelSpaceLibrary(workSpaceName);

		// click on the productionized library tab
		modelSpaceLibraryList.clickProductionizedLibraryTab();

		// wait for element
		Thread.sleep(3000);

		// verify newly created model space library in productionized tab
		modelSpaceLibraryList.verifyWorkspaceAvailabilityInProductionized(workSpaceName);

		// DELETE THE NEWLY CREATED WORKSPACE
		
		// click on the space navigator
		dashboard.clickModuleNavigator();

		// click on the model space option
		dashboard.clickModuleNavigatorModelSpace();

		// wait for element
		Thread.sleep(3000);

		// search the newly created workspace
		workSpaceList.typeWorkSpaceSearch(workSpaceName);

		// wait for element
		Thread.sleep(3000);

		// click on the delete button of the workspace
		workSpaceList.clickDeleteWorkSpace();

		// wait for element
		Thread.sleep(3000);

		// click on the yes
		workSpaceList.clickDeleteWorkSpaceYes();

		// wait for element
		Thread.sleep(3000);

		// click on the module navigator
		dashboard.clickModuleNavigator();

		// wait for element
		Thread.sleep(3000);

		// click on the model space library
		dashboard.clickModuleNavigatorModelSpaceLibrary();

		// wait for element
		Thread.sleep(3000);

		// search the newly created workspace
		modelSpaceLibraryList.typeWorkSpaceLibraryListSearch(workSpaceName + "_");

		// click on the workspace card
		modelSpaceLibraryList.clickWorkSpaceCardBox();

		// wait for element
		Thread.sleep(3000);

		// click on the delete button of the workspace
		modelSpaceLibraryList.clickDeleteWorkSpace();

		// wait for element
		Thread.sleep(3000);

		// click on the yes button of the delete workspace pop up
		modelSpaceLibraryList.clickDeleteWorkSpaceYes();

		// wait for element
		Thread.sleep(3000);

		// verify the success message
		modelSpaceLibraryList.verifyLibraryDeletedSuccessfullyPopUp();
	}

}
