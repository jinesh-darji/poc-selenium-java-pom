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

public class Smoke1Test extends TestBase {
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
	public void smoke1Test() throws IOException, InterruptedException {

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

		// click on the newly created worksapce
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
		addSolution.selectSolutionType(testData.getProperty("solution_type_general_regression_model"));

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

		// click on the save button
		addSolution.clickDataAccessSave();

		// verify the success message
		dataset.verifyWorkSpaceDataUpdatedSuccessMsg();

		// doubleClick on newly created action
		addSolution.doubleClickNewlyCreatedAction1();

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
		addSolutionSpaceBuilderApp.clickFourSection();

		// wait for the element
		Thread.sleep(5000);

		// click on data selection plus button
		addSolutionSpaceBuilderApp.clickDataSelectionPlusSign();

		// wait for the element
		Thread.sleep(3000);

		// click on the single top grid layout
		addSolutionSpaceBuilderApp.clickSingleTopGridLayout();

		// wait for the element
		Thread.sleep(3000);

		// click on the four selection layout tab
		addSolutionSpaceBuilderApp.clickFourSelectionlayoutTab();

		// wait for the element
		Thread.sleep(3000);

		// click on the widgets tab
		addSolutionSpaceBuilderApp.clickWidgetsTab();

		// wait for the element
		Thread.sleep(3000);

		// click on the visualization option
		addSolutionSpaceBuilderApp.clickVisualizationWidgets();

		// wait for the element
		Thread.sleep(3000);

		// click on the bar and column option
		addSolutionSpaceBuilderApp.clickBarAndColumnWidgets();

		// wait for the element
		Thread.sleep(3000);

		// perform drag and drop action for first section of the four section layout
		dragAndDrop("lbl_multiAxisBarChartWidgets_XPATH", "ele_fourSectionWidgets_sectionOne_CSS");

		// wait for the element
		Thread.sleep(3000);

		// verify the multi axis bar chart after dropped
		addSolutionSpaceBuilderApp.verifyMultiAxisBarChartAfterDropped();

		// perform drag and drop action for first section of the four section layout
		dragAndDrop("lbl_stackedBarWidgets_XPATH", "ele_fourSectionWidgets_sectionTwo_CSS");

		// wait for the element
		Thread.sleep(3000);

		// verify the stack bar after dropped
		addSolutionSpaceBuilderApp.verifyStackBarAfterDropped();

		// perform drag and drop action for second section of the four section layout
		dragAndDrop("lbl_stackedColumnWidgets_XPATH", "ele_fourSectionWidgets_sectionThree_CSS");

		// wait for the element
		Thread.sleep(3000);

		// verify the stack column after dropped
		addSolutionSpaceBuilderApp.verifyStackColumnAfterDropped();

		// click on the distribution option
		addSolutionSpaceBuilderApp.clickDistributionWidgets();

		// wait for the element
		Thread.sleep(3000);

		// perform drag and drop action for fourth section of the four section layout
		dragAndDrop("lbl_donutChartWidgets_XPATH", "ele_fourSectionWidgets_sectionFour_CSS");

		// wait for the element
		Thread.sleep(3000);

		// verify the donut chart after dropped
		addSolutionSpaceBuilderApp.verifyDonutChartAfterDropped();

		// click on the single selection layout tab
		addSolutionSpaceBuilderApp.clickSingleSelectionLayoutTab();

		// wait for the element
		Thread.sleep(3000);

		// perform drag and drop action for first section of the single section layout
		dragAndDrop("lbl_dumbbellChartWidgets_XPATH", "ele_singleTopGridWidgets_sectionOne_CSS");

		// wait for the element
		Thread.sleep(3000);

		// verify the dumbbell chart after dropped
		addSolutionSpaceBuilderApp.verifyDumbellChartAfterDropped();

		// click on the four selection layout tab
		addSolutionSpaceBuilderApp.clickFourSelectionlayoutTab();

		// click on the workspace data set
		addSolutionSpaceBuilderApp.clickWorkSpaceDataSet();

		// double click on the first section of the four section layout
		addSolutionSpaceBuilderApp.doubleClickFourSectionWidgetsSectionOneAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the diabetic for x-axis dropdown
		addSolutionSpaceBuilderApp.selectXAxisForCategoricalValue(1);

		// select the diabetic for 2nd x-axis dropdown
		addSolutionSpaceBuilderApp.select2ndXAxis(1);

		// select the diabetic for y-axis dropdown
		addSolutionSpaceBuilderApp.selectYAxisForNumericalValue(1);

		addSolutionSpaceBuilderApp.selectAggregationValues(1);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the second section of the four section layout
		addSolutionSpaceBuilderApp.doubleClickFourSectionWidgetsSectionTwoAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the diabetic for x-axis dropdown
		addSolutionSpaceBuilderApp.selectXAxisForCategoricalValue(2);

		// select the diabetic for y-axis dropdown
		addSolutionSpaceBuilderApp.selectYAxisForNumericalValue(2);

		// select aggregation value
		addSolutionSpaceBuilderApp.selectAggregationValues(2);

		// select the legend category dropdown
		addSolutionSpaceBuilderApp.selectLegendCategory(1);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the third section of the four section layout
		addSolutionSpaceBuilderApp.doubleClickFourSectionWidgetsSectionThreeAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the diabetic for x-axis dropdown
		addSolutionSpaceBuilderApp.selectXAxisForCategoricalValue(3);

		// select the diabetic for y-axis dropdown
		addSolutionSpaceBuilderApp.selectYAxisForNumericalValue(3);

		// select aggregation value
		addSolutionSpaceBuilderApp.selectAggregationValues(3);

		// select the legend category dropdown
		addSolutionSpaceBuilderApp.selectLegendCategory(2);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the fourth section of the four section
		addSolutionSpaceBuilderApp.doubleClickFourSectionWidgetsSectionFourAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the category value from the dropdown
		addSolutionSpaceBuilderApp.selectCategoryValue(1);

		// select the number value from the dropdown
		addSolutionSpaceBuilderApp.selectNumberValue(1);

		// select aggregation value
		addSolutionSpaceBuilderApp.selectAggregationValues(4);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// wait for the element
		Thread.sleep(3000);

		// Switching to single selection layout tab
		addSolutionSpaceBuilderApp.clickSingleSelectionLayoutTab();

		// wait for the element
		Thread.sleep(3000);

		// double click on the first section of the single section layout
		addSolutionSpaceBuilderApp.doubleClickSingleSectionWidgetsSectionAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// select the category value from the dropdown
		addSolutionSpaceBuilderApp.selectCategoryValue(2);

		// select the number value from the dropdown
		addSolutionSpaceBuilderApp.selectNumberValue(2);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// click on the submit button
		addSolutionSpaceBuilderApp.clickSubmit();

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

		// add the tag
		workSpaceSchema.enterTag(tagName);

		// wait for element
		Thread.sleep(2000);

		// click on the save button
		workSpaceSchema.clickSave();

		// wait for element
		Thread.sleep(2000);

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
		
		Thread.sleep(3000);
		// click on the yes button of the delete workspace popup
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
