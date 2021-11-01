package com.gyorgykorek.calcappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static DecimalFormat df = new DecimalFormat("0.00");
    String logerView;
    EditText j1,  k1, k2;
    TextView t1,loger,t2,t3,t4,t5;
    double sum;
    double szorzat = 0;
    double kszorzat = 0;
    double kki =0;
    int kreditszamolo = 0;
    int bukott = 0;
    int knum1, jnum1;
    double harminc = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    // a public method to get the input numbers
    public boolean getNumbers()
    {

        // defining the edit text 1 to e1
        j1 = (EditText)findViewById(R.id.jegy1);

        // defining the edit text 1 to e1
        k1 = (EditText)findViewById(R.id.kr1);


        // defining the text view to t1
        t1 = (TextView)findViewById(R.id.result);
        // defining the text view to t1
        t2 = (TextView)findViewById(R.id.result2);
        // defining the text view to t1
        t3 = (TextView)findViewById(R.id.result3);
        // defining the text view to kreditindex
        t4 = (TextView)findViewById(R.id.result4);
        // defining the text view to korrigálkt kredit
        t5 = (TextView)findViewById(R.id.result5);
        // defining the text view to loger
        loger = (TextView)findViewById(R.id.log);

        // taking input from text box 1
        String js1 = j1.getText().toString();

        // taking input from text box 1
        String ks1 = k1.getText().toString();

        // condition to check if box is not empty
        if ((js1 == null || ks1 == null)
                || (js1.equals("") || ks1.equals(""))) {

            String result = "Add meg kérlek a jegyet és az osztályzatot!";
            logerView = (String) loger.getText();
            loger.setText(logerView+"\n"+result);

            return false;
        }
        else {
            // converting string to int.
            jnum1 = Integer.parseInt(j1.getText().toString());

            // converting string to int.
            knum1 = Integer.parseInt(k1.getText().toString());
        }

        return true;

    }

    // a public method to perform addition
    public void doSum(View v)
    {

        // get the input numbers
        if (getNumbers()) {
            try {

                // get the input numbers
                if (getNumbers()) {
                    if (jnum1<=1){
                        kszorzat = kszorzat + (knum1 * jnum1);
                        bukott = bukott +knum1;
                        t3.setText(Integer.toString((kreditszamolo+bukott)));
                        t4.setText(Double.toString((kszorzat/harminc)));
                        t5.setText(Double.toString(((kszorzat/harminc)*kreditszamolo)/(kreditszamolo+bukott)));
                        logerView = (String) loger.getText();
                        loger.setText(logerView + "\n1-es jegy nem számít bele a súlyozott átlagodba!");
                        k1.setText("");
                        j1.setText("");
                    }
                    else{
                        kszorzat = kszorzat + (knum1 * jnum1);
                        szorzat = szorzat + (knum1 * jnum1);
                        kreditszamolo = kreditszamolo + knum1;
                        sum = (szorzat/(double) kreditszamolo);
                        //súlyozott
                        t1.setText(Double.toString((sum)));
                        //teljesített
                        t2.setText(Integer.toString(kreditszamolo));
                        //felvett
                        t3.setText(Integer.toString((kreditszamolo+bukott)));
                        //kreditindex
                        t4.setText(Double.toString((kszorzat/harminc)));
                        //korrigált kreditindex
                        t5.setText(Double.toString(((kszorzat/harminc)*kreditszamolo)/(kreditszamolo+bukott)));
                        k1.setText("");
                        j1.setText("");
                        logerView = (String) loger.getText();
                        loger.setText(logerView + "\nKredit: "+knum1+"\tJegy: "+jnum1+ "\tSúlyozott átlag: " +df.format(sum));
                    }
                }

            } catch (Exception e) {
                System.out.println("");
            }
        }
    }

    // a public method to perform addition
    public void doClear(View v)
    {

        loger.setText("");
        sum = 0;
        bukott = 0;
        kszorzat = 0;
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        szorzat = 0;
        kreditszamolo = 0;
        k1.setText("");
        j1.setText("");

    }

}