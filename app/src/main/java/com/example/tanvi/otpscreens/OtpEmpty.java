package com.example.tanvi.otpscreens;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.TextView;
import android.widget.Toast;

public class OtpEmpty extends AppCompatActivity {

    TextView counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_empty);

        counter = findViewById(R.id.counter);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText( millisUntilFinished / 1000 + " seconds ");
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                Toast.makeText(OtpEmpty.this, "Time to resend code", Toast.LENGTH_SHORT).show();
            }

        }.start();
    }


    @Override
    public void onBackPressed() {
        finish();
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
                startActivity(new Intent(OtpEmpty.this , OtpTyping.class));
                break;

            case R.id.otp_resend_code :
                startActivity(new Intent(OtpEmpty.this , OtpResendCode.class));
                break;

            case R.id.otp_code_resent :
                startActivity(new Intent(OtpEmpty.this , OtpResentCode.class));
                break;

            case R.id.otp_empty :
                startActivity(new Intent(OtpEmpty.this , OtpEmpty.class));
                break;

            case R.id.otp_filled :
                startActivity(new Intent(OtpEmpty.this , OtpFilled.class));
                break;

            case R.id.otp_incorrect_code :
                startActivity(new Intent(OtpEmpty.this , OtpIncorrectCode.class));
                break;

            case R.id.razorpay :
                startActivity(new Intent(OtpEmpty.this , RazorPayActivity.class));
                break;

        }

        return true;
    }
}
