package com.yy.somepop.framework;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by ly on 2018/4/13.
 */

public interface ListItemListener {
    void onItemClick(AdapterView<?> parent, View view, int position, long id);
}
