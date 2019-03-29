package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.modules.SelectParcels

trait ArtiScalesTaskZonePackager {
  def apply(parcels: File, inputFolder: File, outputFolder: File, regulFile: File, geoFile: File ): Unit = {
    SelectParcels.separateToDifferentOptimizedPack(parcels, outputFolder, inputFolder, regulFile, geoFile)
  }
}

object ArtiScalesTaskZonePackager extends ArtiScalesTaskZonePackager
