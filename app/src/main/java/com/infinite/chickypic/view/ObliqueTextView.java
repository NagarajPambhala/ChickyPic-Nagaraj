package com.infinite.chickypic.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.infinite.chickypic.R;

/**
 * ujwalv on 24-05-2017.
 */

public class ObliqueTextView extends android.support.v7.widget.AppCompatTextView {
    private int dividerColor;
    private Paint paint;

    public ObliqueTextView(Context context)
    {
        super(context);
        init(context);
    }

    public ObliqueTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    public ObliqueTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context)
    {
        Resources resources = context.getResources();
        //replace with your color
        dividerColor = resources.getColor(R.color.grey_text);

        paint = new Paint();
        paint.setColor(dividerColor);
        //replace with your desired width
        paint.setStrokeWidth(resources.getDimension(R.dimen.vertical_divider_width));
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawLine(0, 0, getWidth(), getHeight(), paint);
    }
}
