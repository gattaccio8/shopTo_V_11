package infrastructure


trait WebSpecification {
  WebSpecificationSuite

  val browser = Browser
//  val firefoxDriver = browser.firefoxDriver
  val driver = browser.driver
}


object WebSpecificationSuite {
  RunApp
}
