trait Log[T] {

  def append(term: Int, cmd: T)
  def lastEntry: LogEntry[T]
  def lastCommittedEntry: LogEntry[T]
  def commitNextEntry()
}
