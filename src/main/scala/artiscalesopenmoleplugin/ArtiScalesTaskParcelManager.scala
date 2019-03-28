package artiscalesopenmoleplugin

import java.io.File
import java.nio.file.Files

import fr.ign.cogit.modules.SelectParcels
import fr.ign.cogit.simplu3d.util.SimpluParametersJSON

import scala.util.{Failure, Success, Try}

trait ArtiScalesTaskParcelManager {
  def apply(rootFolder: File, outputFolder: File, varianteSpatialConf: File, paramFile1: File, paramFile2: File, zip: String, tmpFolder: File): Unit = {
		val lF = new java.util.ArrayList[File]
		lF.add(paramFile1)
		lF.add(paramFile2)
		val p: SimpluParametersJSON = new SimpluParametersJSON(lF)
		val mergeFile = new File(tmpFolder, "merge")//not created since not used
		val tmpFile = new File(tmpFolder, "tmpFile")
		tmpFile.mkdirs()//this one is actually used
		Try(new SelectParcels(rootFolder, outputFolder, varianteSpatialConf, p).selectAndDecompParcels(zip, false, mergeFile, tmpFile)) match {
			case Success(_) =>
			case Failure(exception) =>
				println(s"Failure with $exception")
				println(s"""Output folder:\n\t${Option(outputFolder) match {
					case Some(folder) => if (folder.isDirectory) folder.list().mkString(",") else "NOT A DIRECTORY"
					case None => "DOES NOT EXIST"
				}
				}""")
				exception.printStackTrace
		}
	}
}

object ArtiScalesTaskParcelManager extends ArtiScalesTaskParcelManager
