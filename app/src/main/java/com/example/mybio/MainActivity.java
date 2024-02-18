package com.example.mybio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mybio.data.Bio;
import com.example.mybio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private EditText enterHobbies;
    private TextView hobbies;
    private final Bio bio = new Bio();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        bio.setName("Subhajit RuiDas");
        binding.setBio(bio);
          binding.doneButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  addHobbies(view);
              }
          });
    }

    public void addHobbies(View view) {
//        hobbies.setText(String.format("Hobbies:%s", enterHobbies.getText().toString().trim()));
//        hobbies.setVisibility(View.VISIBLE);
        bio.setHobbies(String.format("Hobbies: %s",binding.enterHobby.getText().toString().trim()));
        //binding.hobbyText.setText();
        binding.invalidateAll();
        binding.hobbyText.setVisibility(View.VISIBLE);

        //hide the keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}