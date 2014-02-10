/*
 * Copyright (C) 2013 The MoKee OpenSource Project
 * Modifications Copyright (C) 2014 The NamelessRom Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.namelessrom.setupwizard.setup;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import org.namelessrom.setupwizard.R;
import org.namelessrom.setupwizard.ui.SetupPageFragment;
import org.namelessrom.setupwizard.ui.SetupWizardActivity;

public class FinishPage extends Page {

    public FinishPage(Context context, SetupDataCallbacks callbacks, int titleResourceId) {
        super(context, callbacks, titleResourceId);
    }

    @Override
    public Fragment createFragment() {
        Bundle args = new Bundle();
        args.putString(Page.KEY_PAGE_ARGUMENT, getKey());

        FinishFragment fragment = new FinishFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getNextButtonResId() {
        return R.string.finish;
    }


    public static class FinishFragment extends SetupPageFragment {

        @Override
        protected void setUpPage() {
            mRootView.findViewById(R.id.additional_wizards_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((SetupWizardActivity) getActivity()).launchAdditionalWizards();
                }
            });
        }

        @Override
        protected int getLayoutResource() {
            return R.layout.setup_finished_page;
        }

        @Override
        protected int getTitleResource() {
            return R.string.setup_complete;
        }
    }

}
