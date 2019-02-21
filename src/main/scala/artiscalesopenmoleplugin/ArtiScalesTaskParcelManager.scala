package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.modules.SelectParcels
import fr.ign.cogit.simplu3d.util.SimpluParametersJSON

trait ArtiScalesTaskParcelManager {
  def apply(rootFolder: File, outputFolder: File, varianteSpatialConf: File, paramFile1: File, paramFile2: File, zip: String ): Unit = {
		val lF = new java.util.ArrayList[File]
		lF.add(paramFile1)
		lF.add(paramFile2)
		val p: SimpluParametersJSON = new SimpluParametersJSON(lF)
		new SelectParcels(rootFolder, outputFolder, varianteSpatialConf, p).selectAndDecompParcels(zip, false, null)
	}
}

object ArtiScalesTaskParcelManager extends ArtiScalesTaskParcelManager
