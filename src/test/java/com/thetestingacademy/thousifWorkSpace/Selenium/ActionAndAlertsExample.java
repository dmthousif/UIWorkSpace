package com.thetestingacademy.thousifWorkSpace.Selenium;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.thetestingacademy.driver.DriverManagerTL.getDriver;

public class ActionAndAlertsExample extends CommonToAllTest {
    WebDriver driver;
    WebElement element;

    @Test
    public void actionTest() throws Exception {
        driver = getDriver();
        driver.get(PropertyReader.readKey("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        element = driver.findElement(By.xpath("//button[contains(text(),' Double click Here')]"));
        System.out.println(element.isDisplayed());
        actions.click().build().perform();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));


        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));


        actions.moveToElement(element).doubleClick().build().perform();
        Alert alert = driver.switchTo().alert();
        System.out.println("AlertMessege::" + alert.getText());
        alert.accept();

        Thread.sleep(5000);
    }



    /*

    Action
build()
Generates a composite action containing all actions so far, ready to be performed (and resets the internal builder state, so subsequent calls to this method will contain fresh sequences).
Actions
click()
Clicks at the current mouse location.
Actions
click(WebElement target)
Clicks in the middle of the given element.
Actions
clickAndHold()
Clicks (without releasing) at the current mouse location.
Actions
clickAndHold(WebElement target)
Clicks (without releasing) in the middle of the given element.
Actions
contextClick()
Performs a context-click at the current mouse location.
Actions
contextClick(WebElement target)
Performs a context-click at middle of the given element.
Actions
doubleClick()
Performs a double-click at the current mouse location.
Actions
doubleClick(WebElement target)
Performs a double-click at middle of the given element.
Actions
dragAndDrop(WebElement source, WebElement target)
A convenience method that performs click-and-hold at the location of the source element, moves to the location of the target element, then releases the mouse.
Actions
dragAndDropBy(WebElement source, int xOffset, int yOffset)
A convenience method that performs click-and-hold at the location of the source element, moves by a given offset, then releases the mouse.
KeyInput
getActiveKeyboard()

PointerInput
getActivePointer()

WheelInput
getActiveWheel()

Collection<Sequence>
getSequences()

Actions
keyDown(CharSequence key)
Performs a modifier key press.
Actions
keyDown(WebElement target, CharSequence key)
Performs a modifier key press after focusing on an element.
Actions
keyUp(CharSequence key)
Performs a modifier key release.
Actions
keyUp(WebElement target, CharSequence key)
Performs a modifier key release after focusing on an element.
Actions
moveByOffset(int xOffset, int yOffset)
Moves the mouse from its current position (or 0,0) by the given offset.
Actions
moveToElement(WebElement target)
Moves the mouse to the middle of the element.
Actions
moveToElement(WebElement target, int xOffset, int yOffset)
Moves the mouse to an offset from the element's in-view center point.
Actions
moveToLocation(int xCoordinate, int yCoordinate)
Moves the mouse to provided coordinates on screen regardless of starting position of the mouse.
Actions
pause(long pause)
Performs a pause.
Actions
pause(Duration duration)

void
perform()
A convenience method for performing the actions without calling build() first.
Actions
release()
Releases the depressed left mouse button at the current mouse location.
Actions
release(WebElement target)
Releases the depressed left mouse button, in the middle of the given element.
Actions
scrollByAmount(int deltaX, int deltaY)
Scrolls by provided amounts with the origin in the top left corner of the viewport.
Actions
scrollFromOrigin(WheelInput.ScrollOrigin scrollOrigin, int deltaX, int deltaY)
Scrolls by provided amount based on a provided origin.
Actions
scrollToElement(WebElement element)
If the element is outside the viewport, scrolls the bottom of the element to the bottom of the viewport.
Actions
sendKeys(CharSequence... keys)
Sends keys to the active element.
Actions
sendKeys(WebElement target, CharSequence... keys)
Equivalent to calling: Actions.click(element).sendKeys(keysToSend). This method is different from WebElement.sendKeys(CharSequence...) - see sendKeys(CharSequence...) for details how.
Actions
setActiveKeyboard(String name)

Actions
setActivePointer(PointerInput.Kind kind, String name)

Actions
setActiveWheel(String name)

Actions
tick(Interaction... actions)

     */

}
