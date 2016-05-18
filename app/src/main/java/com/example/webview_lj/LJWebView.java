package com.example.webview_lj;


import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/**
 * @author Administrator
 */
@SuppressLint({ "SetJavaScriptEnabled", "InflateParams" }) 
public class LJWebView extends RelativeLayout{
	
	public static int Circle = 0x01;
	public static int Horizontal = 0x02;
	
	private Context context;
	
	private WebView mWebView = null;  //
	private ProgressBar progressBar = null;  //ˮƽ������
	private RelativeLayout progressBar_circle = null;  //����Բ�ν������Ĳ���
	private int barHeight = 8;  //ˮƽ�������ĸ�
	private boolean isAdd = false;  //�ж��Ƿ��Ѿ����������
	private int progressStyle = Horizontal;  //��������ʽ,Circle��ʾΪԲ�Σ�Horizontal��ʾΪˮƽ
	

	
	public LJWebView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		init();
	}

	public LJWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context = context;
		init();
	}

	public LJWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context = context;
		init();
	}
	
	private void init(){
		mWebView = new WebView(context);
		this.addView(mWebView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		mWebView.setWebChromeClient(new WebChromeClient(){

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				super.onProgressChanged(view, newProgress);
				if(newProgress == 100){
					if(progressStyle == Horizontal){
						progressBar.setVisibility(View.GONE);
					}else{
						progressBar_circle.setVisibility(View.GONE);
					}
				}else{
					if(!isAdd){
						if(progressStyle == Horizontal){
							progressBar = (ProgressBar) LayoutInflater.from(context).inflate(R.layout.progress_horizontal, null);
							progressBar.setMax(100);
							progressBar.setProgress(0);
							LJWebView.this.addView(progressBar, LayoutParams.MATCH_PARENT, barHeight);
						}else{
							progressBar_circle = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.progress_circle, null);
							LJWebView.this.addView(progressBar_circle, LayoutParams.MATCH_PARENT,  LayoutParams.MATCH_PARENT);
						}
						isAdd = true;
					}
					
					if(progressStyle == Horizontal){
						progressBar.setVisibility(View.VISIBLE);
						progressBar.setProgress(newProgress);
					}else{
						progressBar_circle.setVisibility(View.VISIBLE);
					}
				}
			}
		});
	}
	
	public void setBarHeight(int height){
		barHeight = height;
	}
	
	public void setProgressStyle(int style){
		progressStyle = style;
	}
	
	public void setClickable(boolean value){
		mWebView.setClickable(value);
	}
	
	public void setUseWideViewPort(boolean value){
		mWebView.getSettings().setUseWideViewPort(value);
	}
	
	public void setSupportZoom(boolean value){
		mWebView.getSettings().setSupportZoom(value);
	}
	
	public void setBuiltInZoomControls(boolean value){
		mWebView.getSettings().setBuiltInZoomControls(value);
	}
	
	public void setJavaScriptEnabled(boolean value){
		mWebView.getSettings().setJavaScriptEnabled(value);
	}
	
	public void setCacheMode(int value){
		mWebView.getSettings().setCacheMode(value);
	}

	public void setWebViewClient(WebViewClient value){
		mWebView.setWebViewClient(value);
	}
	
	public void loadUrl(String url){
		mWebView.loadUrl(url);
	}
	
}
