package haiphat.com.bds.nghetuvan.view.fragment.projectwarehouse.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentProjectInfoBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.news.DetailNewsViewModel
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ProjectInfoFragment : BaseFragment() {
    private lateinit var dataBindingFragmentNewsInfo: FragmentProjectInfoBinding
    var newsResponseViewModel = DetailNewsViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNewsInfo = DataBindingUtil.inflate(inflater, R.layout.fragment_project_info, container, false)
        newsResponseViewModel.content?.let { dataBindingFragmentNewsInfo.htmTextInfo.setHtml(it, HtmlHttpImageGetter(dataBindingFragmentNewsInfo.htmTextInfo)) }
        return dataBindingFragmentNewsInfo.root
    }


    companion object {
        fun newInstance(content: String?, arguments: Bundle? = null): ProjectInfoFragment {
            val fragment = ProjectInfoFragment()
            fragment.newsResponseViewModel.content = content
            fragment.arguments = arguments
            return fragment
        }
    }
}