name := "Ma"

version := "1.0"

lazy val `ma` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test )

libraryDependencies += "org.apache.hadoop" % "hadoop-core" % "1.2.1"

libraryDependencies += "org.apache.mahout" % "mahout-core" % "0.9"

libraryDependencies += "org.apache.mahout" % "mahout-math" % "0.9"

libraryDependencies += "org.apache.mahout" % "mahout-examples" % "0.9"

libraryDependencies += "org.apache.mahout" % "mahout-math-scala" % "0.9"

libraryDependencies += "com.microsoft.sqlserver" % "mssql-jdbc" % "6.1.0.jre8"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"ExternalLibs/Microsoft JDBC Driver 6.0 for SQL Server/sqljdbc_6.0/enu" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  