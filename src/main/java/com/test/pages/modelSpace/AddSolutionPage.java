package com.ubix.pages.modelSpace;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ubix.base.TestBase;

public class AddSolutionPage extends TestBase {

	Actions actions = new Actions(driver);

	public void typeSolutionName(String input) {
		type("txt_solutionName_CSS", input);
	}

	public void selectSolutionType(String option) {
		select("dd_solutionType_CSS", option);
	}

	public void typeSolutionTypeDescription(String input) {
		type("txt_solutionTypeDescription_CSS", input);
	}

	public void clickAddSolution() {
		click("btn_addSolution_CSS");
	}

	public void clickPlusSign() {
		click("btn_plusSign_CSS");
	}

	public void clickDataAccessSave() {
		click("btn_dataAccess_save_CSS");
	}

	public void doubleClickNewlyCreatedAction1() {
		doubleClick("ele_newlyCreatedAction1_XPATH");
	}

	public void doubleClickNewlyCreatedAction2() {
		doubleClick("ele_newlyCreatedAction2_XPATH");
	}

	public void doubleClickNewlyCreatedAction3() {
		doubleClick("ele_newlyCreatedAction3_XPATH");
	}

	public void doubleClickNewlyCreatedAction4() {
		doubleClick("ele_newlyCreatedAction4_XPATH");
	}

	public void rightClickNewlyCreatedAction1() {
		contextClick("ele_newlyCreatedAction1_XPATH");
	}

	public void rightClickNewlyCreatedAction4() throws InterruptedException {
		explicitWaitClickable("ele_newlyCreatedAction4_XPATH");
		contextClick("ele_newlyCreatedAction4_XPATH");
	}

	public void clickAddActions() {
		click("opt_contextClick_addAction_XPATH");
	}

	public void rightClickDeleteActions() {
		contextClick("opt_contextClick_deleteAction_XPATH");
	}

	public void clickRecommendedTab() {
		click("btn_recommendedTab_XPATH");
	}

	public void clickGeneralActionTab() {
		click("btn_generalActionTab_XPATH");
	}

	public void clickAggregateColumns() {
		scrollToElement("btn_generalActionTab_aggregateColumns_XPATH");
		click("btn_generalActionTab_aggregateColumns_XPATH");
	}

	public void clickCalculateColumns() {
		scrollToElement("btn_generalActionTab_calculateColumns_XPATH");
		click("btn_generalActionTab_calculateColumns_XPATH");
	}

	public void clickDataTable() {
		scrollToElement("btn_generalActionTab_dataTable_XPATH");
		click("btn_generalActionTab_dataTable_XPATH");
	}

	public void clickEditColumnsFilterRows() {
		scrollToElement("btn_generalActionTab_editColumnsFilterRows_XPATH");
		click("btn_generalActionTab_editColumnsFilterRows_XPATH");
	}

	public void clickEditDocuments() {
		scrollToElement("btn_generalActionTab_editDocuments_XPATH");
		scrollToElement("btn_generalActionTab_encodingColumns_XPATH");
		click("btn_generalActionTab_editDocuments_XPATH");
	}

	public void clickEncodingColumns() {
		scrollToElement("btn_generalActionTab_encodingColumns_XPATH");
		click("btn_generalActionTab_encodingColumns_XPATH");
	}

	public void clickFeatureSelection() {
		scrollToElement("btn_generalActionTab_featureSelection_XPATH");
		click("btn_generalActionTab_featureSelection_XPATH");
	}

	public void clickFillMissingValues() {
		scrollToElement("btn_generalActionTab_fillMissingValues_XPATH");
		click("btn_generalActionTab_fillMissingValues_XPATH");
	}

	public void clickHistoricalTimeSeries() {
		scrollToElement("btn_generalActionTab_historicalTimeSeries_XPATH");
		click("btn_generalActionTab_historicalTimeSeries_XPATH");
	}

	public void clickJoinAppend() {
		scrollToElement("btn_generalActionTab_joinAppend_XPATH");
		click("btn_generalActionTab_joinAppend_XPATH");
	}

	public void clickJoinDocuments() throws InterruptedException {

		scrollToElement("btn_generalActionTab_featureSelection_XPATH");
		scrollToElement("btn_generalActionTab_historicalTimeSeries_XPATH");
		Thread.sleep(1000);
		scrollToElement("btn_generalActionTab_joinDocuments_XPATH");
		Thread.sleep(1000);
		click("btn_generalActionTab_joinDocuments_XPATH");
	}

	public void clickNLP() {
		scrollToElement("btn_generalActionTab_nLP_XPATH");
		click("btn_generalActionTab_nLP_XPATH");
	}

	public void clickRemoveOutliers() {
		scrollToElement("btn_generalActionTab_removeOutliers_XPATH");
		click("btn_generalActionTab_removeOutliers_XPATH");
	}

