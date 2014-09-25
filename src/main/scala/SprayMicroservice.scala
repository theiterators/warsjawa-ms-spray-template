import akka.actor.ActorSystem
import akka.event.Logging._
import scala.concurrent.ExecutionContext.Implicits.global
import spray.httpx.SprayJsonSupport._
import spray.json._
import spray.routing.SimpleRoutingApp

object SprayMicroservice extends App with SimpleRoutingApp {
  implicit val _ = ActorSystem()

  startServer(interface = "0.0.0.0", port = 8001) {
    logRequestResponse("spray-microservice", InfoLevel) {
      get {
        complete {
          "Hello world!"
        }
      }
    }
  }
}
