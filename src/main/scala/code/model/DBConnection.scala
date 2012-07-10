package code.model

import net.liftweb.mapper.{DB , Schemifier}
import net.liftweb.util.Props
import net.liftweb.common.{Logger, Loggable}
import net.liftweb.db.{DBLogEntry, DefaultConnectionIdentifier, StandardDBVendor}
import persistedobjects.{PersistedSupplier, PersistedClient}

object DBConnection extends Loggable {

  val models = PersistedClient :: PersistedSupplier :: Nil
  val users = User :: Nil

  var vendor:Option[StandardDBVendor] = None

  def init {
    try {
      if (!vendor.isDefined) {
        println(Props.fileName + " " + Props.get("db.url") + " " + Props.get("db.user"))
        val dBVendor = new StandardDBVendor(Props.get("db.driver").open_!,
        Props.get("db.url").open_!, Props.get("db.user"), Props.get("db.password"))
        DB.defineConnectionManager(DefaultConnectionIdentifier, dBVendor)
        Schemifier.schemify(true, Schemifier.infoF _, models.toArray: _*)
        addLogging
        vendor = Some(dBVendor)
      }
    } catch {
      case e => e.printStackTrace()
    }
  }

  def addLogging {
    DB.addLogFunc {
      case(log, totalDuration) => {
        val logger = Logger("myApp.sql")
        logger.info("total query duration : ".format(totalDuration))
        log.allEntries.foreach {
          case DBLogEntry(stm, duration) => logger.info(" %s in %d ms".format(stm, duration))
        }

      }
    }
  }

}