package com.comp304.ass5

import android.content.Intent
import android.location.Address
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.comp304.ass5.food.Restaurant
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var address: Address? = null
    private lateinit var restaurant: Restaurant

    private val url: String
        get() = "https://www.google.com/maps/search/?api=1&query=${Uri.encode(restaurant.address)}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val bundle = this.intent.extras
        //get address
        this.address = bundle!!.get("address") as Address
        restaurant = bundle.get("restaurant") as Restaurant
        restaurantNameTxt.text = restaurant.name
        restaurantLocationTxt.text = restaurant.address
        restaurantDescriptionTxt.text = restaurant.details
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
        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(43.64, -79.38)
        val restaurant = LatLng(this.address!!.latitude, this.address!!.longitude)

        mMap.addMarker(MarkerOptions().position(restaurant).title(this.restaurant.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant))
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                        LatLng(this.address!!.latitude, this.address!!.longitude),
                        17.0f
                )
        )
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
    }

    fun onMapTypeSwitch(view: View?) {
        if (!this::mMap.isInitialized) return
        mMap.mapType = when (mMap.mapType) {
            GoogleMap.MAP_TYPE_SATELLITE -> GoogleMap.MAP_TYPE_NORMAL
            GoogleMap.MAP_TYPE_NORMAL -> GoogleMap.MAP_TYPE_SATELLITE
            else -> GoogleMap.MAP_TYPE_NORMAL
        }
    }

    fun onRestaurantLinkClick(view: View?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}
