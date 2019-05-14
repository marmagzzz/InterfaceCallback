package io.github.marmagzzz.makepupp.my_interface;

import java.util.ArrayList;

public interface LeadsInterface {

    void onMaxPage(String message);

    void onSuccess(ArrayList<model.Record> resultArrayList, int page);

    void onFail(String message, int page);

}
