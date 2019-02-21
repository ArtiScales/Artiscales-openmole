package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.modules.SimPLUSimulator
import fr.ign.cogit.simplu3d.util.SimpluParametersJSON
import fr.ign.task.Initialize

trait ArtiScalesTaskSimPLU {
  def apply(rootFolder: File, inputFolder: File, outputFolder: File, paramFile1: File, paramFile2: File): Unit = {
    val lF = new java.util.ArrayList[File]
    lF.add(paramFile1)
    lF.add(paramFile2)
    val p: SimpluParametersJSON = new SimpluParametersJSON(lF)
    val simulator = new SimPLUSimulator(rootFolder, inputFolder, p, outputFolder)
    simulator.run
  }
}

object ArtiScalesTaskSimPLU extends ArtiScalesTaskSimPLU
