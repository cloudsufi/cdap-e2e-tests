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
import io.cdap.e2e.pages.locators.CdfHubLocators;
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
  private static final Logger logger = LoggerFactory.getLogger(CdfHubSteps.class);
  static {
    SeleniumHelper.getPropertiesLocators(CdfHubLocators.class);
  }


@Then("Expand the dropdown to apply column transformations for column: {string}")
public static void expandButton(String columnName) {
  WranglerActions.clickOnTransformationButton(columnName);
  }

  @Then("Apply directive: {string} as {string}")
  public static void selectDirectiveAndOption(String directive, String option) throws InterruptedException {
    WranglerActions.selectDirectiveType(directive, option);
  }

  @Then("Apply directive: {string}")
  public static void selectDirective(String directive) {
    WranglerActions.selectDirective(directive);
  }

  @Then("Apply directive: {string} with value {string}")
  public static void selectDirectiveAndEnterText(String directive, String text) throws InterruptedException {
    WranglerActions.selectDirectiveAndEnterValue(directive, text);
  }

  @Then("Apply directive: {string} as {string} with {string} option")
  public static void selectDirectiveAndOption(String directive, String option, String optionType)
    throws InterruptedException {
    WranglerActions.selectDirectiveTypeWithOption(directive, option, optionType);
  }

  @Then("Click on scroll down option")
  public static void clickOnScrollOption() throws InterruptedException {
    WranglerActions.clickOnScrollDownOption();
  }

  @Then("Apply directive:{string} as {string} and enter {string} at {string}")
  public static void clickOnMultipleOption(String directive, String option, String text, String dropdown)
    throws InterruptedException {
    WranglerActions.selectDirectiveTypeWithMultipleOption(directive, option, text, dropdown);
  }
}
