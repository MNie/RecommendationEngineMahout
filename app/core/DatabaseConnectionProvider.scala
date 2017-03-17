package core

import _root_.com.microsoft.sqlserver.jdbc.{SQLServerConnectionPoolDataSource, SQLServerDataSource}
import com.typesafe.config.ConfigFactory

class DatabaseConnectionProvider {
  def getDataSource: SQLServerDataSource = {
    return getDataSource("database")
  }

  private def getDataSource(configuration: String): SQLServerDataSource = {
    val conf = ConfigFactory.load()
    val ds = new SQLServerConnectionPoolDataSource
    val server = conf.getString(configuration + ".server")
    val databaseName = conf.getString(configuration + ".name")
    ds.setServerName(server)
    ds.setDatabaseName(databaseName)
    ds.setUser(conf.getString(configuration + ".connection.username"))
    ds.setPassword(conf.getString(configuration + ".connection.password"))
    return ds
  }
}
