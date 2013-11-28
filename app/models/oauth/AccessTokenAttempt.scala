package models.oauth

import java.util.Date

import play.api.libs.json._

import scala.concurrent.Future

case class AccessTokenAttempt(
  id           : Long,
  requestToken : String,
  created      : Date
)

object AccessTokenAttempt extends ((
  Long,
  String,
  Date
) => AccessTokenAttempt)
//with models.CRUD[AccessTokenAttempt]
{

  implicit val jsonFormat = Json.format[AccessTokenAttempt]

}