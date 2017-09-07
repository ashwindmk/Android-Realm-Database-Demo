package com.example.ashwin.realmdatabasedemo;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.ashwin.realmdatabasedemo.models.Book;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by ashwin on 7/9/17.
 */

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {
        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {
        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {
        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    // Refresh the realm istance
    public void refresh() {
        realm.refresh();
    }

    // Clear all objects from Book.class
    public void clearAll() {
        realm.beginTransaction();
        realm.clear(Book.class);
        realm.commitTransaction();
    }

    // Find all objects in the Book.class
    public RealmResults<Book> getBooks() {
        return realm.where(Book.class).findAll();
    }

    // Query a single item with the given id
    public Book getBook(String id) {
        return realm.where(Book.class).equalTo("id", id).findFirst();
    }

    // Check if Book.class is empty
    public boolean hasBooks() {
        return !realm.allObjects(Book.class).isEmpty();
    }

    // Query example
    public RealmResults<Book> queryedBooks() {
        return realm.where(Book.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();
    }
}
