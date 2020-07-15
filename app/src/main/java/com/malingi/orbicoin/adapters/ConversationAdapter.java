package com.malingi.orbicoin.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.orbicoin.R;
import com.malingi.orbicoin.Conversation;
import com.malingi.orbicoin.chat_activities.Chat_mainActivity;

import java.util.List;

public class ConversationAdapter extends ArrayAdapter<Conversation> {
    List<Conversation> conversationList;
    Context context;
    int resource;

    public ConversationAdapter(Chat_mainActivity context, int resource, List<Conversation> conversationList) {
        super(context, resource, conversationList);
        this.context = context;
        this.resource = resource;
        this.conversationList = conversationList;
    }

    @NonNull
    @Override

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(resource, null, false);

        TextView userName = view.findViewById(R.id.name);
        TextView message = view.findViewById(R.id.message_body);
        View avatar = view.findViewById(R.id.avatar);

        Conversation conversation = conversationList.get(position);

        userName.setText(conversation.getName());
        message.setText(conversation.getMessage());
        avatar.getBackground();

    return view;
    }
}
