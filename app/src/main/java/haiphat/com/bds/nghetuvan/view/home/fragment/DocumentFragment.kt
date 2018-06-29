package haiphat.com.bds.nghetuvan.view.home.fragment

import android.Manifest
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.home.DocumentAdapter
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.FragmentDocumentBinding
import haiphat.com.bds.nghetuvan.models.home.HomeCategoryResponse
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.DialogDownloadFile
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.home.DocumentViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class DocumentFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var dataBindingFragmentDocument: FragmentDocumentBinding
    private var documentViewModel = DocumentViewModel()
    private var name: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentDocument = DataBindingUtil.inflate(inflater, R.layout.fragment_document, container, false)
        dataBindingFragmentDocument.swipeRefreshLayout.setOnRefreshListener(this)
        onRefresh()
        return dataBindingFragmentDocument.root
    }

    private fun initAdapter(list: ArrayList<HomeCategoryResponse>) {

        list?.let {
            dataBindingFragmentDocument.tvNoData.visibility = View.GONE
        }
        var recyclerView = dataBindingFragmentDocument.rvDocument
        var adapter = DocumentAdapter(list, onClick = {
            name = it.name
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), IntentActionKeys.REQUEST_SELECT_FILE_PERMISSION)
        })
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun getItemDocument() {
        documentViewModel.getItemDocument(onSuccess = {
            initAdapter(it)
            dataBindingFragmentDocument.swipeRefreshLayout.isRefreshing = false
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            dataBindingFragmentDocument.swipeRefreshLayout.isRefreshing = false
        })
    }

    override fun onRefresh() {
        dataBindingFragmentDocument.swipeRefreshLayout.isRefreshing = true
        getItemDocument()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (CommonUtil.requestPermissionGrantResults(grantResults)) {
            when (requestCode) {
                IntentActionKeys.REQUEST_SELECT_FILE_PERMISSION -> {
                    val dialogDownload = DialogDownloadFile(activity, "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", name)
                    dialogDownload.show()
                }
            }
        }
    }

    companion object {
        fun newInstance(content: String?, arguments: Bundle? = null): DocumentFragment {
            val fragment = DocumentFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}