package com.justlive.justinbuhay.barberup.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.justlive.justinbuhay.barberup.R
import com.justlive.justinbuhay.barberup.generalitems.Review
import java.util.*

/**
 * Created by jbuha on 2/1/2018.
 */
class ReviewRecyclerViewAdapter: RecyclerView.Adapter<ReviewRecyclerViewAdapter.ViewHolder> {

    private var reviews:LinkedList<Review>? = null

    constructor(reviews: LinkedList<Review>){
        this.reviews = reviews
    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        var views = LayoutInflater.from(parent!!.context).inflate(R.layout.review_list_item, parent, false)
        var vh = ViewHolder(views)
        return vh

    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder!!.mReviewerNameTextView!!.setText(reviews!![position].getReviewerName())
        holder!!.mReviewTextView!!.setText(reviews!![position].getReview())
        holder!!.mDateTextView!!.setText(reviews!![position].getDate())

    }

    override fun getItemCount(): Int {
        return reviews!!.size
    }


    class ViewHolder: RecyclerView.ViewHolder {
        public var mReviewerNameTextView: TextView? = null
        public var mReviewTextView: TextView? = null
        public var mDateTextView: TextView? = null

        constructor(mLayoutListItem: View) : super(mLayoutListItem) {
            this.mReviewerNameTextView = mLayoutListItem.findViewById(R.id.reviewer_name_text_view)
            this.mReviewTextView = mLayoutListItem.findViewById(R.id.reviewer_review_text_view)
            this.mDateTextView = mLayoutListItem.findViewById(R.id.date_text_view)
        }

    }
}