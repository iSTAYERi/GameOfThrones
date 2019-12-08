package ru.skillbranch.gameofthrones.ui.houses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.viewmodels.HousesViewModel

class HousesFragment : Fragment() {

    companion object {
        fun newInstance() = HousesFragment()
    }

    private val viewModel: HousesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.houses_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
