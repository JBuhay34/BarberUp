package com.justlive.justinbuhay.barberup.generalitems

/**
 * Created by jbuha on 2/1/2018.
 */
class Review{
    private var reviewerName: String? = null

    private var review: String? = null


    private var date: String? = null

    constructor(reviewerName: String, review: String, date: String){
        this.reviewerName = reviewerName
        this.review = review
        this.date = date
    }

    fun getReviewerName(): String{
        return this.reviewerName!!
    }

    fun getReview(): String{
        return this.review!!
    }
    fun getDate(): String{
        return this.date!!
    }


}