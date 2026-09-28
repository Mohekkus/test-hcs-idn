package cc.shinemoon.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import cc.shinemoon.domain.model.UserDetailModel
import cc.shinemoon.presentation.R
import cc.shinemoon.presentation.databinding.FragmentUserDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    private val viewModel: UserDetailViewModel by viewModels()

    // Safer ViewBinding pattern to prevent memory leaks
    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserDetailBinding.bind(view)

        // Get arguments from SafeArgs (ensure your nav_graph has a "login" argument)
        val login = arguments?.getString("login")

        setupObservers()

        if (login != null) {
            viewModel.loadUserDetail(login)
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    handleUiState(state)
                }
            }
        }
    }

    private fun handleUiState(state: UserDetailUiState) {
        // Toggle global states
        binding.progressBar.isVisible = state is UserDetailUiState.Loading
        binding.tvError.isVisible = state is UserDetailUiState.Error

        when (state) {
            is UserDetailUiState.Success -> {
                bindUserData(state.userDetail)
            }
            is UserDetailUiState.Error -> {
                binding.tvError.text = state.message
            }
            else -> Unit
        }
    }

    private fun bindUserData(user: UserDetailModel) {
        binding.apply {
            // Basic Info
            tvLogin.text = user.login
            tvBio.text = user.bio
            tvBio.isVisible = user.bio.isNotBlank()

            // Stats
            tvPublicRepos.text = user.publicRepos.toString()
            tvFollowers.text = user.followers.toString()
            tvFollowing.text = user.following.toString()

            // Load Avatar using Glide
            Glide.with(this@UserDetailFragment)
                .load(user.avatarUrl)
                .circleCrop()
                .into(ivAvatar)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}