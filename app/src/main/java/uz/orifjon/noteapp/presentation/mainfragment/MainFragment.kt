package uz.orifjon.noteapp.presentation.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.orifjon.noteapp.R
import uz.orifjon.noteapp.databinding.FragmentMainBinding
import uz.orifjon.noteapp.presentation.mainfragment.adapters.RecyclerViewAdapter


@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainFragmentViewModel by viewModels()

    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        adapter = RecyclerViewAdapter()
        observable()
        binding.apply {
            recyclerView.adapter = adapter
            toolBar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.btnAdd -> findNavController().navigate(R.id.action_mainFragment_to_addFragment)
                }
                true
            }
        }

        setFragmentResultListener("success_create") { requestKey, bundle ->
            if (bundle.getBoolean("success_create")) {
                viewModel.getList()
            }
        }



        return binding.root
    }

    private fun observable() {
        viewModel.notes
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach {
                adapter.submitList(it)
            }.launchIn(lifecycleScope)
    }
}