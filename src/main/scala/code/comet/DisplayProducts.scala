package code.comet

import code.model.xmlmessages.XmlMessageUtil
import java.io.File
import net.liftweb.http.CometActor

class DisplayProducts extends CometActor {

//    val products = XmlMessageUtil.getProdDetails //file)
  override def render = {
    val file = new File("/Users/fabio/Documents/dev/projects/net.shopto/src/test/resources/response/response.xml")
    val products = XmlMessageUtil.getProdDetails(file)
    <div class="row-fluid">
      { products.map(x =>
        <div> { <img class="images" src={x.image} alt="picture"/> } </div>
        <div class="gamename"> { x.name } </div>
        <div class="price"> { <p>£{ x.price } { x.currency }</p> } </div>)
      }
    </div>

  }

  override def localSetup {
    super.localSetup()
  }

  override def localShutdown {
    super.localShutdown()
  }
}