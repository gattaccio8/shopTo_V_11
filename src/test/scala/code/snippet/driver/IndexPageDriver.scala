package code.driver

import infrastructure.WebSpecification


trait IndexPageDriver extends WebSpecification {
  IndexPageDriver

    def enterUsernameAndPassword(username: String, password: String) = {
      elementById("username").sendKeys(username)
      elementById("password").sendKeys(password)
    }

    def clickLogin = elementById("login").click()
    def assertIsHomePage = driver.getTitle.equals("Home Page")
    def assertUsernameFieldExist = elementById("username").isDisplayed
    def assertPasswordFieldExist = elementById("password").isDisplayed
    def assertHasLoginTextFieldsAndButtons = elementById("loginandsignup").isDisplayed


    private def elementById(id: String) = driver.findElementById(id)
}

object IndexPageDriver extends IndexPageDriver {
  driver.get("http://localhost:8080/")
}