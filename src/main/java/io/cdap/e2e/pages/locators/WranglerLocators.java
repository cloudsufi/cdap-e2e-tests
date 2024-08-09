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
  @FindBy(how = How.XPATH, using = "//div[@data-testid='common-components-scrollableList-scrollDownButton']")
  public static WebElement scrollButton;

  @FindBy(how = How.XPATH, using = "//input[@id='DataPrep-Directives-ChangeDataType-decimal-scaleInputId']")
  public static WebElement scaleText;

  @FindBy(how = How.XPATH, using = "//button[contains(text(),'Extract')]")
  public static WebElement extractButton;

  @FindBy(how = How.XPATH, using = "//button[contains(text(),'Replace All')]")
  public static WebElement replaceAllButton;

  @FindBy(how = How.XPATH, using = "//input[@data-testid='features-dataprep-workspace-cli-input']")
  public static WebElement directiveCommandLine;
  @FindBy(how = How.XPATH, using = "  //button[@data-testid='features-dataprep-workspace-topPanel-actionButtons-" +
    "createPipeline']")
  public static WebElement createPipelineButton;

  @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter variable_name']")
  public static WebElement variableName;

  @FindBy(how = How.XPATH, using = "  //div[@class='condition-text-input']//input")
  public static WebElement variableValue;

  @FindBy(how = How.XPATH, using = "//input[@value='sheetnumber']/following::input")
  public static WebElement excelSheetNumber;
  @FindBy(how = How.XPATH, using = "  //button[@class='dropdown-toggle btn btn-secondary']")
  public static WebElement selectPattern;
  @FindBy(how = How.XPATH, using = "//div[contains(@class, 'level-popover')]//input")
  public static WebElement filterText;

  @FindBy(how = How.XPATH, using = "//input[@placeholder='Old value']")
  public static WebElement enterOldValue;

  @FindBy(how = How.XPATH, using = "//input[@placeholder='New value']")
  public static WebElement enterNewValue;
  @FindBy(how = How.XPATH, using = "//div[contains(@class, 'level-popover')]//textarea")
  public static WebElement filterTextArea;

  @FindBy(how = How.XPATH, using = "//div[contains(@class, 'level-popover')]//select")
  public static WebElement filterSelect;

  @FindBy(how = How.XPATH, using = "//*[contains(text(),'Column widths')]")
  public static WebElement columnWidths;
  @FindBy(how = How.XPATH, using = "//*[contains(text(),'Select column in selected row')]" +
    "/following-sibling::div//select")
  public static WebElement selectColumn;

  @FindBy(how = How.XPATH, using = "//*[contains(text(),'Select row where')]/following-sibling::div//select")
  public static WebElement selectRow;
  @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter depth']")
  public static WebElement enterDepth;

  @FindBy(how = How.XPATH, using = "  //input[@placeholder=\"e.g. yyyy.MM.dd G 'at' HH:mm:ss z\"]")
  public static WebElement customDate;

  @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter counter name']")
  public static WebElement enterCounterName;

  @FindBy(how = How.XPATH, using = "//*[contains(text(),'increment the count by')]/following-sibling::input")
  public static WebElement incrementCount;
  //option[@value='EMPTY']

  public static WebElement locateTransformationButton(String columnName) {
    return SeleniumDriver.getDriver()
      .findElement(By.xpath("//th[@id='column-" + columnName + "']/descendant::button"));
  }

  public static WebElement locateCheckboxOfColumn(String columnName) {
    return SeleniumDriver.getDriver()
      .findElement(By.xpath("//th[@id='column-" + columnName + "']/descendant::span[@data-testid='" +
                              "features-dataprep-workspace-dataTable-head-columnSelectToggle']"));
  }

  public static WebElement selectDirective(String directive) {
    return SeleniumDriver.getDriver()
      .findElement(By.xpath("//*[text()='" + directive + "']"));
  }

  public static WebElement selectDropDownOption(String dropdown) {
    return SeleniumDriver.getDriver()
      .findElement(By.xpath("//option[@value='" + dropdown + "']"));
  }

  public static WebElement selectDirectiveOption(String option) {
    return SeleniumDriver.getDriver().findElement(By.xpath("//*[text()='" + option + "']"));
  }

  public static WebElement selectRadioButton(String optionType) {
    return SeleniumDriver.getDriver().findElement(By.xpath("//span[contains(text(),'" + optionType + "')]"));
  }

  public static WebElement selectOption(String optionType) {
    return SeleniumDriver.getDriver().findElement(By.xpath("//span[text()='" + optionType + "']"));
  }
}
