package com.joincoded.taskgetapi.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.taskgetapi.interfaces.PetServiceApi
import com.joincoded.taskgetapi.model.Pet
import com.joincoded.taskgetapi.repsitory.PetRepository
import com.joincoded.taskgetapi.singleton.RetrofitHelper
import kotlinx.coroutines.launch


class PetViewModel: ViewModel() {
    private val petServiceApi = RetrofitHelper.getInstance().create(PetServiceApi::class.java)
    private val repository = PetRepository(petServiceApi)

    var pets by mutableStateOf(listOf<Pet>())

    init{
        fetchPets()
    }
    fun fetchPets(){
        viewModelScope.launch {
            try {
                pets = repository.getAllPets()
            } catch (e: Exception){

            }
        }
    }

    fun addPet(pet: Pet) {
        viewModelScope.launch {
            try {
                val response = petServiceApi.addPet(pet)
                if (response.isSuccessful && response.body() != null) {
                    // Handle successful addition of the book, e.g., updating the UI or list of books
                } else {
                    // Handle failure, e.g., showing an error message
                }
            } catch (e: Exception) {
                // Handle any exceptions, e.g., network errors
            }
        }
    }


        fun deletePet(petId: Int){
            viewModelScope.launch {
                try {
                    val response = petServiceApi.deletePet(petId)

                    if (response.isSuccessful){
                    }else{

                    }
                } catch (e: Exception){

                }
            }

        }

}