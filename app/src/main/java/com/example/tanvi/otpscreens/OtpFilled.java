package com.example.tanvi.otpscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.poovam.pinedittextfield.LinePinField;
import com.poovam.pinedittextfield.PinField;

import org.jetbrains.annotations.NotNull;

import static com.example.tanvi.otpscreens.R.drawable.buttonshapeblue;

public class OtpFilled extends AppCompatActivity {

    Button button;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_filled);

        button = findViewById(R.id.proceedbutton);
        view = findViewById(R.id.filled_view);

        final LinePinField linePinField = findViewById(R.id.lineField);

        linePinField.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {

            @Override
            public boolean onTextComplete (@NotNull String enteredText) {
                view.setVisibility(View.VISIBLE);
                button.setBackgroundResource(R.drawable.buttonshapeblue);
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
                startActivity(new Intent(OtpFilled.this , OtpTyping.class));
                break;

            case R.id.otp_resend_code :
                startActivity(new Intent(OtpFilled.this , OtpResendCode.class));
                break;

            case R.id.otp_code_resent :
                startActivity(new Intent(OtpFilled.this , OtpResentCode.class));
                break;

            case R.id.otp_empty :
                startActivity(new Intent(OtpFilled.this , OtpEmpty.class));
                break;

            case R.id.otp_filled :
                startActivity(new Intent(OtpFilled.this , OtpFilled.class));
                break;

            case R.id.otp_incorrect_code :
                startActivity(new Intent(OtpFilled.this , OtpIncorrectCode.class));
                break;

            case R.id.razorpay :
                startActivity(new Intent(OtpFilled.this , RazorPayActivity.class));
                break;
        }

        return true;
    }
}
