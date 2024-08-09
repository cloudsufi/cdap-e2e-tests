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
package io.cdap.e2e.pages.actions;

import io.cdap.e2e.pages.locators.WranglerLocators;
import io.cdap.e2e.utils.ElementHelper;
import io.cdap.e2e.utils.SeleniumDriver;
import io.cdap.e2e.utils.SeleniumHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CDF wrangler related actions.
 */
public class WranglerActions {
  private static final Logger logger = LoggerFactory.getLogger(WranglerActions.class);

  static {
    SeleniumHelper.getPropertiesLocators(WranglerLocators.class);
  }

  public static void clickOnTransformationButton(String columnName) {
    ElementHelper.clickOnElement(WranglerLocators.locateTransformationButton(columnName));
  }

  public static void selectDirectiveTypeWithDropdownAndText(String directive, String directiveType, String text) throws
    InterruptedException {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));

    if (directive.equals("Find and replace")) {
      ElementHelper.sendKeys(WranglerLocators.enterOldValue, directiveType);
      ElementHelper.sendKeys(WranglerLocators.enterNewValue, text);
      ElementHelper.clickOnElement(WranglerLocators.replaceAllButton);
    } else {


      switch (directiveType) {

        case "value contains":
        case "value is":
        case "value starts with":
        case "value ends with":
        case "value matches regex":
          Select select = new Select(WranglerLocators.filterSelect);
          select.selectByVisibleText(directiveType);
          ElementHelper.sendKeysToTextarea(WranglerLocators.filterText, text);
          break;

        case "Custom condition":
          Select selectCustom = new Select(WranglerLocators.filterSelect);
          selectCustom.selectByVisibleText(directiveType);
          ElementHelper.sendKeysToTextarea(WranglerLocators.filterTextArea, text);
          break;
      }
    }
  }

  public static void selectDirective(String directive) {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
  }

  public static void selectDirectiveAndOption(String directive, String option) throws InterruptedException {

    switch (directive) {

      case "Custom transform":
        ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
        ElementHelper.sendKeysToTextarea(WranglerLocators.filterTextArea, option);
        break;

      case "Filter":
      case "Send to error":
        ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
        Select selectDropdown = new Select(WranglerLocators.filterSelect);
        ElementHelper.scrollToElementUsingJsExecutor(WranglerLocators.selectDirectiveOption(option));
        selectDropdown.selectByVisibleText(option);
        break;

      case "Fill null or empty cells":
      case "Copy column":
        ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
        ElementHelper.sendKeysToTextarea(WranglerLocators.filterText, option);
        break;

      case "Hash":
        ElementHelper.hoverOverElement(WranglerLocators.scrollButton);
        Thread.sleep(3000);
        ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
        Select select = new Select(WranglerLocators.filterSelect);
        ElementHelper.scrollToElementUsingJsExecutor(WranglerLocators.selectDropDownOption(option));
        select.selectByVisibleText(option);
        break;

      case "Decode":
        ElementHelper.hoverOverElement(WranglerLocators.scrollButton);
        Thread.sleep(3000);
        ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
        ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(option));
        break;

      default:
        ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
        ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(option));
    }

  }

  public static void selectDirectiveTypeWithThreeOptions(String directive, String directiveType, String option)
    throws InterruptedException {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
    ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(directiveType));

    switch (directiveType) {
      case "Decimal":
        ElementHelper.sendKeys(WranglerLocators.scaleText, option);
        break;

      case "Character count":
        ElementHelper.replaceElementValue(WranglerLocators.filterText, option);
        break;

      case "Fixed length":
        ElementHelper.sendKeys(WranglerLocators.columnWidths, option);
        break;

      case "XML to JSON":
      case "JSON":
        ElementHelper.replaceElementValue(WranglerLocators.enterDepth, option);
        break;

      case "Excel":
        ElementHelper.replaceElementValue(WranglerLocators.excelSheetNumber, option);
        break;

      case "Using patterns":
        ElementHelper.clickOnElement(WranglerLocators.selectPattern);
        ElementHelper.clickOnElement(WranglerLocators.selectOption(option));
        ElementHelper.clickOnElement(WranglerLocators.extractButton);
        break;

      default:
        ElementHelper.clickOnElement(WranglerLocators.selectRadioButton(option));
    }
  }

  public static void selectDirectiveTypeWithFourOption(String directive, String directiveType, String text,
                                                       String option)
    throws InterruptedException {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
    switch (directiveType) {
      case "Concatenate":
        ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(directiveType));
        ElementHelper.sendKeys(WranglerLocators.filterText, text);
        ElementHelper.clickOnElement(WranglerLocators.filterSelect);
        Thread.sleep(3000);
        ElementHelper.clickOnElementUsingJsExecutor(WranglerLocators.selectDirectiveOption(option));
        break;

      case "Datetime":
      case "Simple date":
        if (option.equals("Custom format")) {
          ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(directiveType));
          ElementHelper.clickOnElement(WranglerLocators.selectRadioButton(option));
          ElementHelper.sendKeys(WranglerLocators.customDate, text);
        }
        break;
      case "Always":
        Select select = new Select(WranglerLocators.filterSelect);
        select.selectByVisibleText(directiveType);
        ElementHelper.sendKeysToTextarea(WranglerLocators.enterCounterName, text);
        ElementHelper.replaceElementValue(WranglerLocators.incrementCount, option);
        break;
    }

  }

  public static void selectDirectiveTypeWithFiveOption(String directive, String option1, String option2,
                                                       String option3, String option4)
    throws InterruptedException {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
    switch (directive) {
      case "Set counter":
        Select select = new Select(WranglerLocators.filterSelect);
        select.selectByVisibleText(option1);
        ElementHelper.sendKeysToTextarea(WranglerLocators.filterTextArea, option2);
        ElementHelper.sendKeysToTextarea(WranglerLocators.enterCounterName, option4);
        ElementHelper.replaceElementValue(WranglerLocators.incrementCount, option3);
        break;

      case "Define variable":
        ElementHelper.sendKeysToTextarea(WranglerLocators.variableName, option4);
        Select selectColumnName = new Select(WranglerLocators.selectColumn);
        selectColumnName.selectByVisibleText(option3);
        Select selectVar = new Select(WranglerLocators.selectRow);
        selectVar.selectByVisibleText(option1);
        if (option1.equals("Custom condition")) {
          ElementHelper.sendKeysToTextarea(WranglerLocators.filterTextArea, option2);
        } else {
          ElementHelper.sendKeysToTextarea(WranglerLocators.variableValue, option2);
        }
        break;
    }
  }

  public static void createPipelineButton() {
    ElementHelper.clickOnElement(WranglerLocators.createPipelineButton);
  }

  public static void enterDirectiveFromCommandLine(String directive) {
    ElementHelper.sendKeys(WranglerLocators.directiveCommandLine, directive);
    Actions act = new Actions(SeleniumDriver.getDriver());
    act.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
  }

  public static void selectCheckboxOnTwoColumns(String column1, String column2) {
    ElementHelper.clickOnElement(WranglerLocators.locateCheckboxOfColumn(column1));
    ElementHelper.clickOnElement(WranglerLocators.locateCheckboxOfColumn(column2));
  }
}
