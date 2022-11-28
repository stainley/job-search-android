package com.appolizer.myapplication;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.salapp.myapplication", appContext.getPackageName());
    }

    @Test
    public void startMainActivityFromHome() throws UiObjectNotFoundException {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // start from the home screen
        device.pressHome();

        // wait for launcher
        final String launcherPackage = device.getLauncherPackageName();
        Assert.assertThat(launcherPackage, IsNull.notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 5000);

        // launch the app
        Context context = ApplicationProvider.getApplicationContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.salapp.myapplication");
        // clear any previous instance
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // wait for the app appear
        device.wait(Until.hasObject(By.pkg("com.salapp.myapplication.MainActivity").depth(0)), 5000);

        UiObject signIn = device.findObject(new UiSelector().text("SIGN").className("android.widget.Button"));

        if(signIn.exists()) {
            signIn.click();
        }
    }



}