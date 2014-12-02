package com.dmkartik.phrasesearch

import java.io.File
import scala.io.BufferedSource
import scala.io.Source
import java.nio.charset.MalformedInputException

object Parser {
  def apply(search: String, path: String): Parser = {
    val parser = new Parser()
    parser.parse(search, path)
  }
}

/**
 * Parser outputs files that contain the search text in the provided path
 */
class Parser() {
  private var search: String = ""
  var files: Array[File] = null
  private var output: Array[String] = new Array[String](0)

  /**
   * Determines all files at a provided path
   * @param path String - the folder path
   * @return Returns an array of the files at the provided path
   */
  def getFileList(path: String): Array[File] = {
    files = new Array[File](0)
    createFileList(Array[File](new File(path)))
    if(files.isEmpty) { addOutput("ERROR: Provided path has no files\n") }
    else { addOutput("List of files containing search string:\n") }
    files
  }

  /**
   * Iterates over an array of Files
   * @param files
   * @return
   */
  def createFileList(files: Array[File]): Boolean = { ArrayIterator.iterate[File](files, (file: File) => addToFileList(file)) }

  /**
   * Passed as a parameter to the iterator in createFileList
   * Determines if a File object is a file or a directory
   * @param file
   * @return Returns false to ensure the iterator processes all of the files
   */
  def addToFileList(file: File): Boolean = {
    if(file.isFile) files = files :+ file
    else if(file.isDirectory) createFileList(file.listFiles)
    false
  }

  /**
   * Adds to the output array
   * @param string
   */
  private def addOutput(string: String): Unit = { output = output :+ string }

  def getOutput: Array[String] = { output }

  /**
   * Takes in the search string, and decorates it to preform case insensitive searches
   * @param string
   * @return
   */
  def setSearchString(string: String): Unit = { search = string }

  /**
   * Checks the line provided whether the search string is present.
   * @param line String - Line from file
   * @return Boolean - Returns true if match is found to exit out of the iterator processing the lines in the file
   */
  def searchLine(line: String): Boolean = { search.r.findFirstIn(line).nonEmpty }

  /**
   * This method is passed as a parameter to the iterator in parse
   * Checks file if search string is present, adding the filename to the output array if true
   * @param file
   * @return Boolean - Returns false always to ensure that the iterator processes each file in the file list.
   */
  def parseFile(file: File): Boolean = {
    try {
      val f: BufferedSource = Source.fromFile(file)
      if(ArrayIterator.iterate[String](f.getLines().toArray, (line: String) => searchLine(line))) { addOutput(file.getCanonicalPath) }
      f.close()
      false
    }
    catch { case e: MalformedInputException => false }
  }

  /**
   * This method processes the files provided to search for matches.
   * @param search
   * @param path
   * @return true when at least one file contains the search string, false when none
   */
  def parse(search: String, path: String): Parser = {
    setSearchString(search)
    val files = getFileList(path)
    if(files.nonEmpty) {
      ArrayIterator.iterate[File](files, (file: File) => parseFile(file))
      if(output.length == 1) { addOutput("No matches.") }
    }
    this
  }
}
