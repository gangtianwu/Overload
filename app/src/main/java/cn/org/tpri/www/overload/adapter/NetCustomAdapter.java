package cn.org.tpri.www.overload.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.Cell;
import cn.org.tpri.www.overload.bean.ColTitle;
import cn.org.tpri.www.overload.bean.RowTitle;
import cn.zhouchaoyuan.excelpanel.BaseExcelPanelAdapter;
import cn.zhouchaoyuan.excelpanel.RecyclerViewAdapter;

import static cn.org.tpri.www.overload.R.id.booking_name;

/**
 * 作者:丁文 on 2017/3/29.
 * copyright: www.tpri.org.cn
 */

public class NetCustomAdapter extends BaseExcelPanelAdapter<RowTitle,ColTitle,Cell> {
    private Context context;
    public NetCustomAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter getTopRecyclerViewAdapter() {
        return super.getTopRecyclerViewAdapter();
    }

    /*
        content's cell
         */
    @Override
    public RecyclerView.ViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_normal_cell, parent, false);
        NetCustomAdapter.CellHolder cellHolder = new NetCustomAdapter.CellHolder(layout);
        return cellHolder;
    }

    @Override
    public void onBindCellViewHolder(RecyclerView.ViewHolder holder, int verticalPosition, int horizontalPosition) {
        Cell cell = getMajorItem(verticalPosition,horizontalPosition);
        if (holder == null || !(holder instanceof NetCustomAdapter.CellHolder) || cell == null){
            return;
        }
        NetCustomAdapter.CellHolder viewHolder = (NetCustomAdapter.CellHolder) holder;
        viewHolder.bookingName.setText(cell.getBookingName());
        if (horizontalPosition ==1 || horizontalPosition ==2){
            Date curDate = new Date(System.currentTimeMillis());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date1 = dateFormat.parse(String.valueOf(viewHolder.bookingName.getText()));

                long diff = curDate.getTime() - date1.getTime();
                if (diff >= 30*1000*60 ){
                    viewHolder.bookingName.setTextColor(Color.RED);
                }if (10*1000*60 < diff && diff < 30*1000*60){
                    viewHolder.bookingName.setTextColor(Color.YELLOW);
                }
                if (0< diff && diff <= 10*1000*60){
                    viewHolder.bookingName.setTextColor(Color.GREEN);
                }
//                else {
//                    viewHolder.bookingName.setTextColor(Color.GREEN);
//                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (horizontalPosition == 0){
            if (viewHolder.bookingName.getText().equals("离线")){
                viewHolder.bookingName.setTextColor(Color.RED);
            }else {
                viewHolder.bookingName.setTextColor(Color.GREEN);
            }
        }
    }

    //================================================top cell===================================
    @Override
    public RecyclerView.ViewHolder onCreateTopViewHolder(ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_top_header_item, parent, false);
        NetCustomAdapter.TopHolder topHolder = new NetCustomAdapter.TopHolder(layout);


        return topHolder;
    }


    @Override
    public void onBindTopViewHolder(RecyclerView.ViewHolder holder, int position) {
        RowTitle rowTitle = getTopItem(position);
        if (holder == null || !(holder instanceof NetCustomAdapter.TopHolder) || rowTitle == null){
            return;
        }
        NetCustomAdapter.TopHolder viewHolder = (NetCustomAdapter.TopHolder) holder;
        viewHolder.roomDate.setText(rowTitle.getDateString());

    }
//=====================================left cell==============================

    @Override
    public RecyclerView.ViewHolder onCreateLeftViewHolder(ViewGroup parent, int viewType) {
//        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_left_header_network_item_item, parent, false);
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_left_header_network_item, parent, false);
        NetCustomAdapter.LeftHolder leftHolder = new NetCustomAdapter.LeftHolder(layout);
        return leftHolder;
    }

    @Override
    public void onBindLeftViewHolder(RecyclerView.ViewHolder holder, int position) {
        ColTitle colTitle = getLeftItem(position);
        if (null == holder || !(holder instanceof NetCustomAdapter.LeftHolder) || colTitle == null) {
            return;
        }
        NetCustomAdapter.LeftHolder viewHolder = (NetCustomAdapter.LeftHolder) holder;
        viewHolder.roomNumberLabel.setText(colTitle.getRoomNumber());
        //test different height
    }
    //===========================left-top cell================================
    @Override
    public View onCreateTopLeftView() {
        View view = LayoutInflater.from(context).inflate(R.layout.room_status_normal_cell, null);
         TextView tv = (TextView) view.findViewById(R.id.booking_name);
        tv.setTextColor(Color.YELLOW);
        return   view;
    }

    class CellHolder extends RecyclerView.ViewHolder{

        private  TextView bookingName;

        public CellHolder(View itemView) {
            super(itemView);
            bookingName = (TextView) itemView.findViewById(booking_name);
        }
    }

    class TopHolder extends RecyclerView.ViewHolder{

        private final TextView roomDate;

        public TopHolder(View layout) {
            super(layout);
            roomDate = (TextView) itemView.findViewById(R.id.data_label);

        }
    }

    class LeftHolder extends RecyclerView.ViewHolder{

        private final TextView roomNumberLabel;

        public LeftHolder(View itemView) {
            super(itemView);
            roomNumberLabel = (TextView) itemView.findViewById(R.id.room_number_label);
        }
    }
}
