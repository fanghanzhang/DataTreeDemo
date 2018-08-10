package com.ironghui.datatree.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import com.ironghui.datatree.R;

public class PersonView extends AppCompatTextView {
    public PersonView(Context context) {
        super(context);
    }

    private Paint mPaint;
    private RectF oval;
    private Picture mPicture;

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.personattr);
        String name = tArray.getString(R.styleable.personattr_name);
        int age = tArray.getInt(R.styleable.personattr_age, 15);
        Boolean adult = tArray.getBoolean(R.styleable.personattr_adult, false);
        String str_adult = getAdultStatus(adult);
        String sex = tArray.getString(R.styleable.personattr_sex);
        int weight = tArray.getInt(R.styleable.personattr_weight, 1);// 默认是中等身材，属性为:1
        String str_weight = getWeightStatus(weight);//获得肥胖属性
        float textSize = tArray.getResources().getDimension(R.dimen.text_size);// 如果你设置为DP等单位，会做像素转换
        tArray.recycle();//回收资源
        setTextSize(textSize);//设置字体大小
        setText("姓名：" + name + "\n" + "年龄：" + age + "\n" + "性别:" + sex + "\n" + "是否成年：" + str_adult
                + "\n" + "体形：" + str_weight);//给自定义的控件赋值

    }

    /**
     * 根据传入的值判断肥胖状态
     */
    public String getWeightStatus(int weight) {
        String str_weight = "中等";
        switch (weight) {
            case 0:
                str_weight = "瘦";
                break;
            case 1:
                str_weight = "中等";
                break;
            case 2:
                str_weight = "肥胖";
                break;
            default:
                break;
        }
        return str_weight;
    }

    public String getAdultStatus(Boolean adult) {
        String str_adult = "未成年";
        if (adult) {
            str_adult = "成年";
        }
        return str_adult;
    }

    public PersonView(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("onDraw:", "onDraw");
        int mWidth = getWidth();
        int mHeight = getHeight();
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rect = new RectF(0, 0, 200, 400);   // 矩形区域
        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, mPaint);
        canvas.drawCircle(25,10,100,mPaint);
        canvas.skew(1, 0);                       // 水平错切 <- 45度
        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, mPaint);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        oval = new RectF();
        // 1.创建Picture
        mPicture = new Picture();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("onMeasure:", "onMeasure");
        int widthMode = MeasureSpec.getMode(300);
        int widthSize = MeasureSpec.getSize(300);
        int heightMode = MeasureSpec.getMode(300);
        int heightSize = MeasureSpec.getSize(300);
        Log.e("tag", "onMeasure--widthMode-->" + widthMode);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:

                break;
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.UNSPECIFIED:

                break;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d("onMeasure:", "onMeasure");
    }
}
