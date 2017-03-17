import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.test.Helpers._
import play.api.test._

@RunWith(classOf[JUnitRunner])
class RecommendationSpec extends Specification {

  "Application" should {

    "send 200 when asking for index page" in new WithApplication{
      val result = route(FakeRequest(GET, "/")).get
      status(result) must equalTo(OK)
    }

    "send 200 when asking for recommendation for a real user" in new WithApplication{
      val result = route(FakeRequest(GET, "/Recommend?userId=646840&limit=20")).get
      status(result) must equalTo(OK)
    }

    "send 400 when asking for recommendation without userid" in new WithApplication{
      val result = route(FakeRequest(GET, "/Recommend")).get
      status(result) must equalTo(BAD_REQUEST)
    }
  }
}
