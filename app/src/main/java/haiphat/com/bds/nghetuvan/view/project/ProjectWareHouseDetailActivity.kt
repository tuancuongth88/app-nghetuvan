package haiphat.com.bds.nghetuvan.view.project

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityProjectWareHouseDetailBinding
import haiphat.com.bds.nghetuvan.models.project.ProjectWarehouseResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrlFixData
import haiphat.com.bds.nghetuvan.view.BaseActivity

class ProjectWareHouseDetailActivity : BaseActivity() {

    private lateinit var dataBingProject : ActivityProjectWareHouseDetailBinding

    override fun getContentView(): View {
        dataBingProject = DataBindingUtil.inflate(layoutInflater, R.layout.activity_project_ware_house_detail, null, false)
        dataBingProject.rippleBack.setOnRippleCompleteListener { onBackPressed() }
        dataBingProject.rippleSetting.setOnRippleCompleteListener { CommonUtil.shareAppLinkViaFacebook(this,"https://developers.facebook.com") }
        return dataBingProject.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        val bundle = intent.extras
        val projectResponse = GsonUtil.fromJson(bundle.getString(IntentActionKeys.KEY_PROJECT_WARE_HOUSE), ProjectWarehouseResponse::class.java)
        dataBingProject.imCovert.fromUrlFixData(projectResponse?.url, placeHolder = R.drawable.ic_defaul_bg_my_course)
        dataBingProject.tvTitle.text = projectResponse?.name

    }
}
