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
}
