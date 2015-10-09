package com.mightystrong.machinelearning

import scala.io.Source
import java.io.File
/**
 * @author ${user.name}
 */
object KNNExample {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
  	var getCurrentDirectory = new java.io.File( "." ).getCanonicalPath
  	println(getCurrentDirectory)
	val basePath = "KNN_Example_1.csv"
	val testData = getDataFromCSV(new File(basePath))
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
