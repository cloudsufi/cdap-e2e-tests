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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Represents CdfSignInLocators
 */
public class CdfSignInLocator {

    @FindBy(how = How.XPATH, using = "//input[@name='identifier']")
    public WebElement cdfUsername;

    @FindBy(how = How.XPATH, using = "//input[@name='Passwd']")
    public WebElement cdfPassword;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Next')]//parent::button")
    public WebElement nextButton;

    public static By locatorOfEmailTextBox() {
        return By.xpath("//input[@name='identifier']");
    }

    public By selectTestAccount(String testAccountName) {
        return By.xpath("//*[contains(text(),'" + testAccountName + "')]");
    }

    public By clickOnAllowButton() {
        return By.xpath("//button[contains(text(),'Allow')]");
    }

    public By clickOnContinueButton() {
        return By.xpath("//span[contains(text(),'Continue')]");
    }

    public static By locatePluginNameInList(String pluginName, String  pluginGroupName) {
        return By.xpath("//div[@data-cy='plugin-" + pluginGroupName + "-group']" +
                "//div[contains(@class, 'PluginNameContainer')][normalize-space(text()) = '" + pluginName + "' " +
                "or translate(normalize-space(text()),' ','') = '" + pluginName + "']");
    }

    @FindBy(how = How.XPATH, using = "//input[@name='providerName']")
    public WebElement byoidProvider;

    @FindBy(how = How.XPATH, using = "//*[@id='kc-header']")
    public WebElement keycloakLogo;

    @FindBy(how = How.XPATH, using = "//*[@id='kc-form-login']//*[@id='username']")
    public WebElement byoidUsername;

    @FindBy(how = How.XPATH, using = "//*[@id='kc-form-login']//*[@id='password']")
    public WebElement byoidPassword;

    @FindBy(how = How.XPATH, using = "//*[@id='kc-form-buttons']//*[@id='kc-login']")
    public WebElement byoidSignInButton;
}
