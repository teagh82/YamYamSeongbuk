package com.yamyam.yamyamseongbuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";
    ViewPager vp;
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottomNavigationView2);

        vp = (ViewPager) findViewById(R.id.main_viewPager);

        vp.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
        vp.setOffscreenPageLimit(3);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
            }

            @Override
            public void onPageSelected(int position)
            {
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
            }
        });


        //첫 화면 띄우기
        //getSupportFragmentManager().beginTransaction().add(R.id.main_viewPager, new HomeFragment()).commit();

        //case 함수를 통해 클릭 받을 때마다 화면 변경하기
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.menu_trend:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.menu_course:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.menu_my:
                        vp.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
}
