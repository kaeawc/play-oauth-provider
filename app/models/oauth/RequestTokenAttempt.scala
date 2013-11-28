package models.oauth

import java.util.Date

import play.api.libs.json._

import scala.concurrent.Future

case class RequestTokenAttempt(
  id           : Long,
  requestToken : String,
  created      : Date
)

object RequestTokenAttempt extends ((
  Long,
  String,
  Date
) => RequestTokenAttempt)
// with models.CRUD[RequestTokenAttempt]
{

  implicit val jsonFormat = Json.format[RequestTokenAttempt]

}