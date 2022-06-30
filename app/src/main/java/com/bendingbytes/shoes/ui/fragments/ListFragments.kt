package com.bendingbytes.shoes.ui.fragments

import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.bendingbytes.shoes.domain.DataState
import com.bendingbytes.shoes.ui.ShoeAdapter
import com.bendingbytes.shoes.ui.ShoeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_list.*

@AndroidEntryPoint
class ListFragments : Fragment() {
    private lateinit var progressDialog: ProgressDialog
    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private var adapter: ShoeAdapter = ShoeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return (inflater.inflate(com.bendingbytes.shoes.R.layout.fragment_list, container, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Wait while loading")
        shoeViewModel.loadShoes()
        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(
            ContextCompat.getDrawable(
                context!!,
                com.bendingbytes.shoes.R.drawable.divider_white
            )!!
        )
        recyclerView.addItemDecoration(itemDecorator)
        shoeViewModel.shoeLiveDataState.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Loading -> {
                    progressDialog.show()
                }
                is DataState.Error -> {
                    val builder = AlertDialog.Builder(context)
                    with(builder)
                    {
                        setTitle("Android Alert")
                        setMessage("We have a message")
                        show()
                    }
                }
                is DataState.Success -> {
                    adapter.submitList(it.data)
                    progressDialog.dismiss()
                }
            }
        }
    }

    companion object {
        fun newInstance() = ListFragments()
    }
}


