package haiphat.com.bds.nghetuvan.view.fragment.projectwarehouse.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentProjectUtilitiesBinding
import haiphat.com.bds.nghetuvan.utils.RippleView
import haiphat.com.bds.nghetuvan.view.BaseFragment

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ProjectUtilitiesFragment : BaseFragment(), RippleView.OnRippleCompleteListener{


    private lateinit var dataBindingFragmentProjectUtilities: FragmentProjectUtilitiesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentProjectUtilities = DataBindingUtil.inflate(inflater, R.layout.fragment_project_utilities, container, false)
        dataBindingFragmentProjectUtilities.ripSetCalendar.setOnRippleCompleteListener(this)
        dataBindingFragmentProjectUtilities.ripCheckTableOfGoods.setOnRippleCompleteListener(this)
        dataBindingFragmentProjectUtilities.ripBankInterest.setOnRippleCompleteListener(this)
        dataBindingFragmentProjectUtilities.ripPayment.setOnRippleCompleteListener(this)

        return dataBindingFragmentProjectUtilities.root
    }


    override fun onComplete(rippleView: RippleView?) {
        when(rippleView){
            dataBindingFragmentProjectUtilities.ripSetCalendar ->{

            }
            dataBindingFragmentProjectUtilities.ripCheckTableOfGoods ->{

            }
            dataBindingFragmentProjectUtilities.ripBankInterest ->{

            }
            dataBindingFragmentProjectUtilities.ripPayment ->{

            }
        }
    }

    companion object {
        fun newInstance(name: String?, arguments: Bundle? = null): ProjectUtilitiesFragment {
            val fragment = ProjectUtilitiesFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}