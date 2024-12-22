package com.ubix.pages.modelSpace;

import java.io.IOException;

import org.testng.Assert;

import com.ubix.base.TestBase;

public class AddSolutionSpaceAppBuilderPage extends TestBase {

	public void clickLayoutTab() {
		click("btn_layoutTab_CSS");
	}

	public void clickWidgetsTab() {
		click("btn_widgetsTab_CSS");
	}

	public void clickFourSelectionlayoutTab() {
		click("btn_fourSelectionLayoutTab_XPATH");
	}

	public void clickSingleSelectionLayoutTab() {
		click("btn_singleSelectionLayoutTab_XPATH");
	}

	public void clickFourSection() {
		click("lbl_fourSection_XPATH");
	}

	public void clickSingleTopGridLayout() {
		click("lbl_singleTopGridLayout_XPATH");
	}

	public void clickSixSectionLayout() {
		click("lbl_sixSectionLayout_XPATH");
	}

	public void clickTopDragBottom2Layout() {
		click("lbl_topDragBottom2Layout_XPATH");
	}

	public void clickTopDragMiddleDragBottomLayout() {
		click("lbl_topDragMiddleDragBottomLayout_XPATH");
	}

	public void clickTopDragMiddleLayout() {
		click("lbl_topDragMiddleLayout_XPATH");
	}

	public void clickTopMiddleBottomLayout() {
		click("lbl_topMiddleBottomLayout_XPATH");
	}

	public void clickTopMiddleDragBottomModelLayout() {
		click("lbl_topMiddleDragBottomModelLayout_XPATH");
	}

	public void clickTablesWidgets() {
		click("lbl_tablesWidgets_CSS");
	}

	public void clickVisualizationWidgets() {
		click("lbl_visualizationWidgets_XPATH");
	}

	public void clickBackToWidgets() {
		click("btn_backtoWidgets_XPATH");
	}

	public void clickDataVisualizeTableWidgets() {
		click("lbl_dataVisualizeTableWidgets_CSS");
	}

	public void clickBarAndColumnWidgets() throws InterruptedException {
		scrollToElement("lbl_barandColumnWidgets_XPATH");
		Thread.sleep(1000);
		click("lbl_barandColumnWidgets_XPATH");
	}

	public void clickDistributionWidgets() {
		click("lbl_distributionWidgets_XPATH");
	}

	public void clickFlowAndParallelSetsWidgets() {
		click("lbl_flowandParallelSetsWidgets_XPATH");
	}

	public void clickHeatMapsWidgets() {
		click("lbl_heatMapsWidgets_XPATH");
	}

	public void clickLineAndAreaWidgets() {
		click("lbl_lineandAreaWidgets_XPATH");
	}

	public void clickMapsAndGeographyWidgets() throws InterruptedException {

		scrollToElement("lbl_mapsandGeographyWidgets_XPATH");
		Thread.sleep(2000);
		click("lbl_mapsandGeographyWidgets_XPATH");
	}

	public void clickModelEvaluationWidgets() {
		click("lbl_modelEvaluationWidgets_XPATH");
	}

	public void clickScatterAndBubbleWidgets() {
		click("lbl_scatterandBubbleWidgets_XPATH");
	}

	public void clickTimeSeriesWidgets() {
		click("lbl_timeSeriesWidgets_XPATH");
	}

	public void clickWorkspaceTab() {
		click("btn_workspaceTab_CSS");
	}

	public void clickExternalTab() {
		click("btn_externalTab_CSS");
	}

	public void clickDataAccessTab() {
		click("btn_dataAccessTab_CSS");
	}

	public void doubleClickFirstChromeTab() {
		doubleClick("lbl_firstChromeTab_CSS");
	}

	public void typeFirstChromeTab(String input) {
		type("txt_firstChromeTab_CSS", input);
	}

	public void doubleClickFirstPageFirstChromeTab() {
		doubleClick("lbl_firstPageFirstChromeTab_CSS");
	}

	public void typeFirstPageFirstChromeTab(String input) {
		type("txt_firstPageFirstChromeTab_CSS", input);
	}

	public boolean isFourSectionWidgetsSectionOneAfterDroppedDisplayed() {
		return isDisplay("ele_fourSectionWidgets_sectionOneAfterDropped_CSS");
	}