	public void clickRetrievalAugmentedGeneration() {
		scrollToElement("btn_generalActionTab_retrievalAugmentedGeneration_XPATH");
		click("btn_generalActionTab_retrievalAugmentedGeneration_XPATH");
	}

	public void clickScalingColumns() {
		scrollToElement("btn_generalActionTab_scalingColumns_XPATH");
		click("btn_generalActionTab_scalingColumns_XPATH");
	}

	public void clickSessionize() {
		scrollToElement("btn_generalActionTab_sessionize_XPATH");
		click("btn_generalActionTab_sessionize_XPATH");
	}

	public void clickSplitBalance() {
		scrollToElement("btn_generalActionTab_splitBalance_XPATH");
		click("btn_generalActionTab_splitBalance_XPATH");
	}

	public void clickTrainAnomalyDetection() {
		scrollToElement("btn_generalActionTab_trainAnomalyDetection_XPATH");
		click("btn_generalActionTab_trainAnomalyDetection_XPATH");
	}

	public void clickTrainClassification() {
		scrollToElement("btn_generalActionTab_trainClassification_XPATH");
		click("btn_generalActionTab_trainClassification_XPATH");
	}

	public void clickTrainClustering() {
		scrollToElement("btn_generalActionTab_trainClustering_XPATH");
		click("btn_generalActionTab_trainClustering_XPATH");
	}

	public void clickTrainRegression() {
		scrollToElement("btn_generalActionTab_trainRegression_XPATH");
		click("btn_generalActionTab_trainRegression_XPATH");
	}

	public void clickTrainTimeSeries() {
		scrollToElement("btn_generalActionTab_trainTimeSeries_XPATH");
		click("btn_generalActionTab_trainTimeSeries_XPATH");
	}

	public void clickAddGeneralAction() {

		click("btn_addGeneralAction_XPATH");
	}

	public void clickAddActionNavigator() {
		click("btn_addActionNavigator_XPATH");
	}

	public void clickSaveChanges() {
		click("btn_saveChanges_XPATH");
	}

	public void clickExecute() {
		click("btn_execute_XPATH");
	}

	public void clickNewExecute() {
		click("btn_newExecute_XPATH");
	}

	public boolean isExecutionInProgressDisplayed() {
		return isDisplay("lbl_executionInProgress_XPATH");
	}

