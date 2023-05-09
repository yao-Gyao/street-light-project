package com.haohao.framwork.haoframwork.utils;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.haohao.framwork.haoframwork.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author hao
 * @date 2017/8/30
 * @description 人群画像-会员数据折线图
 */

public class HaoChartStyleOne {
    /**
     * 绘制线图，默认最多绘制三种颜色。所有线均依赖左侧y轴显示。
     *
     * @param context
     * @param lineChart
     * @param xAxisValue   x轴的轴
     * @param yXAxisValues y轴的值
     * @param lineColors   线的颜色数组。为null时取默认颜色，此时最多绘制三种颜色。
     * @param isLine       是否是直线(true 直线; false 曲线)
     */
    static int gray = 0xFF333333;

    public static void setLinesChart(Context context, LineChart lineChart, final List<String> xAxisValue, List<List<Float>> yXAxisValues, int[] lineColors, boolean isLine) {
        lineChart.setDrawBorders(false); //在折线图上添加边框
        lineChart.setDrawGridBackground(true); //表格颜色

        lineChart.setGridBackgroundColor(Color.TRANSPARENT); //表格的颜色，设置一个透明度
        lineChart.setTouchEnabled(true); //可点击
        lineChart.setDragEnabled(true);  //可拖拽
        lineChart.setScaleEnabled(false);  //可缩放
        lineChart.setPinchZoom(true);
        lineChart.setData(generateLineData(context, yXAxisValues, lineColors, isLine));  //填充数据
        lineChart.setVisibleXRange(1, 10);   //x轴可显示的坐标范围
        lineChart.setNoDataText("");//设置无数据文字
        lineChart.setDescription(null);
        //
        LineChartMarkVeiw markVeiw = new LineChartMarkVeiw(context, R.layout.custom_marker_view);
        markVeiw.setChartView(lineChart);
        lineChart.setMarker(markVeiw);

        //x坐标轴设置
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(false);//设置标签居中
        xAxis.setLabelCount(xAxisValue.size());
        //        xAxis.setTextSize(10);
        xAxis.setAxisLineColor(gray);
        xAxis.setGridColor(gray);
        //设置x轴值距离边界0.5倍间距
        xAxis.setSpaceMin(0.5f);
        xAxis.setSpaceMax(0.5f);
        xAxis.setGridLineWidth(1);
        xAxis.setAxisLineWidth(1);
        xAxis.setTextColor(context.getResources().getColor(R.color.gray_light_ff));
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, AxisBase axisBase) {
                int position = (int) v;
                if (position < xAxisValue.size() && position >= 0) {
                    return xAxisValue.get(position);
                }
                return "" + v;
            }
        });
        //设置y轴数据偏移量(x轴显示文字距离x轴的距离)
        //        xAxis.setYOffset(10);
        xAxis.setAvoidFirstLastClipping(true);


        if (yXAxisValues.size() == 1 || yXAxisValues.size() == 3) {
            YAxis leftAxis = lineChart.getAxisLeft();
            leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            //显示网格线
            leftAxis.setDrawGridLines(true);
            //不显示坐标线
            leftAxis.setDrawAxisLine(false);
            //把轴的标签放在原来的位置，而不是把它们画在原来的位置(true 不根据y轴值自适应值,而是把y轴长度占满,把能显示的值都放上边)
            //                        leftAxis.setCenterAxisLabels(true);
            //            leftAxis.setSpaceMin(0.5f);
            //            leftAxis.setSpaceMax(0.5f);
            leftAxis.setLabelCount(5, true); //显示格数
            //            leftAxis.setMinWidth(3f);
            leftAxis.setAxisLineColor(context.getResources().getColor(R.color.gray_dark_ff));
            leftAxis.setTextColor(context.getResources().getColor(R.color.gray_light_ff));
            leftAxis.setGridColor(gray);
            leftAxis.setAxisMinimum(0);
            leftAxis.setTextSize(10);
            leftAxis.setValueFormatter(new YFormatter());
            leftAxis.setGridLineWidth(1);


            YAxis rightAxis = lineChart.getAxisRight();
            rightAxis.setDrawAxisLine(false);
            rightAxis.setDrawGridLines(false);
            rightAxis.setDrawLabels(false);
        } else if (yXAxisValues.size() == 2) {
            YAxis leftAxis = lineChart.getAxisLeft();
            leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            leftAxis.setDrawGridLines(false);
            leftAxis.setCenterAxisLabels(true);
            leftAxis.setLabelCount(6, true); //显示格数
            leftAxis.setMinWidth(3f);
            leftAxis.setAxisLineColor(context.getResources().getColor(R.color.gray_light_ff));
            leftAxis.setTextColor(context.getResources().getColor(R.color.gray_light_ff));
            leftAxis.setAxisMinimum(0);
            leftAxis.setGridLineWidth(1);
            //y轴设置
            YAxis rightAxis = lineChart.getAxisRight();
            rightAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            rightAxis.setDrawAxisLine(true);
            rightAxis.setDrawLabels(true);
            rightAxis.setDrawGridLines(false);
            rightAxis.setAxisMinimum(0);
            rightAxis.setLabelCount(6, true); //显示格数
            rightAxis.setTextColor(context.getResources().getColor(R.color.gray_light_ff));
            rightAxis.setAxisLineColor(context.getResources().getColor(R.color.gray_light_ff));
        }

        //图例设置
        Legend legend = lineChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setEnabled(false);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setTextSize(12f);

        lineChart.animateX(500);//数据显示动画，从左往右依次显示

        lineChart.getAxisLeft().setEnabled(true); // 显示左边 的坐标轴
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
        lineChart.getXAxis().setEnabled(true); // 显示x轴

        //刷新
        lineChart.notifyDataSetChanged();
    }

    public static final int[] LINE_FILL_COLORS = {
            0xFF6DC4CE, Color.rgb(246, 234, 208), Color.rgb(235, 228, 248)
    };
    public static final int[] LINE_COLORS = {
            Color.rgb(140, 210, 118), Color.rgb(159, 143, 186), Color.rgb(233, 197, 23)
    };//绿色，紫色，黄色


    private static LineData generateLineData(Context context, List<List<Float>> lineValues, int[] lineColors, boolean isLine) {
        List<List<Entry>> entriesList = new ArrayList<>();
        if (lineValues != null) {
            for (int i = 0; i < lineValues.size(); ++i) {
                ArrayList<Entry> entries = new ArrayList<>();
                for (int j = 0, n = lineValues.get(i).size(); j < n; j++) {
                    Entry entry = new Entry(j, lineValues.get(i).get(j));
                    entry.setData("" + lineValues.get(i).get(j));
                    entries.add(entry);
                }
                entriesList.add(entries);
            }
        }
        return generateLineData(context, entriesList, lineColors, 0, isLine);
    }

    private static LineData generateLineData(Context context, List<List<Entry>> entriesList, int[] lineColors, int what, boolean isLine) {
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        if (entriesList != null) {
            for (int i = 0; i < entriesList.size(); ++i) {
                LineDataSet lineDataSet = new LineDataSet(entriesList.get(i), "");
                lineDataSet.setValues(entriesList.get(i));
                if (lineColors != null) {
                    lineDataSet.setColor(context.getResources().getColor(lineColors[i]));
                    lineDataSet.setCircleColor(context.getResources().getColor(lineColors[i]));
                    lineDataSet.setCircleColorHole(Color.WHITE);
                    lineDataSet.setDrawFilled(false);
                } else {
                    lineDataSet.setColor(LINE_FILL_COLORS[i % 3]);
                    lineDataSet.setCircleColor(LINE_COLORS[i % 3]);
                    lineDataSet.setCircleColorHole(Color.WHITE);
                    lineDataSet.setDrawFilled(false);

                }
                lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                if (entriesList.size() == 1 || entriesList.size() == 3) {
                    lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);//设置线数据依赖于左侧y轴
                } else if (entriesList.size() == 2) {
                    if (i == 0) {
                        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);//设置线数据依赖于左侧y轴
                    } else {
                        lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);//设置线数据依赖于右侧y轴
                    }
                }

                lineDataSet.setHighlightEnabled(true);
                lineDataSet.setHighLightColor(LINE_FILL_COLORS[i % 3]); // 高亮的线的颜色
                lineDataSet.setDrawHorizontalHighlightIndicator(false);
                lineDataSet.setValueTextColor(R.color.main_blue); //数值显示的颜色
                lineDataSet.setDrawCircleHole(false);
                lineDataSet.setLineWidth(2f);//设置线的宽度
                lineDataSet.setDrawValues(false);//不绘制线的数据
                lineDataSet.setDrawCircles(false);
                //设置折线图模式(直线,曲线...)
                if (isLine) {
                    //直线
                    lineDataSet.setMode(LineDataSet.Mode.LINEAR);
                } else {
                    //曲线
                    lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                }

                dataSets.add(lineDataSet);
            }
        }

        LineData lineData = new LineData(dataSets);
        lineData.setValueTextSize(10f);
        lineData.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return double2String(value, 2);
            }
        });

        return lineData;
    }

    /**
     * 将double转为数值，并最多保留num位小数。例如当num为2时，1.268为1.27，1.2仍为1.2；1仍为1，而非1.00;100.00则返回100。
     *
     * @param d
     * @param num 小数位数
     * @return
     */
    public static String double2String(double d, int num) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(num);//保留两位小数
        nf.setGroupingUsed(false);//去掉数值中的千位分隔符

        String temp = nf.format(d);
        if (temp.contains(".")) {
            String s1 = temp.split("\\.")[0];
            String s2 = temp.split("\\.")[1];
            for (int i = s2.length(); i > 0; --i) {
                if (!s2.substring(i - 1, i).equals("0")) {
                    return s1 + "." + s2.substring(0, i);
                }
            }
            return s1;
        }
        return temp;
    }

    public static class YFormatter implements IAxisValueFormatter {
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            DecimalFormat mDecimalFormat = new DecimalFormat("#");
            return "" + mDecimalFormat.format(value);
            //        return "" + value;
        }
    }
}

