package com.dmkartik.phrasesearch

import java.io.File

class ParserSpec extends BaseSpec{
  "Parser" must "populate list of files" in {
    val path: String = new File("src/test/resources/files").getAbsolutePath
    val p: Parser = new Parser()
    val fileList: Array[File] = p.getFileList(path)
    for(file <- fileList) { assert(file.isFile) }
  }
}
