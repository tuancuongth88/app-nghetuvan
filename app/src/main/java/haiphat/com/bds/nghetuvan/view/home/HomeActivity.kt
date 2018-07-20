package haiphat.com.bds.nghetuvan.view.home

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.TextView
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.NavItemProfileAdapter
import haiphat.com.bds.nghetuvan.databinding.ActivityHomeBinding
import haiphat.com.bds.nghetuvan.models.auth.UserResponse
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.fragment.HomeFragment
import haiphat.com.bds.nghetuvan.view.fragment.education.EducationFragment
import haiphat.com.bds.nghetuvan.view.fragment.news.BaseNewsFragment
import haiphat.com.bds.nghetuvan.view.fragment.online.OnlineSalesFragment
import haiphat.com.bds.nghetuvan.view.fragment.partner.BasePartnerFragment
import haiphat.com.bds.nghetuvan.view.fragment.profile.ProfileFragment
import haiphat.com.bds.nghetuvan.view.fragment.projectwarehouse.ProjectWarehouseFragment
import haiphat.com.bds.nghetuvan.view.profile.ContactEmailActivity
import haiphat.com.bds.nghetuvan.viewmodel.profiles.NavItemViewModel
import haiphat.com.bds.nghetuvan.viewmodel.profiles.ProfileViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.nav_header_home.view.*

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, TextWatcher, TextView.OnEditorActionListener {

    private lateinit var bindingMain: ActivityHomeBinding
    private lateinit var navigationLayout: View
    private var navItemViewModel = NavItemViewModel()

    override fun getContentView(): View {
        bindingMain = DataBindingUtil.inflate(layoutInflater, R.layout.activity_home, null, false)
        return bindingMain.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_menu)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
            getProfile()
        }
        imgSearch.setOnClickListener { clickSearch() }
        supportFragmentManager.beginTransaction().replace(R.id.flContent, HomeFragment()).commitAllowingStateLoss()
        initView()
    }

    private fun initView() {
        navigationLayout = layoutInflater.inflate(R.layout.nav_header_home, null)
        val recyclerView = navigationLayout.rvNavItem
        UserServices.userInfo?.let {
            updateUINavigation(it)
        }
        navigationLayout.clUser.setOnClickListener {
            val fragmentProfile = ProfileFragment()
            supportFragmentManager.beginTransaction().replace(R.id.flContent, fragmentProfile).commitAllowingStateLoss()
            toolbar.title = ""
            imgSearch.visibility = View.GONE
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        val adapter = NavItemProfileAdapter(navItemViewModel.listNavItemProfile(this), onClick = {
            var fragment: Fragment? = null
            when (it.name) {
                getString(R.string.title_action_bar_home) -> {
                    fragment = HomeFragment()
                    toolbar.title = getString(R.string.title_action_bar_home)
                }
                getString(R.string.title_action_bar_duan) ->{
                    fragment = ProjectWarehouseFragment()
                    toolbar.title = ""
                }
                getString(R.string.title_action_bar_bh_online) ->{
                    fragment = OnlineSalesFragment()
                    toolbar.title = getString(R.string.title_action_bar_bh_online)
                }
                getString(R.string.title_action_bar_daotao) ->{
                    fragment = EducationFragment()
                    toolbar.title = getString(R.string.title_action_bar_daotao)
                }
                getString(R.string.title_action_bar_partner) -> {
                    fragment = BasePartnerFragment()
                    toolbar.title = getString(R.string.title_action_bar_partner)
                }
                getString(R.string.title_action_bar_news) -> {
                    fragment = BaseNewsFragment()
                    toolbar.title = getString(R.string.title_action_bar_news)
                }
                getString(R.string.title_action_bar_contact) -> {
                    startActivity(Intent(this@HomeActivity, ContactEmailActivity::class.java))
                }
                getString(R.string.log_out) -> {
                    showDialogLogOut()
                }
            }
            fragment?.let {
                supportFragmentManager.beginTransaction().replace(R.id.flContent, fragment).commitAllowingStateLoss()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
        })
        val linearLayoutManager = LinearLayoutManager(this@HomeActivity)
        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = adapter
        val dm = resources.displayMetrics
        this.bindingMain.navView.addView(navigationLayout, dm.widthPixels * (3 / 2), ViewGroup.LayoutParams.MATCH_PARENT)
        toolbar.setTitleTextColor(ContextCompat.getColor(applicationContext, R.color.colorWhite))
    }

    private fun getProfile(){
        ProfileViewModel().getProfile(onSuccess = {
            updateUINavigation(it)
        }, onFailed = {})
    }

    private fun updateUINavigation(userResponse: UserResponse?) {
        navigationLayout.rivAvatar.fromUrl(userResponse?.avatar, placeHolder = R.drawable.ic_defaut_avatar)
        navigationLayout.tvName.text = userResponse?.fullname
        navigationLayout.tvEmail.text = userResponse?.email
    }

    private fun clickSearch() {

    }

    fun showDialogLogOut() {
        ShowAlert.confirm(this@HomeActivity, message = getString(R.string.profile_logout_confirm), onClick = {
            UserServices.logout()
        })
    }

    fun setBackgroundColor(color: Int) {
        toolbar.setBackgroundColor(color)
    }

    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
        //TODO call api search course
        val currentFragment = getCurrentFragment()
        if (currentFragment != null && currentFragment.isAdded && currentFragment.isVisible && currentFragment is BaseFragment) {
//            (currentFragment as BaseFragment).onSearchClick(edSearch.text.toString())
        }
        return true
    }

    override fun getCurrentFragment(): BaseFragment? {
        return supportFragmentManager.findFragmentById(flContent.id) as? BaseFragment
    }


    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
