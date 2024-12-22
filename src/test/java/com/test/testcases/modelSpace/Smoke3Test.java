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

public class Smoke3Test extends TestBase {
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
	public void smoke3Test() throws IOException, InterruptedException {

		// CREATED THE NEW WORKSPACE

		// Navigate on Home page
		dashboard.clickUbixLogo();

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

		// wait for the element
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

		// ADD THE DATASET FROM MULTIPLE DATASETS DROPDOWN IN THE WORKSPACE

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

		// select the different option from the datasets dropdown
		dataset.clickDataSetDropdown();

		// search and typing data set
		dataset.typeSearchDataSets(testData.getProperty("dataset_googleAnalytics_ubix"));

		// click on the searched result
		dataset.clickSearchedDatasetsGoogle();

		// type the available attribute in the search field
		dataset.typeAvailableAttributeSearch(testData.getProperty("attribute_googleAnalyticsUserBasic"));

		// wait for the element
		Thread.sleep(2000);

		// click on the checkbox of the searched result
		dataset.checkGoogleAnalyticsUserBasic();

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
		addSolution.selectSolutionType(testData.getProperty("solution_type_general_anomaly_detection_model"));

		// click on the add solution button
		addSolution.clickAddSolution();

		// verify the success message
		addSolution.verifySolutionAddedSuccessMsg();

		// ADD THE MULTIPLE ACTIONS IN THE SOLUTION

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

		// PERFORM THE EXECUTION ON ACTION 1 - FIRST TIME

		// doubleClick on newly created action
		addSolution.doubleClickNewlyCreatedAction1();

		// wait for the element
		Thread.sleep(2000);

		// drag and scroll down the first table
		addSolution.dragAndScrollDownElement();

		// wait for the element
		Thread.sleep(2000);

		// check 1st checkbox of the edit columns table
		addSolution.clickEditColumn1();

		// check 2nd checkbox of the edit columns table
		addSolution.clickEditColumn2();

		// check 3rd checkbox of the edit columns table
		addSolution.clickEditColumn3();

		// check 4th checkbox of the edit columns table
		addSolution.clickEditColumn4();

		// check 5th checkbox of the edit columns table
		addSolution.clickEditColumn5();

		// check 6th checkbox of the edit columns table
		addSolution.clickEditColumn6();

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

		// validate the selected field count
		addSolution.verifyCountofSelectedFields6();

		// click on the new execution button
		addSolution.clickNewExecute();

		// wait for the element
		Thread.sleep(3000);

		// PERFORM THE EXECUTION ON ACTION 1 - SECOND TIME

		// check 1st checkbox of the edit columns table
		addSolution.clickEditColumn1();

		// check 2nd checkbox of the edit columns table
		addSolution.clickEditColumn2();

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

		// waiting for the element
		Thread.sleep(3000);

		// validate the selected field count
		addSolution.verifyCountofSelectedFields2();

		// click on the new execution button
		addSolution.clickNewExecute();

		// PERFORM THE EXECUTION ON ACTION 1 - THIRD TIME

		// check 3rd checkbox of the edit columns table
		addSolution.clickEditColumn3();

		// check 4th checkbox of the edit columns table
		addSolution.clickEditColumn4();

		// check 5th checkbox of the edit columns table
		addSolution.clickEditColumn5();

		// check 6th checkbox of the edit columns table
		addSolution.clickEditColumn6();

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

		// validate the selected field count
		addSolution.verifyCountofSelectedFields4();

		// validate the count of executions
		addSolution.verifyExecutionNo1();
		addSolution.verifyExecutionNo2();
		addSolution.verifyExecutionNo3();

		// click on the execution no 1
		addSolution.clickExecutionNo1();

		// wait for element
		Thread.sleep(3000);

		// ACCEPT THE EXECUTION 1

		// click on accept execution button
		addSolution.clickAcceptExecution();

		// verify the success message
		addSolution.verifyAcceptedMsg();

		// click on close action space button
		addSolution.clickCloseActionSpace();

		// wait for the element
		Thread.sleep(3000);

		// doubleClick on newly created action
		addSolution.doubleClickNewlyCreatedAction3();

		// click on save changes button
		addSolution.clickSaveChanges();

		// click on execute button
		addSolution.clickExecute();

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

		// ADDING LAYOUTS ON TAB 1

		// click on the Top Drag Middle Drag Bottom layout
		addSolutionSpaceBuilderApp.clickTopDragMiddleDragBottomLayout();

		// wait for the element
		Thread.sleep(5000);

		// click on data selection plus button
		addSolutionSpaceBuilderApp.clickDataSelectionPlusSign();

		// wait for the element
		Thread.sleep(3000);

		// click on Top Drag Middle
		addSolutionSpaceBuilderApp.clickTopDragMiddleLayout();

		// wait for the element
		Thread.sleep(5000);

		// click on parent chrome tab plus sign
		addSolutionSpaceBuilderApp.clickParentChromeTabPlusSign();

		// wait for the element
		Thread.sleep(5000);

		// click on the top drag middle drag bottom layout
		addSolutionSpaceBuilderApp.clickTopMiddleBottomLayout();

		// wait for the element
		Thread.sleep(5000);

		// click on data selection plus button
		addSolutionSpaceBuilderApp.clickDataSelectionPlusSignForSecondParentChromeTab();

		// wait for the element
		Thread.sleep(3000);

		// click on the top drag middle drag bottom layout
		addSolutionSpaceBuilderApp.clickTopMiddleDragBottomModelLayout();

		// wait for the element
		Thread.sleep(3000);

		// click on the first new tab
		addSolutionSpaceBuilderApp.clickFirstNewTab();

		// click on the Top Drag Middle Drag Bottom tab
		addSolutionSpaceBuilderApp.clickTopDragMiddleDragBottomLayoutTab();

		// click on the widgets tab
		addSolutionSpaceBuilderApp.clickWidgetsTab();

		// wait for the element
		Thread.sleep(3000);

		// click on the visualization option
		addSolutionSpaceBuilderApp.clickVisualizationWidgets();

		// wait for the element
		Thread.sleep(2000);

		// click on the map and geography widgets
		addSolutionSpaceBuilderApp.clickMapsAndGeographyWidgets();

		// scroll to US map widgets
		addSolutionSpaceBuilderApp.scrolltoUsMapWidgetsWidgets();

		// perform drag and drop action for first section of the four section layout
		dragAndDrop("lbl_usMapWidgets_XPATH", "ele_topDragMiddleDragBottomLayout_sectionOne_XPATH");

		// wait for the element
		Thread.sleep(2000);
		// verify the US map chart after dropped
		addSolutionSpaceBuilderApp.verifyUSMapChartAfterDropped();

		// click on the model evaluation
		addSolutionSpaceBuilderApp.clickModelEvaluationWidgets();

		// scroll to historical timeseries result visualization
		addSolutionSpaceBuilderApp.scrollTohistoricalTimeseriesResultVisualization();

		// drag and drop the historical time series result visualization widgets
		dragAndDrop("lbl_historicalTimeseriesResultVisualizationWidgets_XPATH",
				"ele_topDragMiddleDragBottomLayout_sectionTwo_XPATH");

		// wait for element
		Thread.sleep(3000);

		// scroll to elemnet
		addSolutionSpaceBuilderApp.scrolltoTimeseriesResultVisualizationWidgets();

		// wait for element
		Thread.sleep(2000);

		// drag and drop the time series result visualization widgets
		dragAndDrop("lbl_timeseriesResultVisualizationWidgets_XPATH",
				"ele_topDragMiddleDragBottomLayout_sectionThree_XPATH");

		// click on the top drag middle layout tab
		addSolutionSpaceBuilderApp.clickTopDragMiddleLayoutTab();

		// wait for element
		Thread.sleep(2000);

		// drag and drop the train anomaly result visualization widgets
		dragAndDrop("lbl_trainAnomalyResultVisualizationWidgets_XPATH",
				"ele_TopDragBottomWidgets_sectionOneAfterDropped_XPATH");

		// wait for element
		Thread.sleep(1000);

		// scroll to element
		addSolutionSpaceBuilderApp.scrolltoTrainClassificationResultVisualizationWidgets();

		// wait for element
		Thread.sleep(1000);

		// drag and drop the train classification result visualization widgets
		dragAndDrop("lbl_trainClassificationResultVisualizationWidgets_XPATH",
				"ele_TopDragBottomWidgets_sectionTwoAfterDropped_XPATH");

		// wait for element
		Thread.sleep(3000);

		// click on the second new tab
		addSolutionSpaceBuilderApp.clickSecondNewTab();

		// click on the Top Drag Middle Drag Bottom tab
		addSolutionSpaceBuilderApp.clickTopMiddleBottomLayoutTab();

		// drag and drop the train clustering result visualization widgets
		dragAndDrop("lbl_trainClusteringResultVisualizationWidgets_XPATH",
				"ele_topMiddleBottomLayout_sectionOne_XPATH");

		// scroll to element
		addSolutionSpaceBuilderApp.scrolltoTrainRegressionResultVisualizationWidgets();

		// drag and drop the train regression result visualization widgets
		dragAndDrop("lbl_trainRegressionResultVisualizationWidgets_XPATH",
				"ele_topMiddleBottomLayout_sectionTwo_XPATH");

		// click on the scatter and bubble widgets
		addSolutionSpaceBuilderApp.clickScatterAndBubbleWidgets();

		// drag and drop bubble chart widgets
		dragAndDrop("lbl_bubbleChartWidgets_XPATH", "ele_topMiddleBottomLayout_sectionThree_XPATH");

		// wait for the element
		Thread.sleep(2000);

		addSolutionSpaceBuilderApp.clickTopMiddleDragBottomModelLayoutTab();

		// wait for the element
		Thread.sleep(2000);

		// drag and drop the scatter chart widgets
		dragAndDrop("lbl_scatterChartWidgets_XPATH", "ele_topMiddleDragBottomModelLayout_sectionOne_XPATH");

		// click on the time series widgets
		addSolutionSpaceBuilderApp.clickTimeSeriesWidgets();

		// scroll to element
		addSolutionSpaceBuilderApp.scrollToTimeseriesHistorical();

		dragAndDrop("lbl_timeseriesHistoricalDataWidgets_XPATH", "ele_topMiddleDragBottomModelLayout_sectionTwo_XPATH");

		// click on the bar and column widgets
		addSolutionSpaceBuilderApp.clickBarAndColumnWidgets();

		dragAndDrop("lbl_multiAxisBarChartWidgets_XPATH", "ele_topMiddleDragBottomModelLayout_sectionThree_XPATH");

		// click on the first new tab
		addSolutionSpaceBuilderApp.clickFirstNewTab();

		// click on the Top Drag Middle Drag Bottom layout
		addSolutionSpaceBuilderApp.clickTopDragMiddleDragBottomLayoutTab();

		// wait for the element
		Thread.sleep(2000);

		// click on the workspace data set
		addSolutionSpaceBuilderApp.clickWorkSpaceDataSet();

		// double click on the workspace data set
		addSolutionSpaceBuilderApp.doubleClickTopDragMiddleDragBottomLayoutUSMapAfterDropped();

		// Adding data mapping for the widget
		helper.widgetDataMapping(widgetTitle);

		// wait for the element
		Thread.sleep(3000);

		// select state code values
		addSolutionSpaceBuilderApp.selectStateCode();

		// select the number values
		addSolutionSpaceBuilderApp.selectNumberValues();

		// select the aggregation values
		addSolutionSpaceBuilderApp.selectAggregationValues(2);

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopDragMiddleDragBottomLayoutHistoricalAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_historicalTimeSeriesOutputData_XPATH");

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet1_XPATH", "ele_historicalTimeSeriesTargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopDragMiddleDragBottomLayoutTimeSeriesAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_selectInfoTargetData_XPATH");

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet1_XPATH", "ele_time_series_all_metrics_viz_TargetData_XPATH");

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_time_series_output_data_TargetData_XPATH");

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet1_XPATH", "ele_time_series_target_columns_viz_TargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		addSolutionSpaceBuilderApp.clickTopDragMiddleLayoutTab();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopDragMiddleLayoutTrainAnomalyAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_selectInfoTargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// scroll down the table
		addSolutionSpaceBuilderApp.doubleClickTopDragMiddleLayoutTrainClassificationAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_selectInfoTargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// click on the 2nd new tab
		addSolutionSpaceBuilderApp.clickSecondNewTab();

		// click on the layout tab
		addSolutionSpaceBuilderApp.clickTopMiddleBottomLayoutTab();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopMiddleBottomLayoutTrainClustrtingAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_selectInfoTargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopMiddleBottomLayoutTrainRegressionAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_selectInfoTargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopMiddleBottomLayoutBubbleChartAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_dataset_TargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// select options from x axis for number values drop down
		addSolutionSpaceBuilderApp.selectXAxisForNumberValue();

		// select options from aggregation drop down
		addSolutionSpaceBuilderApp.selectAggregationForBubbleChart();

		// select options from Y axis drop down
		addSolutionSpaceBuilderApp.selectYAxisForNumberValue();

		// select options from each dot drop down
		addSolutionSpaceBuilderApp.selectEachDotCategorical();

		// select options from colorCategorical drop down
		addSolutionSpaceBuilderApp.selectColorCategorical();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		addSolutionSpaceBuilderApp.clickTopMiddleDragBottomModelLayoutTab();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopMiddleDragBottomModelLayoutScatterChartAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_dataset_TargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// select respective field of the mapping model
		addSolutionSpaceBuilderApp.selectXAxisForNumberValue();
		addSolutionSpaceBuilderApp.selectAggregationForBubbleChart();
		addSolutionSpaceBuilderApp.selectYAxisForNumberValue();
		addSolutionSpaceBuilderApp.selectZAxisForNumberValue();
		addSolutionSpaceBuilderApp.selectEachDotCategorical();
		addSolutionSpaceBuilderApp.selectColorCategorical();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopMiddleDragBottomModelLayoutTimeSeriesHistoricalDataAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_time_series_all_metrics_viz_TargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// click on the save data mapping button
		addSolutionSpaceBuilderApp.clickSaveDataMapping();

		// double click on the layout
		addSolutionSpaceBuilderApp.doubleClickTopMiddleDragBottomModelLayoutMultiAxisBarChartAfterDropped();

		// drag and drop the data set
		dragAndDrop("dd_multiDraggableDataSet_XPATH", "ele_dataset_TargetData_XPATH");

		// click on the next button from widget data mapping modal
		addSolutionSpaceBuilderApp.clickNextWidgetMappingModal();

		// select option from the x axis for categorical
		addSolutionSpaceBuilderApp.selectXAxisForCategorical();

		// select option from the 2nd X axis
		addSolutionSpaceBuilderApp.select2ndXAxis();

		// select option from the y axis for number value
		addSolutionSpaceBuilderApp.selectYAxisForNumberValue();

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
