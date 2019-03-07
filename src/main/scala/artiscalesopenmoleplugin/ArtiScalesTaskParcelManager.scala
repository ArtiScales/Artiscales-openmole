package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.modules.SelectParcels
import fr.ign.cogit.simplu3d.util.SimpluParametersJSON

import scala.util.{Failure, Success, Try}

trait ArtiScalesTaskParcelManager {
  def apply(rootFolder: File, outputFolder: File, varianteSpatialConf: File, paramFile1: File, paramFile2: File, zip: String ): Unit = {
		val lF = new java.util.ArrayList[File]
		lF.add(paramFile1)
		lF.add(paramFile2)
		val p: SimpluParametersJSON = new SimpluParametersJSON(lF)
		Try(new SelectParcels(rootFolder, outputFolder, varianteSpatialConf, p).selectAndDecompParcels(zip, false, null)) match {
			case Success(_) =>
			case Failure(exception) =>
				println(s"Failure with $exception")
				println(s"""Output folder contains:\n${outputFolder.list().mkString(",")}""")
		}
	}
}

object ArtiScalesTaskParcelManager extends ArtiScalesTaskParcelManager
