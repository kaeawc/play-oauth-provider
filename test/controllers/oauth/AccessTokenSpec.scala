package controllers.oauth

import test._
import play.api.test._
import play.api.test.Helpers._

class AccessTokenSpec extends Specification {

  "GET /oauth/access/token" should {

    "get a random access token" in new WithApp {

      val request = FakeRequest(GET, "/oauth/access/token")

      val response = route(request).get

      status(response) must equalTo(OK)
    }
  }
}
