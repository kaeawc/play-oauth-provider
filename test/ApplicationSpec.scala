package test

import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends Specification {

  "GET /" should {

    "render the landing page" in new WithApp {

      val request = FakeRequest(GET, "/")

      val response = route(request).get

      status(response) must equalTo(OK)
    }
  }
}
