# Vungle's Android SDK Sample

## Getting Started
To get up and running with Vungle, you'll need to [Create an Account With Vungle](https://v.vungle.com/dashboard) and [Add an Application to the Vungle Dashboard](https://support.vungle.com/hc/en-us/articles/210468678)

Once you've created an account you can follow our [Getting Started for Andriod Guide](https://support.vungle.com/hc/en-us/articles/204222794-Get-started-with-Vungle-Android-SDK) to complete the integration. Remember to get the Vungle App ID from the Vungle dashboard.

### Requirements
* Android 3.0 (Honeycomb - API version 11) or later
* If your application is written in C/C++, you'll need to use JNI to interface with the Publisher SDK written in Java
* Java 1.7 - For Android 5.+ compatibility purposes, JDK 7 is required on the development system 

## Release Notes
### VERSION 4.1.0
* Made cache improvements
* Implemented a robust Vungle SDK audio policy
* Removed MAC address tracking
* Added wrapper-framework support for Fyber, Ironsource, Upsight, Appodeal, Aerserv, Adtoapp
* Removed the deprecated `EventListener.onVideoView()` API

### VERSION 4.0.3
* Added support for Android Nougat (Android v7.0)
* Reporting more device stats to serve better and better ads
* Upgraded to Dagger 2.7
* Added wrapper-framework values for admob, dfp, heyzap, mopub
* Integrated RxJava architecture for ad preparation

### VERSION 4.0.2
* Fixed the device ID timeout when play-services is not included
* Migrate to Dagger 2
* Cleaned up all the Proguard filters that are not required after Dagger 2 migration
* Fixed a few minor Unity bugs
* Handling SSL errors better
* Developers are warned when invalid App ID is used to initialize
* Added support for interstitial MRAID ads
* Updated `EventListener.onAdEnd()` api to include wasSuccessfulView parameter
* Deprecated `EventListener.onVideoView()` api
* Increased min Android API level to 3.0 (Honeycomb - version 11)
* Removed dependency on support-v4 library and nineoldandroids library

### VERSION 3.3.5
* Added support for Dagger 2
* Increased minimum supported Android SDK level from API 9 to API 11
* Upgraded maximum Google Play Services version to 8.3.0
* Removed dependencies on support-v4 library and nineoldandroids library
* Fixed black screen issue with Unity plugin

## License
The Vungle Android-SDK is available under a commercial license. See the LICENSE file for more info.
