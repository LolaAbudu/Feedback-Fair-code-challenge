package org.pursuit.feedbackfaircodechallenge.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.feedbackfaircodechallenge.DisplayActivity;
import org.pursuit.feedbackfaircodechallenge.R;
import org.pursuit.feedbackfaircodechallenge.model.Address;
import org.pursuit.feedbackfaircodechallenge.model.Users;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public static final String EMAIL_KEY = "email";
    public static final String ADDRESS_KEY = "address";
    public static final String PHONE_KEY = "phone";

    private TextView nameTextView;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTextView = itemView.findViewById(R.id.name_text_view);
    }

    public void onBind(final Users users) {
        nameTextView.setText(users.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra(EMAIL_KEY, users.getEmail());
                //intent.putExtra(ADDRESS_KEY, users.getAddress().toString());
                intent.putExtra(PHONE_KEY, users.getPhone());
                v.getContext().startActivity(intent);
            }
        });
    }
}
