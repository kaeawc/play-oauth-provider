package controllers.oauth

import play.api._
import play.api.mvc._

object AccessToken extends Controller {

  def get = Action {
    Ok(views.html.auth.login())
  }

  def submit = Action {
    Created("")
  }
}