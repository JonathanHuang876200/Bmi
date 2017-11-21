package tom.com.bmi;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText weight;
    private EditText height;

        private void findView(){
        weight = (EditText)findViewById(R.id.ed_weight);
        height = (EditText)findViewById(R.id.ed_height);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }



    public void bmi(View view){
        Button bBmi = (Button) findViewById(R.id.b_bmi);


        float w = Float.parseFloat(weight.getText().toString());
        float h = Float.parseFloat(height.getText().toString());
        float bmi = w/(h*h);

        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("EXTRA_BMI",bmi);
        startActivity(intent);

       new AlertDialog.Builder(MainActivity.this)
        .setMessage("你的BMI是: "+bmi)
               .show();
        if(bmi>20){
          new AlertDialog.Builder(MainActivity.this)
                  .setMessage(bmi+"請多吃點")
                  .show();
        }
        if(bmi>3){
        new AlertDialog.Builder(MainActivity.this)
                .setMessage("身高單位應為公尺")
                .setPositiveButton("OK",null)
                .show();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }


}
