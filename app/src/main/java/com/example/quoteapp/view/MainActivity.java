package com.example.quoteapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.text.PrecomputedTextCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.quoteapp.BR;
import com.example.quoteapp.R;
import com.example.quoteapp.adapter.QuoteAdapter;
import com.example.quoteapp.databinding.ActivityMainBinding;
import com.example.quoteapp.model.Quote;
import com.example.quoteapp.viewmodel.QuoteViewModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


private ProgressBar progressBar;

    private QuoteViewModel quoteViewModel;
    private MainActivityClickHandlers clickHandlers;
    public static  int page=1;
    private QuoteAdapter quoteAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Quote> quoteArrayList;
    private ActivityMainBinding activityMainBinding;

    private Toolbar toolbar;

 private PagenoIs pageno;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.QTprogressbar);

        //toolbar
        toolbar=findViewById(R.id.QTtoolbar);
        if(getSupportActionBar()!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("QUOTE");
    }



pageno=new PagenoIs();
        activityMainBinding=  DataBindingUtil.setContentView(this,R.layout.activity_main);
quoteViewModel=new ViewModelProvider(this).get(QuoteViewModel.class);
clickHandlers =new MainActivityClickHandlers();
activityMainBinding.setClickHandlers(clickHandlers);

activityMainBinding.setPagenoIs(pageno);

setObservabledata(page);


    }



    private void setRecycler() {


        recyclerView=activityMainBinding.QTrecyclerview;

        quoteAdapter=new QuoteAdapter(quoteArrayList,this);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(quoteAdapter);

        quoteAdapter.notifyDataSetChanged();

    }
    private void setObservabledata(int newpage){

        progressBar.setVisibility(View.VISIBLE);
                    quoteViewModel.getListLiveDataquote(newpage).observe(MainActivity.this, new Observer<List<Quote>>() {

                        @Override
                        public void onChanged(List<Quote> quotes) {

                            quoteArrayList = (ArrayList<Quote>) quotes;
                            for (Quote quote : quoteArrayList) {
                                Log.v("Tag", quote.getAuthor());
                            }
                            // Toast.makeText(MainActivity.this, "SET called", Toast.LENGTH_SHORT).show();
                            setRecycler();
                            pageno.setPageno(newpage + "/100");
                        }
                    });
        progressBar.setVisibility(View.GONE);
    }

public class PagenoIs  extends BaseObservable {
        private String pageno;

    public PagenoIs() {
    }

    @Bindable
    public String getPageno()
    {

        return pageno;

    }

    public void setPageno(String pageno) {

        this.pageno = pageno;

        notifyPropertyChanged(BR.pageno);

    }

}

    public class MainActivityClickHandlers{

        public  void prePage(View view){
            Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            if(page>1) {
                page--;
                setObservabledata(page);
            }
        }


        public  void nextPage(View view){
            Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            if(page<100) {
                page++;
                setObservabledata(page);
            }
    }
}
}