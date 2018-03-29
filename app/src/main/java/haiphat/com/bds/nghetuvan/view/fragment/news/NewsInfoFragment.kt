package haiphat.com.bds.nghetuvan.view.fragment.news

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.HomeAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentHomeBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsInfoBinding
import haiphat.com.bds.nghetuvan.models.HomePageCategoryType
import haiphat.com.bds.nghetuvan.models.HomePageResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.news.NewsActivity
import haiphat.com.bds.nghetuvan.view.partner.PartnerActivity
import haiphat.com.bds.nghetuvan.viewmodel.HomePageViewModel

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