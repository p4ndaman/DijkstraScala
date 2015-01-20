package test.scala.graph

import java.io.File

/**
 * Created by mayur.pandya on 1/19/15.
 */
object TestUtil {
  def getFile(relativePath:String):File = {
    // TODO: Use input stream in case this entire project is packaged
    // http://stackoverflow.com/questions/14089146/file-loading-by-getclass-getresource
    return new File(getClass().getResource("/test/resources/graph/" + relativePath).toURI)
  }
}
