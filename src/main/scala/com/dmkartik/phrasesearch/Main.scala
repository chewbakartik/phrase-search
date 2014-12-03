package com.dmkartik.phrasesearch

import scala.io.StdIn.readLine

object Main {
  def main(args: Array[String]): Unit = { process }

  /**
   * Provides interactive console to user
   */
  def process: Unit = {
    val search: String = getString("search string:")
    val path: String = getString("path:")
    val parser: Parser = Parser(search, path)
    ArrayIterator.iterate[String](parser.getOutput, (msg: String) => displayMessage(msg))
    if (runAgain) { process }
    else { println("Goodbye") }
  }

  /**
   * Prompts user to input a string.
   * @param stringName Displays type of string requested to user
   * @return Input from user
   */
  def getString(stringName: String): String = {
    println("Please enter ".concat(stringName))
    val string: String = readLine()
    println("")
    if(string == null || string.isEmpty) {
      println("ERROR: Input can not be empty\n")
      return getString(stringName)
    }
    string
  }

  def runAgain: Boolean = {
    println("\nWould you like to run again (Y/N):")
    val again: String = readLine()
    println("")
    val response: Int = again.toLowerCase match {
      case "y" => 1
      case "yes" => 1
      case "n" => 2
      case "no" => 2
      case _ => 3
    }
    if(response == 1) { return true }
    if(response == 2) { return false }
    println("ERROR: Invalid input\n")
    runAgain
  }

  def displayMessage(msg: String): Boolean = {
    println(msg)
    false
  }
}