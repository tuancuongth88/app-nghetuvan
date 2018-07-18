package haiphat.com.bds.nghetuvan.view.fragment.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentApartmentLocationBinding
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrlFixData
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.home.HomeInfoViewModel

class ApartmentLocationFragment : BaseFragment() {
    private lateinit var dataBindingFragmentApartmentLoaction: FragmentApartmentLocationBinding
    private val url : String = "https://file1.batdongsan.com.vn/guestthumb745x510.20140627114319717.jpg"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentApartmentLoaction = DataBindingUtil.inflate(inflater, R.layout.fragment_apartment_location, container, false)
        dataBindingFragmentApartmentLoaction.img.fromUrlFixData(url = url, placeHolder = R.drawable.ic_defaul_bg_my_course)


        return dataBindingFragmentApartmentLoaction.root
    }
}