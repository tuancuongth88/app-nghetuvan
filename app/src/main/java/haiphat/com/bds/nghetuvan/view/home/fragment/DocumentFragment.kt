package haiphat.com.bds.nghetuvan.view.home.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentDocumentBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class DocumentFragment : BaseFragment() {
    private lateinit var dataBindingFragmentDocument: FragmentDocumentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentDocument = DataBindingUtil.inflate(inflater, R.layout.fragment_document, container, false)
        return dataBindingFragmentDocument.root
    }


    companion object {
        fun newInstance(content: String?, arguments: Bundle? = null): DocumentFragment {
            val fragment = DocumentFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}