package infrastructure


trait WebSpecification {
  WebSpecificationSuite

  val browser = Browser
  val firefoxDriver = browser.firefoxDriver
//  val firefoxDriver = browser.chromeDriver
}


object WebSpecificationSuite {
  RunApp
}
