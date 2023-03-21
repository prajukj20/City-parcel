package com.example.cityparcel_listpassed_method;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityparcel_listpassed_method.Fragment.Startingpagefragment;

public class MainActivity extends AppCompatActivity {

    TextView cityparcel;
    ImageView image;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,Startingpagefragment.class);
//                startActivity(intent);
//                finish();

//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.page,new Startingpagefragment());
//                transaction.commit();

                Intent intent = new Intent(MainActivity.this,mainactivitytabs.class);
                startActivity(intent);
                finish();
            }
       });


    }

}

