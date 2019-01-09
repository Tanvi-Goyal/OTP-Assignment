package com.example.tanvi.otpscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class OtpResentCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_resent_code);
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
                startActivity(new Intent(OtpResentCode.this , OtpTyping.class));
                break;

            case R.id.otp_resend_code :
                startActivity(new Intent(OtpResentCode.this , OtpResendCode.class));
                break;

            case R.id.otp_code_resent :
                startActivity(new Intent(OtpResentCode.this , OtpResentCode.class));
                break;

            case R.id.otp_empty :
                startActivity(new Intent(OtpResentCode.this , OtpEmpty.class));
                break;

            case R.id.otp_filled :
                startActivity(new Intent(OtpResentCode.this , OtpFilled.class));
                break;

            case R.id.otp_incorrect_code :
                startActivity(new Intent(OtpResentCode.this , OtpIncorrectCode.class));
                break;

            case R.id.razorpay :
                startActivity(new Intent(OtpResentCode.this , RazorPayActivity.class));
                break;
        }

        return true;
    }

}
