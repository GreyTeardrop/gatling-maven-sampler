package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class Sample extends Simulation {

  val userAgent = s"Gatling/${configuration.core.version}"
  val httpConf = http
    .userAgentHeader(userAgent)

  setUp(
    scenario("Sample")
      .exec(http("sample").get("/"))
      .inject(rampUsers(1).over(1.seconds))
      .protocols(httpConf.baseURL("http://localhost:8080")))
}
