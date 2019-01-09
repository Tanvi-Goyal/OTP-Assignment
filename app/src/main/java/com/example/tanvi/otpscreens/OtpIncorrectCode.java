package com.example.tanvi.otpscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.poovam.pinedittextfield.LinePinField;
import com.poovam.pinedittextfield.PinField;

import org.jetbrains.annotations.NotNull;

public class OtpIncorrectCode extends AppCompatActivity {

    ImageView img;
    TextView text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_incorrect_code);

        img = findViewById(R.id.incorrect_icon);
        text = findViewById(R.id.incorrect_text);
        final LinePinField linePinField = findViewById(R.id.lineField);

        linePinField.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {

            @Override
            public boolean onTextComplete (@NotNull String enteredText) {

                img.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                linePinField.setFieldColor(R.color.red);
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
                startActivity(new Intent(OtpIncorrectCode.this , OtpTyping.class));
                break;

            case R.id.otp_resend_code :
                startActivity(new Intent(OtpIncorrectCode.this , OtpResendCode.class));
                break;

            case R.id.otp_code_resent :
                startActivity(new Intent(OtpIncorrectCode.this , OtpResentCode.class));
                break;

            case R.id.otp_empty :
                startActivity(new Intent(OtpIncorrectCode.this , OtpEmpty.class));
                break;

            case R.id.otp_filled :
                startActivity(new Intent(OtpIncorrectCode.this , OtpFilled.class));
                break;

            case R.id.otp_incorrect_code :
                startActivity(new Intent(OtpIncorrectCode.this , OtpIncorrectCode.class));
                break;

            case R.id.razorpay :
                startActivity(new Intent(OtpIncorrectCode.this , RazorPayActivity.class));
                break;
        }

        return true;
    }
}
