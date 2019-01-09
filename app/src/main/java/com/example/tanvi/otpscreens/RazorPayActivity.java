package com.example.tanvi.otpscreens;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class RazorPayActivity extends AppCompatActivity implements PaymentResultListener {

    EditText pay_editText , name_editext, description_editext;
    Button pay_button ;
    int payment;
    String name , description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razor_pay);

        pay_editText = findViewById(R.id.pay_edittext);
        name_editext = findViewById(R.id.name_edittext);
        description_editext = findViewById(R.id.description_edittext);
        pay_button = findViewById(R.id.pay_button);

        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startPayment();
            }
        });

    }

    private void startPayment() {

        payment = Integer.parseInt(pay_editText.getText().toString());
        name = name_editext.getText().toString();
        description = description_editext.getText().toString();

        Checkout checkout = new Checkout();
        checkout.setImage(R.mipmap.ic_launcher);

        final Activity activity = this;

        try {
            JSONObject options = new JSONObject();

            if(name!="" && payment!=0){
                options.put("name", name);
                options.put("description", description);
                options.put("currency", "INR");
                options.put("amount", payment*100);

                checkout.open(activity, options);
            }else{
                Toast.makeText(activity, "Empty Name or Payment Amount.", Toast.LENGTH_SHORT).show();
            }


        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.side_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.otp_typing :
                startActivity(new Intent(RazorPayActivity.this , OtpTyping.class));
                break;

            case R.id.otp_resend_code :
                startActivity(new Intent(RazorPayActivity.this , OtpResendCode.class));
                break;

            case R.id.otp_code_resent :
                startActivity(new Intent(RazorPayActivity.this , OtpResentCode.class));
                break;

            case R.id.otp_empty :
                startActivity(new Intent(RazorPayActivity.this , OtpEmpty.class));
                break;

            case R.id.otp_filled :
                startActivity(new Intent(RazorPayActivity.this , OtpFilled.class));
                break;

            case R.id.otp_incorrect_code :
                startActivity(new Intent(RazorPayActivity.this , OtpIncorrectCode.class));
                break;

            case R.id.razorpay :
                startActivity(new Intent(RazorPayActivity.this , RazorPayActivity.class));
                break;

        }

        return true;
    }

    @Override
    public void onPaymentSuccess(String s) {

        Toast.makeText(this, "Your payment is Successful", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(this, "Your payment failed", Toast.LENGTH_SHORT).show();

    }
}
