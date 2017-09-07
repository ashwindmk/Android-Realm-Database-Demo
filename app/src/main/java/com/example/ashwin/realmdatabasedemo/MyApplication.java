package com.example.ashwin.realmdatabasedemo;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ashwin on 7/9/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    private void initRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        /*RealmConfiguration myConfig = new RealmConfiguration.Builder(context)
            .name("myrealm.realm").
            .schemaVersion(2)
            .setModules(new MyCustomSchema())
            .build();

        RealmConfiguration otherConfig = new RealmConfiguration.Builder(context)
            .name("otherrealm.realm")
            .schemaVersion(5)
            .setModules(new MyOtherSchema())
            .build();

        Realm myRealm = Realm.getInstance(myConfig);
        Realm otherRealm = Realm.getInstance(otherConfig);*/
    }
}
