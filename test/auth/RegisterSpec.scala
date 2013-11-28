package test.auth

import test._
import play.api.test._
import play.api.test.Helpers._

class RegisterSpec extends Specification {

  "GET /signup" should {

    "render the signup page" in new WithApp {

      val request = FakeRequest(GET, "/signup")

      val response = route(request).get

      status(response) must equalTo(OK)
    }
  }
}
