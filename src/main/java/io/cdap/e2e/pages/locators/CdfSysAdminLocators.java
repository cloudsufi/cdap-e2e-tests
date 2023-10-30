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

package io.cdap.e2e.pages.locators;

import io.cdap.e2e.utils.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Represents CdfSysAdminLocators
 */
public class CdfSysAdminLocators {

  @FindBy(how = How.XPATH, using = "//a[@data-cy='System Admin']")
  public static WebElement systemAdminMenu;

  @FindBy(how = How.XPATH, using = "//a[@href='/cdap/administration/configuration']")
  public static WebElement configurationMenu;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='request-method-selector']")
  public static WebElement apiCallType;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='request-path-input']")
  public static WebElement apiInputURI;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='request-body']")
  public static WebElement requestBody;

  @FindBy(how = How.XPATH, using = "//*[contains(text(),'Clear')]")
  public static WebElement clearButton;

  @FindBy(how = How.XPATH, using = "//*[contains(text(),'Send')]")
  public static WebElement sendButton;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='request-path']/parent::*//child::div[2]")
  public static WebElement success200;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='Clear All']")
  public static WebElement clearAll;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='wizard-result-icon-close-btn']")
  public static WebElement closeNamespaceWindow;

  public static WebElement namespaceAdded(String nameSpace) {
    String path = "//*[@href=\"/cdap/ns/" + nameSpace + "/details\"]";
    return SeleniumDriver.getDriver().findElement(By.xpath(path));
  }

  @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Switch to')]")
  public static WebElement switchToCreatedNamespace;

  @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Go to homepage')]")
  public static WebElement goToHomepage;

  @FindBy(how = How.XPATH, using = "//span[contains(@title, 'Successfully created the namespace')] ")
  public static WebElement locateNameSpaceSuccessMessage;

  @FindBy(how = How.XPATH, using = "//span[contains(text(),'Edit')]")
  public static WebElement editPreferencesButton;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='navbar-hamburger-icon']")
  public static WebElement hamburgerMenu;

  public static WebElement locateMenuLink(String menuLink) {
    String xpath = "//*[@data-cy='navbar-" + menuLink + "-link']";
    return SeleniumDriver.getDriver().findElement(By.xpath(xpath));
  }

  public static WebElement nameSpaceModules(String module, String nameSpace) {
    String path = "//*[@href=\"/cdap/ns/" + nameSpace + "/details/" + module + "\"]";
    return SeleniumDriver.getDriver().findElement(By.xpath(path));
  }

  public static By locateDropdownItem(String option) {
    return By.xpath("//select//option[@value='" + option + "']");
  }

  @FindBy(how = How.XPATH, using = "//*[@data-cy='request-method-selector']")
  public static WebElement requestMethod;
}
