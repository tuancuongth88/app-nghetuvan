package haiphat.com.bds.nghetuvan.view.home.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentDoccumentBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsInfoBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.home.HomeInfoViewModel
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class DoccumentFragment : BaseFragment() {
    private lateinit var dataBindingFragmentDoccument: FragmentDoccumentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentDoccument = DataBindingUtil.inflate(inflater, R.layout.fragment_doccument, container, false)
        return dataBindingFragmentDoccument.root
    }


    companion object {
        fun newInstance(content: String?, arguments: Bundle? = null): DoccumentFragment {
            val fragment = DoccumentFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}