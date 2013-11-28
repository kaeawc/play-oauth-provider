package test.auth

import test._
import play.api.test._
import play.api.test.Helpers._

class LoginSpec extends Specification {

  "GET /login" should {

    "render the login page" in new WithApp {

      val request = FakeRequest(GET, "/login")

      val response = route(request).get

      status(response) must equalTo(OK)
    }
  }

  "POST /login" should {

    "return a BadRequest status when no data is provided" in new WithApp {

      val request = FakeRequest(POST, "/login")

      val response = route(request).get

      status(response) must equalTo(400)
    }
  }
}
