package cn.org.tpri.www.overload.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.Cell;
import cn.org.tpri.www.overload.bean.ColTitle;
import cn.org.tpri.www.overload.bean.RowTitle;
import cn.zhouchaoyuan.excelpanel.BaseExcelPanelAdapter;

import static cn.org.tpri.www.overload.R.id.booking_name;

/**
 * 作者:丁文 on 2017/3/27.
 * copyright: www.tpri.org.cn
 */
public class CustomAdapter extends BaseExcelPanelAdapter<RowTitle,ColTitle,Cell>{
    private Context context;
    public CustomAdapter(Context context) {
        super(context);
        this.context = context;
    }

    /*
    content's cell
     */
    @Override
    public RecyclerView.ViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_normal_cell, parent, false);
        CellHolder cellHolder = new CellHolder(layout);
        return cellHolder;
    }

    @Override
    public void onBindCellViewHolder(RecyclerView.ViewHolder holder, int verticalPosition, int horizontalPosition) {
        Cell cell = getMajorItem(verticalPosition,horizontalPosition);
        if (holder == null || !(holder instanceof CellHolder) || cell == null){
            return;
        }
        CellHolder viewHolder = (CellHolder) holder;
        viewHolder.bookingName.setText(cell.getBookingName());
        if (horizontalPosition == 2){

//            for (int i = 0 ; i < 15;i++){
            if (!TextUtils.isEmpty(viewHolder.bookingName.getText())){
                if (Double.parseDouble((viewHolder.bookingName.getText()).subSequence(0,viewHolder.bookingName.getText().length()-1)+"")>5){
                    viewHolder.bookingName.setTextColor(Color.RED);
                }else {
                    viewHolder.bookingName.setTextColor(Color.GREEN);
                }
            }

//            }
        }

    }

    //================================================top cell===================================
    @Override
    public RecyclerView.ViewHolder onCreateTopViewHolder(ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_top_header_item, parent, false);
        TopHolder topHolder = new TopHolder(layout);
        return topHolder;
    }

    @Override
    public void onBindTopViewHolder(RecyclerView.ViewHolder holder, int position) {
        RowTitle rowTitle = getTopItem(position);
        if (holder == null || !(holder instanceof TopHolder) || rowTitle == null){
            return;
        }
        TopHolder viewHolder = (TopHolder) holder;
        viewHolder.roomDate.setText(rowTitle.getDateString());

    }
//=====================================left cell==============================

    @Override
    public RecyclerView.ViewHolder onCreateLeftViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_status_left_header_item, parent, false);
        LeftHolder leftHolder = new LeftHolder(layout);
        return leftHolder;
    }

    @Override
    public void onBindLeftViewHolder(RecyclerView.ViewHolder holder, int position) {
        ColTitle colTitle = getLeftItem(position);
        if (null == holder || !(holder instanceof LeftHolder) || colTitle == null) {
            return;
        }
        LeftHolder viewHolder = (LeftHolder) holder;
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

         private final TextView bookingName;

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
