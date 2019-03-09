package org.pursuit.feedbackfaircodechallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.pursuit.feedbackfaircodechallenge.recyclerview.UserViewHolder;

public class DisplayActivity extends AppCompatActivity {

    TextView emailTextView;
    TextView addressTextView;
    TextView phoneTextView;

    private String email;
    private String phone;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        emailTextView = findViewById(R.id.email_text_view);
        phoneTextView = findViewById(R.id.phone_text_view);
        addressTextView = findViewById(R.id.address_text_view);

        email = getIntent().getStringExtra(UserViewHolder.EMAIL_KEY);
        phone = getIntent().getStringExtra(UserViewHolder.PHONE_KEY);
        address = getIntent().getStringExtra(UserViewHolder.ADDRESS_KEY);

        emailTextView.setText("Email: " + email);
        phoneTextView.setText("Phone: " + phone);
        addressTextView.setText("Address: " + address);

        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                v.getContext().startActivity(intent);
            }
        });

        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                v.getContext().startActivity(intent);
            }
        });
    }
}
