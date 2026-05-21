package com.example.sistemaregistroestudiantes

fun main() {
    // ===== PARTE 1 =====
    val nombreCurso = "Programacio Funcional "
    val nombreProfesor = "Ing. Ana Barajas"
    var maximoEstudiantes = 5   // Número máximo de estudiantes a registrar

    println("=== SISTEMA DE REGISTRO DE ESTUDIANTES ===")
    println("Curso: $nombreCurso")
    println("Profesor: $nombreProfesor")
    println("Numero maximo de estudiantes: $maximoEstudiantes")
    println()

    // ===== PARTE 2 =====
    val listaEstudiantes = mutableListOf<String>()

    println("--- Registro de 5 estudiantes ---")
    for (i in 1..maximoEstudiantes) {
        print("Ingrese el nombre del estudiante $i: ")
        val nombre = readLine() ?: ""
        if (nombre.isNotBlank()) {
            listaEstudiantes.add(nombre)
        } else {
            println("Nombre invalido, se agregara 'Estudiante $i'")
            listaEstudiantes.add("Estudiante $i")
        }
    }

    println("\n--- Lista de estudiantes registrados ---")
    for (estudiante in listaEstudiantes) {
        println("- $estudiante")
    }

    // ===== PARTE 3 =====
    val calificaciones = mutableMapOf<String, Double>()

    println("\n--- Registro de calificaciones ---")
    for (estudiante in listaEstudiantes) {
        print("Ingrese la calificacion de $estudiante: ")
        val calificacionInput = readLine()?.toDoubleOrNull()
        if (calificacionInput != null && calificacionInput in 0.0..100.0) {
            calificaciones[estudiante] = calificacionInput
        } else {
            println("Calificacio invalida (debe ser 0-100). Se asignara 0.")
            calificaciones[estudiante] = 0.0
        }
    }

    // ===== PARTE 4 =====
    println("\n--- Evaluacion de estudiantes ---")
    var aprobados = 0
    var reprobados = 0
    var sumaCalificaciones = 0.0

    for (estudiante in listaEstudiantes) {
        val nota = calificaciones[estudiante] ?: 0.0
        sumaCalificaciones += nota
        val resultado = if (nota >= 70) "APROBADO" else "REPROBADO"
        if (nota >= 70) aprobados++ else reprobados++
        println("$estudiante | Calificacion: $nota | $resultado")
    }

    val promedio = sumaCalificaciones / listaEstudiantes.size

    // ===== PARTE 5 =====
    val ciudades = mutableSetOf<String>()

    println("\n--- Registro de ciudades de origen ---")
    for (estudiante in listaEstudiantes) {
        print("Ingrese la ciudad de origen de $estudiante: ")
        val ciudad = readLine() ?: ""
        if (ciudad.isNotBlank()) {
            ciudades.add(ciudad)
        } else {
            ciudades.add("Desconocida")
        }
    }

    println("\n--- Ciudades registradas ---")
    for (ciudad in ciudades) {
        println("- $ciudad")
    }
    println("Total de ciudades diferentes: ${ciudades.size}")

    // ===== PARTE 6 =====
    println("\n=== RESULTADOS FINALES ===")
    println("Curso: $nombreCurso")
    println("Profesor: $nombreProfesor")
    println("Total de estudiantes registrados: ${listaEstudiantes.size}")
    println("Lista completa de estudiantes: $listaEstudiantes")
    println("Promedio general del grupo: ${"%.2f".format(promedio)}")
    println("Cantidad de estudiantes aprobados: $aprobados")
    println("Cantidad de estudiantes reprobados: $reprobados")
}