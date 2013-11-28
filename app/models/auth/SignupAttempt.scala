package models

import java.util.Date

import play.api.libs.json._

import scala.concurrent.Future

case class SignupAttempt(
  id              : Long,
  email           : String,
  password        : String,
  retypedPassword : String,
  success         : Boolean,
  created         : Date
)

object SignupAttempt extends ((
  Long,
  String,
  String,
  String,
  Boolean,
  Date
) => SignupAttempt)
// with models.CRUD[SignupAttempt]
{

  implicit val jsonFormat = Json.format[SignupAttempt]

  def getById(id:Long) = ???

  def create(email:String,password:String) = ???

  def delete(id:Long,password:String) = ???

}