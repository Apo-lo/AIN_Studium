import akka.actor.Actor

class SimpleActor extends Actor { def receive = {
  case message =>
    println("actor received: " + message)
} }