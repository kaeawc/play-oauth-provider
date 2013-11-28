package models

import play.api.libs.json._

import scala.concurrent.Future

trait CRUD[Model] {

  def getById(id:Long):Future[Option[Model]]

  def delete(id:Long,password:String):Future[Option[Model]]

}