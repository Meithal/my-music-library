package fr.esgi.students.mymusiclibraryviews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LovedViewModel : ViewModel(){
    val lovedFlow = MutableStateFlow<List<Loved>?>(null)

    fun findLovedList(format: LovedFormat) {
        viewModelScope.launch {
            val loved = NetworkManager.getLovedList(format)
            lovedFlow.emit(loved)
        }
    }
}