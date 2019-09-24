package com.example.testlocation;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private Button btnsave;
    private Button btnproceed;
    private EditText editTextName;
    private EditText editTextLatitude;
    private EditText editTextLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnproceed = (Button) findViewById(R.id.btnproceed);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
        editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);
        btnsave = (Button) findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInformation();
                editTextName.getText().clear();
                editTextLatitude.getText().clear();
                editTextLongitude.getText().clear();
            }
        });


        btnproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });
    }

    private void saveUserInformation() {
        String name = editTextName.getText().toString().trim();
        double latitude = Double.parseDouble(editTextLatitude.getText().toString().trim());
        double longitude = Double.parseDouble(editTextLongitude.getText().toString().trim());
        UserInformation userInformation = new UserInformation(name, latitude, longitude);
        mDatabase.child("User").setValue(userInformation);
        Toast.makeText(this, "Save", Toast.LENGTH_LONG).show();
    }


}
