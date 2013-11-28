package models

import java.util.Date

import play.api.libs.json._

import scala.concurrent.{Future,ExecutionContext}

import ExecutionContext.Implicits.global

case class User(
  id       : Long,
  email    : String,
  password : String,
  salt     : String,
  created  : Date
)

object User extends ((
  Long,
  String,
  String,
  String,
  Date
) => User)
with CRUD[User] {

  import crypto.Hexadecimal._

  implicit val jsonFormat = Json.format[User]

  def getById(id:Long) = ???

  def getByEmail(email:String) = Future { Some(User(1,"","","",new Date())) }

  def findByEmail(email:String) = ???

  def create(user:User):Future[Option[User]] = create(user.email, user.password)

  def create(email:String,password:String):Future[Option[User]] = {
    User.getByEmail(email) map {
      case Some(user:User) => None
      case _ => {

        val salt = crypto.PBKDF2.createSalt()

        val hashedPassword = crypto.PBKDF2.hash(password,salt)

        Some(User(1,email,hashedPassword,salt,new Date()))
      }
    }
  }

  def updateEmail(id:Long,email:String) = ???

  def updatePassword(id:Long,email:String) = ???

  def delete(id:Long,password:String) = ???

  def authenticate(email:String,password:String):Future[Option[User]] = {
    User.getByEmail(email) map {
      case Some(user:User) => {

        val hashedPassword = crypto.PBKDF2.hash(password,user.salt)

        if (hashedPassword == user.password)
          Some(user)
        else
          None
      }
      case _ => None
    }
  }

}