package controllers.auth

import models.User

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.libs.json._
import play.api.data.Forms._

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

object Signup extends Controller {

  def get = Action {
    Ok(views.html.auth.registration())
  }

  val signupForm = Form(
    tuple(
      "email"    -> email,
      "password" -> text(minLength = 6),
      "retyped" -> text(minLength = 6)
    )
  )

  def submit = Action.async { implicit request =>

    signupForm.bindFromRequest match {
      case form:Form[(String,String,String)] if form.hasErrors => Future {
        BadRequest("Could not bind form.")
      }
      case form:Form[(String,String,String)] => {

        val (email,password,retyped) = form.get

        if (password == retyped)
          User.create(email,password) map {
            case Some(user:User) => Created(Json.obj("user" -> user.asPublic))
            case _               => BadRequest(Json.obj("reason" -> "Email address is already in use."))
          }
        else
          Future { BadRequest(Json.obj("reason" -> "Passwords must match.")) }

      }
      case _ => Future {
        Logger.error("Form didn't have errors, but didn't bind properly?")
        BadRequest(Json.obj("reason" -> "Could not bind form."))
      }
    }
  }

}