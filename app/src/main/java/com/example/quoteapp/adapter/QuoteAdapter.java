package com.example.quoteapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quoteapp.R;
import com.example.quoteapp.databinding.QuoteListItemBinding;
import com.example.quoteapp.model.Quote;

import java.util.ArrayList;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.ViewHolder> {
    private ArrayList<Quote> quoteArrayList;
    private Context context;

    public QuoteAdapter(ArrayList<Quote> quoteArrayList, Context context) {
        this.quoteArrayList = quoteArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuoteListItemBinding quoteListItemBinding= DataBindingUtil.inflate(LayoutInflater.
                        from(parent.getContext()),
                R.layout.quote_list_item
        ,parent,false);
        return new ViewHolder(quoteListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quote currentquote=quoteArrayList.get(position);
holder.quoteListItemBinding.setQuote(currentquote);

    }

    @Override
    public int getItemCount() {
        return quoteArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private QuoteListItemBinding quoteListItemBinding;
        public ViewHolder(@NonNull QuoteListItemBinding quoteListItemBinding) {
            super(quoteListItemBinding.getRoot());
            this.quoteListItemBinding=quoteListItemBinding;
quoteListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int position=getAdapterPosition();
        Quote quote=quoteArrayList.get(position);
        Toast.makeText(context, "Quote is"+quote.getAuthor(), Toast.LENGTH_SHORT).show();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, quote.getContent());
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }
});
        }
    }
}
