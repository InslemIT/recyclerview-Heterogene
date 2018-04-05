package inslem.it.recyclerviewheterogene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMessagesView;
    private AdapteurHeterogene adapteurHeterogene;
    private List<Object> mMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donneesTest();
        mMessagesView = findViewById(R.id.messages);
        mMessagesView.setLayoutManager(new LinearLayoutManager(this));
        adapteurHeterogene = new AdapteurHeterogene(this, mMessages);
        mMessagesView.setAdapter(adapteurHeterogene);
    }

    private void donneesTest()
    {
        mMessages.add(new Message("Bonjour"));
        mMessages.add(new Image( getResources().getDrawable(R.drawable.ic_android_black_24dp)));
        mMessages.add(new Message("bonne continuation"));
        mMessages.add(new Image( getResources().getDrawable(R.drawable.ic_android_black_24dp)));
        mMessages.add(new Message("à la prochaine vidéo"));
        mMessages.add(new Image( getResources().getDrawable(R.drawable.ic_android_black_24dp)));


    }
}
