package controllers.auth

import models.User

import play.api._
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

object Signup extends Controller {

  def get = Action {
    Ok(views.html.auth.registration())
  }

  def submit = Action.async {

    val email = ""
    val password = ""
    val retyped = ""

    User.create(email,password) map {
      case Some(user:User) => Created("")
      case _               => NotFound
    }
  }

}