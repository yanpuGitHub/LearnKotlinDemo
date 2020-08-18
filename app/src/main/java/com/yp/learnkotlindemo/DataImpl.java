package com.yp.learnkotlindemo;

import org.jetbrains.annotations.NotNull;

public class DataImpl {



    public void getData(CallbackImpl callback){

        int code = 0;
        String msg = "失败";
        int type = 0;
        switch (type){
            case 0:
                callback.onSuccess(code);
                break;
            case 1:
                callback.onError(msg);
                break;
        }
    }

    public void setData(){
        getData(new CallbackImpl() {
            @Override
            public void onSuccess(int code) {

            }

            @Override
            public void onError(@NotNull String errStr) {
                super.onError(errStr);

            }
        });
    }
}
