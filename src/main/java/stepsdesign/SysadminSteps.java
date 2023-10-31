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

import io.cdap.e2e.pages.actions.CdfSysAdminActions;
import io.cdap.e2e.utils.CdfHelper;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CDF sysadmin related step design.
 */
public class SysadminSteps implements CdfHelper {

  private static final Logger logger = LoggerFactory.getLogger(SysadminSteps.class);

  @Then("Verify the namespace created success message displayed on confirmation window")
  public void verifyNamespaceCreatedSuccessMessageDisplayed() {
    CdfSysAdminActions.namespaceCreatedSuccessMessage();
  }

  @Then("Verify the created namespace: {string} is displayed in Namespace tab")
  public void verifyCreatedNamespaceIsDisplayed(String namespace) {
    CdfSysAdminActions.verifyCreatedNamespaceIsDisplayed(namespace);
  }

  @Then("Click on close icon of successful namespace confirmation window")
  public void closeWindowIcon() {
    CdfSysAdminActions.clickOnCloseIconOnNamespaceWindow();
  }

  @Then("Click on Make HTTP calls from the System admin configuration page")
  public void clickOnMakeHttpCalls() {
    CdfSysAdminActions.clickOnMakeHttpCalls();
  }

  @Then("Click on send button")
  public void clickOnSendButton() {
    CdfSysAdminActions.sendRequest();
  }

  @Then("Verify the status code for success response")
  public void verifyStatusCode() {
    CdfSysAdminActions.verifySuccess();
  }

  @Then("Click on edit namespace preferences to set namespace preferences")
  public void clickOnEditNameSpacePreferences() {
    CdfSysAdminActions.clickOnEditNamespacePreference();
  }

  @Then("Click on the Hamburger menu on the left panel")
  public static void clickOnTheHamburgerMenu() {
    CdfSysAdminActions.clickOnHamburgerMenu();
  }

  @Then("Click {string} tab from Configuration page for {string} Namespace")
  public void openNameSpaceAdminPageTabs(String tabName, String nameSpace) {
    CdfSysAdminActions.clickOnNameSpaceAdminTabs(tabName, nameSpace);
  }

  @Then("Select navigation item: {string} from the Hamburger menu list")
  public void selectNavigationItemFromMenu(String tabName) {
    CdfSysAdminActions.selectHamburgerMenuList(tabName);
  }

  @Then("Click on the switch to namespace button")
  public static void clickOnTheSwitchToButton() {
    CdfSysAdminActions.clickOnSwitchToButton();
  }

  @Then("Select request dropdown property with option value: {string}")
  public void selectDropdownPluginPropertyOptionValue(String option) {
    CdfSysAdminActions.selectRequestDropdownOption(option);
  }
}
