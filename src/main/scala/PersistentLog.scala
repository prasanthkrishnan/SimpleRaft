trait PersistentLog {

  /**
    * Persist the entire log onto disk
    * @return
    */
  def persists(): Boolean
}
