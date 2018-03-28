package consultant.com.haiphat.consultant.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.TextView
import consultant.com.haiphat.consultant.R
import consultant.com.haiphat.consultant.adapter.NavItemProfileAdapter
import consultant.com.haiphat.consultant.databinding.ActivityHomeBinding
import consultant.com.haiphat.consultant.utils.dialog.ShowAlert
import consultant.com.haiphat.consultant.utils.extensions.hideSoftKeyboard
import consultant.com.haiphat.consultant.utils.extensions.showSoftKeyboard
import consultant.com.haiphat.consultant.view.fragment.HomeFragment
import consultant.com.haiphat.consultant.viewmodel.profiles.NavItemViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.nav_header_home.view.*

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, TextWatcher, TextView.OnEditorActionListener {

    private lateinit var bindingMain: ActivityHomeBinding
    private lateinit var navigationLayout : View
    private var navItemViewModel = NavItemViewModel()

    override fun getContentView(): View {
        bindingMain = DataBindingUtil.inflate(layoutInflater, R.layout.activity_home, null, false)
        return bindingMain.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_home_nav)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
            edSearch.hideSoftKeyboard(this@HomeActivity)
        }
        imgSearch.setOnClickListener { clickSearch() }
        imgClear.setOnClickListener { clickClear() }
        edSearch.addTextChangedListener(this)
        edSearch.setOnEditorActionListener(this)
        supportFragmentManager.beginTransaction().replace(R.id.flContent, HomeFragment.newInstance()).commitAllowingStateLoss()
        initView()
    }

    private fun initView() {
        navigationLayout = layoutInflater.inflate(R.layout.nav_header_home, null)
        val recyclerView = navigationLayout.rvNavItem
        var adapter = NavItemProfileAdapter(navItemViewModel.listNavItemProfile(this), onClick = {
            var fragment: Fragment? = null
            clActionBar.visibility = View.GONE
            imgSearch.visibility = View.GONE
            when (it.name) {
                getString(R.string.title_action_bar_home) -> {
                    fragment = HomeFragment.newInstance()
                    toolbar.title = getString(R.string.title_action_bar_home)
                }

                getString(R.string.log_out) ->{
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

    }

    private fun clickSearch() {
        imgSearch.visibility = View.GONE
        clActionBar.visibility = View.VISIBLE
        edSearch.showSoftKeyboard(this@HomeActivity)
    }

    private fun clickClear() {
        imgSearch.visibility = View.VISIBLE
        clActionBar.visibility = View.GONE
        edSearch.text.clear()
        edSearch.hideSoftKeyboard(this@HomeActivity)
    }

    fun showDialogLogOut() {
        ShowAlert.confirm(this@HomeActivity, message = getString(R.string.profile_logout_confirm), onClick = {

        })
    }

    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
        //TODO call api search course
        val currentFragment = getCurrentFragment()
        if (currentFragment != null && currentFragment?.isAdded && currentFragment?.isVisible && currentFragment is BaseFragment) {
            (currentFragment as BaseFragment).onSearchClick(edSearch.text.toString())
        }
        edSearch.hideSoftKeyboard(this@HomeActivity)
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
