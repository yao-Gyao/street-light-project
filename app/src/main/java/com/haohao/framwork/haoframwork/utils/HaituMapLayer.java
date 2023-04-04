package com.haohao.framwork.haoframwork.utils;

import android.util.Log;

import com.esri.android.map.TiledServiceLayer;
import com.esri.core.geometry.Envelope;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.RejectedExecutionException;


/**
 * 基本图层
 *
 * @author ahsoft
 */
public class HaituMapLayer extends TiledServiceLayer {

    private int minLevel = 0;

    private int maxLevel = 17;

/*    private static final double[] SCALES = {2.958293554545656E8,
            1.479146777272828E8, 7.39573388636414E7, 3.69786694318207E7,
            1.848933471591035E7, 9244667.357955175, 4622333.678977588,
            2311166.839488794, 1155583.419744397, 577791.7098721985,
            288895.85493609926, 144447.92746804963, 72223.96373402482,
            36111.98186701241, 18055.990933506204, 9027.995466753102,
            4513.997733376551, 2256.998866688275, 1127.2338602399827,
            563.6169301199914};


    private static final double[] RESOLUTIONS_2000 = {0.7031249999891485,
            0.35156249999999994, 0.17578124999999997, 0.08789062500000014,
            0.04394531250000007, 0.021972656250000007, 0.01098632812500002,
            0.00549316406250001, 0.0027465820312500017, 0.0013732910156250009,
            0.000686645507812499, 0.0003433227539062495,
            0.00017166137695312503, 0.00008583068847656251,
            0.000042915344238281406, 0.000021457672119140645,
            0.000010728836059570307, 0.000005364418029785169};*/


    private double[] scales = new double[]{591657527.591555,
            295828763.79577702, 147914381.89788899, 73957190.948944002,
            36978595.474472001, 18489297.737236001, 9244648.8686180003,
            4622324.4343090001, 2311162.217155, 1155581.108577, 577790.554289,
            288895.277144, 144447.638572, 72223.819286, 36111.909643,
            18055.954822, 9027.9774109999998, 4513.9887049999998};

    private double[] resolutions = new double[]{156543.03392800014,
            78271.516963999937, 39135.758482000092, 19567.879240999919,
            9783.9396204999593, 4891.9698102499797, 2445.9849051249898,
            1222.9924525624949, 611.49622628138, 305.748113140558,
            152.874056570411, 76.4370282850732, 38.2185141425366,
            19.1092570712683, 9.55462853563415, 4.7773142679493699,
            2.3886571339746849, 1.1943285668550503};


    private Point origin = new Point(-20037508.3428, 20037508.3428);

    //这里的原点 是指地图右下角距离屏幕边框的距离

    private int dpi = 96;

    private int tileWidth = 256;

    private int tileHeight = 256;

    private String type;

    public HaituMapLayer() {
        super("");

        this.init();
    }

    private void init() {
        try {
            getServiceExecutor().submit(new Runnable() {
                public void run() {
                    HaituMapLayer.this.initLayer();
                }
            });
        } catch (RejectedExecutionException rejectedexecutionexception) {
            Log.e("Map Layer", "initialization of the layer failed.",
                    rejectedexecutionexception);
        }
    }

    protected void initLayer() {
        this.setDefaultSpatialReference(SpatialReference.create(102113));

        this.setFullExtent(new Envelope(-20037508.3428, -20037508.3428,
                20037508.3428, 20037508.3428));
        ;


        this.setTileInfo(new TileInfo(origin, scales, resolutions,
                scales.length, dpi, tileWidth, tileHeight));


        super.initLayer();
    }

    @Override
    protected byte[] getTile(int level, int col, int row) throws Exception {
        byte[] tileImage = null;
        if (level > maxLevel || level < minLevel) {
            return new byte[0];
        }

        //海事局内网的海图图层
        //                            String path = "http://198.16.1.53:81/map/sea"
        //                                    + "/" + level
        //                                    + "/" + col
        //                                    + "/" + row
        //                                    + ".png";
        //

        //google地图
//        String path = "http://mt2.google.cn/vt/lyrs=m@180000000&hl=zh-CN&gl=cn&src=app&x="
//                + col
//                + "&y=" + row
//                + "&z=" + level
//                + "&s=Gal";
        String path = "https://server.arcgisonline.com/arcgis/rest/services/World_Imagery/MapServer/tile/"
                +level+"/"+row+"/"+col;
        //船达通的海图图层(http://www.shipdt.com)
        //此海图为16进制,例子:http://emap.shipdt.com/L08/R0000006c/C00000038.png
        //level 为
        //                String levelName = "";
        //                if (level < 2) {
        //                    levelName = "/LN" + level;
        //                } else if (level < 12) {
        //                    levelName = "/L0" + (level - 2);
        //                } else {
        //                    levelName = "/L" + (level - 2);
        //                }
        //
        //                String rowValue = String.format("%08x", row);
        //                String rowName = "/R";
        //                int rowLength = 7 - rowValue.length();
        //                if (rowLength > 0) {
        //                    for (int i = 0; i < rowLength; i++) {
        //                        rowName += 0;
        //                    }
        //                }
        //
        //                String colValue = String.format("%08x", col);
        //                String colName = "/C";
        //                int colLength = 7 - colValue.length();
        //                if (rowLength > 0) {
        //                    for (int i = 0; i < colLength; i++) {
        //                        colName += 0;
        //                    }
        //                }
        //
        //                //        String path = "http://emap.shipdt.com"
        //                String path = "http://shipdt-emap.shipdt.com/emap_36"
        //                        + levelName
        //                        + rowName + rowValue
        //                        + colName + colValue
        //                        + ".png";

        //船讯网的海图图层(http://www.shipxy.com/)
//        String path = "http://m12.shipxy.com/tile.c?l=Na&m=o"
//                + "&z=" + level
//                + "&x=" + col
//                + "&y=" + row
//                + ".png";

        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        //获取服务器返回回来的
        InputStream is = conn.getInputStream();

        tileImage = getBytes(is);


        return tileImage;
    }


    private byte[] getBytes(InputStream is) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        is.close();
        bos.flush();
        byte[] result = bos.toByteArray();

        return result;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }


    private static String intToHex(int n) {
        //StringBuffer s = new StringBuffer();
        StringBuilder sb = new StringBuilder(8);
        String a;
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (n != 0) {
            sb = sb.append(b[n % 16]);
            n = n / 16;
        }
        a = sb.reverse().toString();
        return a;
    }
}
