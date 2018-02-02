package com.justlive.justinbuhay.barberup

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.net.Uri
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RatingBar
import com.justlive.justinbuhay.barberup.adapters.ReviewRecyclerViewAdapter
import com.justlive.justinbuhay.barberup.generalitems.Review
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BarberProfileFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BarberProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BarberProfileFragment : Fragment() {

    private var constraintLayout: ConstraintLayout? = null
    private var ratingBar: RatingBar? = null
    private var reviewsRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var mTotalView = inflater.inflate(R.layout.fragment_barber_profile, container, false)

        ratingBar = mTotalView.findViewById(R.id.ratingBar)
        var stars:LayerDrawable = ratingBar!!.progressDrawable as LayerDrawable
        stars!!.getDrawable(2).setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)

        constraintLayout = mTotalView.findViewById(R.id.barber_profile_layout)
        // Animates the layout on creation
        var anim = AnimationUtils.loadAnimation(context, R.anim.profile_animation)
        constraintLayout!!.startAnimation(anim)

        reviewsRecyclerView = mTotalView.findViewById(R.id.reviews_recyclerview)
        reviewsRecyclerView!!.setHasFixedSize(true)
        reviewsRecyclerView!!.layoutManager = LinearLayoutManager(context)

        var tempLinkedList = LinkedList<Review>()
        tempLinkedList.add(Review("Christine Manalang", "Wow His Haircut was awesome", "3 days ago"))
        tempLinkedList.add(Review("Christine Manalang", "Wow His Haircut was awesome", "3 days ago"))
        tempLinkedList.add(Review("Christine Manalang", "Wow His Haircut was awesome", "3 days ago"))
        tempLinkedList.add(Review("Christine Manalang", "Wow His Haircut was awesome", "3 days ago"))

        var mReviewAdapter = ReviewRecyclerViewAdapter(tempLinkedList)
        reviewsRecyclerView!!.adapter = mReviewAdapter

        return mTotalView

    }


}// Required empty public constructor
