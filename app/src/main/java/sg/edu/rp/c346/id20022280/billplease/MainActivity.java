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

    EditText numAmt;
    EditText numPpl;
    ToggleButton togglesvs;
    ToggleButton togglegst;
    EditText textdiscount;
    RadioGroup rgpaytype;
    Button btsplit;
    Button btreset;
    TextView tvtotalbill;
    TextView tveachpay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numAmt = findViewById(R.id.editTextNumAmt);
        numPpl = findViewById(R.id.editTextNumPpl);
        togglesvs = findViewById(R.id.toggleSVS);
        togglegst = findViewById(R.id.toggleGST);
        textdiscount = findViewById(R.id.editTextDiscount);
        rgpaytype = findViewById(R.id.radiogroupPayType);
        btsplit = findViewById(R.id.buttonSplit);
        btreset = findViewById(R.id.buttonReset);
        tvtotalbill = findViewById(R.id.textViewTotalBill);
        tveachpay = findViewById(R.id.textViewEachPays);

            btsplit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    double totalmult = 1.0;

                    //Number Retrieval
                    double amount = Double.parseDouble(numAmt.getText().toString());
                    int numpeople = Integer.parseInt(numPpl.getText().toString());
                    double discount = Double.parseDouble(textdiscount.getText().toString());


                    //calculate gst
                    double gst = 0.07;
                    double servicech = 0.10;

                    if(togglegst.isChecked()){
                        totalmult += gst;
                    }
                    if(togglesvs.isChecked()){
                        totalmult += servicech;
                    }

                    //calculate discount
                    discount =  (100-discount)/100;
                    System.out.println(amount);
                    System.out.println(numpeople);



                    double totalval = (amount*discount)*totalmult;

                    double perperson = totalval/numpeople;

                    String textTotalBill = String.format("Total bill: $%.2f",totalval);
                    String textEachPay = String.format("Each Pay: $%.2f",perperson);


                    int checkedRadioId = rgpaytype.getCheckedRadioButtonId();
                    if(checkedRadioId == R.id.radioButtonCash){
                        textEachPay += " in cash";
                    } else {
                        textEachPay += " via PayNow to 91234567";
                    }

                    tvtotalbill.setText(textTotalBill);
                    tveachpay.setText(textEachPay);
                }
            }
        );

    }
}
