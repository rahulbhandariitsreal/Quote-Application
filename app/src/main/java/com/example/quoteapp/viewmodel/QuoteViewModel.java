package com.example.quoteapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quoteapp.model.Quote;
import com.example.quoteapp.repository.QuoteRepository;

import java.util.List;

public class QuoteViewModel extends AndroidViewModel {

    private LiveData<List<Quote>> listLiveDataquote;
    private QuoteRepository quoteRepository;


    public QuoteViewModel(@NonNull Application application) {
        super(application);
        quoteRepository=new QuoteRepository(application);
    }

    public LiveData<List<Quote>> getListLiveDataquote(int page){
        listLiveDataquote=quoteRepository.getQuoteMutableLiveData(page);
        return  listLiveDataquote;
    }
}
