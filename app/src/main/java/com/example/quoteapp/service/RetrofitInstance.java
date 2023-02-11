package com.example.quoteapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    //base url -> https://quotable.io/
    //url https://quotable.io/quotes?page=1

    public static final String BASE_URL="https://quotable.io/";

    public Retrofit retrofit=null;
    //no need of api key as it is a free api


    public  QuoteInterface getQuoteIntergace(){
        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(QuoteInterface.class);
    }

}
