package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.modules.SimPLUSimulator
import fr.ign.parameters.Parameters
import fr.ign.task.Initialize

trait ArtiScalesTaskSimPLU {
  def apply(rootFolder: File, inputFolder: File, outputFolder: File, paramFile1: File, paramFile2: File): Unit = {
    val lF = new java.util.ArrayList[File]
    lF.add(paramFile1)
    lF.add(paramFile2)
    val p: Parameters = Parameters.unmarshall(lF)
    new SimPLUSimulator(rootFolder, inputFolder, p, outputFolder).run
  }
}

object ArtiScalesTaskSimPLU extends ArtiScalesTaskSimPLU
