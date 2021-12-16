package messages.type_class

import language._

trait MessageProvider {
  def message: String
}
trait HelloMessageProvider[L <: Language] extends MessageProvider {
  override def message: String
}
trait GoodbyeMessageProvider[L <: Language] extends MessageProvider {
  override def message: String
}

final class EnglishHelloMessageProvider extends HelloMessageProvider[EnglishLanguage.type] {
  override def message: String = "Hello"
}
final class SpanishHelloMessageProvider extends  HelloMessageProvider[SpanishLanguage.type] {
  override def message: String = "Hola"
}
final class RussianHelloMessageProvider extends  HelloMessageProvider[RussianLanguage.type] {
  override def message: String = "Привет"
}

final class EnglishGoodbyeMessageProvider extends GoodbyeMessageProvider[EnglishLanguage.type] {
  override def message: String = "Goodbye"
}
final class SpanishGoodbyeMessageProvider extends  GoodbyeMessageProvider[SpanishLanguage.type] {
  override def message: String = "Adios"
}
final class RussianGoodbyeMessageProvider extends  GoodbyeMessageProvider[RussianLanguage.type] {
  override def message: String = "До свидания"
}

object HelloMessageProvider {
  implicit val englishHelloMessageProvider: HelloMessageProvider[EnglishLanguage.type] =
    new EnglishHelloMessageProvider
  implicit val spanishHelloMessageProvider: HelloMessageProvider[SpanishLanguage.type] =
    new SpanishHelloMessageProvider
  implicit val russianHelloMessageProvider: HelloMessageProvider[RussianLanguage.type] =
    new RussianHelloMessageProvider
}

object GoodbyeMessageProvider {
  implicit val englishGoodbyeMessageProvider: GoodbyeMessageProvider[EnglishLanguage.type] =
    new EnglishGoodbyeMessageProvider
  implicit val spanishGoodbyeMessageProvider: GoodbyeMessageProvider[SpanishLanguage.type] =
    new SpanishGoodbyeMessageProvider
  implicit val russianGoodbyeMessageProvider: GoodbyeMessageProvider[RussianLanguage.type] =
    new RussianGoodbyeMessageProvider
}

object Messages {
  def hello[L <: Language](l: Language)(implicit hmp: HelloMessageProvider[l.type]): String =
    hmp.message

  def goodbye[L <: Language](l: Language)(implicit gmp: GoodbyeMessageProvider[l.type]): String =
    gmp.message
}

object TypeClassMessagesApp extends App {
  import Messages._

  println(hello(EnglishLanguage))
  println(goodbye(EnglishLanguage))
  println(hello(SpanishLanguage))
  println(goodbye(SpanishLanguage))
  println(hello(RussianLanguage))
  println(goodbye(RussianLanguage))
}
