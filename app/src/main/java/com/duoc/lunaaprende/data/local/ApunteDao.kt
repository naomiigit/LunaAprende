package com.duoc.lunaaprende.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ApunteDao {

    @Insert
    fun insertar(apunte: Apunte)

    @Query("SELECT * FROM apuntes ORDER BY fecha DESC")
    fun obtenerTodos(): List<Apunte>

    @Query("DELETE FROM apuntes WHERE id = :id")
    fun eliminar(id: Int)
}