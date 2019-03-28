package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.util.DataPreparator

trait ArtiScalesTaskZonePackager {
  def apply(parcels: File, inputFolder: File, outputFolder: File): Unit = {
    DataPreparator.createPackages(parcels, inputFolder, outputFolder)
  }
}

object ArtiScalesTaskZonePackager extends ArtiScalesTaskZonePackager
