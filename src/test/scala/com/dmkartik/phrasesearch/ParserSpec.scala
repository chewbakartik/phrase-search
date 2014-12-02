package com.dmkartik.phrasesearch

import java.io.File

class ParserSpec extends BaseSpec{
  "Parser" must "populate list of files" in {
    val path: String = new File("src/test/resources/files").getAbsolutePath
    val p: Parser = new Parser()
    val fileList: Array[File] = p.getFileList(path)
    for(file <- fileList) { assert(file.isFile) }
  }

  "Parser" must "determine whether a string contains the search phrase" in {
    val search: String = "find"
    val p: Parser = new Parser()
    p.setSearchString(search)
    val strings: Array[String] = Array("First string", "Second string", "Value to find")
    assert(!p.searchLine(strings(0)))
    assert(!p.searchLine(strings(1)))
    assert(p.searchLine(strings(2)))
    p.setSearchString("and")
    for(string <- strings) { assert(!p.searchLine(string)) }
  }

  "File parser" must "output files that contain phrase matches" in {
    val basePath: String = new File(".").getCanonicalPath
    val resourcePath: String = "/src/test/resources/files"
    val path: String = basePath.concat(resourcePath)
    val search: String = "(?i)everything"
    val p: Parser = Parser(search, path)
    val fileListPaths: Array[String] = p.files.map(_.getCanonicalPath)
    val resultsArr: Array[String] = p.getOutput
    assertResult(true) { resultsArr contains fileListPaths(0) }
    assertResult(true) { resultsArr contains fileListPaths(1) }
    assertResult(false) { resultsArr contains fileListPaths(2) }
    assertResult(false) { resultsArr contains fileListPaths(3) }
  }
}
