package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.welcome.fragment.BoxFragment;
import com.example.welcome.fragment.HomeFragment;
import com.example.welcome.fragment.MessageFragment;
import com.example.welcome.fragment.VideoFragment;
import com.example.welcome.adapter.WelComeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private ViewPager actWelcomeViewpage;
    private BottomNavigationBar actWelcomeBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actWelcomeViewpage = (ViewPager) findViewById(R.id.act_welcome_viewpage);
        actWelcomeBottom = (BottomNavigationBar) findViewById(R.id.act_welcome_bottom);
        actWelcomeBottom.setTabSelectedListener(this);
        initView();
        initBottom();
    }

    private void initView() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new VideoFragment());
        fragments.add(new MessageFragment());
        fragments.add(new BoxFragment());
        WelComeAdapter welComeAdapter = new WelComeAdapter(getSupportFragmentManager(), WelComeAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments);
        actWelcomeViewpage.setAdapter(welComeAdapter);
    }

    private void initBottom() {
        actWelcomeBottom.setMode(BottomNavigationBar.MODE_FIXED);
        actWelcomeBottom.setActiveColor(R.color.red);
        actWelcomeBottom.setInActiveColor(R.color.blank);
        actWelcomeBottom.addItem(new BottomNavigationItem(R.drawable.home_24,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.video_24,"视频"))
                .addItem(new BottomNavigationItem(R.drawable.message_24,"微头条"))
                .addItem(new BottomNavigationItem(R.drawable.box_24,"我的"))
                .initialise();
    }

    @Override
    public void onTabSelected(int position) {
        actWelcomeViewpage.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
