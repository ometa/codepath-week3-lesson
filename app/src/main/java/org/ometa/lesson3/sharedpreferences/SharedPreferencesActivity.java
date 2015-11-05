package org.ometa.lesson3.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import org.ometa.lesson3.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    EditText etSearch;
    CheckBox cbOpenNow;


    // can only store key/value pairs, simple datatypes
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);


        etSearch = (EditText) findViewById(R.id.etSearch);
        cbOpenNow = (CheckBox) findViewById(R.id.btnSubmit);

        prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

        etSearch.setText(prefs.getString("search", ""));
        cbOpenNow.setChecked(prefs.getBoolean("open_now", false));
    }
    public void onSubmitClick(View view) {

        String searchText = etSearch.getText().toString();
        boolean openNowState = cbOpenNow.isChecked();

        SharedPreferences.Editor editor editor = prefs.edit();
        editor.putString("search", searchText);
        editor.putBoolean("open_now", openNowState);
        editor.apply();
        // apply  (async)
        // commit (sync)
    }
}
