package models.oauth

import java.util.Date

import play.api.libs.json._

case class Consumer(
  id      : Long,
  email   : String,
  created : Date
)

object Consumer extends ((
  Long,
  String,
  Date
) => Consumer) {

  implicit val jsonFormat = Json.format[Consumer]

}