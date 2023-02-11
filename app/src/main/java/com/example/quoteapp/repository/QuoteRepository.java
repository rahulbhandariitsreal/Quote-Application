package com.example.quoteapp.repository;



import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.quoteapp.model.Quote;
import com.example.quoteapp.model.QuoteResponse;
import com.example.quoteapp.service.QuoteInterface;
import com.example.quoteapp.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteRepository {


    private ArrayList<Quote> quoteArrayList;
    private MutableLiveData<List<Quote>> quoteMutableLiveData=new MutableLiveData<>();

    private RetrofitInstance retrofitInstance;

    private Application application;

    public QuoteRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Quote>> getQuoteMutableLiveData(int page){
        retrofitInstance=new RetrofitInstance();
        QuoteInterface quoteInterface= retrofitInstance.getQuoteIntergace();
        Call<QuoteResponse> call=quoteInterface.getallQuotes(page);
        call.enqueue(new Callback<QuoteResponse>() {

            @Override
            public void onResponse(Call<QuoteResponse> call, Response<QuoteResponse> response) {
                QuoteResponse result=response.body();
                if(result!=null  && result.getResults()!=null){
                    quoteArrayList=(ArrayList<Quote>) result.getResults();
                    quoteMutableLiveData.setValue(quoteArrayList);
                }
            }

            @Override
            public void onFailure(Call<QuoteResponse> call, Throwable t) {
                Toast.makeText(application, "Data Unavaliable", Toast.LENGTH_SHORT).show();
            }
        });
        return quoteMutableLiveData;
    }

}
