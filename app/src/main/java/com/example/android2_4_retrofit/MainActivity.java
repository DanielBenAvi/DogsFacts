package com.example.android2_4_retrofit;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView factTextView;
    private Button newFactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factTextView = findViewById(R.id.textView);
        newFactButton = findViewById(R.id.button);


        newFactButton.setOnClickListener(v -> newFact());


        newFact();
    }

    private void newFact(){
        ApiController.fetchFact(callback_fact);
    }


    private ApiController.Callback_Fact callback_fact = new ApiController.Callback_Fact() {
        @Override
        public void onResponse(Fact fact) {
            factTextView.setText(fact.getFacts().get(0));
        }

        @Override
        public void onFailure() {
            factTextView.setText("Failed to fetch fact");
        }
    };
}