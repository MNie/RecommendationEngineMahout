package service

import core.{DataProvider, DatabaseConnectionProvider}
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity

class RecommendationService {
  private val dataModel = new DataProvider(new DatabaseConnectionProvider()).getModel
  private val userSimilarity = new LogLikelihoodSimilarity(dataModel)
  private val neighborhood = new NearestNUserNeighborhood(25, userSimilarity, dataModel)
  private val _recommender = new GenericBooleanPrefUserBasedRecommender(dataModel, neighborhood, userSimilarity)

  def GetRecommendationsFor(userId: Long, howMany: Int) = {
    _recommender.recommend(userId, howMany)
  }
}
