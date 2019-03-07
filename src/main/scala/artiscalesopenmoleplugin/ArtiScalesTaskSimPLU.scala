package artiscalesopenmoleplugin

import java.io.File

import fr.ign.cogit.modules.SimPLUSimulator
import fr.ign.cogit.simplu3d.util.SimpluParametersJSON

import scala.util.{Failure, Success, Try}

trait ArtiScalesTaskSimPLU {
  def apply(rootFolder: File, inputFolder: File, outputFolder: File, paramFile1: File, paramFile2: File): Unit = {
    val lF = new java.util.ArrayList[File]
    lF.add(paramFile1)
    lF.add(paramFile2)
    val p: SimpluParametersJSON = new SimpluParametersJSON(lF)
    val simulator = new SimPLUSimulator(rootFolder, inputFolder, p, outputFolder)
    Try(simulator.run) match {
      case Success(_) =>
      case Failure(exception) =>
        println(s"Failure with $exception")
        println(s"""Output folder contains:\n${outputFolder.list().mkString(",")}""")
    }
  }
}

object ArtiScalesTaskSimPLU extends ArtiScalesTaskSimPLU
