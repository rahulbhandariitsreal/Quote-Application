package com.example.quoteapp.service;

import com.example.quoteapp.model.QuoteResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuoteInterface {

    //base url -> https://quotable.io/
    //url https://quotable.io/quotes?page=1

    @GET("quotes")
    Call<QuoteResponse> getallQuotes(@Query("page") int page);
}

