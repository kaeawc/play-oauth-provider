package controllers.auth

import models.User

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.libs.json._
import play.api.data.Forms._

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

object Login extends Controller {

  def get = Action {
    Ok(views.html.auth.login())
  }

  val loginForm = Form(
    tuple(
      "email"    -> email,
      "password" -> text(minLength = 6)
    )
  )

  def submit = Action.async { implicit request =>

    loginForm.bindFromRequest match {
      case form:Form[(String,String)] if form.hasErrors => Future {
        BadRequest("Could not bind form.")
      }
      case form:Form[(String,String)] => {

        val (email,password) = form.get
        
        User.authenticate(email,password) map {
          case Some(user:User) => Accepted(Json.obj("user" -> user.asPublic))
          case _               => Unauthorized(Json.obj("reason" -> "Invalid credentials."))
        }

      }
      case _ => Future {
        Logger.error("Form didn't have errors, but didn't bind properly?")
        BadRequest(Json.obj("reason" -> "Could not bind form."))
      }
    }
  }
}