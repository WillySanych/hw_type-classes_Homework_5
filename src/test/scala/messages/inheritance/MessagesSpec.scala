package messages.inheritance

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks

class MessagesSpec extends AnyFlatSpec with should.Matchers with TableDrivenPropertyChecks {

  import language._

  private val hellolanguages = Table(
    ("Language", "Hello Message"),
    (EnglishLanguage, "Hello"),
    (RussianLanguage, "Привет"),
    (SpanishLanguage, "Hola")
  )

  private val goodbyelanguages = Table (
    ("Language", "Goodbye Message"),
    (EnglishLanguage, "Goodbye"),
    (RussianLanguage, "До свидания"),
    (SpanishLanguage, "Adios")
  )

  import Messages._

  "hello" should "return hello message in appropriate language" in {
    forAll (hellolanguages) { (language, helloMessage) =>
      hello(language) should be (helloMessage)
    }
  }

  "goodbye"should "return goodbye message in appropriate language" in {
    forAll (goodbyelanguages) { (language, goodbyeMessage) =>
      goodbye(language) should be(goodbyeMessage)
    }
  }
}
