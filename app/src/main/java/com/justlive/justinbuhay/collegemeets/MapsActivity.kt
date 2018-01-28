package com.justlive.justinbuhay.collegemeets

import android.graphics.Color
import android.support.v4.app.FragmentActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : FragmentActivity(), OnMapReadyCallback, GoogleMap.OnPolylineClickListener, GoogleMap.OnPolygonClickListener {

    private var mMap: GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.style_json))

        val line = mMap!!.addPolyline(PolylineOptions()
                .add(LatLng(51.5, -0.1), LatLng(40.7, -74.0))
                .clickable(true)
                .width(5f)
                .color(Color.RED))

        // Add a marker in Sydney and move the camera
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(51.5, -40.0), 3f))

        googleMap.setOnPolylineClickListener(this)
    }

    override fun onPolygonClick(polygon: Polygon) {

    }

    override fun onPolylineClick(polyline: Polyline) {
        polyline.color = Color.BLUE
    }

    companion object {

        private val TAG = MapsActivity::class.java.simpleName
    }


}
