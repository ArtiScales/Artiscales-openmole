package artiscalesopenmoleplugin

import java.io.File

import org.apache.commons.io.FileUtils

import scala.util.{Failure, Success, Try}
import org.geotools.data.shapefile.ShapefileDataStore

trait ArtiScalesTaskParcelManagerCountAndDelete {
  def apply(folder: File): Int = {
		val file = folder.listFiles().filter(_.getName.endsWith(".shp")).head
		val count = Try {
			val dataStore = new ShapefileDataStore(file.toURI.toURL)
			val parcelCollection = dataStore.getFeatureSource.getFeatures
			val size = parcelCollection.size()
			dataStore.dispose()
			size
		}
		count match {
			case Success(c) => c
			case Failure(_) =>
				folder.listFiles().foreach{FileUtils.deleteQuietly}
				0
		}
	}
}

object ArtiScalesTaskParcelManagerCountAndDelete extends ArtiScalesTaskParcelManagerCountAndDelete
