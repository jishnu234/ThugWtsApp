package com.example.thugwtsapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements Filterable {

    private ArrayList<User> userArrayList;
    private ArrayList<User> userArrayListCopy;
    private Context context;
    private MediaPlayer mediaPlayer;

    public MyAdapter(Context context,ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
        userArrayListCopy=new ArrayList<>(userArrayList);
        this.context=context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_list_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder holder, final int position) {


            holder.imageView.setImageResource(userArrayList.get(position).getImage());
            holder.textView.setText(userArrayList.get(position).getName());

            holder.play_button.setOnClickListener(
                    new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(mediaPlayer==null)
                    {
                        mediaPlayer=MediaPlayer.create(context,userArrayList.get(position).getMusic());
                        mediaPlayer.start();
                        holder.play_icon.setImageResource(R.drawable.pause_button);
                        mediaPlayer.setLooping(false);
                        holder.seekBar.setProgress(0);
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mediaPlayer.stop();
                                mediaPlayer.release();
                                holder.seekBar.setProgress(100);
                                mediaPlayer=null;
                                holder.play_icon.setImageResource(R.drawable.play_icon);
                            }
                        });

                    }
                    else
                    {


                        if(mediaPlayer.isPlaying())
                        {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer=null;
                            holder.play_icon.setImageResource(R.drawable.play_icon);
                        }
                        else {
                            mediaPlayer.start();
                            holder.play_icon.setImageResource(R.drawable.pause_button);
                        }

                        }
                        }


            });






    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<User> filterResults=new ArrayList<>();
            if(constraint==null|| constraint.length()==0)
            {
                filterResults.addAll(userArrayListCopy);
            }
            else
            {
                String value=constraint.toString().toLowerCase().trim();

                for(User user:userArrayListCopy)
                {
                    if(user.getName().toLowerCase().contains(value))
                    {
                        filterResults.add(user);
                    }
                }
            }

            FilterResults results=new FilterResults();
            results.values=filterResults;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            userArrayList.clear();
            userArrayList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView,play_button,share_button,play_icon;
        TextView textView;
        SeekBar seekBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.content);
            seekBar=itemView.findViewById(R.id.seekbar);
            play_button=itemView.findViewById(R.id.play_button);
            share_button=itemView.findViewById(R.id.share_button);
            play_icon=itemView.findViewById(R.id.play_button);
        }
    }
}
