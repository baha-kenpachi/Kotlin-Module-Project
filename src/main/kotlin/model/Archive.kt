package model

data class Archive(val archiveName: String) {
    val notes: MutableList<Note> = mutableListOf()
}