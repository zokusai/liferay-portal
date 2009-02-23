/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portalweb.portlet.webcontent;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * <a href="AssertWebContentDisplayLocalizationTest.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class AssertWebContentDisplayLocalizationTest extends BaseTestCase {
	public void testAssertWebContentDisplayLocalization()
		throws Exception {
		selenium.click(RuntimeVariables.replace("link=Back to My Community"));
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='add-page']/a/span");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("new_page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.type("new_page",
			RuntimeVariables.replace(
				"Web Content Display Localization Test Page"));
		selenium.click("link=Save");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"link=Web Content Display Localization Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace(
				"link=Web Content Display Localization Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Add Application");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//div[@id='ContentManagement-WebContentDisplay']/p")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click("//div[@id='ContentManagement-WebContentDisplay']/p/a");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//div[@id='Tools-Language']/p")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click("//div[@id='Tools-Language']/p/a");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Configuration")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace(
				"//img[@alt='Select Web Content']"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace(
				"link=Hello World Localized Article"));
		selenium.waitForPageToLoad("30000");
		selenium.click(RuntimeVariables.replace(
				"link=Web Content Display Localization Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals("Hello World Page Name",
			selenium.getText("//div/div[1]/div/table/tbody/tr/td[1]"));
		assertEquals("Hello World Page Description", selenium.getText("//td[2]"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//img[@alt='\u4e2d\u6587 (\u4e2d\u56fd)']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace(
				"//img[@alt='\u4e2d\u6587 (\u4e2d\u56fd)']"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals("\u4e16\u754c\u60a8\u597d Page Name",
			selenium.getText("//div/div[1]/div/table/tbody/tr/td[1]"));
		assertEquals("\u4e16\u754c\u60a8\u597d Page Description",
			selenium.getText("//td[2]"));
		selenium.click(RuntimeVariables.replace(
				"//img[@alt='English (United States)']"));
		selenium.waitForPageToLoad("30000");
		assertEquals("Hello World Page Name",
			selenium.getText("//div/div[1]/div/table/tbody/tr/td[1]"));
		assertEquals("Hello World Page Description", selenium.getText("//td[2]"));
	}
}