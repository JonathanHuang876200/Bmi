package tom.com.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void bmi(View view){
        Button bBmi = (Button) findViewById(R.id.b_bmi);

        EditText weight = (EditText)findViewById(R.id.ed_weight);
        EditText height = (EditText)findViewById(R.id.ed_height);
        int w = Integer.parseInt(weight.getText().toString());
        int h = Integer.parseInt(height.getText().toString());
        int bmi = w/(h*h);
            new AlertDialog.Builder(this)
                    .setMessage(bmi)
                    .show();
        if(bmi>20){
          new AlertDialog.Builder(MainActivity.this)
                  .setMessage(bmi+"請多吃點")
                  .show();
        }
        if(h>3){
        new AlertDialog.Builder(MainActivity.this)
                .setMessage("身高單位應為公尺")
                .setPositiveButton("OK",null)
                .show();
        }
    }

}
