package messages.type_class

import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MessagesSpec extends AnyFlatSpec with MockFactory with should.Matchers {

  import language._
  import Messages._

  "EnglishHello" should "return hello message in given language" in {
    val language: Language = mock[Language]
    implicit val helloMessageProvider: HelloMessageProvider[language.type] = mock[HelloMessageProvider[language.type]]

    (helloMessageProvider.message _).expects().returning("Hello").once()

    hello(language) should be("Hello")
  }

  "EnglishGoodbye" should "return goodbye message in given language" in {
    val language: Language = mock[Language]
    implicit val EnglishGoodbyeMessageProvider: GoodbyeMessageProvider[language.type] = mock[GoodbyeMessageProvider[language.type]]

    (EnglishGoodbyeMessageProvider.message _).expects().returning("Goodbye").once()

    goodbye(language) should be("Goodbye")
  }

  "SpanishHello" should "return hello message in given language" in {
    val language: Language = mock[Language]
    implicit val helloMessageProvider: HelloMessageProvider[language.type] = mock[HelloMessageProvider[language.type]]

    (helloMessageProvider.message _).expects().returning("Hola").once()

    hello(language) should be("Hola")
  }

  "SpanishGoodbye" should "return goodbye message in given language" in {
    val language: Language = mock[Language]
    implicit val SpanishGoodbyeMessageProvider: GoodbyeMessageProvider[language.type] = mock[GoodbyeMessageProvider[language.type]]

    (SpanishGoodbyeMessageProvider.message _).expects().returning("Adios").once()

    goodbye(language) should be("Adios")
  }

  "RussianHello" should "return hello message in given language" in {
    val language: Language = mock[Language]
    implicit val helloMessageProvider: HelloMessageProvider[language.type] = mock[HelloMessageProvider[language.type]]

    (helloMessageProvider.message _).expects().returning("Привет").once()

    hello(language) should be("Привет")
  }

  "RussianGoodbye" should "return goodbye message in given language" in {
    val language: Language = mock[Language]
    implicit val SpanishGoodbyeMessageProvider: GoodbyeMessageProvider[language.type] = mock[GoodbyeMessageProvider[language.type]]

    (SpanishGoodbyeMessageProvider.message _).expects().returning("До свидания").once()

    goodbye(language) should be("До свидания")
  }
}