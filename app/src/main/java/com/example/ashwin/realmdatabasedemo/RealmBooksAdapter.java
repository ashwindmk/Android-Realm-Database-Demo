package com.example.ashwin.realmdatabasedemo;

import android.content.Context;

import com.example.ashwin.realmdatabasedemo.models.Book;

import io.realm.RealmResults;

/**
 * Created by ashwin on 7/9/17.
 */

public class RealmBooksAdapter extends RealmModelAdapter<Book> {

    public RealmBooksAdapter(Context context, RealmResults<Book> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
