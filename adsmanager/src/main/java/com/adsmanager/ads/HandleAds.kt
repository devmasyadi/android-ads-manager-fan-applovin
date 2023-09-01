package com.adsmanager.ads

import android.app.Activity
import android.content.Context
import android.widget.RelativeLayout
import com.adsmanager.applovin.ApplovinDiscoveryAds
import com.adsmanager.applovin.ApplovinMaxAds
import com.adsmanager.core.CallbackAds
import com.adsmanager.core.NetworkAds
import com.adsmanager.core.SizeBanner
import com.adsmanager.core.SizeNative
import com.adsmanager.core.iadsmanager.IInitialize
import com.adsmanager.core.rewards.IRewards
import com.adsmanager.fan.FanAds

class HandleAds(
    private val fanAds: FanAds,
    private val applovinMaxAds: ApplovinMaxAds,
    private val applovinDiscoveryAds: ApplovinDiscoveryAds,
) {
    fun initialize(
        context: Context,
        appId: String?,
        iInitialize: IInitialize,
        networkAds: NetworkAds
    ) {
        when (networkAds) {
            NetworkAds.FAN -> fanAds.initialize(context, appId, iInitialize)
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.initialize(context, appId, iInitialize)
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.initialize(
                context,
                appId,
                iInitialize
            )
            else -> {}
        }
    }

    fun setTestDevices(activity: Activity, testDevices: List<String>, networkAds: NetworkAds) {
        when (networkAds) {
            NetworkAds.FAN -> fanAds.setTestDevices(activity, testDevices)
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.setTestDevices(activity, testDevices)
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.setTestDevices(
                activity,
                testDevices
            )
            else -> {}
        }
    }

    fun loadGdpr(activity: Activity, childDirected: Boolean, networkAds: NetworkAds) {
        when (networkAds) {
            NetworkAds.FAN -> fanAds.loadGdpr(activity, childDirected)
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.loadGdpr(activity, childDirected)
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.loadGdpr(activity, childDirected)
            else -> {}
        }
    }

    fun showBanner(
        activity: Activity,
        bannerView: RelativeLayout,
        sizeBanner: SizeBanner,
        networkAds: NetworkAds,
        adUnitId: String,
        callbackAds: CallbackAds?
    ) {
        if (adUnitId.isEmpty()) {
            callbackAds?.onAdFailedToLoad("AdUnit Empty")
            return
        }
        when (networkAds) {
            NetworkAds.FAN -> fanAds.showBanner(
                activity,
                bannerView,
                sizeBanner,
                adUnitId,
                callbackAds
            )
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.showBanner(
                activity,
                bannerView,
                sizeBanner,
                adUnitId,
                callbackAds
            )
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.showBanner(
                activity,
                bannerView,
                sizeBanner,
                adUnitId,
                callbackAds
            )
            else -> {
                callbackAds?.onAdFailedToLoad("Ads None")
            }
        }
    }

    fun loadInterstitial(
        activity: Activity,
        networkAds: NetworkAds,
        adUnitId: String,
    ) {
        if (adUnitId.isEmpty()) {
            return
        }
        when (networkAds) {
            NetworkAds.FAN -> fanAds.loadInterstitial(activity, adUnitId)
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.loadInterstitial(activity, adUnitId)
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.loadInterstitial(
                activity,
                adUnitId
            )
            else -> {}
        }
    }

    fun showInterstitial(
        activity: Activity,
        networkAds: NetworkAds,
        adUnitId: String,
        callbackAds: CallbackAds?
    ) {
        if (adUnitId.isEmpty()) {
            callbackAds?.onAdFailedToLoad("AdUnit Empty")
            return
        }
        when (networkAds) {
            NetworkAds.FAN -> fanAds.showInterstitial(activity, adUnitId, callbackAds)
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.showInterstitial(
                activity,
                adUnitId,
                callbackAds
            )
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.showInterstitial(
                activity,
                adUnitId,
                callbackAds
            )
            else -> {
                callbackAds?.onAdFailedToLoad("Ads None")
            }
        }
    }

    fun showNativeAds(
        activity: Activity,
        nativeView: RelativeLayout,
        sizeNative: SizeNative,
        networkAds: NetworkAds,
        adUnitId: String,
        callbackAds: CallbackAds?
    ) {
        if (adUnitId.isEmpty()) {
            callbackAds?.onAdFailedToLoad("AdUnit Empty")
            return
        }
        when (networkAds) {
            NetworkAds.FAN -> fanAds.showNativeAds(
                activity,
                nativeView,
                sizeNative,
                adUnitId,
                callbackAds
            )
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.showNativeAds(
                activity,
                nativeView,
                sizeNative,
                adUnitId,
                callbackAds
            )
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.showNativeAds(
                activity,
                nativeView,
                sizeNative,
                adUnitId,
                callbackAds
            )
            else -> {
                callbackAds?.onAdFailedToLoad("Ads None")
            }
        }
    }

    fun loadRewards(
        activity: Activity,
        networkAds: NetworkAds,
        adUnitId: String,
    ) {
        if (adUnitId.isEmpty()) {
            return
        }
        when (networkAds) {
            NetworkAds.FAN -> fanAds.loadRewards(activity, adUnitId)
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.loadRewards(activity, adUnitId)
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.loadRewards(activity, adUnitId)
            else -> {}
        }
    }

    fun showRewards(
        activity: Activity,
        networkAds: NetworkAds,
        adUnitId: String,
        callbackAds: CallbackAds?,
        iRewards: IRewards?
    ) {
        if (adUnitId.isEmpty()) {
            callbackAds?.onAdFailedToLoad("AdUnit Empty")
            return
        }
        when (networkAds) {
            NetworkAds.FAN -> fanAds.showRewards(activity, adUnitId, callbackAds, iRewards)
            NetworkAds.APPLOVIN_MAX -> applovinMaxAds.showRewards(
                activity,
                adUnitId,
                callbackAds,
                iRewards
            )
            NetworkAds.APPLOVIN_DISCOVERY -> applovinDiscoveryAds.showRewards(
                activity,
                adUnitId,
                callbackAds,
                iRewards
            )
            else -> {
                callbackAds?.onAdFailedToLoad("Ads None")
            }
        }
    }
}