package haiphat.com.bds.nghetuvan.view.fragment.news.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsInfoBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NewsInfoFragment : BaseFragment() {
    private lateinit var dataBindingFragmentNewsInfo: FragmentNewsInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNewsInfo = DataBindingUtil.inflate(inflater, R.layout.fragment_news_info, container, false)
        return dataBindingFragmentNewsInfo.root
    }


    companion object {
        fun newInstance(arguments: Bundle? = null): NewsInfoFragment {
            val fragment = NewsInfoFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}