/*
 * Copyright © 2021 Cask Data, Inc.
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

package io.cdap.e2e.pages.actions;

import io.cdap.e2e.pages.locators.CdfSysAdminLocators;
import io.cdap.e2e.utils.AssertionHelper;
import io.cdap.e2e.utils.ConstantsUtil;
import io.cdap.e2e.utils.ElementHelper;
import io.cdap.e2e.utils.PluginPropertyUtils;
import io.cdap.e2e.utils.SeleniumHelper;
import io.cdap.e2e.utils.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents CdfSysAdminActions
 */
public class CdfSysAdminActions {
  private static final Logger logger = LoggerFactory.getLogger(CdfSysAdminActions.class);
  public static CdfSysAdminLocators cdfSysAdminLocators;

  static {
    cdfSysAdminLocators = SeleniumHelper.getPropertiesLocators(CdfSysAdminLocators.class);
  }

  public static void clickSystemAdminMenu() {
    ElementHelper.clickOnElement(CdfSysAdminLocators.systemAdminMenu);
  }

  public static void clickConfigurationMenu() {
    ElementHelper.clickOnElement(CdfSysAdminLocators.configurationMenu);
  }

  public static void selectMacroAPIService(String service) {
    Select drpAPIRequest = new Select(CdfSysAdminLocators.apiCallType);
    drpAPIRequest.selectByVisibleText(service);
  }

  public static void enterURI(String service) {
    CdfSysAdminLocators.apiInputURI.sendKeys(service);
  }

  public static void enterRequestBody(String requestBody) {
    CdfSysAdminLocators.requestBody.sendKeys(requestBody);
  }

  public static void clearRequest() {
    CdfSysAdminLocators.clearButton.click();
  }

  public static void clearAllRequest() {
    CdfSysAdminLocators.clearAll.click();
  }

  public static void sendRequest() {
    CdfSysAdminLocators.sendButton.click();
  }

  public static void verifySuccess() {
    boolean checkParam = false;
    String verify = CdfSysAdminLocators.success200.getText();
    if (verify.contains("200")) {
      checkParam = true;
      logger.info("Success");
    }
    Assert.assertTrue(checkParam);
  }

  /**
   * Check whether Namespace created successfully
   */
  public static void namespaceCreatedSuccessMessage() {
    WaitHelper.waitForElementToBeDisplayed(CdfSysAdminLocators.locateNameSpaceSuccessMessage,
        ConstantsUtil.DEFAULT_TIMEOUT_SECONDS);
  }

  /**
   * Click on Switch button to switch to created Namespace
   */
  public static void clickOnSwitchToButton() {
    ElementHelper.clickOnElement(CdfSysAdminLocators.switchToCreatedNamespace);
  }

  /**
   * Click on close button to close the Namespace window
   */
  public static void clickOnCloseIconOnNamespaceWindow() {
    ElementHelper.clickOnElement(CdfSysAdminLocators.closeNamespaceWindow);
  }

  /**
   * Check whether created Namespace is displayed in System Admin's Namespace tab
   *
   * @param namespaceName any specific title created
   */
  public static void verifyCreatedNamespaceIsDisplayed(String namespaceName) {
    WaitHelper.waitForElementToBeDisplayed(CdfSysAdminLocators.namespaceAdded
        (PluginPropertyUtils.pluginProp(namespaceName)));
    AssertionHelper.verifyElementDisplayed(CdfSysAdminLocators.
        namespaceAdded(PluginPropertyUtils.pluginProp(namespaceName)));
  }

  /**
   * Click on Make HTTP calls
   */
  public static void clickOnMakeHttpCalls() {
    ElementHelper.clickOnElement(CdfSysAdminLocators.makeHttpCall);
  }

  /**
   * Click on EDIT button to add Namespace preferences
   */
  public static void clickOnEditNamespacePreference() {
    ElementHelper.clickOnElement(CdfSysAdminLocators.editPreferencesButton);
  }

  /**
   * Click on Hamburger Menu
   */
  public static void clickOnHamburgerMenu() {
    ElementHelper.clickOnElement(CdfSysAdminLocators.hamburgerMenu);
  }

  /**
   * Select the type of tab from hamburger menu list
   *
   * @param listName        @data-cy attribute value from menu list. If Provisioner is present in
   *                        {@link ConstantsUtil#DEFAULT_DATACY_ATTRIBUTES_FILE} then its data-cy is
   *                        fetched from it else Provisioner is used as it is.
   */
  public static void selectHamburgerMenuList(String listName) {
    String pluginPropertyDataCyAttribute = PluginPropertyUtils.getPluginPropertyDataCyAttribute(
        listName);
    if (pluginPropertyDataCyAttribute == null) {
      pluginPropertyDataCyAttribute = listName;
    }
    ElementHelper.clickOnElement(
        CdfSysAdminLocators.locateMenuLink(pluginPropertyDataCyAttribute));
  }

  /**
   * Click on Namespace tab links
   *
   * @param tabName            @data-cy attribute value of tabName. If tabName is present in
   *                           {@link ConstantsUtil#DEFAULT_DATACY_ATTRIBUTES_FILE}
   *                           then its data-cy is fetched from it else tabName is used
   *                           as it is.
   * @param nameSpaceName      Actual nameSpaceName is fetched from {@link
   *                           ConstantsUtil#DEFAULT_PLUGIN_PROPERTIES_FILE} else nameSpaceName param is used as it is
   */
  public static void clickOnNameSpaceAdminTabs(String tabName, String nameSpaceName) {
    ElementHelper.clickOnElement(
        CdfSysAdminLocators.nameSpaceModules(tabName, PluginPropertyUtils.pluginProp(nameSpaceName)));
  }

  /**
   * Select the request method from drop down
   *
   * @param requestMethod any specific value
   */
  public static void selectRequestDropdownOption(String requestMethod) {
    Select selectRequestMethod = new Select(CdfSysAdminLocators.requestMethod);
    selectRequestMethod.selectByVisibleText(PluginPropertyUtils.pluginProp(requestMethod));
  }
}
