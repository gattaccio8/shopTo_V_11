package code.driver

import code.acceptance.infrastructure.WebSpecification


trait HomeDriver extends WebSpecification {
  HomeDriver
}

object HomeDriver extends HomeDriver {
  firefoxDriver.get("http://localhost:8080/")
}