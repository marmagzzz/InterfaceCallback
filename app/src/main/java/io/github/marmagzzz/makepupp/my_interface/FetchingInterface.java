package io.github.marmagzzz.makepupp.my_interface;

import io.github.marmagzzz.makepupp.activity.leadspackage.RecyclerAdapter.LeadsAdapter;

public interface FetchingInterface {

    void onSuccessFetchingList(LeadsAdapter leadsAdapter);

    void onFailFetchingList(String message);

}
