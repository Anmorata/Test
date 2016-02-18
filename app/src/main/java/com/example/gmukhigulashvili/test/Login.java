package com.example.gmukhigulashvili.test;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        OnButtonClickListner();



        Button loginFB = (Button) findViewById(R.id.login_facebook);
        Button loginGoogle = (Button) findViewById(R.id.login_google);
        Button loginSkip = (Button) findViewById(R.id.skip_button);
        TextView WelcomeText = (TextView) findViewById(R.id.login_l1);
        TextView WelcomeText_2 = (TextView) findViewById(R.id.login_l2);
        TextView SignUp = (TextView) findViewById(R.id.login_signup);
        TextView Or = (TextView) findViewById(R.id.login_or);


        Typeface Roboto_Light = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");


        //  Set fonts

        loginFB.setTypeface(Roboto_Light);
        loginGoogle.setTypeface(Roboto_Light);
        loginSkip.setTypeface(Roboto_Light);
        WelcomeText.setTypeface(Roboto_Light);
        WelcomeText_2.setTypeface(Roboto_Light);
        SignUp.setTypeface(Roboto_Light);
        Or.setTypeface(Roboto_Light);


        // Font End \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    }
    private static Button button_skip;

    public void OnButtonClickListner (){
        button_skip = (Button) findViewById(R.id.skip_button);
        button_skip.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        startActivity(intent);

                    }
                }
        );
    }



}