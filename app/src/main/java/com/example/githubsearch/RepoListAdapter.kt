package com.example.githubsearch

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RepoListAdapter (val data: List<GitHubRepos>) : RecyclerView.Adapter<RepoListAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(viewType, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        val nameTextView = holder.view.findViewById<TextView>(R.id.repo_name)
        val htmlUrlTextView = holder.view.findViewById<TextView>(R.id.repo_html_url)
        val starTextView = holder.view.findViewById<TextView>(R.id.repo_stargazers_count)
        val watcherTextView = holder.view.findViewById<TextView>(R.id.repo_watchers_count)
        val forksTextView = holder.view.findViewById<TextView>(R.id.repo_forks_count)
        val languageTextView = holder.view.findViewById<TextView>(R.id.repo_language)

        nameTextView.text = item.name
        htmlUrlTextView.text = item.html_url
        starTextView.text = "star : ${item.stargazers_count.toString()}"
        watcherTextView.text = "watcher : ${item.watchers_count.toString()}"
        forksTextView.text = "fork : ${item.forks_count.toString()}"
        languageTextView.text = "language : ${item.language}"

        // 암시적 인탠트
        holder.view.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.html_url))
            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.repo_list
    }
}