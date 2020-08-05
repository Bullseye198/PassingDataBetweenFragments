package com.example.passingdatabetweenfragments.dependencyInjection

import com.example.passingdatabetweenfragments.ui.gallery.GalleryFragment
import com.example.passingdatabetweenfragments.ui.home.HomeFragment
import com.example.passingdatabetweenfragments.ui.secondfragment.SecondFragment
import com.example.passingdatabetweenfragments.ui.slideshow.SlideshowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface UIModule {

    @ContributesAndroidInjector
    fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    fun contributesGalleryFragment(): GalleryFragment

    @ContributesAndroidInjector
    fun contributesSlideshowFragment(): SlideshowFragment

    @ContributesAndroidInjector
    fun contributesSecondFragment(): SecondFragment
}