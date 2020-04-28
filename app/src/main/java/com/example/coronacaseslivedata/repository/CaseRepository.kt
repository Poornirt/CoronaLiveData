package com.example.coronacaseslivedata.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.coronacaseslivedata.apiservice.ApiService
import com.example.coronacaseslivedata.jdo.Cases
import com.example.coronacaseslivedata.jdo.CasesWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CaseRepository(var application: Application) {

    private var mCases=ArrayList<Cases>()
    private var mMutableLiveData=MutableLiveData<List<Cases>>()

    public fun getMutableLiveData():MutableLiveData<List<Cases>>{
        var call:Call<CasesWrapper> = ApiService.getApiService().getCurrentCase()
        call.enqueue(object:Callback<CasesWrapper>{
            override fun onResponse(call: Call<CasesWrapper>, response: Response<CasesWrapper>) {
                var casesWrapper: CasesWrapper? =response.body()
                Log.d("CaseRepository",response.body().toString())
                if(casesWrapper!=null && casesWrapper.mCases!=null) {
                    mCases= casesWrapper.mCases as ArrayList<Cases>
                    mMutableLiveData.value=mCases
                }
            }

            override fun onFailure(call: Call<CasesWrapper>, t: Throwable) {

            }
        })
        return mMutableLiveData
    }

}