	public boolean isFourSectionWidgetsSectionTwoAfterDroppedDisplayed() {
		return isDisplay("ele_fourSectionWidgets_sectionTwoAfterDropped_CSS");
	}

	public boolean isFourSectionWidgetsSectionThreeAfterDroppedDisplayed() {
		return isDisplay("ele_fourSectionWidgets_sectionThreeAfterDropped_CSS");
	}

	public boolean isFourSectionWidgetsSectionFourAfterDroppedDisplayed() {
		return isDisplay("ele_fourSectionWidgets_sectionFourAfterDropped_CSS");
	}

	public void doubleClickFourSectionWidgetsSectionOneAfterDropped() {
		doubleClick("ele_fourSectionWidgets_sectionOneAfterDropped_XPATH");
	}

	public void doubleClickFourSectionWidgetsSectionTwoAfterDropped() {
		doubleClick("ele_fourSectionWidgets_sectionTwoAfterDropped_XPATH");
	}

	public void doubleClickFourSectionWidgetsSectionThreeAfterDropped() {
		doubleClick("ele_fourSectionWidgets_sectionThreeAfterDropped_XPATH");
	}

	public void doubleClickFourSectionWidgetsSectionFourAfterDropped() {
		doubleClick("ele_fourSectionWidgets_sectionFourAfterDropped_XPATH");
	}

	public void doubleClickSingleSectionWidgetsSectionAfterDropped() {
		doubleClick("ele_singleTopGridWidgets_sectionOne_CSS");
	}

	public void clickDataSelectionPlusSign() {
		click("btn_dataSelection_plusSign_XPATH");
	}

	public void clickDataSelectionPlusSignForSecondParentChromeTab() {
		click("btn_dataSelection_plusSign_forSecondParentChromeTab_XPATH");
	}

	public void typeWidgetTitle(String input) {
		type("ele_widgetTitle_XPATH", input);
	}

	public void clickWorkSpaceDataSetDropdown() {
		click("btn_dataMapping_XPATH");
	}

	public void clickWorkSpaceDataSet() {
		click("dd_workSpaceDataSet_XPATH");
	}

	public void clickNextWidgetMappingModal() throws InterruptedException {
		Thread.sleep(3000);
		click("btn_nextWidgetMappingModal_XPATH");
	}

	public void selectXAxisForCategoricalValue(int option) throws IOException, InterruptedException {

		selectOptionFromDropDown(option, "dd_xAxisForCategoricalValue_XPATH",
				"dd_xAxisForCategoricalValueOptions_XPATH");

	}

	public void selectYAxisForCategoricalValue(int option) throws IOException, InterruptedException {

		selectOptionFromDropDown(option, "dd_yAxisForCategoricalValue_XPATH",
				"dd_yAxisForCategoricalValueOption_XPATH");

	}

	public void selectXAxisForOrderValue(int option) throws IOException, InterruptedException {

		selectOptionFromDropDown(option, "dd_xAxisForOrder_XPATH", "dd_xAxisForOrderOption_XPATH");

	}

	public void selectBloodpressureFromXAxisForOrder() {
		click("dd_xAxisForOrder_XPATH");

		click("ele_bloodpressure_XPATH");
	}

	public void select2ndXAxis(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_2ndXAxis_XPATH", "dd_2ndXAxisOptions_XPATH");

	}

	public void selectYAxisForNumericalValue(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_yAxisForNumericalValue_XPATH", "dd_yAxisForNumericalValueOptions_XPATH");
	}

	public void clickSaveDataMapping() {

		click("btn_saveDataMapping_XPATH");
	}

	public void selectLegendCategory(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_legendCategory_XPATH", "dd_legendCategoryOption_XPATH");
	}

	public void selectCategoryValue(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_categoryValue_XPATH", "dd_categoryValueOption_XPATH");

	}

	public void selectNumberValue(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_numberValue_XPATH", "dd_numberValueOption_XPATH");

	}

	public void selectFromCategoryValue(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_fromCategoryValue_XPATH", "dd_fromCategoryValueOption_XPATH");

	}

	public void selectFromCategoricalValue(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_fromCategoricalValue_XPATH", "dd_fromCategoryValueOptoin_XPATH");

	}

