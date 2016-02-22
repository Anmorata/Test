package com.example.gmukhigulashvili.test.Fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gmukhigulashvili.test.adapters.MainAdapter;
import com.example.gmukhigulashvili.test.MainActivity;
import com.example.gmukhigulashvili.test.R;
import com.example.gmukhigulashvili.test.domain.MainFragment;
import com.example.gmukhigulashvili.test.interfaces.RecyclerViewOnClickListenerHack;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMain extends Fragment implements RecyclerViewOnClickListenerHack {

    private RecyclerView mRecylerView;
    private List<MainFragment> mList;


    public FragmentMain() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mRecylerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) mRecylerView.getLayoutManager();
                MainAdapter adapter = (MainAdapter) mRecylerView.getAdapter();

                if (mList.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    List<MainFragment> listAux = ((MainActivity) getActivity()).getSetCarList(10);
                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), mList.size());
                    }
                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecylerView.setLayoutManager(llm);

        mList = ((MainActivity) getActivity()).getSetCarList(10);
        MainAdapter adapter = new MainAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListnerHack(this);
        mRecylerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onClickListner(View view, int position) {
        Toast.makeText(getActivity(), "Position" + position, Toast.LENGTH_SHORT).show();

        MainAdapter adapter =(MainAdapter) mRecylerView.getAdapter();
        adapter.removeListItem(position);

    }
}
