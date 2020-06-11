package com.bootcamp.ujian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bootcamp.ujian.AdapterKesehatan.AdapterListBasic;
import com.bootcamp.ujian.model.Data;
import com.raizlabs.android.dbflow.sql.queriable.StringQuery;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rView;
    List<Data> listData;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Daftar Pasient");

        btnAdd = (Button) findViewById(R.id.btnAdd);
        rView = (RecyclerView) findViewById(R.id.rView);

        sqlQueryList();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent);
            }
        });
    }


    public void sqlQueryList() {
        String rawQuery = "SELECT * FROM `Data` ";
        StringQuery<Data> stringQuery = new StringQuery<>(Data.class, rawQuery);
        stringQuery.async().queryListResultCallback(
                new QueryTransaction.QueryResultListCallback<Data>() {
                    @Override
                    public void onListQueryResult(QueryTransaction transaction, @NonNull List<Data> models) {
                        setupAdapterList(models);
                    }
                }
        ).execute();
    }


    public void setupAdapterList(List<Data> model) {
        AdapterListBasic toadapter = new AdapterListBasic(MainActivity.this, model);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rView.setLayoutManager(linearLayoutManager);

        rView.setAdapter(toadapter);
    }

}