	public void selectToCategoricalValue(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_toCategoricalCalue_XPATH", "dd_toCategoricalValueOption_XPATH");


	}

	public void selectFromNumericalValue() {
		click("dd_fromNumerical_XPATH");
		click("dd_fromNumericalValue_XPATH");

	}

	public void selectToCategoryValue(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_toCategoryValue_XPATH", "dd_toCategoryValueOption_XPATH");

	}

	public void clickSubmit() {
		click("btn_submit_XPATH");
	}

	public void veriryNewTabAddeSuccessMsg() throws IOException {
		verifyTrue("txt_NewTabAddedSuccessMsg_XPATH", "Validation failing...");
	}

	public void clickSaveWidget() {
		click("btn_saveWidget_XPATH");
	}

	public void clickCloseSolutionSpaceAppBuilder() {
		click("btn_closeSolutionSpaceAppBuilder_XPATH");
	}

	public void clickProductionSpace() {
		click("btn_productionSpace_XPATH");
	}

	public void clickProductionizeConfirmationYes() {
		click("btn_productionizeConfirmationYes_XPATH");
	}

	public void verifyWorkSpaceDeleteSuccessMsg() throws IOException {
		verifyTrue("txt_workSpaceDeleteSuccessMsg_XPATH", "Validation failing...");
	}

	public void verifyProductionSpaceDoneMsg() throws IOException {
		verifyTrue("txt_productionSpaceDoneMsg_XPATH", "Validation failing...");
	}

