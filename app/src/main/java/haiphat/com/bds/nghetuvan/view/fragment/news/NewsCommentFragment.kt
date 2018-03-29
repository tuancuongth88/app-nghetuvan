package haiphat.com.bds.nghetuvan.view.fragment.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentHomeBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NewsCommentFragment : BaseFragment() {
    private lateinit var dataBindingFragmentHome: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentHome = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return dataBindingFragmentHome.root
    }


    companion object {
        fun newInstance(arguments: Bundle? = null): NewsCommentFragment {
            val fragment = NewsCommentFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}