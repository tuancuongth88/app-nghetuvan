package haiphat.com.bds.nghetuvan.view.home.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsInfoBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.home.HomeInfoViewModel
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter

class HomeInfoFragment : BaseFragment() {
    private lateinit var dataBindingFragmentNewsInfo: FragmentNewsInfoBinding
    private var homeInfoViewModel = HomeInfoViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNewsInfo = DataBindingUtil.inflate(inflater, R.layout.fragment_news_info, container, false)
        homeInfoViewModel.content?.let { dataBindingFragmentNewsInfo.htmTextInfo.setHtml(it, HtmlHttpImageGetter(dataBindingFragmentNewsInfo.htmTextInfo)) }
        return dataBindingFragmentNewsInfo.root
    }


    companion object {
        fun newInstance(content: String?, arguments: Bundle? = null): HomeInfoFragment {
            val fragment = HomeInfoFragment()
//            fragment.newsResponseViewModel.content = content
            fragment.arguments = arguments
            return fragment
        }
    }
}