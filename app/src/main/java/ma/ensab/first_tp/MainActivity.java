package ma.ensab.first_tp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAmount;
    private Button btnCompute;
    private TextView textViewResult;
    private ListView listViewResult;
    private ArrayList<String> data;
    private ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        btnCompute = findViewById(R.id.btnCompute);
        textViewResult = findViewById(R.id.textViewResult);
        listViewResult = findViewById(R.id.listViewResults);

        data = new ArrayList<>();
        stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listViewResult.setAdapter(stringArrayAdapter);

        btnCompute.setOnClickListener(view -> {
            String amountStr = editTextAmount.getText().toString();
            if (!amountStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);
                double result = amount * 11;
                textViewResult.setText(String.valueOf(result));
                data.add(amount + " => " + result);
                stringArrayAdapter.notifyDataSetChanged();
                editTextAmount.setText("");
            }
        });
    }
}
