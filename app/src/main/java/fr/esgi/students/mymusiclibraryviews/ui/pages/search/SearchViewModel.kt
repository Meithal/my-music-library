package fr.esgi.students.mymusiclibraryviews.ui.pages.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class SearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()

    val text: LiveData<String> = _text.map {
        "${_text.value}"
    }


    fun setText(text: String) {
        _text.value = text
    }
}
