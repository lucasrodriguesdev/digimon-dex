package br.com.lucas.digidex

import android.app.Application
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.lucas.digidex.ui.DigimonList
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var navController: TestNavHostController
    private lateinit var digimonList: FragmentScenario<DigimonList>

    @Before
    fun setup() {
        navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        digimonList = launchFragmentInContainer(themeResId = R.style.Theme_DigiDex)

        digimonList.onFragment { fragment ->
            navController.setGraph(R.navigation.navgraph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
    }

    @Test
    fun navigate_to_details_nav_component() {

        onView(withId(R.id.recyclerview_digimon_list))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click())
            )

        assertEquals(navController.currentDestination?.id, R.id.digimonDetail)
    }

    companion object{

        @BeforeClass
        @JvmStatic
        fun setupClass(){
            print("setup class")
        }

        @BeforeClass
        @JvmStatic
        fun tearDownClass(){
            print("down class")
        }
    }
}