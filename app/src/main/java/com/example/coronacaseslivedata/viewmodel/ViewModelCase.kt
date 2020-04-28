package com.example.coronacaseslivedata.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coronacaseslivedata.jdo.Cases
import com.example.coronacaseslivedata.jdo.CasesWrapper
import com.example.coronacaseslivedata.repository.CaseRepository

class ViewModelCase(application: Application) : AndroidViewModel(application) {
    var caseRepository=CaseRepository(application)

     fun getCases():MutableLiveData<List<Cases>>{
         Log.d("CaseRepository",caseRepository.getMutableLiveData().toString())
         return caseRepository.getMutableLiveData()
    }

}