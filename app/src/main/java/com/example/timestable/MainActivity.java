package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    public  void generateTimeTable(int timesTable){
        ArrayList<String> timesTableContent=new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            timesTableContent.add(Integer.toString(i*timesTable));
        }

        ArrayAdapter<String> arrayAdapter=new
                ArrayAdapter<>(this,android.R.layout.simple_list_item_1,timesTableContent);
        myListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar myTimesSeekBar=findViewById(R.id.timesSeekbar);
         myListView=findViewById(R.id.timesTableListView);
        myTimesSeekBar.setMax(20);
        myTimesSeekBar.setProgress(10);
        myTimesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timesTable;

                if (i<min){
                    timesTable=min;
                    myTimesSeekBar.setProgress(min);
                }else {
                    timesTable=i;
                }
                generateTimeTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       generateTimeTable(10);
    }
}