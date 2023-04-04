package com.haohao.framwork.haoframwork.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.event.OnPanListener;
import com.esri.android.map.event.OnSingleTapListener;
import com.esri.android.map.event.OnZoomListener;
import com.esri.android.runtime.ArcGISRuntime;
import com.esri.core.geometry.Point;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;
import com.haohao.framwork.haoframwork.utils.HaituMapLayer;

public class MapActivity extends BaseActivity implements SensorEventListener {

    private MapView mapView;
    private SensorManager mSensorManager;
    private double lastX;
    private int mCurrentDirection;
    //原点
    private Point originPoint = new Point(1.3518083477676086E7, 3414110.948134567);
    private GraphicsLayer graphicsLayer;
    /**
     * 本人定位,绘制的id
     */
    private int mLocationId;
    /**
     * 本人定位的经纬度
     */
    private double mLocationLatitude;
    private double mLocationLongitude;
    private Drawable drawableYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initView();
    }

    private void initView() {
        setStatusBar(false);
        mapView = (MapView) findViewById(R.id.mapView);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);//获取传感器管理服务
        drawableYellow = zoomDrawable(getResources().getDrawable(R.mipmap.ic_map_mark), 150, 150);
        initMapView();
//        initMyLocation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //为系统的方向传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_UI);
//        initBaiduLocation();
    }


    @Override
    protected void onStop() {
        super.onStop();
        //取消注册传感器监听
        mSensorManager.unregisterListener(this);
//        if (mLocationClient != null && mLocationClient.isStarted()) {
//            mLocationClient.stop();
//        }
//        if (mDisposable != null && !mDisposable.isDisposed()) {
//            mDisposable.dispose();
//        }
    }

    /**
     * 绘制海图
     */
    private void initMapView() {
        //去水印
        ArcGISRuntime.setClientId("Rj4Xn8knM2HXUEht");
        //去除背景网格
        HaituMapLayer haituMapLayer = new HaituMapLayer();
        mapView.addLayer(haituMapLayer);
        //设置最大放大尺寸
        mapView.setMaxScale(3332.6894049149);
        //设置最小放大尺寸
        // mapView.setMinScale(5.805307550495123E7);
        mapView.setMinScale(2.113120367020388E7);
        //        zoomControlView.setMapView(mapView);
        //默认定位在宁波海事处
        mapView.centerAt(originPoint, false);
        // 船舶图层
        graphicsLayer = new GraphicsLayer();
        mapView.addLayer(graphicsLayer);
        //比例缩放监听
        mapView.setOnZoomListener(new OnZoomListener() {
            @Override
            public void preAction(float v, float v1, double v2) {

            }

            @Override
            public void postAction(float v, float v1, double v2) {
            }
        });


        // 地图操作事件
        // 平移
        mapView.setOnPanListener(new OnPanListener() {
            @Override
            public void postPointerMove(float fromx, float fromy, float tox, float toy) {

            }

            @Override
            public void postPointerUp(float fromx, float fromy, float tox, float toy) {
            }

            @Override
            public void prePointerMove(float fromx, float fromy, float tox, float toy) {
            }

            @Override
            public void prePointerUp(float fromx, float fromy, float tox, float toy) {

            }
        });


        //点击事件,点击获取要素
        mapView.setOnSingleTapListener(new OnSingleTapListener() {
            @Override
            public void onSingleTap(float v, float v1) {
            }
        });
    }

    /**
     * 绘制本人位置
     */
//    private void initMyLocation() {
//        double[] doubles = GpsTransform.gcj02_To_Gps84(mLocationLatitude, mLocationLongitude);
//        double lon;
//        double lat;
//        if (doubles.length == 2) {
//            lon = doubles[1];
//            lat = doubles[0];
//        } else {
//            lon = mLocationLongitude;
//            lat = mLocationLatitude;
//        }
//        //转gis坐标
//        Point point = new Point(lon, lat- ConstantId.LAT_OFFSet);
//        Point gisPoint = (Point) GeometryEngine.project(point, SpatialReference.create(4326), SpatialReference.create(102113));
//
//        CompositeSymbol shipSymbol = new CompositeSymbol();
//        //图片
//        PictureMarkerSymbol markerSymbol = new PictureMarkerSymbol(drawableYellow);
//        //        PictureMarkerSymbol markerSymbol = new PictureMarkerSymbol(getDrawable(R.drawable.ic_map_mark));
//        //船首向
//        markerSymbol.setAngle(mCurrentDirection);
//        shipSymbol.add(markerSymbol);
//        //属性的map
//        Map<String, Object> attributes = new HashMap<>();
//        Graphic graphic = new Graphic(gisPoint, shipSymbol, attributes);
//
//        if (mLocationId == 0) {
//            mLocationId = graphicsLayer.addGraphic(graphic);
//        } else {
//            //更新标志物
//            graphicsLayer.updateGraphic(mLocationId, graphic);
//        }
//    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        double x = sensorEvent.values[SensorManager.DATA_X];
        if (Math.abs(x - lastX) > 1.0) {
            mCurrentDirection = (int) x;
        }
        lastX = x;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    //缩放drawable
    private Drawable zoomDrawable(Drawable drawable, int w, int h) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap oldbmp = drawableToBitmap(drawable);
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) w / width);
        float scaleHeight = ((float) h / height);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height,
                matrix, true);
        return new BitmapDrawable(null, newbmp);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }
}