package sg.edu.rp.c346.p12spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnType, spnNumber;
    Button btnUpdate;
    ArrayList<String> alNumber;
    ArrayAdapter<String > aaNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnType = findViewById(R.id.spinner);
        spnNumber = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        alNumber = new ArrayList<>();
        aaNumber = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alNumber);
        spnNumber.setAdapter(aaNumber);

        alNumber.add("2");
        alNumber.add("4");
        alNumber.add("6");

        String[] strNumbers = getResources().getStringArray(R.array.even_number);
        //Convert Array to List and add to the ArrayList
        alNumber.addAll(Arrays.asList(strNumbers));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spnType.getSelectedItemPosition();
                alNumber.clear();

                if (spnType.getSelectedItem().equals("Even")){
                    String[] strNumbers = getResources().getStringArray(R.array.even_number);
                    alNumber.addAll(Arrays.asList(strNumbers));
                }
                else{
                    String[] strNumbers = getResources().getStringArray(R.array.odd_number);
                    alNumber.addAll(Arrays.asList(strNumbers));
                }
            }
        });

       spnType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               alNumber.clear();
               switch (position){
                   case 0:
                       String[] strEvenNumbers = getResources().getStringArray(R.array.even_number);
                       alNumber.addAll(Arrays.asList(strEvenNumbers));
                       break;
                   case 1:
                       String[] strOddNumber = getResources().getStringArray(R.array.odd_number);
                       alNumber.addAll(Arrays.asList(strOddNumber));
                       break;

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

    }
}
