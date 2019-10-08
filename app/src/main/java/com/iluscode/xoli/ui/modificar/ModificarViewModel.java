package com.iluscode.xoli.ui.modificar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ModificarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ModificarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is modificar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}