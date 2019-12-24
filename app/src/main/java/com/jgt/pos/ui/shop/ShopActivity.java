package com.jgt.pos.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jgt.pos.R;
import com.jgt.pos.ui.admin.AdminActivity;
import com.jgt.pos.ui.shop.cart.ShopCartFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class ShopActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Toolbar toolbar = findViewById(R.id.tb_activity_product);
        setSupportActionBar(toolbar);
        //TODO: fragment not changing
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_shop_grid,
                R.id.nav_shop_cart)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_shop);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(toolbar, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_shop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_shop_admin:
                //TODO: check for password first
                this.startActivity(new Intent(this, AdminActivity.class));
                break;
//            case R.id.nav_product_cart:
//                startCartFragment();
//                break;
            default:
                break;
        }
        return true;
    }

    private void startCartFragment() {
        ShopCartFragment fragment = new ShopCartFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_shop, fragment);
        transaction.commit();
    }
}