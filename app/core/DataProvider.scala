package core

import javax.inject.Inject
import javax.sql.DataSource

import org.apache.mahout.cf.taste.common.TasteException
import org.apache.mahout.cf.taste.impl.model.jdbc.{ReloadFromJDBCDataModel, SQL92BooleanPrefJDBCDataModel}
import org.apache.mahout.cf.taste.model.DataModel

class DataProvider @Inject() (databaseConnectionProvider: DatabaseConnectionProvider)  {
    private val dataSource = databaseConnectionProvider.getDataSource

    def getModel: DataModel = {
      return getBooleanDataModel(dataSource, "Recommender.DataModelView", "user_id", "item_id", "interval")
    }

  private def getBooleanDataModel(dataSource: DataSource, table: String, userIDColumn: String, itemIDColumn: String, timestampColumn: String): DataModel = {
    var dataModel: DataModel = null
    try {
      dataModel = new ReloadFromJDBCDataModel(new SQL92BooleanPrefJDBCDataModel(dataSource, table, userIDColumn, itemIDColumn, timestampColumn))
    }
    catch {
      case e: TasteException => {
        throw new RuntimeException("Failed to load data from table '" + table + "'", e)
      }
    }
    return dataModel
  }
}
