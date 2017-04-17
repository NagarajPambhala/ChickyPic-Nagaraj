package com.infinite.chickypic.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * ujwalv on 13-04-2017.
 */

public class Behavior_VpMainScreen<V extends ViewGroup>extends CoordinatorLayout.Behavior<V>{

    private static final String TAG = "Behavior_VpMainScreen";

    public Behavior_VpMainScreen(){
    }

    public Behavior_VpMainScreen(Context context, AttributeSet attributeSet){
        super(context,attributeSet);

    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int nestedScrollAxes) {
        super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
        Log.i(TAG, "onStartNestedScroll: ");
        return true;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        Log.i(TAG, "onNestedScroll: ");
    }
}
