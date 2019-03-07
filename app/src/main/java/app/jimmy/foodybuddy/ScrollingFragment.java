package app.jimmy.foodybuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ScrollingFragment extends Fragment {

    private TextView textView;
    private int contentTextId;

    public static ScrollingFragment newInstance(int contentTextId) {
        Bundle args = new Bundle();
        args.putInt("stringId",contentTextId);
        ScrollingFragment fragment = new ScrollingFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_scrolling, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        readBundle(getArguments());

        textView = view.findViewById(R.id.text);
        FloatingActionButton fabLike = view.findViewById(R.id.fabLike);
        FloatingActionButton fabDisLike = view.findViewById(R.id.fabDisLike);

        fabLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Liked",Toast.LENGTH_SHORT).show();
            }
        });
        fabDisLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Disliked",Toast.LENGTH_SHORT).show();
            }
        });

        textView.setText(contentTextId);
    }


    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            contentTextId = bundle.getInt("stringId");
        }
    }
}
