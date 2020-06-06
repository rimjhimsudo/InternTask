package com.enjoy.interntask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    private final static int ID_home=1;
    private final static int ID_dashboard=2;
    private final static int ID_account=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation= findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_dashboard_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_account_box_black_24dp));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"Clicked item"+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment select_fragment=null;
                switch (item.getId()){
                    case ID_home:
                        select_fragment=new HomeFragment();
                        break;
                    case ID_dashboard:
                        select_fragment=new DashboardFragment();
                        break;
                    case ID_account:
                        select_fragment=new AccountFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,select_fragment).commit();
            }
        });



    }
}
