package cc.shinemoon.presentation.search

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cc.shinemoon.presentation.R
import cc.shinemoon.presentation.UserAdapter
import cc.shinemoon.presentation.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModels()

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val userAdapter by lazy {
        UserAdapter { user ->
            val action = SearchFragmentDirections.actionSearchFragmentToUserDetailFragment(user.login)
            findNavController().navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)

        setupRecyclerView()
        setupListeners()
        observeViewModel()

        viewModel.loadSearchQuery()
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.uiState.collect { state ->
                        handleUiState(state)
                    }
                }

                launch {
                    viewModel.searchQuery.collect { query ->
                        if (binding.etSearchQuery.text.toString() != query) {
                            binding.etSearchQuery.setText(query)
                        }
                    }
                }
            }
        }
    }

    private fun handleUiState(state: SearchUiState) {
        // Use isVisible (KTX) to reduce visibility boilerplate
        binding.progressBar.isVisible = state is SearchUiState.Loading
        binding.rvUsers.isVisible = state is SearchUiState.Success
        binding.tvError.isVisible = state is SearchUiState.Error || state is SearchUiState.Empty

        when (state) {
            is SearchUiState.Success -> userAdapter.submitList(state.users)
            is SearchUiState.Error -> binding.tvError.text = state.message
            is SearchUiState.Empty -> binding.tvError.text = getString(R.string.no_results)
            else -> Unit
        }
    }

    private fun setupListeners() {
        // Use KTX extension for cleaner TextWatcher
        binding.etSearchQuery.doAfterTextChanged { text ->
            viewModel.updateSearchQuery(text?.toString().orEmpty())
        }

        binding.btnSearch.setOnClickListener {
            val query = binding.etSearchQuery.text.toString()
            if (query.isNotBlank()) {
                viewModel.searchUsers(query)
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvUsers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}