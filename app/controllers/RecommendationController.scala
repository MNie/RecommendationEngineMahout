package controllers

import play.api.mvc.{Action, Controller}
import service.RecommendationService

import scala.collection.JavaConversions._

object RecommendationController extends Controller {
  private val recommender = new RecommendationService()
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def recommend(userId: Long, limit: Int) = Action {
    val result = recommender.GetRecommendationsFor(userId, limit)
    result.toList.foreach{ item => println("item: " + item.getItemID + " value: " + item.getValue)}
    Ok("")
  }
}