package com.example.thugwtsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.dialog.MaterialDialogs;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ArrayList<User> arrayList=new ArrayList<>();
    private RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

         toolbar=findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         recyclerView=findViewById(R.id.recyclerView);


         arrayList.add(new User(R.drawable.polytechnic,"sreenivasan",R.raw.dharavi_kochinhaneefa));
         arrayList.add(new User(R.drawable.suraj,"suraj",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.evideyo_entho_thakararu_pole,"harisree asokan",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.ithoke_enthu,"salim kumar",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.pinne_oru_aiswary_rai,"santhosh pandit",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.ramanan,"harisree asokan",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.polytechnic,"sreenivasan",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.suraj,"suraj",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.evideyo_entho_thakararu_pole,"harisree asokan",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.ithoke_enthu,"salim kumar",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.pinne_oru_aiswary_rai,"santhosh pandit",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.ramanan,"harisree asokan",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.polytechnic,"sreenivasan",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.suraj,"suraj",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.evideyo_entho_thakararu_pole,"harisree asokan",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.ithoke_enthu,"salim kumar",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.pinne_oru_aiswary_rai,"santhosh pandit",R.raw.dharavi_kochinhaneefa));
        arrayList.add(new User(R.drawable.ramanan,"harisree asokan",R.raw.dharavi_kochinhaneefa));




         inflateLayout();
    }

    private void inflateLayout() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MyAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView)item.getActionView();

        searchView.setIconified(false);
        searchView.setIconifiedByDefault(false);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.share)
        {
            Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onBackPressed() {

        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(MainActivity.this);
        builder.setTitle("Exit")
                .setMessage("Do you really want to exit!")
                .setCancelable(false)
                .setIcon(R.drawable.crying_imoji)
                .setBackground(getResources().getDrawable(R.drawable.top_layout))
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();


//        Button positive=dialog.getButton(DialogInterface.BUTTON_POSITIVE);
//        positive.setTextColor(Color.);
//        Button negative=dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
//        negative.setTextColor(Color.GREEN);

    }
}
