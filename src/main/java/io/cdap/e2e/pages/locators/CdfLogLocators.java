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

/**
 * Represents CdfLogLocators
 */
public class CdfLogLocators {

  @FindBy(xpath = "//*[contains(text(),'The preview of the pipeline has failed')]")
  public static WebElement errorMessagePopup;

  @FindBy(xpath = "//*[@ng-if='dismissable']")
  public static WebElement dismissable;

  @FindBy(xpath = "//*[@class='button-label' and contains(text(),'Logs')]")
  public static WebElement goToLogs;

  @FindBy(xpath = "//*[contains(text(),'Pipeline') and contains(text(),'failed')]")
  public static WebElement validateFailed;

  @FindBy(xpath = "//*[contains(text(),'Pipeline') and contains(text(),'failed')]/parent::*//child::div[2]")
  public static WebElement validateCategoryError;

  @FindBy(xpath = "//*[@data-testid='view-advanced-logs']")
  public static WebElement getGoToAdvanceLogs;

  @FindBy(xpath = "//*[contains(text(),'Pipeline') and contains(text(),'succeeded')]")
  public static WebElement validateSucceeded;
  public static By closeLogs = By.xpath("//*[contains(@class, 'close')]");

  public static WebElement getPipelineStatusFromLogs(String status) {
    return SeleniumDriver.getDriver()
      .findElement(By.xpath("//*[contains(text(),'Pipeline') and contains(text(),'" + status + "')]"));
  }

  public static WebElement locateLogEntry(String logLevel, String logMessage) {
    String xpath = "//div[@data-cy='log-viewer-row']//div[normalize-space(text()) ='" + logLevel + "']" +
      "//following-sibling::div[@data-cy='log-message'][contains(normalize-space(.), \"" + logMessage + "\")]";
    return SeleniumDriver.getDriver().findElement(By.xpath(xpath));
  }

  public static WebElement locateLogLevel(String logLevel) {
    String xpath = "//div[@data-cy='log-viewer-row']//div[normalize-space(text()) ='" + logLevel + "']";
    return SeleniumDriver.getDriver().findElement(By.xpath(xpath));
  }
}
