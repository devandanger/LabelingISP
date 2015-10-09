package com.mightystrong.machinelearning

import scala.swing._
import scala.io.Source
import java.io.File
import smile.plot.ScatterPlot
import java.awt.Color
/**
 * @author ${user.name}
 */
object KNNExample {

  object GUI extends SimpleSwingApplication {
	def top = new MainFrame {
	  	title = "KNN Example"
	  	val basePath = "KNN_Example_1.csv"
	  	val testData = getDataFromCSV(new File(basePath))
	  	val plot = ScatterPlot.plot(testData._1,
	                                 testData._2, 
	                                 '@', 
	                                 Array(Color.red, Color.blue)
	                                )
	    peer.setContentPane(plot)
	    size = new Dimension(400, 400)
	  }
  }
  
  def main(args : Array[String]) {
  	GUI.main(args)
  }

  def getDataFromCSV(file: File): (Array[Array[Double]], Array[Int]) = {
	var source = scala.io.Source.fromFile(file)
	var data = source
		.getLines()
		.drop(1)
		.map(x => getDataFromString(x))
		.toArray
	source.close()
	var dataPoints = data.map(x => x._1)
	var classifierArray = data.map(x => x._2)
	return (dataPoints, classifierArray)
	}

  def getDataFromString(dataString: String): (Array[Double], Int) = {
	var dataArray: Array[String] = dataString.split(',')

	var xCoordinate: Double = dataArray(0).toDouble
	var yCoordinate: Double = dataArray(1).toDouble
	var classifier: Int = dataArray(2).toInt

	return (Array(xCoordinate, yCoordinate), classifier)
	}
}
