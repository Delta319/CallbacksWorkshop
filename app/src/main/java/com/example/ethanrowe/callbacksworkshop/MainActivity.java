package com.example.ethanrowe.callbacksworkshop;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CallbackFragment.CallbackClass {

    @BindView(R.id.activity_layout)
    protected ConstraintLayout layout;
    @BindView(R.id.callback_message_textview)
    protected TextView textView;
    protected CallbackFragment callbackFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.launch_fragment_button)
    protected void launchFragment() {
        callbackFragment = CallbackFragment.newInstance();
        callbackFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, callbackFragment).commit();

    }

    @Override
    public void showToast() {
        Toast.makeText(this, "The MainActivity is Toasting the Fragment.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeTextview() {

        textView.setText("Callback from Fragment Received");
    }

    @Override
    public void changeBackgroundColor() {

        layout.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void removeFragment() {

        getSupportFragmentManager().beginTransaction().remove(callbackFragment).commit();
    }
}
