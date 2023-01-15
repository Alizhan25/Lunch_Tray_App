
package com.example.lunchtray.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentAccompanimentMenuBinding
import com.example.lunchtray.model.OrderViewModel

class AccompanimentMenuFragment : Fragment() {

    private var _binding: FragmentAccompanimentMenuBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccompanimentMenuBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            fragment = this@AccompanimentMenuFragment
        }
    }

    fun goToNextScreen() {
        val action = AccompanimentMenuFragmentDirections.actionAccompanimentMenuFragmentToCheckoutFragment()
        this.findNavController().navigate(action)
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        val action = AccompanimentMenuFragmentDirections.actionAccompanimentMenuFragmentToStartOrderFragment()
        this.findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
