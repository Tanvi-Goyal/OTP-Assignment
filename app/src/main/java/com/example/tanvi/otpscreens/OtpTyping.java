package com.example.tanvi.otpscreens;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.autofill.AutofillValue;
import android.widget.Toast;

import com.poovam.pinedittextfield.LinePinField;
import com.poovam.pinedittextfield.PinField;

import org.jetbrains.annotations.NotNull;

public class OtpTyping extends AppCompatActivity {


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_typing);


        final LinePinField linePinField = findViewById(R.id.lineField);

        linePinField.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {

            @Override
            public boolean onTextComplete (@NotNull String enteredText) {
                Toast.makeText(OtpTyping.this,enteredText,Toast.LENGTH_SHORT).show();
                return true; // Return true to keep the keyboard open else return false to close the keyboard
            }
        });
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
                startActivity(new Intent(OtpTyping.this , OtpTyping.class));
                break;

            case R.id.otp_resend_code :
                startActivity(new Intent(OtpTyping.this , OtpResendCode.class));
                break;

            case R.id.otp_code_resent :
                startActivity(new Intent(OtpTyping.this , OtpResentCode.class));
                break;

            case R.id.otp_empty :
                startActivity(new Intent(OtpTyping.this , OtpEmpty.class));
                break;

            case R.id.otp_filled :
                startActivity(new Intent(OtpTyping.this , OtpFilled.class));
                break;

            case R.id.otp_incorrect_code :
                startActivity(new Intent(OtpTyping.this , OtpIncorrectCode.class));
                break;

            case R.id.razorpay :
                startActivity(new Intent(OtpTyping.this , RazorPayActivity.class));
                break;
        }

        return true;
    }

}
