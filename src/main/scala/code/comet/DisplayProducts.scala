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
        <dl class="dl-horizontal"><dt>{ <img class="images" src={x.image} alt="picture"/> }</dt>
          <dd class="gamename"> { x.name }</dd>
          <dd class="price">£{ x.price } { x.currency }</dd>
        </dl>)
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