package hu.bme.aut.mobsoft.lab.mobsoft.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.bme.aut.mobsoft.lab.mobsoft.R;
import hu.bme.aut.mobsoft.lab.mobsoft.model.Element;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist.OnClickCardListener;

/**
 * Created by Szabo Gyorgy on 2017. 05. 03..
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ElementViewHolder> {

    private List<Element> elementList;
    private OnClickCardListener cardListener;
    private Context rootContext;

    public RVAdapter(List<Element> elementList, OnClickCardListener cardListener, Context context) {
        this.elementList = elementList;
        this.cardListener = cardListener;
        this.rootContext = context;
    }

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_element_data, parent, false);
        return new ElementViewHolder(view, cardListener);
    }

    @Override
    public void onBindViewHolder(ElementViewHolder holder, int position) {
        Element element = elementList.get(position);

        holder.title.setText(element.getTitle());
        Picasso.with(rootContext).load(element.getPosterUrl()).into(holder.poster);
        holder.year.setText(element.getYear());
        if (element.isFavourite()) {
            holder.favourite.setImageResource(R.drawable.loved);
        } else {
            holder.favourite.setImageResource(R.drawable.unloved);
        }
    }

    @Override
    public int getItemCount() {
        return elementList.size();
    }

    public static class ElementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private OnClickCardListener cardListener;

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.poster)
        ImageView poster;
        @BindView(R.id.year)
        TextView year;
        @BindView(R.id.favourite)
        ImageView favourite;


        public ElementViewHolder(View itemView, OnClickCardListener cardListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.cardListener = cardListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cardListener.onClickCard(view);
        }
    }
}
