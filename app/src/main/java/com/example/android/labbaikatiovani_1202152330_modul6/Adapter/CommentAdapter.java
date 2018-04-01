package com.example.android.labbaikatiovani_1202152330_modul6.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.labbaikatiovani_1202152330_modul6.R;

import org.w3c.dom.Comment;

import java.util.ArrayList;

/**
 * Created by Labbaika Putri on 4/1/2018.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    Context context;
    ArrayList<Comment> comments;

    public CommentAdapter(Context context, ArrayList<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }
    //untuk menampilkan data ke layout comment
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment_post, parent, false);
        return new ViewHolder(view);
    }
    //ambil data user yang comment
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Comment comment = comments.get(position);

        //username yang mengomentari
        /*holder.mUsername.setText(comment.getUsername());
        //komentar yang diisi
        holder.mComment.setText(comment.getComment());
        //ambil ava
        holder.ava.setImageResource(R.drawable.ic_account_circle_24dp);*/
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        //variable
        TextView mUsername;
        TextView mComment;
        ImageView ava;

        public ViewHolder(View itemView) {
            super(itemView);
            //bind data
            mUsername = itemView.findViewById(R.id.tv_username);
            mComment = itemView.findViewById(R.id.tv_comment);
            ava = itemView.findViewById(R.id.img_ava);
        }
    }
}
