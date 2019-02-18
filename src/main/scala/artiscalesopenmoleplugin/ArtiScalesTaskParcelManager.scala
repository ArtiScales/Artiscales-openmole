package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.modules.SimPLUSimulator
import fr.ign.parameters.Parameters
import fr.ign.task.Initialize

trait ArtiScalesTaskParcelManager {
  def apply(rootFolder: File, outputFolder: File, varianteSpatialConf: File, paramFile1: File, paramFile2: File): Unit = {
	val lF = new java.util.ArrayList[File]
	lF.add(paramFile1)
	lF.add(paramFile2)
	val p: Parameters = Parameters.unmarshall(lF)
	new SelectParcels(rootFile, outputFolder, varianteSpatialConf, p).run
  }
}

object ArtiScalesTaskParcelManager extends ArtiScalesTaskParcelManager
