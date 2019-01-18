package ru.eyelog.rxjavapattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText etLength, etSteps;
    Button btClassic, btReact;
    ListView listView;

    LoopEngine loopEngine;
    ReactEngine reactEngine;

    int steps, length;
    List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        etLength = findViewById(R.id.etLength);
        etSteps = findViewById(R.id.etSteps);
        btClassic = findViewById(R.id.btClassic);
        btReact = findViewById(R.id.btReact);
        listView = findViewById(R.id.listView);

        loopEngine = new LoopEngine();
        reactEngine = new ReactEngine();

        btClassic.setOnClickListener((v) -> {
            if(etSteps.getText().toString().equals("")||etLength.getText().toString().equals("")){
                Toast.makeText(this, "Not all fields filled", Toast.LENGTH_SHORT).show();
            }else {
                steps = Integer.parseInt(etSteps.getText().toString());
                length = Integer.parseInt(etLength.getText().toString());
                stringList = loopEngine.getStringList(steps, length);
                listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList));
            }
        });

        btReact.setOnClickListener((v) -> {
            if(etSteps.getText().toString().equals("")||etLength.getText().toString().equals("")){
                Toast.makeText(this, "Not all fields filled", Toast.LENGTH_SHORT).show();
            }else {
                steps = Integer.parseInt(etSteps.getText().toString());
                length = Integer.parseInt(etLength.getText().toString());
                stringList = reactEngine.getStringList(steps, length);
                listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList));
            }
        });

    }
}
