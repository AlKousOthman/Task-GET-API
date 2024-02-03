package com.joincoded.taskgetapi.repsitory

import com.joincoded.taskgetapi.interfaces.PetServiceApi

class PetRepository(private val api: PetServiceApi){

    suspend fun getAllPets() = api.getAllPets()
}