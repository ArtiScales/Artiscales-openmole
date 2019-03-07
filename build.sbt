name := "ArtiScales-openmole-plugin"

version := "1.0"

scalaVersion := "2.12.6"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
scalacOptions += "-target:jvm-1.8"

enablePlugins(SbtOsgi)

OsgiKeys.exportPackage := Seq("artiscalesopenmoleplugin.*")

OsgiKeys.importPackage := Seq("*;resolution:=optional")

//OsgiKeys.privatePackage := Seq("""
//|!scala.*,!java.*,META-INF.*;-split-package:=merge-first,
//|*;-split-package:=merge-first
//|""".stripMargin)

OsgiKeys.privatePackage := Seq("!scala.*,!java.*,*")

//OsgiKeys.privatePackage := Seq("*")

OsgiKeys.requireCapability := """osgi.ee; osgi.ee="JavaSE";version:List="1.8,1.9"""""

resolvers += "IDB" at "http://igetdb.sourceforge.net/maven2-repository/"

resolvers += Resolver.mavenLocal

resolvers += "IGN snapshots" at "https://forge-cogit.ign.fr/nexus/content/repositories/snapshots/"

resolvers += "IGN releases" at "https://forge-cogit.ign.fr/nexus/content/repositories/releases/"

//resolvers += "ISC-PIF Public" at "http://maven.iscpif.fr/public/"

//resolvers += "ISC-PIF Snapshots" at "http://maven.iscpif.fr/ign-snapshots/"

//resolvers += "ISC-PIF Release" at "http://maven.iscpif.fr/ign-releases/"

resolvers += "ImageJ" at "http://maven.imagej.net/content/repositories/public"

resolvers += "Boundless" at "http://repo.boundlessgeo.com/main"

resolvers += "osgeo" at "http://download.osgeo.org/webdav/geotools/"

resolvers += "geosolutions" at "http://maven.geo-solutions.it/"

resolvers += "Hibernate" at "http://www.hibernatespatial.org/repository"

val geotoolsGridVersion = "21.0"

libraryDependencies ++= Seq (
  "org.geotools" % "gt-grid" % geotoolsGridVersion,
  "org.geotools" % "gt-coverage" % geotoolsGridVersion,
  "org.geotools" % "gt-geotiff" % geotoolsGridVersion,
  "org.geotools" % "gt-image" % geotoolsGridVersion,
  "org.geotools" % "gt-epsg-hsql" % geotoolsGridVersion,
  "org.geotools" % "gt-referencing" % geotoolsGridVersion,
  "org.geotools" % "gt-shapefile" % geotoolsGridVersion,
  "org.geotools" % "gt-graph" % geotoolsGridVersion,
  "org.geotools" % "gt-metadata" % geotoolsGridVersion,
  "org.geotools" % "gt-opengis" % geotoolsGridVersion,
  "org.geotools" % "gt-main" % geotoolsGridVersion,
//  "org.geotools" % "gt-api" % geotoolsGridVersion,
  "javax.media" % "jai_core" % "1.1.3" from "http://download.osgeo.org/webdav/geotools/javax/media/jai_core/1.1.3/jai_core-1.1.3.jar",
  "javax.media" % "jai_codec" % "1.1.3",
  "javax.media" % "jai_imageio" % "1.1"
)

val artiscalesVersion = "0.3-SNAPSHOT"

libraryDependencies += "fr.ign.cogit" % "ArtiScales" % artiscalesVersion excludeAll(
    ExclusionRule(organization = "org.geotools"),
    ExclusionRule(organization = "com.sun.image.codec.jpeg"),
    ExclusionRule(organization = "com.sun.imageio.plugins.common"),
    ExclusionRule(organization = "com.sun.imageio.spi"),
    ExclusionRule(organization = "com.sun.jdmk.comm"),
    ExclusionRule(organization = "com.sun.jna"),
    ExclusionRule(organization = "com.sun.jna.platform.win32"),

    ExclusionRule(organization = "uk.ac.ed.ph.snuggletex"),
    ExclusionRule(organization = "vigna.dsi.unimi.it"),
    ExclusionRule(organization = "net.billylieurance.azuresearch"),
    ExclusionRule(organization = "net.sf.jafama"),
    ExclusionRule(organization = "net.sourceforge.jmatio"),
    ExclusionRule(organization = "jgrapht"),
    ExclusionRule(organization = "org.bethecoder"),
    ExclusionRule(organization = "com.aetrion.flickr"),
    ExclusionRule(organization = "com.caffeineowl.graphics"),
    ExclusionRule(organization = "de.bwaldvogel"),
    ExclusionRule(organization = "mnstarfire"),
    ExclusionRule(organization = "com.thoughtworks.xstream"),
    ExclusionRule(organization = "jfree"),
    ExclusionRule(organization = "javax.media"),
    ExclusionRule(organization = "org.slf4j")
)

val simplu3DVersion = "1.3-SNAPSHOT"
val geoxVersion = "1.10-SNAPSHOT"

libraryDependencies ++= Seq (
  "fr.ign.cogit" % "simplu3d" % simplu3DVersion excludeAll(ExclusionRule(organization = "org.geotools")),
  "fr.ign.cogit" % "geoxygene-api" % geoxVersion excludeAll(ExclusionRule(organization = "org.geotools")),
  "fr.ign.cogit" % "geoxygene-feature" % geoxVersion excludeAll(ExclusionRule(organization = "org.geotools")),
  "fr.ign.cogit" % "geoxygene-filter" % geoxVersion excludeAll(ExclusionRule(organization = "org.geotools")),
  "fr.ign.cogit" % "geoxygene-io" % geoxVersion excludeAll(ExclusionRule(organization = "org.geotools")),
  "fr.ign.cogit" % "geoxygene-util" % geoxVersion excludeAll(ExclusionRule(organization = "org.geotools")),
  "fr.ign.cogit" % "geoxygene-spatial" % geoxVersion excludeAll(ExclusionRule(organization = "org.geotools")),
  "fr.ign.cogit" % "geoxygene-sig3d" % geoxVersion excludeAll(ExclusionRule(organization = "org.geotools"))
)

excludeDependencies ++= Seq(
  ExclusionRule("com.vividsolutions", "jts"),
  ExclusionRule("fr.ign.cogit", "geoxygene-database"),
  ExclusionRule("org.hibernate.common", "hibernate-commons-annotations"),
  ExclusionRule("org.hibernate.javax.persistence", "hibernate-jpa-2.1-api"),
  ExclusionRule("org.hibernate", "hibernate-core"),
  ExclusionRule("org.hibernate", "hibernate-entitymanager")
  //  ExclusionRule("javax.media","jai_imageio")
)

OsgiKeys.additionalHeaders :=  Map(
  "Specification-Title" -> "Spec Title",
  "Specification-Version" -> "Spec Version",
  "Specification-Vendor" -> "IGN",
  "Implementation-Title" -> "Impl Title",
  "Implementation-Version" -> "Impl Version",
  "Implementation-Vendor" -> "IGN"
)
//updateOptions := updateOptions.value.withLatestSnapshots(false)

OsgiKeys.embeddedJars := (Keys.externalDependencyClasspath in Compile).value map (_.data) filter (f=> (f.getName startsWith "gt-"))
