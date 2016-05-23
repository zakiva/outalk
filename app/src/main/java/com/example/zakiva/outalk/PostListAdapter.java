package com.example.zakiva.outalk;

/**
 * Created by zakiva on 5/12/16.
 */
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.firebase.client.Query;

public class PostListAdapter extends FirebaseListAdapter<Post> {

    // The mUsername for this client. We use this to indicate which messages originated from this user
    private String mUsername;

    public PostListAdapter(Query ref, Activity activity, int layout, String mUsername) {
        super(ref, Post.class, layout, activity);
        this.mUsername = mUsername;
    }

    /**
     * Bind an instance of the <code>Post</code> class to our view. This method is called by <code>FirebaseListAdapter</code>
     * when there is a data change, and we are given an instance of a View that corresponds to the layout that we passed
     * to the constructor, as well as a single <code>Post</code> instance that represents the current data to bind.
     *
     * @param view A view instance corresponding to the layout we passed to the constructor.
     * @param post An instance representing the current state of a chat message
     */
    @Override
    protected void populateView(View view, Post post) {
        // Map a post object to an entry in our listview
        String author = post.getAuthor();
        TextView authorText = (TextView) view.findViewById(R.id.author);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.relativePost);
        authorText.setText(author);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        // If the message was sent by this user, color it differently
        if (author != null && author.equals(mUsername)) {
            authorText.setVisibility(View.GONE);
            relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            params.setMargins(40, 3, 0, 3);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            relativeLayout.setLayoutParams(params);
            //  authorText.setTextColor(Color.RED);
            //   linearLayout.setGravity(Gravity.RIGHT); // no
        } else {
            authorText.setVisibility(View.VISIBLE);
            relativeLayout.setBackgroundColor(Color.parseColor("#9a48f84b"));
            params.setMargins(0, 3, 40, 3);
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            relativeLayout.setLayoutParams(params);
           // authorText.setTextColor(Color.BLUE);
        }
        ((TextView) view.findViewById(R.id.message)).setText(" " + post.getMessage() + "   ");
    }
}