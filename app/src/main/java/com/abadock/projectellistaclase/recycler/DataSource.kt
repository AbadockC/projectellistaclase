package com.abadock.projectellistaclase.recycler

class DataSource {
    var LlistarAlumnes = mutableListOf(
        AlumnesViewModel(1,"Sofía", 16, "1r SMX"),
        AlumnesViewModel(1,"Mateo", 15, "1r SMX"),
        AlumnesViewModel(1,"Camila", 17, "2n SMX"),
        AlumnesViewModel(1,"David", 16, "2n SMX"),
        AlumnesViewModel(1,"Ana", 16 , "1r DAM"),
        AlumnesViewModel(1,"Lucas", 15, "1r DAM"),
        AlumnesViewModel(1,"Julia", 17, "2n DAM"),
        AlumnesViewModel(1,"Diego", 16, "2n DAM"),
    )

    fun loadAlumnes() :List<AlumnesViewModel>{
        return LlistarAlumnes
    }
    fun addAlumne(alumne: AlumnesViewModel) {
        LlistarAlumnes.add(alumne)
    }
    fun reOrder(nom: String) {
        LlistarAlumnes.sortBy { it.nom == nom }
    }
}