package com.malingi.orbicoin.chat_activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.orbicoin.R;
import com.malingi.orbicoin.Conversation;
import com.malingi.orbicoin.adapters.ConversationAdapter;
import com.malingi.orbicoin.authentication.AddUserActivity;

import java.util.ArrayList;
import java.util.List;

public class Chat_mainActivity extends Activity {
    List<Conversation> conversationList;
    ListView listView;
    ConversationAdapter conversationAdapter;
    Context context;
    int resource;
    TextView groupChat;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_chatmain);

        groupChat = findViewById(R.id.groupChat);

        conversationList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.conversations_view);

        conversationList.add(new Conversation(R.mipmap.ic_lprofile_img, "Prestone Mwangome", "How are you doing today?"));
        conversationList.add(new Conversation(R.mipmap.ic_lprofile_img, "Feddis Mbodze", "Yeah. That;s how the deal goes."));
        conversationList.add(new Conversation(R.mipmap.ic_lprofile_img, "Sharon Luvuno", "Hio nguo inacost how much?"));
        conversationList.add(new Conversation(R.mipmap.ic_lprofile_img, "Brighton Malingi", "Am coming over for launch"));
        conversationList.add(new Conversation(R.mipmap.ic_lprofile_img, "Graceliane Macharia", "Unakuja lini kututembelea?"));
        conversationList.add(new Conversation(R.mipmap.ic_lprofile_img, "Kateline Mwaka", "Mambo aunty."));

        ConversationAdapter conversationAdapter = new ConversationAdapter(this, R.layout.conversation_holder, conversationList);

        listView.setAdapter(conversationAdapter);

        groupChat.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), AddUserActivity.class)));
    }
}
