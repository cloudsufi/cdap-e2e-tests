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

import io.cdap.e2e.pages.locators.CdfHubLocators;
import io.cdap.e2e.pages.locators.WranglerLocators;
import io.cdap.e2e.utils.ElementHelper;
import io.cdap.e2e.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CDF wrangler related actions.
 */
public class WranglerActions {
  private static final Logger logger = LoggerFactory.getLogger(CdfHubActions.class);

  static {
    SeleniumHelper.getPropertiesLocators(CdfHubLocators.class);
  }

  public static void clickOnTransformationButton(String columnName) {
    ElementHelper.clickOnElement(WranglerLocators.locateTransformationButton(columnName));
  }
  public static void selectDirectiveType(String directive, String directiveType) throws InterruptedException {
      ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
      switch (directiveType) {
        case "value is empty":
          ElementHelper.isElementDisplayed(WranglerLocators.selectDropdown);
          ElementHelper.clickOnElement(WranglerLocators.selectDropdown);
          ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(directiveType));
          break;

        default:
          ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(directiveType));
      }
  }

  public static void selectDirective(String directive) {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
  }

  public static void selectDirectiveAndEnterValue(String directive, String text) throws InterruptedException {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
    Thread.sleep(5000);
    ElementHelper.hoverOverElement(WranglerLocators.customTransform);
    ElementHelper.clickOnElement(WranglerLocators.customTransform);
//    ElementHelper.sendKeys(WranglerLocators.customTransform, text);
  }

  public static void clickOnScrollDownOption() throws InterruptedException {
  //  Thread.sleep(1000);
    ElementHelper.clickIfDisplayed((By) WranglerLocators.scrollButton, 30);
    Thread.sleep(100);
  //  ElementHelper.clickOnElement(WranglerLocators.scrollButton);
    //WaitHelper.waitForElementToBeDisplayed(WranglerLocators.scrollButtonDisabled);
  }

  public static void selectDirectiveTypeWithOption(String directive, String directiveType, String option)
    throws InterruptedException {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
    ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(directiveType));
    Thread.sleep(5000);
    switch (directiveType) {
      case "Decimal":
        ElementHelper.sendKeys(WranglerLocators.scaleText, option);
      break;

      case "Character count":
        ElementHelper.replaceElementValue(WranglerLocators.destinationColumn, option);
        break;

      case "Fixed length":
        ElementHelper.sendKeys(WranglerLocators.columnWidths, option);
        break;
      case "XML to JSON":
      case "JSON":
        ElementHelper.replaceElementValue(WranglerLocators.enterDepth, option);
        break;
      default:
        ElementHelper.clickOnElement(WranglerLocators.selectRadioButton(option));
    }
  }
  public static void selectDirectiveTypeWithMultipleOption(String directive, String directiveType, String text,
                                                           String option)
    throws InterruptedException {
    ElementHelper.clickOnElement(WranglerLocators.selectDirective(directive));
    ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(directiveType));
    switch (directiveType) {
      case "Concatenate":
    //    ElementHelper.sendKeys(WranglerLocators.enterText, text);
        Select select = new Select(WranglerLocators.selectDropdownConcatenate);
        select.selectByVisibleText("at the end");
//        ElementHelper.clickOnElement(WranglerLocators.selectDropdownConcatenate);
//        ElementHelper.clickOnElement(WranglerLocators.selectDirectiveOption(option));
        break;
    }

  }
  }

