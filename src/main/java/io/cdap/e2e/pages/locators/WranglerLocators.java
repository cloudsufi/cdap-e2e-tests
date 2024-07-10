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
package io.cdap.e2e.pages.locators;

import io.cdap.e2e.utils.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * CDF wrangler related locators.
 */
public class WranglerLocators {
  @FindBy(how = How.XPATH, using = "//div[@class='scroll-down-container text-center']")
  public static WebElement scrollButton;

  @FindBy(how = How.XPATH, using = "//input[@id='DataPrep-Directives-ChangeDataType-decimal-scaleInputId']")
  public static WebElement scaleText;

  @FindBy(how = How.XPATH, using = "//input[@placeholder='Destination column']")
  public static WebElement destinationColumn;

  @FindBy(how = How.XPATH, using = "//select[@class='form-control mousetrap']")
  public static WebElement selectDropdown;

  @FindBy(how = How.XPATH, using = "//select[@class='form-control mousetrap']")
  public static WebElement selectDropdownConcatenate;

  @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter string']")
  public static WebElement enterText;
  @FindBy(how = How.XPATH, using = "//*[contains(text(),'Column widths')]")
  public static WebElement columnWidths;

  @FindBy(how = How.XPATH, using = "//textarea[@class='form-control mousetrap']")
  public static WebElement customTransform;
  @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter depth']")
  public static WebElement enterDepth;
  @FindBy(how = How.XPATH, using = "//div[@class='scroll-down-container text-center-disabled']")
  public static WebElement scrollButtonDisabled;

  @FindBy(how = How.XPATH, using = "//select[@class='form-control mousetrap']")
  public static WebElement locatePropertyElement;

  public static By locateDropdownListItem(String option) {
    return By.xpath("//*[contains(text(),'" + option + "')]");
  }
  public static WebElement locateTransformationButton(String columnName) {
    return SeleniumDriver.getDriver()
      .findElement(By.xpath("//th[@id='column-" + columnName + "']/descendant::button"));
  }
  public static WebElement selectDirective(String directive) {
    return SeleniumDriver.getDriver()
      .findElement(By.xpath("//*[contains(text(),'" + directive + "')]"));
  }

  public static WebElement selectDirectiveOption(String option) {
    return SeleniumDriver.getDriver().findElement(By.xpath("//*[contains(text(),'" + option + "')]"));
  }

  public static WebElement selectRadioButton(String optionType) {
    return SeleniumDriver.getDriver().findElement(By.xpath("//span[contains(text(),'" + optionType + "')]"));
  }
}
