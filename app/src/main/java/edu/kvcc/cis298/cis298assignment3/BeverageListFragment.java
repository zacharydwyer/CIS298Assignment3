package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zak Dwyer on 12/5/2015.
 */
public class BeverageListFragment extends Fragment {

    /* WIDGET (Just one - a RecyclerView!) */
    private RecyclerView mRecyclerView;

    /* BeverageAdapter */
    private BeverageAdapter mBeverageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_beverage_list, container, false);      // Create view using layout

        /* WIRE UP THEM WIDGETS */
        mRecyclerView = (RecyclerView)myView.findViewById(R.id.recycler_view);

        /* ASSIGN PROPERTIES AND STUFF */
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));         // RecyclerView needs a LayoutManager to manage the scrolling behavior.

        updateUI();

        return myView;
    }

    private void updateUI() {
        List<Beverage> beverageList = Beverages.get().getBeverages();       // Get list of beverages
        mBeverageAdapter = new BeverageAdapter(beverageList);               // Create a new Adapter using the beverageList
        mRecyclerView.setAdapter(mBeverageAdapter);                         // Give the RecyclerView this new adapter to work with
    }

    //////////////////////////////////
    //////// VIEW HOLDER /////////////
    //////////////////////////////////
    private class BeverageViewHolder extends RecyclerView.ViewHolder {      // Literally holds a set of views

        /* BEVERAGE WE ACQUIRE FROM bindBeverage) */
        private Beverage mBeverage;

        /* WIDGETS WE'RE WORKING WITH */
        private TextView mNameTextView;
        private TextView mIDTextView;
        private TextView mPriceTextView;

        public BeverageViewHolder(View itemView) {
            super(itemView);

            /* GET REFERENCES TO WIDGETS */
            mNameTextView = (TextView) itemView.findViewById(R.id.list_item_name_text_view);
            mIDTextView = (TextView) itemView.findViewById(R.id.list_item_id_text_view);
            mPriceTextView = (TextView) itemView.findViewById(R.id.list_item_price_text_view);

        }

        // Bind a Beverage's properties to the corresponding widget text properties
        public void bindBeverage(Beverage beverage) {
            mBeverage = beverage;
            mNameTextView.setText(mBeverage.getName());
            mIDTextView.setText(mBeverage.getName());
            mPriceTextView.setText(String.format("{0:C2}", mBeverage.getPrice()));      // Format decimal into a $ text amount
        }
    }

    //////////////////////////////////
    /////////// ADAPTER //////////////
    //////////////////////////////////
    private class BeverageAdapter extends RecyclerView.Adapter<BeverageViewHolder> {
        private List<Beverage> mBeverageList;

        public BeverageAdapter(List<Beverage> beverages) {
            mBeverageList = beverages;
        }

        @Override
        public BeverageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());         // Get the layout inflater from the activity
            View myView = layoutInflater.inflate(R.layout.list_item_beverage, parent, false);
            return new BeverageViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(BeverageViewHolder holder, int position) {
            Beverage beverage = mBeverageList.get(position);            // Get beverage from list at this position
            holder.mNameTextView.setText(beverage.getName());           // Set the text of the "name" textview to the name of the beverage in that position of the list
        }

        @Override
        public int getItemCount() {
            return mBeverageList.size();
        }
    }

}
