package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def requestToken = Action {
    Ok("")
  }

  def accessToken = Action {
    Ok("")
  }

  def login = Action {
    Ok(views.html.auth.login())
  }

  def registration = Action {
    Ok(views.html.auth.registration())
  }

  def register = Action {
    Created("")
  }

}