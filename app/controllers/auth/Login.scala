package controllers.auth

import models.User

import play.api._
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

object Login extends Controller {

  def get = Action {
    Ok(views.html.auth.login())
  }

  def submit = Action.async {

    val email = ""
    val password = ""

    User.authenticate(email,password) map {
      case Some(user:User) => Accepted("")
      case _               => NotFound
    }
  }
}