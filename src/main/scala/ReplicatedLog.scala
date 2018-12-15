import scala.collection.mutable.ArrayBuffer

class ReplicatedLog [String] extends Log[String] with PersistentLog[String] {

  val logEntries: ArrayBuffer[LogEntry[String]] = ArrayBuffer.empty[LogEntry[String]]
  var commitedIdx: Int = -1

  override def persists(): Boolean = {
    // TODO
    true
  }

  override def commitNextEntry(): Unit = {
    commitedIdx += 1
  }

  override def append(term: Int, cmd: String): Unit = {
    logEntries += LogEntry(term, logEntries.size, cmd)
  }

  override def lastEntry: LogEntry[String] = {
    logEntries(logEntries.size)
  }

  override def lastCommittedEntry: LogEntry[String] = {
    logEntries(commitedIdx)
  }
}
