package messages.type_class

import org.scalatest.flatspec._
import org.scalatest.matchers._

class HelloMessageProviderSpec extends AnyFlatSpec with should.Matchers {

  private val englishHelloMessageProvider = new EnglishHelloMessageProvider
  private val englishGoodbyeMessageProvider = new EnglishGoodbyeMessageProvider
  private val spanishHelloMessageProvider = new SpanishHelloMessageProvider
  private val spanishGoodbyeMessageProviders = new SpanishGoodbyeMessageProvider
  private val russianHelloMessageProvider = new RussianHelloMessageProvider
  private val russianGoodbyeMessageProvider = new RussianGoodbyeMessageProvider

  "EnglishHelloMessageProvider" should "provide hello message" in {
    englishHelloMessageProvider.message should be ("Hello")
  }

  "EnglishGoodbyeMessageProvider" should "provide goodbye message" in {
    englishGoodbyeMessageProvider.message should be ("Goodbye")
  }

  "SpanishHelloMessageProvider" should "provide hello message" in {
    spanishHelloMessageProvider.message should be ("Hola")
  }

  "SpanishGoodbyeMessageProvider" should "provide goodbye message" in {
    spanishGoodbyeMessageProviders.message should be ("Adios")
  }

  "RussianHelloMessageProvider" should "provide hello message" in {
    russianHelloMessageProvider.message should be ("Привет")
  }

  "RussianGoodbyeMessageProvider" should "provide goodbye message" in {
    russianGoodbyeMessageProvider.message should be ("До свидания")
  }
}
