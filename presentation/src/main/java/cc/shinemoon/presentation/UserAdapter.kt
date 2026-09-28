package cc.shinemoon.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cc.shinemoon.domain.model.UserModel
import cc.shinemoon.presentation.databinding.ItemUserBinding
import com.bumptech.glide.Glide

class UserAdapter(
    private val onUserClick: (UserModel) -> Unit
) : ListAdapter<UserModel, UserAdapter.UserViewHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<UserModel>() {
            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position)) {
            onUserClick(it)
        }
    }

    class UserViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserModel, callback: (UserModel) -> Unit) {
            binding.usernameText.text = user.login

            Glide.with(binding.root.context)
                .load(user.avatarUrl)
                .circleCrop()
                .into(binding.avatarImage)

            itemView.setOnClickListener { callback(user) }
        }
    }
}