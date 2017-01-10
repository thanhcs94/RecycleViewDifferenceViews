package thanhcs.com.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ThanhCS94 on 1/8/17.
 * I'm HIDING. Don't waste your time to find me.
 */

public class MultipleViewTypesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_FIRST  = 0;
    private static final int VIEW_TYPE_SECOND = 1;
    ArrayList<String> abc;
    public MultipleViewTypesAdapter(ArrayList<String> abc){
        this.abc = abc;
    }
    class ViewHolderFirst extends RecyclerView.ViewHolder {

        public ViewHolderFirst(View itemView) {
            super(itemView);
        }
    }
    class ViewHolderSecond extends RecyclerView.ViewHolder {

        public ViewHolderSecond(View itemView) {
            super(itemView);
        }
    }
    @Override
    public int getItemViewType(int position) {
        if(position==0) return 0;
        else return 1;
    }

    @Override
    public int getItemCount() {
        return abc.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType== VIEW_TYPE_FIRST){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_scrolling, parent, false);
            return new ViewHolderFirst(view);
        }else{
            View view2 = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.contentpp, parent, false);
            return new ViewHolderSecond(view2);
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_FIRST:
                ViewHolderFirst viewHolderFirst = (ViewHolderFirst)holder;
                break;
            case VIEW_TYPE_SECOND:
                ViewHolderSecond viewHolderSecond = (ViewHolderSecond)holder;
                break;
        }
    }
}