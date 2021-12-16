package messages.inheritance

import org.scalatest.flatspec._
import org.scalatest.matchers._

class MessagesProviderSpec extends AnyFlatSpec with should.Matchers {

  private val englishmessages = new EnglishMessagesProvider
  private val russianmessages = new RussianMessagesProvider
  private val spanishmessages = new SpanishMessagesProvider

  "EnglishMessagesProvider" should "provide hello message" in {
    englishmessages.hello should be ("Hello")
  }

  it should "provide goodbye message" in {
    englishmessages.goodbye should be ("Goodbye")
  }

  "RussianMessageProvider" should "provide hello message" in {
    russianmessages.hello should be ("Привет")
  }
  it should "provide goodbye message" in {
    russianmessages.goodbye should be ("До свидания")
  }

  "SpanishMessageProvider" should "provide hello message" in {
    spanishmessages.hello should be ("Hola")
  }

  it should "provide goodbye message" in {
    spanishmessages.goodbye should be ("Adios")
  }

}
