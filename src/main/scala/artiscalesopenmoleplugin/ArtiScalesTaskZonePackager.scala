package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.util.DataPreparator

trait ArtiScalesTaskZonePackager {
  def apply(parcels: File, tmpFolder: File, outputFolder: File): Unit = {
    DataPreparator.createPackages(parcels, tmpFolder, outputFolder)
  }
}

object ArtiScalesTaskZonePackager extends ArtiScalesTaskZonePackager
