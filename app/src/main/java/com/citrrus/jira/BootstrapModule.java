package com.citrrus.jira;

import android.accounts.AccountManager;
import android.content.Context;
import com.citrrus.jira.event.TimerService;
import com.citrrus.jira.authenticator.BootstrapAccountAuthenticator;
import com.citrrus.jira.authenticator.LogoutService;
import com.citrrus.jira.ui.activity.BootstrapAuthenticatorActivity;
import com.citrrus.jira.ui.activity.BootstrapTimerActivity;
import com.citrrus.jira.ui.fragment.CheckInsListFragment;
import com.citrrus.jira.ui.activity.CarouselActivity;
import com.citrrus.jira.ui.activity.NewsActivity;
import com.citrrus.jira.ui.activity.UserActivity;
import com.citrrus.jira.ui.fragment.NewsListFragment;
import com.citrrus.jira.ui.fragment.UserListFragment;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        entryPoints = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                BootstrapAccountAuthenticator.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
