//https://marwendoukh.wordpress.com/2017/02/01/consuming-rest-web-service-from-android/
//https://developer.android.com/reference/org/xmlpull/v1/XmlPullParser.html
//https://medium.com/@JasonCromer/android-asynctask-http-request-tutorial-6b429d833e28

package com.brainfeaster.sanneo.simpletools.helper;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.brainfeaster.sanneo.simpletools.helper.testDelegate;
import com.brainfeaster.sanneo.app.rajyaSabhaMember.RajyaSabhaMember;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class bfRssReader extends AsyncTask<Void, Void, Boolean> implements testDelegate{
        private String urlLink;
        private testDelegate _stda;
        private int _processId;

        public bfRssReader (testDelegate stda, String url, int processID){
            _stda = stda;
            urlLink = url;
            _processId = processID;
        }
        @Override
        protected void onPreExecute() {
            //urlLink = "http://164.100.47.5/AndroidFeeds/MemberRss.aspx";
        }
        @Override
        protected Boolean doInBackground(Void... voids) {
            InputStream inputStream = null;
            if (TextUtils.isEmpty(urlLink))
                return false;
            try {
                if(!urlLink.startsWith("http://") && !urlLink.startsWith("https://"))
                    urlLink = "http://" + urlLink;

                URL url = new URL(urlLink);
                inputStream = url.openConnection().getInputStream();
                parse(inputStream, _processId);
                inputStream.close();
                // super.addData(item.getValuesToAdd());
                }
                catch (XmlPullParserException e) {e.printStackTrace();}
                catch (IOException e) {e.printStackTrace();}
                finally {
                //inputStream.close();
            }

            return false;
        }

        public void parse(InputStream inputStream, int _processId) throws XmlPullParserException, IOException
        {
            _stda.parse(inputStream, _processId);
        }
        @Override
        protected void onPostExecute(Boolean success) {
            //mSwipeLayout.setRefreshing(false);

            if (success) {
             //   mFeedTitleTextView.setText("Feed Title: " + mFeedTitle);
             //   mFeedDescriptionTextView.setText("Feed Description: " + mFeedDescription);
            //    mFeedLinkTextView.setText("Feed Link: " + mFeedLink);
                // Fill RecyclerView
              //  mRecyclerView.setAdapter(new RssFeedListAdapter(mFeedModelList));
            } else {
                ////Toast.makeText(MainActivity.this,
                    //    "Enter a valid Rss feed url",
                   ////     Toast.LENGTH_LONG).show();
            }
        }
    }


