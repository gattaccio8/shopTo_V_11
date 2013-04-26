package infrastructure


trait ApplicationDriver {
  def click: Unit
  def assertElementExists(id: String): Boolean
}