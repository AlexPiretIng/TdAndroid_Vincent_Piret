package com.example.td6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private Repos mRepo;
    private Context mContext;

    public RepoAdapter(Repos repo, Context context) {
        mRepo = repo;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View repoView = inflater.inflate(R.layout.activity_result, parent, false);
        return new ViewHolder(repoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Repo repo = mRepo.getItems().get(position);

        TextView repo_id = holder.repo_id;
        repo_id.setText(repo.getId());

        TextView repo_name = holder.repo_name;
        repo_name.setText(repo.getName());

        TextView repo_fullname = holder.repo_fullname;
        repo_fullname.setText(repo.getFullname());

        TextView repo_url = holder.repo_url;
        repo_url.setText(repo.getHtml_url());
    }

    @Override
    public int getItemCount() {
        if (mRepo != null){
            return mRepo.getItems().size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView repo_id;
        public TextView repo_name;
        public TextView repo_fullname;
        public TextView repo_url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            repo_id = (TextView) itemView.findViewById(R.id.id_repo);
            repo_name = (TextView)itemView.findViewById(R.id.nom_repo);
            repo_fullname = (TextView)itemView.findViewById(R.id.fullname_repo);
            repo_url = (TextView)itemView.findViewById(R.id.url_repo);
        }
    }
}
