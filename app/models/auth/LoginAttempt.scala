package models

import java.util.Date

import play.api.libs.json._

import scala.concurrent.Future

case class LoginAttempt(
  id       : Long,
  email    : String,
  password : String,
  success  : Boolean,
  created  : Date
)

object LoginAttempt extends ((
  Long,
  String,
  String,
  Boolean,
  Date
) => LoginAttempt)
// with models.CRUD[LoginAttempt]
{

  implicit val jsonFormat = Json.format[LoginAttempt]

  def getById(id:Long):Future[Option[LoginAttempt]] = ???

  def create(email:String,password:String):Future[Option[LoginAttempt]] = ???

  def delete(id:Long,password:String):Future[Option[LoginAttempt]] = ???

}