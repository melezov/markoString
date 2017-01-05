// ### BASIC SETTINGS ### //
organization := "com.oradian.util"
name := "marko-string"
version := "0.0.1"

unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value)
unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)

// ### DEPENDENCIES ### //
libraryDependencies += "org.specs2" %% "specs2-scalacheck" % "3.8.6" % "test"

// ### COMPILE SETTINGS ### //
crossScalaVersions := Seq("2.12.1", "2.11.8")
scalaVersion := crossScalaVersions.value.head
scalacOptions ++= (Seq(
  "-deprecation"
, "-encoding", "UTF-8"
, "-feature"
, "-language:_"
, "-target:jvm-1.8"
, "-unchecked"
, "-Xfuture"
, "-Xlint:_"
, "-Xverify"
, "-Yno-adapted-args"
, "-Yrangepos"
, "-Yrepl-sync"
, "-Ywarn-dead-code"
, "-Ywarn-numeric-widen"
, "-Ywarn-unused-import"
, "-Ywarn-unused"
, "-Ywarn-value-discard"
) ++ (CrossVersion.partialVersion(scalaVersion.value) match {
  case Some((2, 12)) => Seq (
    "-opt:_"
  )
  case Some((2, 11)) => Seq(
    "-Yclosure-elim",
    "-Yconst-opt",
    "-Ydead-code",
    "-Yinline",
    "-Yinline-warnings:false"
  )
  case _ => Nil
}))

scalacOptions in (Compile, doc) ++= Seq(
  "-no-link-warnings"
, "-sourcepath", (scalaSource in Compile).value.toString
, "-doc-source-url", s"""https://github.com/oradian/markoString/blob/${version.value}-${
    CrossVersion.partialVersion(scalaVersion.value).get.productIterator.mkString(".")
  }.x/src/main/scala\u20AC{FILE_PATH}.scala"""
)
