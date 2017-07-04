<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">   
    <script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
    <script src="js/cufon-yui.js" type="text/javascript"></script>
    <script src="js/cufon-replace.js" type="text/javascript"></script>
    <script src="js/FF-cash.js" type="text/javascript"></script>
	
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"9148",secure:"9157"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body id="page5" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/teachingresource/WebRoot/contact.jsp">
	<div class="extra" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/teachingresource/WebRoot/contact.jsp">
    	<!--==============================header=================================-->
       
         <div>
        <jsp:include page="header.jsp" flush="true"/>
    	</div>
        <!--==============================content================================-->
        <section id="content"><div class="ic">More Website Templates @ TemplateMonster.com. December10, 2011!</div>
            <div class="content-bg">
                <div class="main">
                    <div class="container_12">
                        <div class="wrapper">
                        	<article class="grid_8">
                            	<h3>联系表格</h3>
                                <form id="contact-form2" method="post" enctype="multipart/form-data">                    
                                    <fieldset>
                                          <label><span class="text-form">姓名：</span><input name="p1" type="text" /></label>
                                          <label><span class="text-form">邮箱：</span><input name="p2" type="text" /></label>                              
                                          <div class="wrapper">
                                            <div class="text-form">留言：</div>
                                            <div class="extra-wrap">
                                                <textarea></textarea>
                                                <div class="clear"></div>
                                                <div class="buttons2">
                                                    <a href="#" onClick="document.getElementById('contact-form2').reset()">重置</a>
                                                    <a href="#" onClick="document.getElementById('contact-form2').submit()">发送</a>
                                                </div> 
                                            </div>
                                          </div>                            
                                    </fieldset>						
                                </form>
                            </article>    
                            <article class="grid_4">
                            	<h3>联系方式</h3>
                                <figure class="img-indent-bot img-border">
                                    <img src="images/map.jpg"/>
                                </figure>
                                <dl>
                                    <dt class="indent-bot">四川省<br>成都都江堰市东软大道一号</dt>
                                    <dd><span>联系电话:</span> 13458562607 / 18380438200</dd>
                                    <dd><span>Email:</span><a href="#">912161658@qq.com</a></dd>
                                </dl>
                            </article>                        
                        </div>
                    </div>
                </div>
                <div class="block"></div>
            </div>
        </section>
    </div>
	
	<!--==============================footer=================================-->
    <%@ include file="foot.jsp"%>
	<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
