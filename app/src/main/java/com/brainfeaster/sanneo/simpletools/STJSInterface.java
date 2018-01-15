//http://androidtrainningcenter.blogspot.com/2012/11/android-webview-loading-custom-html-and.html
//https://stackoverflow.com/questions/2989005/delegation-example-regarding-java-context
//http://rapidprogrammer.com/android-how-to-call-native-java-methods-from-webview-javascript

package com.brainfeaster.sanneo.simpletools;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.brainfeaster.sanneo.app.rajyaSabhaMember.RSMBusiness;
import com.brainfeaster.sanneo.simpletools.MainActivity;
import com.brainfeaster.sanneo.simpletools.helper.bfRssReader;
import com.brainfeaster.sanneo.simpletools.helper.db;

public class STJSInterface {

        private Context _con;
        public static db _DBConnect = null;
        private RSMBusiness _RSMBus = null;

        public STJSInterface(Context con, db dbConnect) {
            this._con = con;
            this._DBConnect = dbConnect;
            //Load all Apps
            _RSMBus = new RSMBusiness();
        }

        @JavascriptInterface
        public String runAndroidMethod(String methodName, String callback, String params) {
            String rtnStr ="";
            switch (methodName)
            {
                case "step1":
                    _RSMBus.clearAllFromDB(_DBConnect);
                    rtnStr ="Cleared all data";
                    break;
                case "step2":
                    _RSMBus.getMembersDataFromService(_DBConnect);
                    rtnStr ="Loaded all Members";
                    break;
                case "step3":
                    rtnStr = _RSMBus.getAllAvailableMPCodeFromSQL(_DBConnect);
                    break;
                case "step4":
                    _RSMBus.getMemberDetailDataFromService(_DBConnect,params);
                    break;
                case "step5":
                    rtnStr =  _RSMBus.getMemberDetailDataFromService(_DBConnect,params);
                    break;
                case "initRSMApp":
                    _RSMBus.getMembersDataFromService(_DBConnect);
                    rtnStr ="Loaded all Members";
                    Log.d("RSMApp",rtnStr);
                    break;
                case "readyRSMApp":
                    rtnStr =_RSMBus.getRecordCountFromSQL(_DBConnect);
                    Log.d("RSMApp",rtnStr);
                    break;
            }

            return rtnStr;
        }

        private void STAndroidAlert(String title, String Msg)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(_con);
            alertDialogBuilder.setTitle(title);
            alertDialogBuilder
                    .setMessage(Msg)
                    .setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {

                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    @JavascriptInterface
    public void showResult() {
        String str = "x";
       // myWebView.loadUrl("javascript:xxx('"+str+"')");
    }
}
