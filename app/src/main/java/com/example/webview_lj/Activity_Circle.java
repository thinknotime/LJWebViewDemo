package com.example.webview_lj;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Activity_Circle extends Activity{

	private LJWebView mLJWebView = null;
	private String url = "http://www.2345.com/?k89067047";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		mLJWebView = (LJWebView) findViewById(R.id.web);
		mLJWebView.setProgressStyle(LJWebView.Circle);
		mLJWebView.setBarHeight(8);
		mLJWebView.setClickable(true);
		mLJWebView.setUseWideViewPort(true);
		mLJWebView.setSupportZoom(true);
		mLJWebView.setBuiltInZoomControls(true);
		mLJWebView.setJavaScriptEnabled(true);
		mLJWebView.setCacheMode(WebSettings.LOAD_NO_CACHE);		
		mLJWebView.setWebViewClient(new WebViewClient() {
			//��д�˷�����������ڲ���ת
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		mLJWebView.loadUrl(url);
	}

}
