package models.oauth

import java.util.Date

import play.api.libs.json._

case class Nonce(
  id      : Long,
  email   : String,
  created : Date
)

object Nonce extends ((
  Long,
  String,
  Date
) => Nonce) {

  implicit val jsonFormat = Json.format[Nonce]

}