/*
 * Copyright © 2023 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package stepsdesign;

import io.cdap.e2e.pages.actions.WranglerActions;
import io.cdap.e2e.pages.locators.WranglerLocators;
import io.cdap.e2e.utils.CdfHelper;
import io.cdap.e2e.utils.SeleniumHelper;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CDF wrangler related steps.
 */
public class WranglerSteps implements CdfHelper {
  private static final Logger logger = LoggerFactory.getLogger(WranglerSteps.class);

  static {
    SeleniumHelper.getPropertiesLocators(WranglerLocators.class);
  }


  @Then("Expand the dropdown to apply column transformations for column: {string}")
  public static void expandButton(String columnName) {
    WranglerActions.clickOnTransformationButton(columnName);
  }

//  @Then("Apply directive: {string} as {string}")
//  public static void selectDirectiveAndOption(String directive, String option) throws InterruptedException {
//    WranglerActions.selectDirectiveType(directive, option);
//  }

  @Then("Apply directive: {string}")
  public static void selectDirective(String directive) {
    WranglerActions.selectDirective(directive);
  }

  @Then("Click on Create pipeline button")
  public static void createPipelineButton() {
    WranglerActions.createPipelineButton();
  }

  @Then("Apply directive: {string} as {string}")
  public static void selectDirectiveAndEnterOption(String directive, String text) throws InterruptedException {
    WranglerActions.selectDirectiveAndOption(directive, text);
  }

  @Then("Enter directive from CLI {string}")
  public static void enterDirectiveFromUserInput(String directive) throws InterruptedException {
    WranglerActions.enterDirectiveFromCommandLine(directive);
  }

  @Then("Apply directive: {string} as {string} with {string} option")
  public static void selectDirectiveWithThreeOption(String directive, String option, String optionType)
    throws InterruptedException {
    WranglerActions.selectDirectiveTypeWithThreeOptions(directive, option, optionType);
  }

  @Then("Select checkbox on two columns {string} and {string}")
  public static void selectDirectiveOnTwoColumns(String column1, String column2)
    throws InterruptedException {
    WranglerActions.selectCheckboxOnTwoColumns(column1, column2);
  }

  @Then("Apply directive: {string} and select: {string} and enter: {string}")
  public static void selectDirectiveDropdownAndText(String directive, String option, String optionType)
    throws InterruptedException {
    WranglerActions.selectDirectiveTypeWithDropdownAndText(directive, option, optionType);
  }

  @Then("Apply directive:{string} with directive type: {string} and select {string} and enter {string}")
  public static void clickOnMultipleOption(String directive, String option, String text, String dropdown)
    throws InterruptedException {
    WranglerActions.selectDirectiveTypeWithFourOption(directive, option, text, dropdown);
  }

  @Then("Apply directive:{string} and select {string} with condition {string} with option {string} and name {string}")
  public static void clickOnFiveOption(String directive, String option1, String option2, String option3, String option4)
    throws InterruptedException {
    WranglerActions.selectDirectiveTypeWithFiveOption(directive, option1, option2, option3, option4);
  }
}
