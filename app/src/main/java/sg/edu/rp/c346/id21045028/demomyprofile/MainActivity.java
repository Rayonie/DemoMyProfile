package sg.edu.rp.c346.id21045028.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float gpa= Float.parseFloat(etGPA.getText().toString());
        //Obtain the SharedPref instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Create a SharedPref Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Set a key-value pair in the editor
        prefEdit.putString("name",strName);
        prefEdit.putFloat("gpa",gpa);
        //Call commit to save the changes made to the SharedPref
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Obtain the SharedPref instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Retrieve the saved data from SharedPref
        // with the default value if no matching data
        String name = prefs.getString("name","no name displayed");
        Float gpa = prefs.getFloat("gpa",0);

        //Update UI element according to the saved
        etName.setText(name);
        etGPA.setText(gpa+ "");
    }
}