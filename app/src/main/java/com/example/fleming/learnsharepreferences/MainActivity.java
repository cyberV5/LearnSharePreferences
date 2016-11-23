package com.example.fleming.learnsharepreferences;

import android.support.v4.app.Fragment;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new SharePfsFragment();
    }

    @Override
    protected void onActivityCreate() {
        setContentView(R.layout.activity_base);
    }

}
