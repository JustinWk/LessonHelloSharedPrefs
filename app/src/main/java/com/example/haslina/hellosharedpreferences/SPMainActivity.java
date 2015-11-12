package com.example.haslina.hellosharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SPMainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btSave, btLoad;
    TextView tvUsername, tvPassword;
    private  Context c;
    public static final String DEFAULT = "N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_activity_main);
        etUsername = (EditText) findViewById(R.id.etusername);
        etPassword = (EditText) findViewById(R.id.etpassword);
        btSave = (Button) findViewById(R.id.btsave);
        btLoad = (Button) findViewById(R.id.btload);
        tvUsername = (TextView) findViewById(R.id.tvusername);
        tvPassword = (TextView) findViewById(R.id.tvpassword);

    }

    public void Save (View v){
        SharedPreferences sp = getApplicationContext().getSharedPreferences
                ("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "save", Toast.LENGTH_LONG).show();
    }

    public void Load (View v){
        SharedPreferences sp = getApplicationContext().getSharedPreferences(
                "MyData", Context.MODE_PRIVATE);
        String name = sp.getString("username", DEFAULT);
        String pass = sp.getString("password", DEFAULT);
        if (name.equals(DEFAULT) || pass.equals(DEFAULT)) {
            Toast.makeText(getApplicationContext(), "DATA NOT FOUND "
                    +DEFAULT, Toast.LENGTH_LONG).show();
        } else
        {
            tvUsername.setText(name);
            tvPassword.setText(pass);
            Toast.makeText(getApplicationContext(), "DATA FOUND",
                    Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "load", Toast.LENGTH_LONG).show();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