	// Methods for widgets
	public void verifyMultiAxisBarChartAfterDropped() throws IOException {
		verifyTrue("ele_fourSectionWidgets_multiAxisBarChartAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyStackBarAfterDropped() throws IOException {
		verifyTrue("ele_fourSectionWidgets_stackBarAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyStackColumnAfterDropped() throws IOException {
		verifyTrue("ele_fourSectionWidgets_stackColumnAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyDonutChartAfterDropped() throws IOException {
		verifyTrue("ele_fourSectionWidgets_donutChartAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyDumbellChartAfterDropped() throws IOException {
		verifyTrue("ele_fourSectionWidgets_dumbellChartAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyProductionSpace() {
		String attributeValue = getAttribute("ele_productionSpaceDisable_XPATH", "class");
		Assert.assertEquals(attributeValue, "btn-holder ng-star-inserted");
	}

	public void verifyproductionSpaceDisable() throws IOException {

		verifyTrue("ele_productionSpaceDisable_XPATH", "The production space button is not displayed disabled.");

	}

	public void typeNumberOfBins() {

		type("ele_numberOfBins_XPATH", "2");
	}

	public void doubleClickSixSectionWidgetsSectionOneAfterDropped() {
		doubleClick("ele_sixSectionWidgets_sectionOneAfterDropped_XPATH");
	}

	public void doubleClickSixSectionWidgetsSectionTwoAfterDropped() {
		doubleClick("ele_sixSectionWidgets_sectionTwoAfterDropped_XPATH");
	}

	public void doubleClickSixSectionWidgetsSectionThreeAfterDropped() {
		doubleClick("ele_sixSectionWidgets_sectionThreeAfterDropped_XPATH");
	}

	public void doubleClickSixSectionWidgetsSectionFourAfterDropped() {
		doubleClick("ele_sixSectionWidgets_sectionFourAfterDropped_XPATH");
	}

	public void doubleClickSixSectionWidgetsSectionFiveAfterDropped() {
		doubleClick("ele_sixSectionWidgets_sectionFiveAfterDropped_XPATH");
	}

	public void doubleClickSixSectionWidgetsSectionSixAfterDropped() {
		doubleClick("ele_sixSectionWidgets_sectionSixAfterDropped_XPATH");
	}

	public void selectDiabeticFromLegendCategory() throws InterruptedException {

		click("dd_legendCategory_XPATH");
		Thread.sleep(1000);
		scrollToElement("dd_diabeticValueForLegendCategoryDD_XPATH");
		click("dd_diabeticValueForLegendCategoryDD_XPATH");

	}

	public void selectCategoryFromCategoryValueDD() {
		click("dd_categoryValue_XPATH");
		click("ele_categoryValue_XPATH");

	}

	public void clickTopDragBottom2LayoutTab() {
		click("btn_topDragBottom2_XPATH");
	}

	public void clicksixSectionLlayoutTab() {
		click("btn_sixSectionLlayout_XPATH");
	}

	public void clickTopDragMiddleDragBottomLayoutTab() {
		click("btn_topDragMiddleDragBottomLayout_XPATH");
	}

	public void clickTopDragMiddleLayoutTab() {
		click("btn_topDragMiddleLayout_XPATH");
	}

	public void clickTopMiddleBottomLayoutTab() {
		click("btn_topMiddleBottomLayout_XPATH");
	}

	public void clickTopMiddleDragBottomModelLayoutTab() {
		click("btn_topMiddleDragBottomModelLayout_XPATH");
	}

	public void scrollToLineChartWidgets() {
		scrollToElement("lbl_lineChartWidgets_XPATH");
	}

	public void scrollToDependencyWheelChart() {
		scrollToElement("lbl_dependencyWheelChartWidgets_XPATH");
	}

	public void doubleClickTopDragBottomLayoutSectionOne() {
		doubleClick("btn_TopDragBottomWidgets_sectionOneAfterDropped_XPATH");
	}

	public void doubleClickTopDragBottomLayoutSectionTwo() {
		doubleClick("btn_TopDragBottomWidgets_sectionTwoAfterDropped_XPATH");
	}

	public void verifyHistogramChartAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_histogramChartAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyDependencyChartAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_dependencyChartAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyFunnelChartAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_funnelChartAfterDropped_XPATH", "Validation failing...");
	}

	public void verifySankeyChartAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_sankeyChartAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyHeatmapAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_heatmapAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyLineChartAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_lineChartAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyNetworGraphChartAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_networGraphAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyStackAreaChartAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_stackedAreaAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyTreeMapChartAfterDropped() throws IOException {
		verifyTrue("ele_sixSectionWidgets_treemapGraphAfterDropped_XPATH", "Validation failing...");
	}

	public void verifyUSMapChartAfterDropped() throws IOException {
		verifyTrue("ele_topDragMiddleDragBottomLayout_USMapAfterDropped_XPATH", "Validation failing...");
	}

	public void clickParentChromeTabPlusSign() throws IOException {
		click("btn_parentChromeTab_plusSign_XPATH");
	}

	public void clickFirstNewTab() throws IOException {
		click("ele_firstNewTab_XPATH");
	}

	public void clickSecondNewTab() throws IOException {
		click("ele_secondNewTab_XPATH");
	}

	public void scrolltoTimeseriesResultVisualizationWidgets() throws IOException {
		scrollToElement("lbl_timeseriesResultVisualizationWidgets_XPATH");
	}

	public void scrolltoTrainClassificationResultVisualizationWidgets() throws IOException {
		scrollToElement("lbl_trainClassificationResultVisualizationWidgets_XPATH");
	}

	public void scrolltoTrainRegressionResultVisualizationWidgets() throws IOException {
		scrollToElement("lbl_trainRegressionResultVisualizationWidgets_XPATH");
	}

	public void scrolltoUsMapWidgetsWidgets() throws IOException, InterruptedException {
		Thread.sleep(2000);
		scrollToElement("lbl_usMapWidgets_XPATH");
	}

	public void doubleClickTopDragMiddleDragBottomLayoutUSMapAfterDropped() throws IOException {
		doubleClick("ele_topDragMiddleDragBottomLayout_USMapAfterDropped_XPATH");

	}

	public void doubleClickTopDragMiddleDragBottomLayoutHistoricalAfterDropped() throws IOException {
		doubleClick("ele_topDragMiddleDragBottomLayout_HistoricalAfterDropped_XPATH");

	}

	public void doubleClickTopDragMiddleDragBottomLayoutTimeSeriesAfterDropped() throws IOException {
		doubleClick("ele_topDragMiddleDragBottomLayout_TimeSeriesAfterDropped_XPATH");

	}

	public void doubleClickTopDragMiddleLayoutTrainAnomalyAfterDropped() throws IOException {
		doubleClick("ele_topDragMiddleLayout_TrainAnomalyAfterDropped_XPATH");

	}

	public void doubleClickTopDragMiddleLayoutTrainClassificationAfterDropped() throws IOException {
		doubleClick("ele_topDragMiddleLayout_TrainClassificationAfterDropped_XPATH");

	}

	public void doubleClickTopMiddleBottomLayoutTrainClustrtingAfterDropped() throws IOException {
		doubleClick("ele_topMiddleBottomLayout_TrainClustrtingAfterDropped_XPATH");

	}

	public void doubleClickTopMiddleBottomLayoutTrainRegressionAfterDropped() throws IOException {
		doubleClick("ele_topMiddleBottomLayout_TrainRegressionVisualizationAfterDropped_XPATH");

	}

	public void doubleClickTopMiddleBottomLayoutBubbleChartAfterDropped() throws IOException {
		doubleClick("ele_topMiddleBottomLayout_BubbleChartAfterDropped_XPATH");

	}

	public void doubleClickTopMiddleDragBottomModelLayoutScatterChartAfterDropped() throws IOException {
		doubleClick("ele_topMiddleDragBottomModelLayout_ScatterChartAfterDropped_XPATH");

	}

	public void doubleClickTopMiddleDragBottomModelLayoutTimeSeriesHistoricalDataAfterDropped() throws IOException {
		doubleClick("ele_topMiddleDragBottomModelLayout_TimeSeriesHistoricalDataAfterDropped_XPATH");

	}

	public void doubleClickTopMiddleDragBottomModelLayoutMultiAxisBarChartAfterDropped() throws IOException {
		doubleClick("ele_topMiddleDragBottomModelLayout_MultiAxisBarChartAfterDropped_XPATH");

	}

	public void scrollTohistoricalTimeseriesResultVisualization() throws IOException, InterruptedException {
		Thread.sleep(1000);
		scrollToElement("lbl_historicalTimeseriesResultVisualizationWidgets_XPATH");
	}

	public void scrollToTimeseriesHistorical() throws IOException, InterruptedException {
		Thread.sleep(2000);
		scrollToElement("lbl_timeseriesHistoricalDataWidgets_XPATH");
	}

	public void selectStateCode() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_stateCode_XPATH", "dd_stateCodeValue_XPATH");
	}

	public void selectNumberValues() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_numberValue_XPATH", "dd_numberValues_XPATH");
	}

	public void selectAggregationValues(int option) throws IOException, InterruptedException {
		selectOptionFromDropDown(option, "dd_aggregation_XPATH", "dd_aggregationOption_XPATH");
	}

	// Method to select a value from the X-axis for number value dropdown
	public void selectXAxisForNumberValue() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_XAxisForNumberValue_XPATH", "dd_XAxisForNumberValueOptions_XPATH");
	}

	// Method to select a value from the aggregation for bubble chart dropdown
	public void selectAggregationForBubbleChart() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_aggregationForBubbleChart_XPATH", "dd_aggregationForBubbleChartOptions_XPATH");
	}

	// Method to select a value from the Y-axis for number value dropdown
	public void selectYAxisForNumberValue() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_YAxisForNumberValue_XPATH", "dd_YAxisForNumberValueOption_XPATH");
	}

	public void clickYAxisForNumberValueDropDown() {
		click("dd_YAxisForNumberValue_XPATH");
	}

	// Method to select a value from the Z-axis for number value dropdown
	public void selectZAxisForNumberValue() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_ZAxisForNumberValue_XPATH", "dd_ZAxisForNumberValueOptions_XPATH");
	}

	// Method to select a value from the each dot categorical dropdown
	public void selectEachDotCategorical() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_eachDotCategorical_XPATH", "dd_eachDotCategoricalOptions_XPATH");
	}

	// Method to select a value from the color categorical dropdown
	public void selectColorCategorical() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_colorCategorical_XPATH", "dd_colorCategoricalOptions_XPATH");
	}

	public void selectXAxisForCategorical() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_XAxisForCategorical_XPATH", "dd_XAxisForCategoricalOptions_XPATH");
	}

	public void select2ndXAxis() throws IOException, InterruptedException {
		selectOptionFromDropDown(1, "dd_2ndXAxis_XPATH", "dd_2ndXAxisOptions_XPATH");
	}

}