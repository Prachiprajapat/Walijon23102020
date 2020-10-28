package com.iwtechnocrat.waljon.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.iwtechnocrat.waljon.Adapter.Ad_ShopByBrand;
import com.iwtechnocrat.waljon.Adapter.ViewPagerCustomerAdapter;
import com.iwtechnocrat.waljon.Model.Shop_by_Brand_model;
import com.iwtechnocrat.waljon.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class HommeeFragment extends Fragment {
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    Timer timer;
    int dotscount;
    double lat,lng;
    private ImageView[] dots;
    private Thread mUiThread;
    final Handler mHandler = new Handler();
    Context context;
    RecyclerView recycle_shopbybrand;
    ArrayList<Shop_by_Brand_model> shop_by_brand_models = new ArrayList<>();
    SearchView searchview;
    EditText inputSearch;



    ListView lv;

    ArrayList<String> productList = new ArrayList<>();

    public HommeeFragment(){

    }
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.hommee_frag, container, false);

        viewPager = view.findViewById(R.id.viewPager);
        sliderDotspanel = view.findViewById(R.id.SliderDots);
        recycle_shopbybrand = view.findViewById(R.id.recycle_shopbybrand);
     //   searchview = view.findViewById(R.id.searchview);

        context = getContext();



//        String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
//                "iPhone 4S", "Samsung Galaxy Note 800",
//                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};
//        productList.addAll( Arrays.asList(products));

//        final ArrayAdapter adapter =  new ListAdapter(getActivity(), R.layout.list_item, R.id.product_name, productList);
//        lv.setAdapter(adapter);


        ViewPagerCustomerAdapter viewPagerAdapter = new ViewPagerCustomerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);
        timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 3000, 4000);

//
//        inputSearch.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
//                // When user changed the Text
//               // getActivity().adapter.getFilter().filter(cs);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                          int arg3) {
//                // TODO Auto-generated method stub
//
//            }
//
//
//        });



        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        LinearLayoutManager linearLayoutManager3=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recycle_shopbybrand.setLayoutManager(linearLayoutManager3);
        shop_by_brand_models.add(new Shop_by_Brand_model("Jwellery",R.drawable.jwelleryone));
        shop_by_brand_models.add(new Shop_by_Brand_model("Lipstick",R.drawable.lipstick));
        shop_by_brand_models.add(new Shop_by_Brand_model("Sandal",R.drawable.lipstick));
        shop_by_brand_models.add(new Shop_by_Brand_model("Jwellery",R.drawable.jwelleryone));
        shop_by_brand_models.add(new Shop_by_Brand_model("Jwellery",R.drawable.jwelleryone));
       Ad_ShopByBrand ad_shopByBrand = new Ad_ShopByBrand(context, shop_by_brand_models);
        recycle_shopbybrand.setHasFixedSize(true);
        recycle_shopbybrand.setAdapter(ad_shopByBrand);



        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 4, 8, 4);

            sliderDotspanel.addView(dots[i], params);

        }


        dots[0].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return  view;
    }
    private class SliderTimer extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < dotscount - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public final void runOnUiThread(Runnable action) {
        if (Thread.currentThread() != mUiThread) {
            mHandler.post(action);
        } else {
            action.run();
        }
    }

}
