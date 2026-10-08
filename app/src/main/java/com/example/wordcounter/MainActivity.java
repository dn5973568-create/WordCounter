package com.example.wordcounter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText textInput = findViewById(R.id.textInput);
        Spinner countSpinner = findViewById(R.id.countSpinner);
        Button countButton = findViewById(R.id.countButton);
        TextView resultTextView = findViewById(R.id.resultTextView);
        WordCounter wordCounter = new WordCounter();

        countButton.setOnClickListener(v -> {

            String text = textInput.getText().toString().trim();

            if (text.isEmpty()) {
                Toast.makeText(this, getString(R.string.empty_text_warning), Toast.LENGTH_SHORT).show();
                return;
            }

            int count = 0;

            String selectedOption = countSpinner.getSelectedItem().toString();

            if (selectedOption.equals("Words")) {
                count = wordCounter.countWords(text);
            } else if (selectedOption.equals("Chars")) {
                count = wordCounter.countChars(text);
            } else if (selectedOption.equals("Sentences")) {
                count = wordCounter.countSentences(text);
            } else if (selectedOption.equals("Numbers")) {
                count = wordCounter.countNumbers(text);
            }
            resultTextView.setText(getString(R.string.count_result, count));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}