package controllers

import org.specs2.mutable.Specification

import models.User

import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.ExecutionContext.Implicits.global

package object auth extends Specification {

  def createUser(email:String,password:String) = {

    User.create(email,password) map {
      case Some(user:User) => user
      case _ => failure("Could not create this user, probably already exists.")
    }
  }
}