package com.mvvm.room.myjsonapp

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.core.app.ApplicationProvider
import com.mvvm.room.myjsonapp.model.TableModel
import com.mvvm.room.myjsonapp.repository.DetailsRepository
import com.mvvm.room.myjsonapp.retrofit.RetrofitClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.net.HttpURLConnection


public class TestRepositoryClass {

    //Target
    @Mock
    private lateinit var mRepo: DetailsRepository

    @Mock
    var context: Context? = null

    @Mock
    var liveData: MutableLiveData<TableModel>? = null

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    val mNextValue = "https://https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json"
    val mCount = 87

    @Before
    fun start() {
    }

    @Test
    fun test_online_repo_retrieves_expected_data() = runBlocking<Unit> {

        mockNetworkResponseWithFileContent("success_response.json", HttpURLConnection.HTTP_OK)
        mRepo = DetailsRepository()
        context = ApplicationProvider.getApplicationContext()
        liveData = MutableLiveData()

        val dataReceived = mRepo.getDataFromApi(context!!, liveData!!)

        assertNotNull(dataReceived)
        assertEquals(dataReceived, mCount)
        assertEquals(dataReceived, mNextValue)
    }

    fun mockNetworkResponseWithFileContent(fileName: String, responseCode: Int) {

        val call = RetrofitClient.apiInterface.getDetails()
        call.enqueue(object : Callback<TableModel> {
            override fun onFailure(call: Call<TableModel>, t: Throwable) {
                // TODO("Not yet implemented")
                getJson(fileName)
            }

            override fun onResponse(call: Call<TableModel>, response: Response<TableModel>) {
                // TODO("Not yet implemented")
            }
        })

    }

    fun getJson(path: String): String {
        val uri = javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

}