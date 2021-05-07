package sg.edu.rp.c346.id20022280.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amt;
    EditText numppl;
    ToggleButton svs;
    ToggleButton gst;
    EditText discount;
    RadioGroup paytype;
    Button split;
    Button reset;
    TextView totalbill;
    TextView eachpay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amt = findViewById(R.id.editTextNumAmt);
        numppl = findViewById(R.id.editTextNumPpl);
        svs = findViewById(R.id.toggleSVS);
        gst = findViewById(R.id.toggleGST);
        discount = findViewById(R.id.editTextDiscount);
        paytype = findViewById(R.id.radiogroupPayType);
        split = findViewById(R.id.buttonSplit);
        reset = findViewById(R.id.buttonReset);
        totalbill = findViewById(R.id.textViewTotalBill);
        eachpay = findViewById(R.id.textViewEachPays);

            split.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //gst & svs check
                    boolean gsttrue = false;
                    boolean svstrue = false;

                    if(gst.isChecked()){
                        gsttrue=true;
                    }else{
                        gsttrue=false;
                    }

                    if(svs.isChecked()){
                        svstrue=true;
                    }else{
                        svstrue=false;
                    }

                    //

                }
            }
        );

    }
}