	public void clickAcceptExecution() {

		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("btn_acceptExecution_XPATH"))));
		element.click();

	}

	public boolean isAcceptedDisplayed() {
		return isDisplay("lbl_accepted_XPATH");
	}

	public void clickCloseActionSpace() {

		click("btn_closeActionSpace_CSS");
	}

	public void doubleClickForeignObject() {
		doubleClick("ele_foreign_object_XPATH");
	}

	public void verifySolutionAddedSuccessMsg() throws IOException {
		verifyTrue("txt_solutionAddedSuccessMsg_XPATH", "Validation failing...");
	}

	public void verifyAcceptedMsg() throws IOException {
		verifyTrue("lbl_accepted_XPATH", "Validation failing...");
	}

	public void clickEditColumn1() throws InterruptedException {
		scrollToElement("ckbx_editColumn_1_XPATH");
		Thread.sleep(1000);
		click("ckbx_editColumn_1_XPATH");

	}

	public void clickEditColumn2() throws InterruptedException {

		scrollToElement("ckbx_editColumn_2_XPATH");
		Thread.sleep(1000);
		click("ckbx_editColumn_2_XPATH");

	}

	public void clickEditColumn3() throws InterruptedException {

		scrollToElement("ckbx_editColumn_3_XPATH");
		Thread.sleep(1000);
		click("ckbx_editColumn_3_XPATH");

	}

	public void clickEditColumn4() throws InterruptedException {

		scrollToElement("ckbx_editColumn_4_XPATH");
		Thread.sleep(1000);
		click("ckbx_editColumn_4_XPATH");

	}

	public void clickEditColumn5() throws InterruptedException {

		scrollToElement("ckbx_editColumn_5_XPATH");
		Thread.sleep(1000);
		click("ckbx_editColumn_5_XPATH");

	}

	public void clickEditColumn6() throws InterruptedException {

		scrollToElement("ckbx_editColumn_6_XPATH");
		Thread.sleep(1000);
		click("ckbx_editColumn_6_XPATH");

	}

	public void verifyProvisioningExecutionResourcesProgressBar() throws IOException {
		verifyTrue("ele_progress_provisioningExecutionResources_XPATH",
				"Not displayed Provisioning Execution Resources as a completed.");
	}

	public void verifyLoadingAndPreparingInputDatasetsProgressBar() throws IOException {
		verifyTrue("ele_progress_loading&PreparingInputdatasets_XPATH",
				"Not displayed Loading & Preparing Input datasets as a completed.");
	}

	public void verifyLoadingFunctionToMemoryProgressBar() throws IOException {
		verifyTrue("ele_progress_loadingFunctiontomemory_XPATH",
				"Not displayed Loading Function to memory as a completed.");
	}

	public void verifyProcessingDataAndRunningComputationsProgressBar() throws IOException {
		verifyTrue("ele_progress_processingDataandRunningComputations_XPATH",
				"Not displayed Processing Data and Running Computations as a completed.");
	}

	public void verifySavingFeaturesProgressBar() throws IOException {
		verifyTrue("ele_progress_savingFeatures_XPATH", "Not displayed Saving Features as a completed.");
	}

	public void verifyGeneratingResultsProgressBar() throws IOException {
		verifyTrue("ele_progress_generatingResults_XPATH", "Not displayed Generating Results as a completed.");
	}

	public void verifyCountofSelectedFields6() throws IOException, InterruptedException {

		List<WebElement> selectedFields = driver.findElements(By.xpath(OR.getProperty("ele_selectedColumns_XPATH")));
		verifyEqualsModified(Integer.toString(selectedFields.size()), "6");
		Thread.sleep(3000);
	}

	public void verifyCountofSelectedFields2() throws IOException, InterruptedException {
		List<WebElement> selectedFields = driver.findElements(By.xpath(OR.getProperty("ele_selectedColumns_XPATH")));
		verifyEqualsModified(Integer.toString(selectedFields.size()), "2");
		Thread.sleep(3000);
	}

	public void verifyCountofSelectedFields4() throws IOException, InterruptedException {
		List<WebElement> selectedFields = driver.findElements(By.xpath(OR.getProperty("ele_selectedColumns_XPATH")));
		verifyEqualsModified(Integer.toString(selectedFields.size()), "4");
		Thread.sleep(3000);
	}

	public void verifyExecutionNo1() throws IOException {
		verifyTrue("lbl_executionNo1_XPATH", "Execution No: 1 is not displayed.");
	}

	public void verifyExecutionNo2() throws IOException {
		verifyTrue("lbl_executionNo2_XPATH", "Execution No: 2 is not displayed.");
	}

	public void verifyExecutionNo3() throws IOException {
		verifyTrue("lbl_executionNo3_XPATH", "Execution No: 3 is not displayed.");
	}

	public void clickExecutionNo1() throws IOException {
		click("lbl_executionNo1_XPATH");
	}

	public void dragAndScrollDownElement() throws IOException {

		WebElement dragElement = driver.findElement(By.cssSelector(OR.getProperty("ele_editColunmDragElement_CSS")));
		// Perform the drag and scroll action
		actions.clickAndHold(dragElement).moveByOffset(0, 100) // Adjust the offset as needed
				.release().build().perform();
	}

	public void clickSelectAllUbixDocs() {
		click("ckbx_selectAll_UbixDocs_XPATH");
	}

	public void doubleClickDataTable5() {
		scrollToElement("ele_newlyCreatedAction_dataTable5_XPATH");
		doubleClick("ele_newlyCreatedAction_dataTable5_XPATH");
	}

	public void doubleClickSessionize18() {
		scrollToElement("ele_newlyCreatedAction_sessionize18_XPATH");
		doubleClick("ele_newlyCreatedAction_sessionize18_XPATH");
	}

	public void doubleClickJoinAppend13() {
		scrollToElement("ele_newlyCreatedAction_joinAppend13_XPATH");
		doubleClick("ele_newlyCreatedAction_joinAppend13_XPATH");
	}

	public void doubleClickTrainSplit19() {
		scrollToElement("ele_newlyCreatedAction_trainSplit19_XPATH");
		doubleClick("ele_newlyCreatedAction_trainSplit19_XPATH");
	}

	public void doubleClickAggregateColumns5() {
		scrollToElement("ele_newlyCreatedAction_aggregateColumns5_XPATH");
		doubleClick("ele_newlyCreatedAction_aggregateColumns5_XPATH");
	}

	public void doubleClickJoinDocuments4() {
		scrollToElement("ele_newlyCreatedAction_joinDocuments4_XPATH");
		doubleClick("ele_newlyCreatedAction_joinDocuments4_XPATH");
	}

	public void doubleClickCalculateColumn6() {
		scrollToElement("ele_newlyCreatedAction_calculateColumn6_XPATH");
		doubleClick("ele_newlyCreatedAction_calculateColumn6_XPATH");
	}

	public void doubleClickEncodingColumns9() {
		scrollToElement("ele_newlyCreatedAction_encodingColumns9_XPATH");
		doubleClick("ele_newlyCreatedAction_encodingColumns9_XPATH");
	}

	public void doubleClickRemoveOutliers15() {
		scrollToElement("ele_newlyCreatedAction_removeOutliers15_XPATH");
		doubleClick("ele_newlyCreatedAction_removeOutliers15_XPATH");
	}

	public void doubleClickScalingColumns17() {
		scrollToElement("ele_newlyCreatedAction_scalingColumns17_XPATH");
		doubleClick("ele_newlyCreatedAction_scalingColumns17_XPATH");
	}

	public void doubleClickTrainClustering22() {
		scrollToElement("ele_newlyCreatedAction_trainClustering22_XPATH");
		doubleClick("ele_newlyCreatedAction_trainClustering22_XPATH");
	}

	public void doubleClickFeatureSelection10() {
		scrollToElement("ele_newlyCreatedAction_featureSelection10_XPATH");
		doubleClick("ele_newlyCreatedAction_featureSelection10_XPATH");
	}

	public void doubleClickTrainTimeSeries24() {
		scrollToElement("ele_newlyCreatedAction_trainTimeSeries24_XPATH");
		doubleClick("ele_newlyCreatedAction_trainTimeSeries24_XPATH");
	}

	public void doubleClickFillMissingValues11() {
		scrollToElement("ele_newlyCreatedAction_fillMissingValues11_XPATH");
		doubleClick("ele_newlyCreatedAction_fillMissingValues11_XPATH");
	}

	public void doubleClickTrainClassification21() {
		scrollToElement("ele_newlyCreatedAction_trainClassification21_XPATH");
		doubleClick("ele_newlyCreatedAction_trainClassification21_XPATH");
	}

	public void doubleClickHistoricalTimeSeries12() {
		scrollToElement("ele_newlyCreatedAction_historicalTimeSeries12_XPATH");
		doubleClick("ele_newlyCreatedAction_historicalTimeSeries12_XPATH");
	}

	public void doubleClickEditColumnsFilterRows8() {
		scrollToElement("ele_newlyCreatedAction_editColumnsFilterRows8_XPATH");
		doubleClick("ele_newlyCreatedAction_editColumnsFilterRows8_XPATH");
	}

	public void doubleClickTrainAnomalyDetection20() {
		scrollToElement("ele_newlyCreatedAction_trainAnomalyDetection20_XPATH");
		doubleClick("ele_newlyCreatedAction_trainAnomalyDetection20_XPATH");
	}

	public void doubleClickRetrievalAugmentedGeneration16() {
		scrollToElement("ele_newlyCreatedAction_retrievalAugmentedGeneration16_XPATH");
		doubleClick("ele_newlyCreatedAction_retrievalAugmentedGeneration16_XPATH");
	}

	public void doubleClickEditDocuments3() {
		scrollToElement("ele_newlyCreatedAction_editDocuments3_XPATH");
		doubleClick("ele_newlyCreatedAction_editDocuments3_XPATH");
	}

	public void clickSelectAllAggregateColumn3GroupBy() {
		click("ckbx_selectAll_AggregateColumn3_GroupBy_XPATH");
	}

	public void clickSelectAllAggregateColumn3Aggregate() {
		click("ckbx_selectAll_AggregateColumn3_Aggregate_XPATH");
	}

	public void selectAggregateColumn3Aggregate(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_select_AggregateColumn3_Aggregate_XPATH",
				"dd_select_AggregateColumn3_AggregateOptions_XPATH");
	}

	public void clickAddNewColumnCalculateColumn() {
		click("btn_addNewColumn_CalculateColumn_XPATH");
	}

	public void typeColumnNameCalculateColumn(String value) {
		type("type_columnName_CalculateColumn_XPATH", value);
	}

	public void clickAddNewColumnCalculateColumnAction() {
		click("btn_addNewColumn_calculateColumnAction_XPATH");
	}

	public void clickSelectAllJoinAppend() {
		click("ele_outsideLoader_XPATH");
	}

	public void clickAddDataTableButton() {
		click("btn_addDataTable_dataTable5_XPATH");
	}

	public void selectUniqueValueOption(int option) throws IOException, InterruptedException {

		selectOptionFromDropDown(option, "dd_uniqueValue_dataTable5_XPATH", "dd_uniqueValueOption_dataTable5_XPATH");

	}

	public void selectAdditionalAttributesOption(int option) throws IOException, InterruptedException {

		selectOptionFromDropDown(option, "dd_additionalAttributes_dataTable5_XPATH", "dd_additionalAttributesOption_dataTable5_XPATH");

		click("dd_additionalAttributes_dataTable5_XPATH");
		click("dd_additionalAttributesOption_dataTable5_XPATH");
	}

	public void clickContinueButton() {
		click("btn_continueBtn_dataTable5_XPATH");
	}

}