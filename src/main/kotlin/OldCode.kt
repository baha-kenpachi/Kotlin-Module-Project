import model.Archive

open class Data() {
    companion object ArchiveList {
        /*val allItem: MutableMap<String, MutableMap<String, Note>?> = mutableMapOf()
        val archives: MutableList<String> = mutableListOf()
        val notes: MutableMap<String, String> = mutableMapOf()
*/
        val archives: MutableList<Archive> = mutableListOf()
        fun getAllArchives(): MutableList<Archive> {
            return this.archives
        }

        fun addArchive(archive: Archive) {
            archives.add(archive)
        }
        fun removeArchive(archive: Archive){
            archives.remove(archive)
        }

        fun getArchiveByName(name: String): Archive? {
            return archives.find { it.archiveName == name }
        }

    }
}
