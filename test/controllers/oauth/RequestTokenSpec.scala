package controllers.oauth

import test._
import play.api.test._
import play.api.test.Helpers._

class RequestTokenSpec extends Specification {

  "GET /oauth/request/token" should {

    "get a random request token" in new WithApp {

      val request = FakeRequest(GET, "/oauth/request/token")

      val response = route(request).get

      status(response) must equalTo(OK)
    }
  }
}
