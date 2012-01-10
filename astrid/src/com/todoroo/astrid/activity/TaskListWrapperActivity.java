package com.todoroo.astrid.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.timsu.astrid.R;
import com.todoroo.astrid.service.ThemeService;

public class TaskListWrapperActivity extends AstridWrapperActivity {
    /**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        ThemeService.applyTheme(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task_list_wrapper_activity);

        Fragment frag = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.filterlist_fragment);
        if (frag != null && frag.isInLayout())
        {
            mMultipleFragments = true;
        }
	}

    @Override
    public void setTitle(CharSequence title) {
        Fragment frag = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.tasklist_fragment);
        if (frag != null && frag.isInLayout())
            ((TextView)frag.getView().findViewById(R.id.listLabel)).setText(title);
        // update the actionbar-title
        getSupportActionBar().setTitle(title);
    }
}